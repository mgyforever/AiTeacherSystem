package com.ccut.teachingaisystem.domain.question.rate;

public class Knowledge {
    int id;
    String name;
    int chapter;
    String chapterName;
    String subjectName;

    public Knowledge() {
    }

    public Knowledge(int id, String name, int chapter, String chapterName, String subjectName) {
        this.id = id;
        this.name = name;
        this.chapter = chapter;
        this.chapterName = chapterName;
        this.subjectName = subjectName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
