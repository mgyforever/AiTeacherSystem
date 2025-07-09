package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeacherChapterPercentText {

    @SerializedName("chapter_name")
    String chapter_name;

    @SerializedName("knowledge_percent")
    double knowledge_percent;

    @SerializedName("knowledge")
    List<TeacherPercentText> knowledge;

    public TeacherChapterPercentText() {
    }

    public TeacherChapterPercentText(String chapter_name, double knowledge_percent, List<TeacherPercentText> knowledge) {
        this.chapter_name = chapter_name;
        this.knowledge_percent = knowledge_percent;
        this.knowledge = knowledge;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }

    public double getKnowledge_percent() {
        return knowledge_percent;
    }

    public void setKnowledge_percent(double knowledge_percent) {
        this.knowledge_percent = knowledge_percent;
    }

    public List<TeacherPercentText> getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(List<TeacherPercentText> knowledge) {
        this.knowledge = knowledge;
    }
    @Override
    public String toString() {
        return "{\"chapter_name\":\"" + chapter_name + "\",\"knowledge_percent\":\""
                + knowledge_percent + "\",\"knowledge\":" + knowledge + "}";
    }
}
