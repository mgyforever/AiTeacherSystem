package com.ccut.teachingaisystem.domain.question.pub;

public class ChoiceAndBlankQuestion {
    int[] choiceIds;
    int[] blankIds;
    String chapter;
    String knowledge;
    String choiceStr;
    String blankStr;
    double grade;

    public ChoiceAndBlankQuestion() {
    }

    public ChoiceAndBlankQuestion(int[] choiceIds, int[] blankIds, String knowledge, double grade
            , String chapter, String choiceStr, String blankStr) {
        this.choiceIds = choiceIds;
        this.blankIds = blankIds;
        this.knowledge = knowledge;
        this.grade = grade;
        this.chapter = chapter;
        this.choiceStr = choiceStr;
        this.blankStr = blankStr;
    }

    public int[] getChoiceIds() {
        return choiceIds;
    }

    public void setChoiceIds(int[] choiceIds) {
        this.choiceIds = choiceIds;
    }

    public int[] getBlankIds() {
        return blankIds;
    }

    public void setBlankIds(int[] blankIds) {
        this.blankIds = blankIds;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getChoiceStr() {
        return choiceStr;
    }

    public void setChoiceStr(String choiceStr) {
        this.choiceStr = choiceStr;
    }

    public String getBlankStr() {
        return blankStr;
    }

    public void setBlankStr(String blankStr) {
        this.blankStr = blankStr;
    }
}
