package com.ccut.teachingaisystem.domain.question.aiAnalysis.student;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StudentChapterPercentText {

    @SerializedName("chapter_name")
    private String chapter_name;

    @SerializedName("chapter_percent")
    private double chapter_percent;

    @SerializedName("knowledge")
    List<StudentKnowledgePercentText> knowledge;

    public StudentChapterPercentText() {
    }

    public StudentChapterPercentText(String chapter_name, double chapter_percent
            , List<StudentKnowledgePercentText> knowledge) {
        this.chapter_name = chapter_name;
        this.chapter_percent = chapter_percent;
        this.knowledge = knowledge;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }

    public double getChapter_percent() {
        return chapter_percent;
    }

    public void setChapter_percent(double chapter_percent) {
        this.chapter_percent = chapter_percent;
    }

    public List<StudentKnowledgePercentText> getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(List<StudentKnowledgePercentText> knowledge) {
        this.knowledge = knowledge;
    }

    @Override
    public String toString() {
        return "{\"chapter_name\":\"" + chapter_name + "\",\"chapter_percent\":\"" +
                chapter_percent + "\", \"knowledge\":" + knowledge + "}";
    }
}
