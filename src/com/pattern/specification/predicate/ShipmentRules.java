package com.pattern.specification.predicate;

import com.pattern.specification.Shipment;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.function.Predicate;

public class ShipmentRules {

    private static final Long MINIMUM_WEIGHT = 10L;
    private static final Integer TWO_WEEKS = 14;

    public static Predicate<Shipment> packageMustHaveAtLeastItems(long total){
        return shipment -> shipment.getQuantity() >= total;
    }

    public static Predicate<Shipment> minimumWeight(){
        return shipment -> shipment.getWeight() >= MINIMUM_WEIGHT;
    }


    public static Predicate<Shipment> requestWithinTheTimeLimit(){
        return shipment -> ChronoUnit.DAYS.between(shipment.getRequest(), LocalDateTime.now()) <= TWO_WEEKS;
    }

}
