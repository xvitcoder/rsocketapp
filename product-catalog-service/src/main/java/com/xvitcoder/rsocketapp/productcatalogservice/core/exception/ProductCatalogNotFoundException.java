package com.xvitcoder.rsocketapp.productcatalogservice.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductCatalogNotFoundException extends RuntimeException {
    public ProductCatalogNotFoundException(Long productCatalogId) {
        super(String.format("Product Catalog with Id: %d, was not found", productCatalogId));
    }
}
