package com.ccut.teachingaisystem.domain.question.blank;

public class BlankQuestionsBody {
    private String subject;
    private String chapter;
    private int blank_num;

    public BlankQuestionsBody() {
    }

    public BlankQuestionsBody(String subject, String chapter, int blank_num) {
        this.subject = subject;
        this.chapter = chapter;
        this.blank_num = blank_num;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public int getBlank_num() {
        return blank_num;
    }

    public void setBlank_num(int blank_num) {
        this.blank_num = blank_num;
    }
}
