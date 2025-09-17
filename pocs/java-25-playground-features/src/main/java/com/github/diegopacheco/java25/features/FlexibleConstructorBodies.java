package com.github.diegopacheco.java25.features;

/*
 * JEP 513: Flexible Constructor Bodies
 * https://openjdk.org/jeps/513
 *
 * This feature allows constructors to have more flexible bodies, enabling
 * additional logic before the call to the superclass constructor
 * or instance initializer. This can be useful for validation,
 * initialization, or other pre-construction logic.
 */
public class FlexibleConstructorBodies {

    static class Person {
        int age;
        Person(int age) {
            if (age < 0) throw new IllegalArgumentException("Invalid age");
            this.age = age;
        }
    }

    static class Employee extends Person {
        String department;

        Employee(int age, String department) {
            if (age < 18 || age > 67) throw new IllegalArgumentException("Employee age must be 18-67");
            this.department = department;
            super(age);
        }
    }

    static void main() {
        Employee emp = new Employee(25, "Engineering");
        System.out.println("Age: " + emp.age + ", Department: " + emp.department);
    }
}
