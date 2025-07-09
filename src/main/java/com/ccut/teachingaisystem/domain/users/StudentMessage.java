package com.ccut.teachingaisystem.domain.users;

public class StudentMessage {
    int id;
    String year;
    String professional;
    String classroom;
    String student_id;
    String name;
    int age;
    String sex;
    String address;

    public StudentMessage() {
    }

    public StudentMessage(int id, String year, String classroom
            , String student_id, String name, int age, String sex, String address, String professional) {
        this.id = id;
        this.year = year;
        this.classroom = classroom;
        this.student_id = student_id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.professional = professional;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }
}
