package com.pattern.specification;

import com.pattern.specification.predicate.Specification;
import com.pattern.specification.traditional.validation.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static com.pattern.specification.predicate.ShipmentRules.*;

public class Main {

    private static final String SUCCESS_MESSAGE = "Shipment ran successfully";
    private static final String ERROR_MESSAGE = "Shipment failed";

    public static void main(String[] args) {
        LocalDateTime requestDate = LocalDateTime.now().minus(5, ChronoUnit.DAYS);
        Shipment shipment = Shipment.newInstance(requestDate, 50000L, 10D);

        // Traditional structure
        Boolean resultTradSpec = new MinimumWeight()
                .and(new PackageMustHaveAtLeastItems(25L))
                .and(new RequestWithinTheTimeLimit())
                .isSatisfiedBy(shipment);
        System.out.println(resultTradSpec ? SUCCESS_MESSAGE : ERROR_MESSAGE);

        // Specification using predicate abstracted in a class
        Boolean resultLambdaSpec = new Specification<Shipment>()
                .and(minimumWeight())
                .and(packageMustHaveAtLeastItems(25L))
                .and(requestWithinTheTimeLimit())
                .isSatisfiedBy(shipment);
        System.out.println(resultLambdaSpec ? SUCCESS_MESSAGE : ERROR_MESSAGE);

        // Using only Predicate Functional Interface
        Boolean resultPredicate = minimumWeight()
                .and(packageMustHaveAtLeastItems(1000000L))
                .and(requestWithinTheTimeLimit())
                .test(shipment);
        System.out.println(resultPredicate ? SUCCESS_MESSAGE : ERROR_MESSAGE);

    }
}
