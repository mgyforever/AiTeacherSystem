package com.ccut.teachingaisystem.domain.question.pub;

public class JudgeQuestions {
    private int question_id;
    private double grade;
    //0为选择， 1为填空
    private int type;
    //前端不用传
    private int judge;
    private String answer;

    public JudgeQuestions() {
    }


    public JudgeQuestions(int question_id, double grade, int type, int judge, String answer) {
        this.question_id = question_id;
        this.grade = grade;
        this.type = type;
        this.judge = judge;
        this.answer = answer;
    }

    public JudgeQuestions(int question_id, double grade, int type, String answer) {
        this.question_id = question_id;
        this.grade = grade;
        this.type = type;
        this.answer = answer;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getJudge() {
        return judge;
    }

    public void setJudge(int judge) {
        this.judge = judge;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "\n" + "question_id:" + question_id + ", grade:" + grade + ", type:"
                + type + ", judge:" + judge + ", answer:" + answer + "\n";
    }
}
