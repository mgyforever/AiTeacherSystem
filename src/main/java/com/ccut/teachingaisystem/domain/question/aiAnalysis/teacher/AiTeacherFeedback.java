package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher;

import com.google.gson.annotations.SerializedName;

public class AiTeacherFeedback {

    @SerializedName("analysis")
    TeacherStudentFeedbackText analysis;

    public AiTeacherFeedback() {
    }

    public AiTeacherFeedback(TeacherStudentFeedbackText analysis) {
        this.analysis = analysis;
    }

    public TeacherStudentFeedbackText getAnalysis() {
        return analysis;
    }

    public void setAnalysis(TeacherStudentFeedbackText analysis) {
        this.analysis = analysis;
    }

    @Override
    public String toString() {
        return "{\"analysis\":" + analysis + "}";
    }
}
