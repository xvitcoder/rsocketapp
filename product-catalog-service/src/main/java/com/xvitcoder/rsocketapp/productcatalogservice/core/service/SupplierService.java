package com.xvitcoder.rsocketapp.productcatalogservice.core.service;

import com.xvitcoder.rsocketapp.productcatalogservice.core.domain.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

@Service
public class SupplierService {
    private RSocketRequester supplierServiceRequester;

    public SupplierService(RSocketRequester.Builder builder) {
        this.supplierServiceRequester = builder
                .rsocketConnector(connector -> connector.reconnect(Retry.backoff(10, Duration.ofMillis(500))))
                .dataMimeType(MediaType.APPLICATION_CBOR)
                .tcp("localhost", 6562);
    }

    public Mono<Supplier> findSupplierById(Long supplierId) {
        return supplierServiceRequester
                .route("/suppliers/" + supplierId)
                .retrieveMono(Supplier.class);
    }
}
