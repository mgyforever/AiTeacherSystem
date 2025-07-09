package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.test;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChapterPointsText {

    @SerializedName("chapter")
    String chapter;

    @SerializedName("chapter_points")
    double chapter_points;

    @SerializedName("knowledges")
    List<KnowledgePointsText> knowledges;

    public ChapterPointsText() {
    }

    public ChapterPointsText(String chapter, double chapter_points, List<KnowledgePointsText> knowledges) {
        this.chapter = chapter;
        this.chapter_points = chapter_points;
        this.knowledges = knowledges;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public double getChapter_points() {
        return chapter_points;
    }

    public void setChapter_points(double chapter_points) {
        this.chapter_points = chapter_points;
    }

    public List<KnowledgePointsText> getKnowledges() {
        return knowledges;
    }

    public void setKnowledges(List<KnowledgePointsText> knowledges) {
        this.knowledges = knowledges;
    }

    @Override
    public String toString() {
        return "{\"chapter\":\"" + chapter + "\", \"chapter_points\":\""
                + chapter_points + "\" ,\"knowledges\":" + knowledges + "}";
    }
}
