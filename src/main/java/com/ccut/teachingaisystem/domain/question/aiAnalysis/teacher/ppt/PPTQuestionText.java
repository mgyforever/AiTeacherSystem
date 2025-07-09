package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.ppt;

import com.google.gson.annotations.SerializedName;

public class PPTQuestionText {

    @SerializedName("question")
    String question;

    @SerializedName("option1")
    String option1;

    @SerializedName("option2")
    String option2;

    @SerializedName("option3")
    String option3;

    @SerializedName("option4")
    String option4;

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

    public PPTQuestionText() {
    }

    public PPTQuestionText(String question, String option1, String option2, String option3
            , String option4, String answer, String analysis, String subject, String chapter
            , int judge) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
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

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
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
        return "{\"question\":\"" + question + "\", \"option1\":\"" + option1 + "\", \"option2\":\""
                + option2 +  "\", \"option3\":\"" + option3 + "\", \"option4\":\"" + option4
                + "\", \"answer\":\"" + answer + "\", \"analysis\":\"" + analysis
                + "\", \"subject\":\"" + subject + "\", \"chapter\":\"" + chapter
                + "\", \"judge\":" + judge + "\"}";
    }
}
