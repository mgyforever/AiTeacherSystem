package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AiTeacherAnalysis {

    @SerializedName("subject")
    List<TeacherAnalysisText> subject;

    public AiTeacherAnalysis() {
    }

    public AiTeacherAnalysis(List<TeacherAnalysisText> subject) {
        this.subject = subject;
    }

    public List<TeacherAnalysisText> getSubject() {
        return subject;
    }

    public void setSubject(List<TeacherAnalysisText> subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "{\"subject\":" + subject + "}";
    }
}
