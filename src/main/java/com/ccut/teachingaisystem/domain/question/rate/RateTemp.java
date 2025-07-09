package com.ccut.teachingaisystem.domain.question.rate;

public class RateTemp {
    int id;
    String test_id;
    String test_name;
    String subject;
    String chapter;
    String knowledge;
    String year;
    String classroom;

    public RateTemp() {
    }


    public RateTemp(int id, String test_id, String subject, String chapter, String knowledge
            , String year, String test_name, String classroom) {
        this.id = id;
        this.test_id = test_id;
        this.test_name = test_name;
        this.subject = subject;
        this.chapter = chapter;
        this.knowledge = knowledge;
        this.year = year;
        this.classroom = classroom;
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

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
