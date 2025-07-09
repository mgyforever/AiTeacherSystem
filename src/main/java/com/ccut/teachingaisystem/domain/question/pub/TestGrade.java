package com.ccut.teachingaisystem.domain.question.pub;

public class TestGrade {
    private int id;
    private String test_id;
    private String subject;
    private String classroom;
    private String year;
    private String professional;
    private String student_id;
    private String name;
    private String time;
    private double grade;

    public TestGrade() {
    }

    public TestGrade(String test_id, String subject, String classroom
            , String student_id, String name, String time, double grade, String year, String professional) {
        this.test_id = test_id;
        this.subject = subject;
        this.classroom = classroom;
        this.student_id = student_id;
        this.name = name;
        this.time = time;
        this.grade = grade;
        this.year = year;
        this.professional = professional;
    }

    public TestGrade(int id, String test_id, String subject, String classroom, String student_id
            , String name, int grade, String time, String year, String professional) {
        this.id = id;
        this.test_id = test_id;
        this.subject = subject;
        this.classroom = classroom;
        this.student_id = student_id;
        this.name = name;
        this.grade = grade;
        this.time = time;
        this.year = year;
        this.professional = professional;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTest_id() {
        return test_id;
    }

    public void setTest_id(String test_id) {
        this.test_id = test_id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
}
