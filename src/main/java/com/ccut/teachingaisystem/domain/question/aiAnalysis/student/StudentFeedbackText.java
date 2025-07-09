package com.ccut.teachingaisystem.domain.question.aiAnalysis.student;

import com.google.gson.annotations.SerializedName;

public class StudentFeedbackText {

    @SerializedName("suggestion")
    private String suggestion;

    public StudentFeedbackText() {
    }

    public StudentFeedbackText(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    @Override
    public String toString() {
        return "{\"suggestion\":\"" + suggestion + "\"}";
    }
}
