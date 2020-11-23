package com.xvitcoder.rsocketapp.productcatalogservice.web.controller;

import com.xvitcoder.rsocketapp.productcatalogservice.core.domain.ProductCatalog;
import com.xvitcoder.rsocketapp.productcatalogservice.core.service.ProductCatalogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/product-catalogs")
@RequiredArgsConstructor
public class ProductCatalogController {
    private final ProductCatalogService productCatalogService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ProductCatalog> findProductCatalogs(Pageable pageable) {
        return productCatalogService.findProductCatalogs(pageable);
    }

    @GetMapping("/api/{productCatalogId}")
    @ResponseStatus(HttpStatus.OK)
    public ProductCatalog findProductCatalogById(@PathVariable Long productCatalogId) {
        return productCatalogService.findProductCatalogById(productCatalogId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductCatalog createProductCatalog(@RequestBody ProductCatalog productCatalog) {
        return productCatalogService.createProductCatalog(productCatalog);
    }
}
