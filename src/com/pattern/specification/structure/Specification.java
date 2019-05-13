package com.pattern.specification.structure;

public interface Specification<T> {
    Boolean isSatisfiedBy(T t);
    Specification<T> and(Specification<T> other);
    Specification<T> or(Specification<T> other);
}