package com.ccut.teachingaisystem.domain.question.blank;

import com.google.gson.annotations.SerializedName;

public class AiBlankQuestion {
    @SerializedName("blank")
    private Blank blank;

    public AiBlankQuestion() {
    }

    public AiBlankQuestion(Blank blank) {
        this.blank = blank;
    }

    public Blank getBlank() {
        return blank;
    }

    public void setBlank(Blank blank) {
        this.blank = blank;
    }

    @Override
    public String toString() {
        return "{\"blank\":" + blank + "}";
    }
}
