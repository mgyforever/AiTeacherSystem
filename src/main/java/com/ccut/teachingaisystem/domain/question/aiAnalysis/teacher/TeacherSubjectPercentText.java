package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeacherSubjectPercentText {

    @SerializedName("student_id")
    String student_id;

    @SerializedName("chapter")
    List<TeacherChapterPercentText> chapter;

    public TeacherSubjectPercentText() {
    }

    public TeacherSubjectPercentText(String student_id, List<TeacherChapterPercentText> chapter) {
        this.student_id = student_id;
        this.chapter = chapter;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public List<TeacherChapterPercentText> getChapter() {
        return chapter;
    }

    public void setChapter(List<TeacherChapterPercentText> chapter) {
        this.chapter = chapter;
    }

    @Override
    public String toString() {
        return "{\"student_id\":\"" + student_id + "\",\"chapter\":" + chapter + "}";
    }
}
