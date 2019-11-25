package com.pattern.specification.predicate;

import java.util.function.Predicate;

public class Specification<E> {

    private Predicate<E> rules;

    public Specification(){
        rules = (r) -> 1 == 1;
    }

    public Specification<E> and(Predicate<E> rule) {
        rules.and(rule);
        return this;
    }

    public Specification<E> or(Predicate<E> rule) {
        rules.or(rule);
        return this;
    }

    public Specification<E> not(Predicate<E> rule) {
        rules.and(rule).negate();
        return this;
    }

    public boolean isSatisfiedBy(E object) {
        return rules.test(object);
    }

}
