package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.course;

import com.google.gson.annotations.SerializedName;

public class AiTeachingAssessmentText {

    @SerializedName("overall_performance")
    String overall_performance;

    @SerializedName("strongest_aspect")
    String strongest_aspect;

    @SerializedName("weakest_aspect")
    String weakest_aspect;

    public AiTeachingAssessmentText() {
    }

    public AiTeachingAssessmentText(String overall_performance, String strongest_aspect, String weakest_aspect) {
        this.overall_performance = overall_performance;
        this.strongest_aspect = strongest_aspect;
        this.weakest_aspect = weakest_aspect;
    }

    public String getOverall_performance() {
        return overall_performance;
    }

    public void setOverall_performance(String overall_performance) {
        this.overall_performance = overall_performance;
    }

    public String getStrongest_aspect() {
        return strongest_aspect;
    }

    public void setStrongest_aspect(String strongest_aspect) {
        this.strongest_aspect = strongest_aspect;
    }

    public String getWeakest_aspect() {
        return weakest_aspect;
    }

    public void setWeakest_aspect(String weakest_aspect) {
        this.weakest_aspect = weakest_aspect;
    }

    @Override
    public String toString() {
        return new com.google.gson.Gson().toJson(this);
    }
}
