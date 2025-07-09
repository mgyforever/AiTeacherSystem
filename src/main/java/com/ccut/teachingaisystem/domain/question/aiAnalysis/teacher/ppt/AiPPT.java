package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.ppt;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AiPPT {

    @SerializedName("author")
    String author;

    @SerializedName("subject")
    String subject;

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

    @Override
    public String toString() {
        return "{\"author\":\"" + author + "\", \"subject\":\"" + subject + "\", \"topics\":" + topics + "}";
    }
}
