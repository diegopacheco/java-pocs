package com.github.diegopacheco.audible.fun;

public class Student{

    String fullName;
    String someField;

    public Student(){} 

    public String getFullName() {
        return fullName;
    }
    public String getFirstName(){
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setSomeField(Object o){
        this.someField = o.toString();
    }
    public void setStudent(Object o){
        this.fullName = o.toString();
    }
}