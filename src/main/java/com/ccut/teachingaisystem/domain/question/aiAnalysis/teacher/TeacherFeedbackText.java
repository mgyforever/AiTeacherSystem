package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher;

import com.google.gson.annotations.SerializedName;

public class TeacherFeedbackText {

    @SerializedName("student_id")
    String student_id;

    @SerializedName("suggestion")
    String suggestion;

    public TeacherFeedbackText() {
    }

    public TeacherFeedbackText(String student_id, String suggestion) {
        this.student_id = student_id;
        this.suggestion = suggestion;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    @Override
    public String toString() {
        return "{\"student_id\":\"" + student_id + "\", \"suggestion\":\"" + suggestion + "\"}";
    }
}
