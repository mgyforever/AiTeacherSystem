package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.course;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AiTeacherGrade {

    @SerializedName("overall_score")
    double overall_score;

    @SerializedName("overall_grade")
    String overall_grade;

    @SerializedName("model_scores")
    AiModelScoresText model_scores;

    @SerializedName("teaching_assessment")
    AiTeachingAssessmentText teaching_assessment;

    @SerializedName("improvement_suggestions")
    List<String> improvement_suggestions;

    public AiTeacherGrade() {
    }

    public AiTeacherGrade(double overall_score, String overall_grade, AiModelScoresText model_scores
            , AiTeachingAssessmentText teaching_assessment, List<String> improvement_suggestions) {
        this.overall_score = overall_score;
        this.overall_grade = overall_grade;
        this.model_scores = model_scores;
        this.teaching_assessment = teaching_assessment;
        this.improvement_suggestions = improvement_suggestions;
    }

    public double getOverall_score() {
        return overall_score;
    }

    public void setOverall_score(double overall_score) {
        this.overall_score = overall_score;
    }

    public String getOverall_grade() {
        return overall_grade;
    }

    public void setOverall_grade(String overall_grade) {
        this.overall_grade = overall_grade;
    }

    public AiModelScoresText getModel_scores() {
        return model_scores;
    }

    public void setModel_scores(AiModelScoresText model_scores) {
        this.model_scores = model_scores;
    }

    public AiTeachingAssessmentText getTeaching_assessment() {
        return teaching_assessment;
    }

    public void setTeaching_assessment(AiTeachingAssessmentText teaching_assessment) {
        this.teaching_assessment = teaching_assessment;
    }

    public List<String> getImprovement_suggestions() {
        return improvement_suggestions;
    }

    public void setImprovement_suggestions(List<String> improvement_suggestions) {
        this.improvement_suggestions = improvement_suggestions;
    }

    @Override
    public String toString() {
        return new com.google.gson.Gson().toJson(this);
    }
}
