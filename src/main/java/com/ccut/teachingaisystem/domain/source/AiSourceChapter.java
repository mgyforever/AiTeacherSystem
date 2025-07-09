package com.ccut.teachingaisystem.domain.source;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AiSourceChapter {

    @SerializedName("chapter")
    private String chapter;

    @SerializedName("knowledge")
    private List<String> knowledge;

    public AiSourceChapter() {
    }

    public AiSourceChapter(String chapter, List<String> knowledge) {
        this.chapter = chapter;
        this.knowledge = knowledge;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public List<String> getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(List<String> knowledge) {
        this.knowledge = knowledge;
    }

    @Override
    public String toString() {
        return "{\"chapter\":\"" + chapter + "\", \"knowledge\":" + knowledge + "}";
    }
}
