package com.ccut.teachingaisystem.domain.question.pub;

public class Test {

    /**
     * 必须的参数:
     * String begin(year-month-day h:m:s), String end(year-month-day h:m:s), String classroom, String name
     * , String subject, int[] question_id, String teacher_id, int duration
     */

    private int id;
    //不传
    private String test_id;
    //格式为year-month-day h:m:s
    private String begin;
    //格式为year-month-day h:m:s
    private String end;
    private String year;
    private String professional;
    private String classroom;
    private String name;
    private String subject;
    private int[] chapter_id;
    private int[] blank_chapter_id;
    private int[] question_id;
    private int[] blank_question_id;
    private double[] question_grade;
    private int[] knowledge_id;
    private int[] blank_knowledge_id;
    private double[] blank_question_grade;
    private String teacher_name;
    private String teacher_id;
    //不传
    private String question_text;
    //不传
    private String grade_text;
    //不传
    private String knowledge_text;
    private int duration;
    private double grade;

    public Test() {
    }

    public Test(String begin, String end, String classroom, String name, String subject, int[] question_id
            , double[] question_grade, int[] knowledge_id, String teacher_name, String teacher_id
            , int duration, double grade, String year, int[] blank_question_id, int[] blank_chapter_id
            , int[] blank_knowledge_id, double[] blank_question_grade) {
        this.begin = begin;
        this.end = end;
        this.classroom = classroom;
        this.name = name;
        this.subject = subject;
        this.question_id = question_id;
        this.question_grade = question_grade;
        this.knowledge_id = knowledge_id;
        this.teacher_name = teacher_name;
        this.teacher_id = teacher_id;
        this.duration = duration;
        this.grade = grade;
        this.year = year;
        this.blank_question_id = blank_question_id;
        this.blank_chapter_id = blank_chapter_id;
        this.blank_knowledge_id = blank_knowledge_id;
        this.blank_question_grade = blank_question_grade;
    }

    public Test(String begin, String end, String classroom, String name, String subject
            , int[] question_id, double[] question_grade, String teacher_name
            , String teacher_id, int duration, double grade, String year, int[] blank_question_id
            , int[] blank_chapter_id, int[] blank_knowledge_id, double[] blank_question_grade) {
        this.begin = begin;
        this.end = end;
        this.classroom = classroom;
        this.name = name;
        this.subject = subject;
        this.question_id = question_id;
        this.question_grade = question_grade;
        this.teacher_name = teacher_name;
        this.teacher_id = teacher_id;
        this.duration = duration;
        this.grade = grade;
        this.year = year;
        this.blank_question_id = blank_question_id;
        this.blank_chapter_id = blank_chapter_id;
        this.blank_knowledge_id = blank_knowledge_id;
        this.blank_question_grade = blank_question_grade;
    }

    public Test(int id, String test_id, String end, String classroom, String name, int[] question_id
            , double[] question_grade, String teacher_name, String teacher_id
            , String question_text, int duration, String year, int[] blank_question_id, int[] blank_chapter_id
            , int[] blank_knowledge_id, double[] blank_question_grade) {
        this.id = id;
        this.test_id = test_id;
        this.end = end;
        this.classroom = classroom;
        this.name = name;
        this.question_id = question_id;
        this.question_grade = question_grade;
        this.teacher_name = teacher_name;
        this.teacher_id = teacher_id;
        this.question_text = question_text;
        this.duration = duration;
        this.year = year;
        this.blank_question_id = blank_question_id;
        this.blank_chapter_id = blank_chapter_id;
        this.blank_knowledge_id = blank_knowledge_id;
        this.blank_question_grade = blank_question_grade;
    }

    public Test(int id, String test_id, String begin, String end, String classroom, String name
            , String subject, int[] question_id, String teacher_name, String teacher_id
            , String question_text, int duration, double[] question_grade, String year
            , int[] blank_question_id, int[] blank_chapter_id, int[] blank_knowledge_id
            , double[] blank_question_grade, String professional) {
        this.id = id;
        this.test_id = test_id;
        this.begin = begin;
        this.end = end;
        this.classroom = classroom;
        this.name = name;
        this.subject = subject;
        this.question_id = question_id;
        this.teacher_name = teacher_name;
        this.teacher_id = teacher_id;
        this.question_text = question_text;
        this.duration = duration;
//        ChoiceQuestions = choiceQuestions;
//        this.blankQuestions = blankQuestions;
        this.question_grade = question_grade;
        this.year = year;
        this.blank_question_id = blank_question_id;
        this.blank_chapter_id = blank_chapter_id;
        this.blank_knowledge_id = blank_knowledge_id;
        this.blank_question_grade = blank_question_grade;
        this.professional = professional;
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

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int[] getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int[] question_id) {
        this.question_id = question_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double[] getQuestion_grade() {
        return question_grade;
    }

    public void setQuestion_grade(double[] question_grade) {
        this.question_grade = question_grade;
    }

    public String getGrade_text() {
        return grade_text;
    }

    public void setGrade_text(String grade_text) {
        this.grade_text = grade_text;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int[] getKnowledge_id() {
        return knowledge_id;
    }

    public void setKnowledge_id(int[] knowledge_id) {
        this.knowledge_id = knowledge_id;
    }

    public String getKnowledge_text() {
        return knowledge_text;
    }

    public void setKnowledge_text(String knowledge_text) {
        this.knowledge_text = knowledge_text;
    }

    public int[] getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(int[] chapter_id) {
        this.chapter_id = chapter_id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int[] getBlank_chapter_id() {
        return blank_chapter_id;
    }

    public void setBlank_chapter_id(int[] blank_chapter_id) {
        this.blank_chapter_id = blank_chapter_id;
    }

    public int[] getBlank_question_id() {
        return blank_question_id;
    }

    public void setBlank_question_id(int[] blank_question_id) {
        this.blank_question_id = blank_question_id;
    }

    public int[] getBlank_knowledge_id() {
        return blank_knowledge_id;
    }

    public void setBlank_knowledge_id(int[] blank_knowledge_id) {
        this.blank_knowledge_id = blank_knowledge_id;
    }

    public double[] getBlank_question_grade() {
        return blank_question_grade;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public void setBlank_question_grade(double[] blank_question_grade) {
        this.blank_question_grade = blank_question_grade;
    }
}
