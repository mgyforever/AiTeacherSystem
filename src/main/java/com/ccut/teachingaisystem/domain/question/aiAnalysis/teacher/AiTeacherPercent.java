package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AiTeacherPercent {

    @SerializedName("subject")
    List<TeacherSubjectPercentText> subject;

    public AiTeacherPercent() {
    }

    public AiTeacherPercent(List<TeacherSubjectPercentText> subject) {
        this.subject = subject;
    }

    public List<TeacherSubjectPercentText> getSubject() {
        return subject;
    }

    public void setSubject(List<TeacherSubjectPercentText> subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "{\"subject\":" + subject + "}";
    }
}
