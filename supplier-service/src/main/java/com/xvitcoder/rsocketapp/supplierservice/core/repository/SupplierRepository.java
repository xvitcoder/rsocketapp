package com.xvitcoder.rsocketapp.supplierservice.core.repository;

import com.xvitcoder.rsocketapp.supplierservice.core.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
