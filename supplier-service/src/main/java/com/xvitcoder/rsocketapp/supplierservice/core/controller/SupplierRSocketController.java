package com.xvitcoder.rsocketapp.supplierservice.core.controller;

import com.xvitcoder.rsocketapp.supplierservice.core.domain.Supplier;
import com.xvitcoder.rsocketapp.supplierservice.core.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class SupplierRSocketController {

    private final SupplierService supplierService;

    @MessageMapping("/suppliers/{supplierId}")
    public Mono<Supplier> findSupplierById(@DestinationVariable Long supplierId) {
        return Mono.justOrEmpty(supplierService.findSupplierById(supplierId));
    }

    @MessageMapping("/suppliers")
    public Flux<Supplier> findSuppliers() {
        return Flux.fromIterable(supplierService.findSuppliers());
    }
}
