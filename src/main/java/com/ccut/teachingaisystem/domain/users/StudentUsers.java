package com.ccut.teachingaisystem.domain.users;

public class StudentUsers {
    int id;
    String student_id;
    String userName;
    String password;
    String phoneNumber;
    String email;
    String account;
    String year;
    String classroom;
    String professional;

    public StudentUsers() {
    }

    public StudentUsers(int id, String student_id, String userName, String password
            , String phoneNumber, String email, String account, String classroom, String year, String professional) {
        this.id = id;
        this.student_id = student_id;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.account = account;
        this.classroom = classroom;
        this.year = year;
        this.professional = professional;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
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

    @Override
    public String toString() {
        return "StudentUsers:{" + "id=" + id + ", student_id=" + student_id +
                ", userName=" + userName + ", password=" + password + "phoneNumber" + phoneNumber + '}';
    }
}
