package com.github.diegopacheco.javapocs.ddd.specs;

import com.github.diegopacheco.javapocs.ddd.domain.ContractType;
import com.github.diegopacheco.javapocs.ddd.domain.Employee;

public class VacationFactory {

    public static VacationSpecification<Employee> getVacationPolicy(Employee e){
        if (null==e || null==e.getContractType() ||
            ContractType.STANDARD==e.getContractType()){
            return new StandardVacationSpecification();
        }else if (ContractType.HOURLY==e.getContractType()){
            return new HourBasedVacationSpecification();
        }
        throw new IllegalArgumentException("Could not figure it out the Vacation Policy with: " + e);
    }

}
