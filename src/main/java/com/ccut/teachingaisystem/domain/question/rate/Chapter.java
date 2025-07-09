package com.ccut.teachingaisystem.domain.question.rate;

public class Chapter {
    int id;
    String subject;
    String chapter;

    public Chapter() {
    }

    public Chapter(int id, String subject, String chapter) {
        this.id = id;
        this.subject = subject;
        this.chapter = chapter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return Chapter.class.getSimpleName() + " [id=" + id + ", chapter="
                + chapter + "]";
    }
}
