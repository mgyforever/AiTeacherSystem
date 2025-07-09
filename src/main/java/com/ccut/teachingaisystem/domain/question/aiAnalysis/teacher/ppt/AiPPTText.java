package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.ppt;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AiPPTText {

    @SerializedName("subject")
    String subject;

    @SerializedName("chapter")
    String chapter;

    @SerializedName("questions_choice")
    List<PPTQuestionText> questions_choice;

    @SerializedName("questions_blank")
    List<PPTBlankText> questions_blank;

    public AiPPTText() {
    }

    public AiPPTText(String subject, String chapter, List<PPTQuestionText> questions_choice
            , List<PPTBlankText> questions_blank) {
        this.subject = subject;
        this.chapter = chapter;
        this.questions_choice = questions_choice;
        this.questions_blank = questions_blank;
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

    public List<PPTQuestionText> getQuestions_choice() {
        return questions_choice;
    }

    public void setQuestions_choice(List<PPTQuestionText> questions_choice) {
        this.questions_choice = questions_choice;
    }

    public List<PPTBlankText> getQuestions_blank() {
        return questions_blank;
    }

    public void setQuestions_blank(List<PPTBlankText> questions_blank) {
        this.questions_blank = questions_blank;
    }

    @Override
    public String toString() {
        return "{\"subject\":\"" + subject + "\", \"chapter\":\"" + chapter +
                "\", \"questions_choice\":" + questions_choice + ", \"questions_blank\":"
                + questions_blank + "}";
    }
}
