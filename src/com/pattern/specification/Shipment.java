package com.pattern.specification;

import java.time.LocalDateTime;

public final class Shipment {

    private final Long quantity;
    private final Double weight;
    private final LocalDateTime request;

    private Shipment(LocalDateTime request, Long quantity, Double weight){
        this.request = request;
        this.quantity = quantity;
        this.weight = weight;
    }

    public LocalDateTime getRequest() {
        return request;
    }

    public Long getQuantity() {
        return quantity;
    }

    public Double getWeight() {
        return weight;
    }

    public static Shipment newInstance(final LocalDateTime request, final Long quantity, final Double weight){
        return new Shipment(request, quantity, weight);
    }
}
