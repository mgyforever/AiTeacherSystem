package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.course;

import com.google.gson.annotations.SerializedName;

public class AiVideo {

    @SerializedName("video_url")
    String video_url;

    @SerializedName("subject")
    String subject;

    @SerializedName("chapter")
    String chapter;

    public AiVideo() {
    }

    public AiVideo(String video_url, String subject, String chapter) {
        this.video_url = video_url;
        this.subject = subject;
        this.chapter = chapter;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
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

    @Override
    public String toString() {
        return new com.google.gson.Gson().toJson(this);
    }
}
