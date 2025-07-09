package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher;

import com.google.gson.annotations.SerializedName;

public class TeacherPercentText {

    @SerializedName("knowledge_name")
    String knowledge_name;

    @SerializedName("knowledge_percent")
    double knowledge_percent;

    public TeacherPercentText() {
    }

    public TeacherPercentText(String knowledge_name, double knowledge_percent) {
        this.knowledge_name = knowledge_name;
        this.knowledge_percent = knowledge_percent;
    }

    public String getKnowledge_name() {
        return knowledge_name;
    }

    public void setKnowledge_name(String knowledge_name) {
        this.knowledge_name = knowledge_name;
    }

    public double getKnowledge_percent() {
        return knowledge_percent;
    }

    public void setKnowledge_percent(double knowledge_percent) {
        this.knowledge_percent = knowledge_percent;
    }

    @Override
    public String toString() {
        return "{\"knowledge_name\":\"" + knowledge_name + "\", \"knowledge_percent\":\"" + knowledge_percent + "\"}";
    }
}
