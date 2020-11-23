package com.xvitcoder.rsocketapp.productcatalogservice.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SupplierNotFoundException extends RuntimeException {
    public SupplierNotFoundException(Long supplierId) {
        super(String.format("Supplier with id %d, not found", supplierId));
    }
}
