package com.ccut.teachingaisystem.domain.question.aiAnalysis.student;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AiStudentPercent {

    @SerializedName("subject")
    List<StudentChapterPercentText> subject;

    public AiStudentPercent() {
    }

    public AiStudentPercent(List<StudentChapterPercentText> subject) {
        this.subject = subject;
    }

    public List<StudentChapterPercentText> getSubject() {
        return subject;
    }

    public void setSubject(List<StudentChapterPercentText> subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "{\"subject\":" + subject + "}";
    }
}
