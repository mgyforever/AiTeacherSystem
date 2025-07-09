package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.ppt;

import com.google.gson.annotations.SerializedName;

public class BlankQuestionBackText {

    @SerializedName("question")
    String question;

    @SerializedName("answer")
    String answer;

    @SerializedName("analysis")
    String analysis;

    public BlankQuestionBackText() {
    }

    public BlankQuestionBackText(String question, String answer, String analysis) {
        this.question = question;
        this.answer = answer;
        this.analysis = analysis;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    @Override
    public String toString() {
        return "{\"question\":\"" + question + "\", \"answer\":\"" + answer
                + "\", \"analysis\":\"" + analysis + "\"}";
    }
}
