package com.github.diegopacheco.javapocs.ddd.domain;

import java.math.BigInteger;
import java.util.Objects;
import java.util.UUID;

public class Employee {

    private UUID id;
    private String name;
    private String email;
    private BigInteger daysSinceJoined;
    private ContractType contractType;

    public Employee(){}

    public Employee(UUID id, String name, String email, BigInteger daysSinceJoined) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.daysSinceJoined = daysSinceJoined;
        this.contractType = ContractType.STANDARD;
    }

    public Employee(UUID id, String name, String email, BigInteger daysSinceJoined, ContractType contractType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.daysSinceJoined = daysSinceJoined;
        this.contractType = contractType;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getDaysSinceJoined() {
        return daysSinceJoined;
    }
    public void setDaysSinceJoined(BigInteger daysSinceJoined) {
        this.daysSinceJoined = daysSinceJoined;
    }

    public ContractType getContractType() {
        return contractType;
    }
    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(email, employee.email) && Objects.equals(daysSinceJoined, employee.daysSinceJoined) && contractType == employee.contractType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, daysSinceJoined, contractType);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", daysSinceJoined=" + daysSinceJoined +
                ", contractType=" + contractType +
                '}';
    }
}
