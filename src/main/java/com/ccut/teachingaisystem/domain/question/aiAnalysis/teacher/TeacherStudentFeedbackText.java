package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeacherStudentFeedbackText {

    @SerializedName("all_student_control_knowledge")
    String all_student_control_knowledge;

    @SerializedName("all_student_suggestion")
    String all_student_suggestion;

    @SerializedName("student")
    List<TeacherFeedbackText> student;

    public TeacherStudentFeedbackText() {
    }

    public TeacherStudentFeedbackText(String all_student_control_knowledge
            , String all_student_suggestion, List<TeacherFeedbackText> student) {
        this.all_student_control_knowledge = all_student_control_knowledge;
        this.all_student_suggestion = all_student_suggestion;
        this.student = student;
    }

    public String getAll_student_control_knowledge() {
        return all_student_control_knowledge;
    }

    public void setAll_student_control_knowledge(String all_student_control_knowledge) {
        this.all_student_control_knowledge = all_student_control_knowledge;
    }

    public String getAll_student_suggestion() {
        return all_student_suggestion;
    }

    public void setAll_student_suggestion(String all_student_suggestion) {
        this.all_student_suggestion = all_student_suggestion;
    }

    public List<TeacherFeedbackText> getStudent() {
        return student;
    }

    public void setStudent(List<TeacherFeedbackText> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "{\"all_student_control_knowledge\":\"" + all_student_control_knowledge
                + "\", \"all_student_suggestion\":\"" + all_student_suggestion
                + "\", \"student\":" + student + "}";
    }
}
