package com.xvitcoder.rsocketapp.supplierservice.web.controller;

import com.xvitcoder.rsocketapp.supplierservice.core.domain.Supplier;
import com.xvitcoder.rsocketapp.supplierservice.core.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Supplier> findSuppliers(Pageable pageable) {
        return supplierService.findSuppliers(pageable);
    }

    @GetMapping("/{supplierId}")
    @ResponseStatus(HttpStatus.OK)
    public Supplier findSupplierById(@PathVariable Long supplierId) {
        return supplierService.findSupplierById(supplierId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Supplier createSupplier(@RequestBody Supplier supplier) {
        return supplierService.createSupplier(supplier);
    }
}
