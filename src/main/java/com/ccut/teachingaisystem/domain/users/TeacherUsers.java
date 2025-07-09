package com.ccut.teachingaisystem.domain.users;

public class TeacherUsers {
    int id;
    String teacher_id;
    String userName;
    String password;
    String phoneNumber;
    String email;
    String subject;
    String account;
    String classroom;

    public TeacherUsers() {
    }

    public TeacherUsers(int id, String teacher_id, String userName, String password
            , String phoneNumber, String email, String subject
            , String account, String classroom) {
        this.id = id;
        this.teacher_id = teacher_id;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.subject = subject;
        this.account = account;
        this.classroom = classroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    @Override
    public String toString() {
        return "TeacherUsers:{" + "id=" + id + ", teacher_id=" + teacher_id +
                ", userName=" + userName + ", password=" + password + '}';
    }
}
