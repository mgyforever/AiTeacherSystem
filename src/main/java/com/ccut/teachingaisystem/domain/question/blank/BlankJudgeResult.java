package com.ccut.teachingaisystem.domain.question.blank;

public class BlankJudgeResult {
    private int id;
    private int judge;
    private String question;
    private String answer;
    private String analysis;
    private String subject;
    private String chapter;
    private String knowledge;
    private String practice_id;
    private String question_id;
    private String img1;
    private String img2;
    private String img3;

    public BlankJudgeResult() {
    }

    public BlankJudgeResult(int id, int judge, String question, String answer, String analysis, String subject
            , String chapter, String knowledge, String practice_id, String question_id
            , String img1, String img2, String img3) {
        this.id = id;
        this.judge = judge;
        this.question = question;
        this.answer = answer;
        this.analysis = analysis;
        this.subject = subject;
        this.chapter = chapter;
        this.knowledge = knowledge;
        this.practice_id = practice_id;
        this.question_id = question_id;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJudge() {
        return judge;
    }

    public void setJudge(int judge) {
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

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public String getPractice_id() {
        return practice_id;
    }

    public void setPractice_id(String practice_id) {
        this.practice_id = practice_id;
    }

    public String getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(String question_id) {
        this.question_id = question_id;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }
}
