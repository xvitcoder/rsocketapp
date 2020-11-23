package com.xvitcoder.rsocketapp.supplierservice.core.service;

import com.xvitcoder.rsocketapp.supplierservice.core.domain.Supplier;
import com.xvitcoder.rsocketapp.supplierservice.core.exception.SupplierNotFoundException;
import com.xvitcoder.rsocketapp.supplierservice.core.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepository supplierRepository;

    @Transactional(readOnly = true)
    public Page<Supplier> findSuppliers(Pageable pageable) {
        return supplierRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public List<Supplier> findSuppliers() {
        return supplierRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Supplier findSupplierById(Long supplierId) {
        return supplierRepository.findById(supplierId)
                .orElseThrow(() -> new SupplierNotFoundException(supplierId));
    }

    @Transactional
    public Supplier createSupplier(Supplier supplier) {
        supplier.setId(null);
        supplier.setCreatedOn(LocalDateTime.now());

        supplier = supplierRepository.save(supplier);

        return supplier;
    }
}
