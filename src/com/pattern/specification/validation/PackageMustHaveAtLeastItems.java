package com.pattern.specification.validation;

import com.pattern.specification.Shipment;
import com.pattern.specification.structure.CompositeSpecification;

public class PackageMustHaveAtLeastItems extends CompositeSpecification<Shipment> {

    private Long total;
    public PackageMustHaveAtLeastItems(Long total){
        this.total = total;
    }

    @Override
    public Boolean isSatisfiedBy(Shipment shipmentEntity) {
        return shipmentEntity.getQuantity() >= total;
    }

}
