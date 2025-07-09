package com.ccut.teachingaisystem.domain.question.rate;

public class QuestionsRate {
    int knowledge;
    double rate;
    String test_name;
    String knowledge_name;

    public QuestionsRate() {
    }

    public QuestionsRate(int knowledge, double rate, String test_name) {
        this.knowledge = knowledge;
        this.rate = rate;
        this.test_name = test_name;
    }

    public QuestionsRate(int knowledge, double rate, String test_name, String knowledge_name) {
        this.knowledge = knowledge;
        this.rate = rate;
        this.test_name = test_name;
        this.knowledge_name = knowledge_name;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(int knowledge) {
        this.knowledge = knowledge;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public String getKnowledge_name() {
        return knowledge_name;
    }

    public void setKnowledge_name(String knowledge_name) {
        this.knowledge_name = knowledge_name;
    }
}
