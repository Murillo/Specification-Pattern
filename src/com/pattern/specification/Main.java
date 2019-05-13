package com.pattern.specification;

import com.pattern.specification.validation.MinimumWeight;
import com.pattern.specification.validation.PackageMustHaveAtLeastItems;
import com.pattern.specification.validation.RequestWithinTheTimeLimit;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

    private static final String SUCCESS_MESSAGE = "Shipment ran successfully";
    private static final String ERROR_MESSAGE = "Shipment failed";

    public static void main(String[] args) {
        LocalDateTime requestDate = LocalDateTime.now().minus(5, ChronoUnit.DAYS);
        Shipment shipment = Shipment.newInstance(requestDate, 50000L, 10D);
        Boolean result = new MinimumWeight()
                .and(new PackageMustHaveAtLeastItems(25L))
                .and(new RequestWithinTheTimeLimit())
                .isSatisfiedBy(shipment);

        System.out.println(result ? SUCCESS_MESSAGE : ERROR_MESSAGE);
    }
}
