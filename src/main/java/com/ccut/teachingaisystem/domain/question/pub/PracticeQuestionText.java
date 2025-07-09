package com.ccut.teachingaisystem.domain.question.pub;

public class PracticeQuestionText {
    int id;
    String time;
    String practice_name;
    String teacher_id;
    int question_id;
    int type;
    String img1;
    String img2;
    String img3;

    public PracticeQuestionText() {
    }

    public PracticeQuestionText(int id, String time, String practice_name
            , String teacher_id, int question_id, int type,  String img1
            ,  String img2, String img3) {
        this.id = id;
        this.time = time;
        this.practice_name = practice_name;
        this.teacher_id = teacher_id;
        this.question_id = question_id;
        this.type = type;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPractice_name() {
        return practice_name;
    }

    public void setPractice_name(String practice_name) {
        this.practice_name = practice_name;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }
}
