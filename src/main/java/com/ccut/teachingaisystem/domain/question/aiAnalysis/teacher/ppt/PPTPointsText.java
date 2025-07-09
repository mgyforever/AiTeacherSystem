package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.ppt;

import com.google.gson.annotations.SerializedName;

public class PPTPointsText {

    @SerializedName("knowledge")
    String knowledge;

    @SerializedName("practice")
    String practice;

    @SerializedName("time")
    String time;

    public PPTPointsText() {
    }

    public PPTPointsText(String knowledge, String practice, String time) {
        this.knowledge = knowledge;
        this.practice = practice;
        this.time = time;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "{\"knowledge\":\"" + knowledge + "\", \"practice\":\""
                + practice + "\", \"time\":\"" + time + "\"}";
    }
}
