package com.xvitcoder.rsocketapp.productcatalogservice.core.repository;

import com.xvitcoder.rsocketapp.productcatalogservice.core.domain.ProductCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCatalogRepository extends JpaRepository<ProductCatalog, Long> {
}
