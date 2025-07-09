package com.ccut.teachingaisystem.domain.question.analysis;

public class MyResponseBody {
    private String[][] chapters;
    private String judges;
    private double[][] proportion;

    public MyResponseBody() {
    }

    public MyResponseBody(String[][] chapters, String judges, double[][] proportion) {
        this.chapters = chapters;
        this.judges = judges;
        this.proportion = proportion;
    }

    public String[][] getChapters() {
        return chapters;
    }

    public void setChapters(String[][] chapters) {
        this.chapters = chapters;
    }

    public double[][] getProportion() {
        return proportion;
    }

    public void setProportion(double[][] judge) {
        this.proportion = judge;
    }

    public String getJudges() {
        return judges;
    }

    public void setJudges(String judges) {
        this.judges = judges;
    }
}
