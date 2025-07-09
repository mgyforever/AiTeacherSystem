package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.test;

import com.google.gson.annotations.SerializedName;

public class KnowledgePointsText {

    @SerializedName("knowledge")
    String knowledge;

    @SerializedName("knowledge_num")
    int knowledge_num;

    @SerializedName("knowledge_grade")
    double knowledge_grade;

    @SerializedName("knowledge_points")
    double knowledge_points;

    public KnowledgePointsText() {
    }

    public KnowledgePointsText(String knowledge, int knowledge_num, double knowledge_grade, double knowledge_points) {
        this.knowledge = knowledge;
        this.knowledge_num = knowledge_num;
        this.knowledge_grade = knowledge_grade;
        this.knowledge_points = knowledge_points;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public int getKnowledge_num() {
        return knowledge_num;
    }

    public void setKnowledge_num(int knowledge_num) {
        this.knowledge_num = knowledge_num;
    }

    public double getKnowledge_grade() {
        return knowledge_grade;
    }

    public void setKnowledge_grade(double knowledge_grade) {
        this.knowledge_grade = knowledge_grade;
    }

    public double getKnowledge_points() {
        return knowledge_points;
    }

    public void setKnowledge_points(double knowledge_points) {
        this.knowledge_points = knowledge_points;
    }

    @Override
    public String toString() {
        return "{\"knowledge\":\"" + knowledge + "\", \"knowledge_num\":\"" + knowledge_num
                + "\", \"knowledge_grade\":\"" + knowledge_grade + "\", \"knowledge_points\":\""
                + knowledge_points + "\"}";
    }
}
