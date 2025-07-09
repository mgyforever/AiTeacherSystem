package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.ppt;

import com.google.gson.annotations.SerializedName;

public class PPTFile {
    @SerializedName("ppt_url")
    private String pptUrl;

    @SerializedName("office_outline_file")
    private String officeUrl;

    @SerializedName("outline_file")
    private String outlineUrl;

    public PPTFile() {
    }

    public PPTFile(String pptUrl, String outlineUrl, String officeUrl) {
        this.pptUrl = pptUrl;
        this.outlineUrl = outlineUrl;
        this.officeUrl = officeUrl;
    }

    public String getPptUrl() {
        return pptUrl;
    }

    public void setPptUrl(String pptUrl) {
        this.pptUrl = pptUrl;
    }

    public String getOutlineUrl() {
        return outlineUrl;
    }

    public void setOutlineUrl(String outlineUrl) {
        this.outlineUrl = outlineUrl;
    }

    public String getOfficeUrl() {
        return officeUrl;
    }

    public void setOfficeUrl(String officeUrl) {
        this.officeUrl = officeUrl;
    }

    @Override
    public String toString() {
        return "{\"pptUrl\":\"" + pptUrl + "\", \"office\":\"" + officeUrl + "\",\"outlineUrl\":\"" + outlineUrl +"\"}";
    }
}
