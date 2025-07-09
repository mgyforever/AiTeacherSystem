package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.ppt;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AiPPtTextBack {

    @SerializedName("question_most_choice")
    List<ChoiceQuestionBackText> question_most_choice;

    @SerializedName("question_most_blank")
    List<BlankQuestionBackText> question_most_blank;

    @SerializedName("section")
    String section;

    @SerializedName("topics")
    List<PPTTitleText> topics;

    public AiPPtTextBack() {
    }

    public AiPPtTextBack(List<ChoiceQuestionBackText> question_most_choice
            , List<BlankQuestionBackText> question_most_blank
            , String section, List<PPTTitleText> topics) {
        this.question_most_choice = question_most_choice;
        this.question_most_blank = question_most_blank;
        this.section = section;
        this.topics = topics;
    }

    public List<ChoiceQuestionBackText> getQuestion_most_choice() {
        return question_most_choice;
    }

    public void setQuestion_most_choice(List<ChoiceQuestionBackText> question_most_choice) {
        this.question_most_choice = question_most_choice;
    }

    public List<BlankQuestionBackText> getQuestion_most_blank() {
        return question_most_blank;
    }

    public void setQuestion_most_blank(List<BlankQuestionBackText> question_most_blank) {
        this.question_most_blank = question_most_blank;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public List<PPTTitleText> getTopics() {
        return topics;
    }

    public void setTopics(List<PPTTitleText> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "{\"question_most_choice\":" + question_most_choice + ", \"question_most_blank\":"
                + question_most_blank + ", \"section\":\"" + section + "\", \"topics\":" + topics + "}";
    }
}
