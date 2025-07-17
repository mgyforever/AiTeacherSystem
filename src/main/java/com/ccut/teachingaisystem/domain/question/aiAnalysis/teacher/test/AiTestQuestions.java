package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.test;

import com.ccut.teachingaisystem.domain.question.pub.ChoiceAndBlankQuestion;

import java.util.List;

public class AiTestQuestions {
    AiTestPercent aiTestPercent;
    List<ChoiceAndBlankQuestion> Questions;

    public AiTestQuestions() {
    }

    public AiTestQuestions(AiTestPercent aiTestPercent, List<ChoiceAndBlankQuestion> questions) {
        this.aiTestPercent = aiTestPercent;
        Questions = questions;
    }

    public AiTestPercent getAiTestPercent() {
        return aiTestPercent;
    }

    public void setAiTestPercent(AiTestPercent aiTestPercent) {
        this.aiTestPercent = aiTestPercent;
    }

    public List<ChoiceAndBlankQuestion> getQuestions() {
        return Questions;
    }

    public void setQuestions(List<ChoiceAndBlankQuestion> questions) {
        Questions = questions;
    }

    @Override
    public String toString() {
        return "{\"aiTestPercent\":" + aiTestPercent + ", \"questions\":" + Questions + "}";
    }
}
