package com.github.diegopacheco.javapocs.ddd.specs;

public interface VacationSpecification<T> {
    public boolean isSatisfiedBy(T pojo);
}
