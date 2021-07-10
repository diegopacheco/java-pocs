package com.github.diegopacheco.javapocs.ddd.service;

import com.github.diegopacheco.javapocs.ddd.domain.Employee;
import com.github.diegopacheco.javapocs.ddd.specs.VacationFactory;
import com.github.diegopacheco.javapocs.ddd.specs.VacationSpecification;

public class EmployeeService {

    public boolean canTakeVacationsNow(Employee e){
        VacationSpecification<Employee> policy =
                VacationFactory.getVacationPolicy(e);
        return policy.isSatisfiedBy(e);
    }

}
