package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher;

import com.google.gson.annotations.SerializedName;

public class TeacherAnalysisText {

    @SerializedName("chapter")
    private String chapter;

    @SerializedName("knowledge")
    private String knowledge;

    @SerializedName("judge")
    int judge;

    @SerializedName("student_id")
    private String student_id;

    public TeacherAnalysisText() {
    }

    public TeacherAnalysisText(String chapter, String knowledge, int judge, String student_id) {
        this.chapter = chapter;
        this.knowledge = knowledge;
        this.judge = judge;
        this.student_id = student_id;
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

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    @Override
    public String toString() {
        return "{\"chapter\":\"" + chapter + "\", \"knowledge\":\"" + knowledge +
                "\", \"judge\":" + judge + "\", \"student_id\":\"" + student_id + "\"}";
    }
}
