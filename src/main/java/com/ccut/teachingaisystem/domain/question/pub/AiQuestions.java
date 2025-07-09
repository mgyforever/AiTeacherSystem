package com.ccut.teachingaisystem.domain.question.pub;

import com.ccut.teachingaisystem.domain.question.choice.Choice;
import com.google.gson.annotations.SerializedName;

public class AiQuestions {
    @SerializedName("choice")
    private Choice choice;

    public AiQuestions() {
    }

    public AiQuestions(Choice choice) {
        this.choice = choice;
    }

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }

    @Override
    public String toString() {
        return "{\"choice\":" + choice + "}";
    }
}
