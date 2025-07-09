package com.ccut.teachingaisystem.domain.question.rate;

public class TestRate {
    int id;
    String test_id;
    String test_name;
    String subject;
    String chapter;
    String knowledge;
    String year;
    String classroom;
    int classroom_num;
    int year_num;
    int classroom_right_num;
    int year_right_num;
    double classroom_rate;
    double year_rate;

    public TestRate() {
    }

    public TestRate(int id, String test_id, String subject, String chapter, String knowledge, String year
            , String classroom, int classroom_num, int year_num, int classroom_right_num
            , int year_right_num, double classroom_rate, double year_rate, String test_name) {
        this.id = id;
        this.test_id = test_id;
        this.subject = subject;
        this.chapter = chapter;
        this.knowledge = knowledge;
        this.year = year;
        this.classroom = classroom;
        this.classroom_num = classroom_num;
        this.year_num = year_num;
        this.classroom_right_num = classroom_right_num;
        this.year_right_num = year_right_num;
        this.classroom_rate = classroom_rate;
        this.year_rate = year_rate;
        this.test_name = test_name;
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

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
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

    public int getClassroom_num() {
        return classroom_num;
    }

    public void setClassroom_num(int classroom_num) {
        this.classroom_num = classroom_num;
    }

    public int getYear_num() {
        return year_num;
    }

    public void setYear_num(int year_num) {
        this.year_num = year_num;
    }

    public int getClassroom_right_num() {
        return classroom_right_num;
    }

    public void setClassroom_right_num(int classroom_right_num) {
        this.classroom_right_num = classroom_right_num;
    }

    public int getYear_right_num() {
        return year_right_num;
    }

    public void setYear_right_num(int year_right_num) {
        this.year_right_num = year_right_num;
    }

    public double getClassroom_rate() {
        return classroom_rate;
    }

    public void setClassroom_rate(double classroom_rate) {
        this.classroom_rate = classroom_rate;
    }

    public double getYear_rate() {
        return year_rate;
    }

    public void setYear_rate(double year_rate) {
        this.year_rate = year_rate;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }
}
