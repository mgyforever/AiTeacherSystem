package com.ccut.teachingaisystem.domain.users;

public class TempUsers {
    int id;
    int judge;
    int age;
    String student_id;
    String teacher_id;
    String userName;
    String password;
    String phoneNumber;
    String email;
    String subject;
    String account;
    String year;
    String professional;
    String address;
    String classroom;
    String name;
    String sex;
    String IDNumber;

    public TempUsers() {
    }

    public TempUsers(String student_id, String password, int judge) {
        this.student_id = student_id;
        this.password = password;
        this.judge = judge;
    }

    public TempUsers(int id, int judge, String student_id, String teacher_id, String userName
            , String password, String phoneNumber, String email, String subject
            , String account, String classroom, String year, String name
            , String sex, String IDNumber, int age, String professional, String address) {
        this.id = id;
        this.judge = judge;
        this.student_id = student_id;
        this.teacher_id = teacher_id;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.subject = subject;
        this.account = account;
        this.classroom = classroom;
        this.year = year;
        this.name = name;
        this.IDNumber = IDNumber;
        this.age = age;
        this.sex = sex;
        this.professional = professional;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJudge() {
        return judge;
    }

    public void setJudge(int judge) {
        this.judge = judge;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "[student_id=" + student_id + ", teacher_id=" + teacher_id + ", userName=" + userName + ", password=" + password + ", phoneNumber=" + phoneNumber + ", email=" + email + ", subject=" + subject + ", account=" + account + ", year" + year + ", professional=" + professional + ", address=" + address + ", name=" + name + ", sex=" + sex + ", age=" + age + "]";
    }
}
