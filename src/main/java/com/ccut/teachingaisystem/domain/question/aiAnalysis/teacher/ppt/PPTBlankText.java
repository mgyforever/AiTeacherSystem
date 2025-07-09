package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.ppt;

import com.google.gson.annotations.SerializedName;

public class PPTBlankText {

    @SerializedName("question")
    String question;

    @SerializedName("answer")
    String answer;

    @SerializedName("analysis")
    String analysis;

    @SerializedName("subject")
    String subject;

    @SerializedName("chapter")
    String chapter;

    @SerializedName("judge")
    int judge;

    public PPTBlankText() {
    }

    public PPTBlankText(String question, String answer, String analysis
            , String subject, String chapter, int judge) {
        this.question = question;
        this.answer = answer;
        this.analysis = analysis;
        this.subject = subject;
        this.chapter = chapter;
        this.judge = judge;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public int getJudge() {
        return judge;
    }

    public void setJudge(int judge) {
        this.judge = judge;
    }

    @Override
    public String toString() {
        return "{\"question\":\"" + question + "\", \"answer\":\"" + answer + "\", \"analysis\":\""
                + analysis + "\", \"subject\":\"" + subject + "\", \"chapter\":\"" + chapter
                + "\", \"judge\":\"" + judge + "\"}";
    }
}
