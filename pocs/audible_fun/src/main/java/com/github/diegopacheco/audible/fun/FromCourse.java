package com.github.diegopacheco.audible.fun;

import java.util.List;

public class FromCourse {
    String title;
    List<FromStudent> students;

    public FromCourse(){}
    
    public List<FromStudent> getStudents() {
        return students;
    }
    public void setStudents(List<FromStudent> students) {
        this.students = students;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getName(){
        return title;
    }

    public String getLetterGrade(){
        return "A";
    }
}