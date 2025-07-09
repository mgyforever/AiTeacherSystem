package com.ccut.teachingaisystem.domain.question.aiAnalysis.student;

import com.google.gson.annotations.SerializedName;

public class AiStudentFeedback {

    @SerializedName("analysis")
    private StudentFeedbackText analysis;

    public AiStudentFeedback() {
    }

    public AiStudentFeedback(StudentFeedbackText analysis) {
        this.analysis = analysis;
    }

    public StudentFeedbackText getAnalysis() {
        return analysis;
    }

    public void setAnalysis(StudentFeedbackText analysis) {
        this.analysis = analysis;
    }

    @Override
    public String toString() {
        return "{\"analysis\":" + analysis + "}";
    }
}
