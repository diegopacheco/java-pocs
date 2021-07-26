package com.github.diegopacheco.design.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

// Composite: The composite pattern is meant to allow treating individual objects and
// compositions of objects, or “composites” in the same way.
public class HeadDepartment implements Department {
    private Integer id;
    private String name;

    private List<Department> childDepartments;

    public HeadDepartment(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.childDepartments = new ArrayList<>();
    }

    @Override
    public void printDepartmentName() {
        System.out.println("[" + name + "] rules following Departments: ");
        childDepartments.forEach(Department::printDepartmentName);
    }

    public void addDepartment(Department department) {
        childDepartments.add(department);
    }
    public void removeDepartment(Department department) {
        childDepartments.remove(department);
    }
}
