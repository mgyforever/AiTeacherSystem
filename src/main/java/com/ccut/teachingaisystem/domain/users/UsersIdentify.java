package com.ccut.teachingaisystem.domain.users;

public class UsersIdentify {
    String id;
    String name;
    String sex;
    int age;
    int judge;
    String phoneNumber;
    String IDNumber;

    public UsersIdentify() {
    }

    public UsersIdentify(String id, String name, String sex, int age, int judge
            , String phoneNumber, String IDNumber) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.judge = judge;
        this.phoneNumber = phoneNumber;
        this.IDNumber = IDNumber;
    }

    public UsersIdentify(String id, String name, String sex, int age
            , String phoneNumber, String IDNumber) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.IDNumber = IDNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public int getJudge() {
        return judge;
    }

    public void setJudge(int judge) {
        this.judge = judge;
    }

    @Override
    public String toString() {
        return "UsersIdentify:{" + "chapter=" + name + ", sex=" + sex +
                ", age=" + age + ", phoneNumber=" + phoneNumber + '}';
    }
}
