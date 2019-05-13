package com.pattern.specification.structure;

public class OrSpecification<T> extends CompositeSpecification<T> {
    private Specification<T> leftRule;
    private Specification<T> rightRule;

    public OrSpecification(Specification<T> leftRule, Specification<T> rightRule) {
        this.leftRule = leftRule;
        this.rightRule = rightRule;
    }

    @Override
    public Boolean isSatisfiedBy(T t) {
        return leftRule.isSatisfiedBy(t) || rightRule.isSatisfiedBy(t);
    }

}
