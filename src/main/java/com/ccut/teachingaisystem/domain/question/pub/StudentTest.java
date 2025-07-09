package com.ccut.teachingaisystem.domain.question.pub;

import java.util.List;

public class StudentTest {
    private int id;
    private String test_id;
    private String test_name;
    private String time;
    private String year;
    private String professional;
    private String classroom;
    private String student_id;
    private String name;
    double grade;
    private List<JudgeQuestions> judge_questions;

    public StudentTest() {
    }

    public StudentTest(String test_id, String test_name, String time, String classroom, String student_id
            , String name, double grade, List<JudgeQuestions> judge_questions) {
        this.test_id = test_id;
        this.test_name = test_name;
        this.time = time;
        this.classroom = classroom;
        this.student_id = student_id;
        this.name = name;
        this.grade = grade;
        this.judge_questions = judge_questions;
    }

    public StudentTest(int id, String test_id, String test_name, String time, String classroom
            , String student_id, List<JudgeQuestions> judge_questions, double grade
            , String year, String professional) {
        this.id = id;
        this.test_id = test_id;
        this.test_name = test_name;
        this.time = time;
        this.classroom = classroom;
        this.student_id = student_id;
        this.judge_questions = judge_questions;
        this.grade = grade;
        this.year = year;
        this.professional = professional;
    }

    public StudentTest(String test_id, String test_name, String time, String classroom
            , String name, String student_id, List<JudgeQuestions> judge_questions) {
        this.test_id = test_id;
        this.test_name = test_name;
        this.time = time;
        this.classroom = classroom;
        this.name = name;
        this.student_id = student_id;
        this.judge_questions = judge_questions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTest_id() {
        return test_id;
    }

    public void setTest_id(String test_id) {
        this.test_id = test_id;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public List<JudgeQuestions> getJudge_questions() {
        return judge_questions;
    }

    public void setJudge_questions(List<JudgeQuestions> judge_questions) {
        this.judge_questions = judge_questions;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }
}
