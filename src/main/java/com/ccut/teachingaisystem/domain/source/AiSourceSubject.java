package com.ccut.teachingaisystem.domain.source;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AiSourceSubject {

    @SerializedName("type")
    private String type;

    @SerializedName("url")
    private String url;

    @SerializedName("subject")
    private String subject;

    @SerializedName("chapters")
    private List<AiSourceChapter> chapters;

    public AiSourceSubject() {
    }

    public AiSourceSubject(String type, String url, String subject, List<AiSourceChapter> chapters) {
        this.type = type;
        this.url = url;
        this.subject = subject;
        this.chapters = chapters;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<AiSourceChapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<AiSourceChapter> chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "{\"type\":\"" + type + "\", \"url\":\"" + url + "\", \"subject\":\""
                + subject + "\", \"chapters\":" + chapters + "}";
    }
}
