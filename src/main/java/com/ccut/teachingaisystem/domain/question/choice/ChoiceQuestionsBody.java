package com.ccut.teachingaisystem.domain.question.choice;

import com.ccut.teachingaisystem.domain.question.aiAnalysis.student.AiStudentAnalysis;

public class ChoiceQuestionsBody {
    private String subject;
    private String chapter;
    private int choice_num;

    public ChoiceQuestionsBody(AiStudentAnalysis analysis) {
    }

    public ChoiceQuestionsBody(String subject, String chapter, int choice_num) {
        this.subject = subject;
        this.chapter = chapter;
        this.choice_num = choice_num;
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

    public int getChoice_num() {
        return choice_num;
    }

    public void setChoice_num(int choice_num) {
        this.choice_num = choice_num;
    }
}
