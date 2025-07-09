package com.ccut.teachingaisystem.domain.question.pub;

public class StudentSumGrade {
    int id;
    String year;
    String professional;
    String classroom;
    String student_id;
    String name;
    String test_id;
    String test_name;
    double grade;

    public StudentSumGrade() {
    }

    public StudentSumGrade(int id, String year, String professional
            , String classroom, String student_id, String name
            , double grade, String test_id, String test_name) {
        this.id = id;
        this.year = year;
        this.professional = professional;
        this.classroom = classroom;
        this.student_id = student_id;
        this.name = name;
        this.grade = grade;
        this.test_id = test_id;
        this.test_name = test_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getTest_id() {
        return test_id;
    }

    public void setTest_id(String test_id) {
        this.test_id = test_id;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }
}
