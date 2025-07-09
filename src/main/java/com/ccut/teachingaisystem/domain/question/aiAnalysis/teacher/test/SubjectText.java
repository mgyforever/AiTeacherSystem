package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.test;

import com.google.gson.annotations.SerializedName;

public class SubjectText {

    @SerializedName("chapter")
    String chapter;

    @SerializedName("knowledge")
    String knowledge;

    @SerializedName("judge")
    int judge;

    public SubjectText() {
    }

    public SubjectText(String chapter, String knowledge, int judge) {
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
        return "{\"chapter\":\"" + chapter + "\", \"knowledge\":\""
                + knowledge + "\", \"judge\":\"" + judge + "\"}";
    }
}
