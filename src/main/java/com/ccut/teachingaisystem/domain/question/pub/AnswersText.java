package com.ccut.teachingaisystem.domain.question.pub;

public class AnswersText {
    private int id;
    private String question;
    private String answer;
    private String analysis;
    private String subject;
    private String chapter;
    private String knowledge;
    private String reply;

    public AnswersText() {
    }

    public AnswersText(int id, String question, String answer, String analysis
            , String subject, String chapter, String reply, String knowledge) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.analysis = analysis;
        this.subject = subject;
        this.chapter = chapter;
        this.reply = reply;
        this.knowledge = knowledge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

}
