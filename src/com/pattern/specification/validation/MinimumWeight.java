package com.pattern.specification.validation;

import com.pattern.specification.Shipment;
import com.pattern.specification.structure.CompositeSpecification;

public class MinimumWeight extends CompositeSpecification<Shipment> {

    private static final Long MINIMUM_WEIGHT = 10L;

    @Override
    public Boolean isSatisfiedBy(Shipment shipment) {
        return shipment.getWeight() >= MINIMUM_WEIGHT;
    }

}
