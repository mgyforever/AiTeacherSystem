package com.ccut.teachingaisystem.domain.source;

import com.google.gson.annotations.SerializedName;

public class AiSourceResult {

    @SerializedName("subject")
    String subject;

    @SerializedName("statue")
    int statue;

    public AiSourceResult() {
    }

    public AiSourceResult(String subject, int statue) {
        this.subject = subject;
        this.statue = statue;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getStatue() {
        return statue;
    }

    public void setStatue(int statue) {
        this.statue = statue;
    }

    @Override
    public String toString() {
        return "{\"subject\":\"" + subject + "\", \"statue\":\"" + statue + "\"}";
    }
}
