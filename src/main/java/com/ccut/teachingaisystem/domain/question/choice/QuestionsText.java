package com.ccut.teachingaisystem.domain.question.choice;

public class QuestionsText {
    int id;
    String question;
    String option1;
    String option2;
    String option3;
    String option4;
    String answer;
    String analysis;
    String subject;
    String chapter;
    String knowledge;

    public QuestionsText() {
    }

    public QuestionsText(String question, String option1, String option2, String option3, String option4
            , String answer, String analysis, String subject, String chapter, String knowledge) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
        this.analysis = analysis;
        this.subject = subject;
        this.chapter = chapter;
        this.knowledge = knowledge;
    }

    public QuestionsText(int id, String question, String option1, String option2, String option3
            , String option4, String answer, String analysis, String subject
            , String chapter, String knowledge) {
        this.id = id;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
        this.analysis = analysis;
        this.subject = subject;
        this.chapter = chapter;
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

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
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

    @Override
    public String toString() {
        return "{\"id\":" + "\"" + id + "\"" + ", \"question\":" + "\"" + question + "\"" + ", \"option1\":" + "\"" + option1 + "\"" + ", \"option2\":" + "\"" + option2 + "\""
                + ", \"option3\":" + "\"" + option3 + "\"" + ", \"option4\":" + "\"" + option4 + "\"" + ", \"answer\":"
                + "\"" + answer + "\"" + ", \"analysis\":" + "\"" + analysis + "\"" + ", \"subject\":" + "\"" + subject + "\"" + ", \"chapter\":" + "\"" + chapter + "\""
                + ", \"knowledge\":" + "\"" + knowledge + "\"" + "}";
    }
}
