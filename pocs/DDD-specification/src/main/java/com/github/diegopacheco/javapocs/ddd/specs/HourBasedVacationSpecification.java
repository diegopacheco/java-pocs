package com.github.diegopacheco.javapocs.ddd.specs;

import com.github.diegopacheco.javapocs.ddd.domain.Employee;

public class HourBasedVacationSpecification implements VacationSpecification<Employee>{
    @Override
    public boolean isSatisfiedBy(Employee pojo) {
        if (pojo==null || null==pojo.getDaysSinceJoined()){
            return false;
        }
        return true;
    }
}
