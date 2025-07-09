package com.ccut.teachingaisystem.domain.question.analysis;

public class Test {
    private String chapter;
    private String Knowledge;
    int judge;

    public Test() {
    }

    public Test(String chapter, String knowledge, int judge) {
        this.chapter = chapter;
        Knowledge = knowledge;
        this.judge = judge;
    }

    public String getKnowledge() {
        return Knowledge;
    }

    public void setKnowledge(String knowledge) {
        Knowledge = knowledge;
    }

    public int getJudge() {
        return judge;
    }

    public void setJudge(int judge) {
        this.judge = judge;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }
}
