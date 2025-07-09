package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.test;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AiTestPercent {

    @SerializedName("question")
    List<ChapterPointsText> question;

    public AiTestPercent() {
    }

    public AiTestPercent(List<ChapterPointsText> question) {
        this.question = question;
    }

    public List<ChapterPointsText> getQuestion() {
        return question;
    }

    public void setQuestion(List<ChapterPointsText> question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "{\"question\":" + question + "}";
    }
}
