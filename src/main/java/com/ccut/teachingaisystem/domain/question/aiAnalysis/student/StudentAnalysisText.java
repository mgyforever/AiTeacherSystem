package com.ccut.teachingaisystem.domain.question.aiAnalysis.student;

import com.google.gson.annotations.SerializedName;

public class StudentAnalysisText {

    @SerializedName("chapter")
    private String chapter;

    @SerializedName("knowledge")
    private String knowledge;

    @SerializedName("judge")
    private int judge;

    public StudentAnalysisText() {
    }

    public StudentAnalysisText(String chapter, String knowledge, int judge) {
        this.chapter = chapter;
        this.knowledge = knowledge;
        this.judge = judge;
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

    public int getJudge() {
        return judge;
    }

    public void setJudge(int judge) {
        this.judge = judge;
    }

    @Override
    public String toString() {
        return "{\"chapter\":\"" + chapter + "\", \"knowledge\":\"" + knowledge + "\", \"judge\":\"" + judge + "\"}";
    }
}
