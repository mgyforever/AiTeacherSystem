package com.ccut.teachingaisystem.domain.question.choice;

public class JudgeResult {
    private int id;
    private int judge;
    private int questionId;
    private String classroom;
    private String student_id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
    private String analysis;
    private String subject;
    private String chapter;
    private String knowledge;
    private String reply;
    private int practice_id;
    private int question_id;
    private String img1;
    private String img2;
    private String img3;

    public JudgeResult() {
    }


    public JudgeResult(int id, int questionId, String student_id) {
        this.id = id;
        this.questionId = questionId;
        this.student_id = student_id;
    }

    public JudgeResult(int judge, int questionId, String student_id, String reply) {
        this.judge = judge;
        this.questionId = questionId;
        this.student_id = student_id;
        this.reply = reply;
    }

    public JudgeResult(int judge, String student_id, String question, String answer
            , String analysis, String subject, String chapter
            , String knowledge,  String reply, String classroom) {
        this.judge = judge;
        this.student_id = student_id;
        this.question = question;
        this.answer = answer;
        this.analysis = analysis;
        this.subject = subject;
        this.knowledge = knowledge;
        this.chapter = chapter;
        this.reply = reply;
        this.classroom = classroom;
    }

    public JudgeResult(int judge, String student_id, String question, String option1, String option2
            , String option3, String option4, String answer, String analysis, String subject
            , String chapter, String knowledge, String reply, String classroom) {
        this.judge = judge;
        this.student_id = student_id;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
        this.analysis = analysis;
        this.subject = subject;
        this.chapter = chapter;
        this.knowledge = knowledge;
        this.reply = reply;
        this.classroom = classroom;
    }

    public JudgeResult(int judge, int questionId, String student_id, String question, String option1
            , String option2, String option3, String option4, String answer
            , String analysis, String subject, String chapter
            , String knowledge, String reply) {
        this.judge = judge;
        this.questionId = questionId;
        this.student_id = student_id;
        this.option1 = option1;
        this.question = question;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
        this.analysis = analysis;
        this.subject = subject;
        this.chapter = chapter;
        this.knowledge = knowledge;
        this.reply = reply;
    }

    public JudgeResult(int id, int judge, int questionId, String student_id, String question
            , String option1, String option2, String option3, String option4, String answer
            , String analysis, String subject, String chapter, String knowledge, String reply
            , String classroom, int practice_id, int question_id, String img1, String img2
            , String img3) {
        this.id = id;
        this.judge = judge;
        this.questionId = questionId;
        this.student_id = student_id;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
        this.analysis = analysis;
        this.subject = subject;
        this.chapter = chapter;
        this.knowledge = knowledge;
        this.reply = reply;
        this.classroom = classroom;
        this.practice_id = practice_id;
        this.question_id = question_id;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
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

    public int getJudge() {
        return judge;
    }

    public void setJudge(int judge) {
        this.judge = judge;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getPractice_id() {
        return practice_id;
    }

    public void setPractice_id(int practice_id) {
        this.practice_id = practice_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    @Override
    public String toString() {
        return "JudgeResult [id=" + id + ", questionId=" + questionId + "]";
    }
}
