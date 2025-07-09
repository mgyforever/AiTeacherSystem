package com.ccut.teachingaisystem.domain.question.rate;

public class QuestionTestRate {
    int year_num;
    int classroom_num;
    double year_rate;
    double classroom_rate;
    String chapter;
    String knowledge;

    public QuestionTestRate() {
    }

    public QuestionTestRate(int year_num, int classroom_num, double year_rate
            , double classroom_rate, String chapter, String knowledge) {
        this.year_num = year_num;
        this.classroom_num = classroom_num;
        this.year_rate = year_rate;
        this.classroom_rate = classroom_rate;
        this.chapter = chapter;
        this.knowledge = knowledge;
    }

    public int getYear_num() {
        return year_num;
    }

    public void setYear_num(int year_num) {
        this.year_num = year_num;
    }

    public int getClassroom_num() {
        return classroom_num;
    }

    public void setClassroom_num(int classroom_num) {
        this.classroom_num = classroom_num;
    }

    public double getYear_rate() {
        return year_rate;
    }

    public void setYear_rate(double year_rate) {
        this.year_rate = year_rate;
    }

    public double getClassroom_rate() {
        return classroom_rate;
    }

    public void setClassroom_rate(double classroom_rate) {
        this.classroom_rate = classroom_rate;
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
}
