package com.ccut.teachingaisystem.domain.question.blank;

import com.ccut.teachingaisystem.domain.question.choice.QuestionsText;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Blank {
    @SerializedName("blank")
    private List<BlankQuestionText> blankQuestionTexts;

    public Blank() {
    }

    public Blank(List<BlankQuestionText> blankQuestionTexts) {
        this.blankQuestionTexts = blankQuestionTexts;
    }

    public List<BlankQuestionText> getBlankQuestionTexts() {
        return blankQuestionTexts;
    }

    public void setBlankQuestionTexts(List<BlankQuestionText> blankQuestionTexts) {
        this.blankQuestionTexts = blankQuestionTexts;
    }

    @Override
    public String toString() {
        return "{\"blank\":" + blankQuestionTexts + "}";
    }
}
