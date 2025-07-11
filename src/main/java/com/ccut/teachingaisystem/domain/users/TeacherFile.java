package com.ccut.teachingaisystem.domain.users;

public class TeacherFile {
    int id;
    String teacher_id;
    String file_path;
    String file_name;

    public TeacherFile() {
    }

    public TeacherFile(int id, String teacher_id, String file_path,  String file_name) {
        this.id = id;
        this.teacher_id = teacher_id;
        this.file_path = file_path;
        this.file_name = file_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }
}
