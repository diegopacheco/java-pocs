package com.github.diegopacheco.audible.fun;

public class FromStudent {
    String firstName;
    String lastName;
    Integer age;
    Double gpa;
    String name;

    public FromStudent(){}

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    
    public String getName(){
        return firstName + lastName;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getAge() {
        return age;
    }

    public Double getGpa() {
        return gpa;
    }
    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public void setStudent(Object o){
        this.name = o.toString();
    }

}   