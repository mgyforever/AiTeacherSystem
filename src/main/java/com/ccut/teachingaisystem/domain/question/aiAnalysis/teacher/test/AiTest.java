package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.test;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AiTest {

    @SerializedName("subject_name")
    String subject_name;

    @SerializedName("points")
    int points;

    @SerializedName("question_num")
    int question_num;

    @SerializedName("subject")
    List<SubjectText> subject;

    public AiTest() {
    }

    public AiTest(String subject_name, int points, int question_num, List<SubjectText> subject) {
        this.subject_name = subject_name;
        this.points = points;
        this.question_num = question_num;
        this.subject = subject;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getQuestion_num() {
        return question_num;
    }

    public void setQuestion_num(int question_num) {
        this.question_num = question_num;
    }

    public List<SubjectText> getSubject() {
        return subject;
    }

    public void setSubject(List<SubjectText> subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "{\"subject_name\":\"" + subject_name + "\", \"points\":\"" + points
                + "\", \"question_num\":\"" + question_num + "\", \"subject\":" + subject + "}";
    }
}
