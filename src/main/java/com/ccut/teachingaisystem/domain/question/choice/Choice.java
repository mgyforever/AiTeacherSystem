package com.ccut.teachingaisystem.domain.question.choice;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Choice {
    @SerializedName("choice")
    private List<QuestionsText> choicesQuestions;

    public Choice() {
    }

    public Choice(List<QuestionsText> choicesQuestions) {
        this.choicesQuestions = choicesQuestions;
    }

    public List<QuestionsText> getChoicesQuestions() {
        return choicesQuestions;
    }

    public void setChoicesQuestions(List<QuestionsText> choicesQuestions) {
        this.choicesQuestions = choicesQuestions;
    }

    @Override
    public String toString() {
        return "{\"choice\":" + choicesQuestions + "}";
    }

}
