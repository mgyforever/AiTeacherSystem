package com.ccut.teachingaisystem.domain.question.rate;

public class AccuracyRate {
    int id;
    String student_id;
    String knowledgeName;
    String student_name;
    String classroom;
    String test_id;
    String test_name;
    String subject;
    String chapter;
    String year;
    String professional;
    int knowledge;
    int num;
    double rate;

    public AccuracyRate() {
    }

    public AccuracyRate(int id, String student_id, String knowledgeName, int knowledge
            , double rate, String student_name, String classroom, String test_id
            , String test_name, String subject, String chapter, String year
            , String professional, int num) {
        this.id = id;
        this.student_id = student_id;
        this.knowledgeName = knowledgeName;
        this.knowledge = knowledge;
        this.rate = rate;
        this.student_name = student_name;
        this.classroom = classroom;
        this.test_id = test_id;
        this.test_name = test_name;
        this.subject = subject;
        this.chapter = chapter;
        this.year = year;
        this.professional = professional;
        this.num = num;
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

    public String getKnowledgeName() {
        return knowledgeName;
    }

    public void setKnowledgeName(String knowledgeName) {
        this.knowledgeName = knowledgeName;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(int knowledge) {
        this.knowledge = knowledge;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"student_id\":\"" + student_id + "\"" +
                ", \"knowledgeName\":\"" + knowledgeName + "\"" +
                ", \"student_name\":\"" + student_name + "\"" +
                ", \"classroom\":\"" + classroom + "\"" +
                ", \"test_id\":\"" + test_id + "\"" +
                ", \"test_name\":\"" + test_name + "\"" +
                ", \"subject\":\"" + subject + "\"" +
                ", \"chapter\":\"" + chapter + "\"" +
                ", \"year\":\"" + year + "\"" +
                ", \"professional\":\"" + professional + "\"" +
                ", \"knowledge\":" + knowledge +
                ", \"num\":" + num +
                ", \"rate\":" + rate +
                "}";
    }
}
