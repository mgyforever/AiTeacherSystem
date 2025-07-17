package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.ppt;

import com.google.gson.annotations.SerializedName;

public class PPTTitleText {

    @SerializedName("title")
    String title;

    @SerializedName("points")
    PPTPointsText points;

    @SerializedName("time_allocation")
    String time_allocation;

    public PPTTitleText() {
    }

    public PPTTitleText(String title, PPTPointsText points, String time_allocation) {
        this.title = title;
        this.points = points;
        this.time_allocation = time_allocation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PPTPointsText getPoints() {
        return points;
    }

    public void setPoints(PPTPointsText points) {
        this.points = points;
    }

    public String getTime_allocation() {
        return time_allocation;
    }

    public void setTime_allocation(String time_allocation) {
        this.time_allocation = time_allocation;
    }

    @Override
    public String toString() {
        return new com.google.gson.Gson().toJson(this);
    }
}
