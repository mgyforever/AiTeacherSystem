package com.ccut.teachingaisystem.domain.users;

public class StudentSubject {
    int id;
    String student_id;
    //不传
    String student_name;
    //不传
    String classroom;
    //不传
    String year;
    //不传
    String professional;
    String subject;
    String teacher_id;

    public StudentSubject() {
    }

    public StudentSubject(int id, String student_id, String subject, String teacher_id
            , String classroom, String year, String professional, String student_name) {
        this.id = id;
        this.student_id = student_id;
        this.subject = subject;
        this.teacher_id = teacher_id;
        this.classroom = classroom;
        this.year = year;
        this.professional = professional;
        this.student_name = student_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
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
