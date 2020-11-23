package com.xvitcoder.rsocketapp.productcatalogservice.core.service;

import com.xvitcoder.rsocketapp.productcatalogservice.core.domain.ProductCatalog;
import com.xvitcoder.rsocketapp.productcatalogservice.core.exception.ProductCatalogNotFoundException;
import com.xvitcoder.rsocketapp.productcatalogservice.core.repository.ProductCatalogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProductCatalogService {
    private final ProductCatalogRepository productCatalogRepository;

    @Transactional(readOnly = true)
    public Page<ProductCatalog> findProductCatalogs(Pageable pageable) {
        return productCatalogRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public ProductCatalog findProductCatalogById(Long productCatalogId) {
        return productCatalogRepository.findById(productCatalogId)
                .orElseThrow(() -> new ProductCatalogNotFoundException(productCatalogId));
    }

    @Transactional
    public ProductCatalog createProductCatalog(ProductCatalog productCatalog) {
        productCatalog.setId(null);
        productCatalog.setCreatedOn(LocalDateTime.now());

        // TODO: Check if the specified supplierId exists

        productCatalog = productCatalogRepository.save(productCatalog);

        return productCatalog;
    }
}
