package com.pattern.specification.traditional.validation;

import com.pattern.specification.Shipment;
import com.pattern.specification.traditional.structure.CompositeSpecification;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RequestWithinTheTimeLimit  extends CompositeSpecification<Shipment> {

    private static final Integer TWO_WEEKS = 14;

    @Override
    public Boolean isSatisfiedBy(Shipment shipmentEntity) {
        return ChronoUnit.DAYS.between(shipmentEntity.getRequest(), LocalDateTime.now()) <= TWO_WEEKS;
    }
}
