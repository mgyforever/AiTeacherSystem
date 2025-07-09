package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.ppt;

import com.google.gson.annotations.SerializedName;

public class AiPPTBack {

    @SerializedName("ppt_url")
    String ppt_url;

    @SerializedName("office_online_url")
    String office_online_url;

    public AiPPTBack() {
    }

    public AiPPTBack(String ppt_url, String office_online_url) {
        this.ppt_url = ppt_url;
        this.office_online_url = office_online_url;
    }

    public String getPpt_url() {
        return ppt_url;
    }

    public void setPpt_url(String ppt_url) {
        this.ppt_url = ppt_url;
    }

    public String getOffice_online_url() {
        return office_online_url;
    }

    public void setOffice_online_url(String office_online_url) {
        this.office_online_url = office_online_url;
    }

    @Override
    public String toString() {
        return "{\"ppt_url\":\"" + ppt_url + "\", \"office_online_url\":\"" + office_online_url + "\"}";
    }
}
