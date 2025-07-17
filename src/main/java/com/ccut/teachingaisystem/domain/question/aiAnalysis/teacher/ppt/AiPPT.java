package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.ppt;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AiPPT {

    @SerializedName("author")
    String author;

    @SerializedName("subject")
    String subject;

    @SerializedName("question_most_choice")
    List<String> question_most_choice;

    @SerializedName("question_most_blank")
    List<String> question_most_blank;

    @SerializedName("section")
    String section;

    @SerializedName("topics")
    List<PPTTitleText> topics;

    public AiPPT() {
    }

    public AiPPT(String author, String subject, String chapter, List<PPTTitleText> topics) {
        this.author = author;
        this.subject = subject;
        this.topics = topics;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<PPTTitleText> getTopics() {
        return topics;
    }

    public void setTopics(List<PPTTitleText> topics) {
        this.topics = topics;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public List<String> getQuestion_most_choice() {
        return question_most_choice;
    }

    public void setQuestion_most_choice(List<String> question_most_choice) {
        this.question_most_choice = question_most_choice;
    }

    public List<String> getQuestion_most_blank() {
        return question_most_blank;
    }

    public void setQuestion_most_blank(List<String> question_most_blank) {
        this.question_most_blank = question_most_blank;
    }

    @Override
    public String toString() {
        return new com.google.gson.Gson().toJson(this);
    }
}
