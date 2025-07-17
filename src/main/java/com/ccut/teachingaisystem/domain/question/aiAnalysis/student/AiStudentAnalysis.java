package com.ccut.teachingaisystem.domain.question.aiAnalysis.student;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AiStudentAnalysis {

    @SerializedName("subject_name")
    private String subject_name;

    @SerializedName("subject")
    private List<StudentAnalysisText> studentAnalysis;

    public AiStudentAnalysis() {
    }

    public AiStudentAnalysis(List<StudentAnalysisText> studentAnalysis, String subject_name) {
        this.studentAnalysis = studentAnalysis;
        this.subject_name = subject_name;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public List<StudentAnalysisText> getStudentAnalysis() {
        return studentAnalysis;
    }

    public void setStudentAnalysis(List<StudentAnalysisText> studentAnalysis) {
        this.studentAnalysis = studentAnalysis;
    }

    @Override
    public String toString() {
        return "{\"subject_name\":\"" + subject_name + "\", \"studentAnalysis\":" + studentAnalysis + "}";
    }
}
