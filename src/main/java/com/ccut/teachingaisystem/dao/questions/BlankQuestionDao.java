package com.ccut.teachingaisystem.dao.questions;

import com.ccut.teachingaisystem.domain.question.aiAnalysis.student.StudentAnalysisText;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.TeacherAnalysisText;
import com.ccut.teachingaisystem.domain.question.blank.BlankJudgeResult;
import com.ccut.teachingaisystem.domain.question.blank.BlankQuestionText;
import com.ccut.teachingaisystem.domain.question.choice.JudgeResult;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BlankQuestionDao {
    @Insert("insert into ai_blank_test (question " +
            ",answer, analysis, subject, chapter, knowledge)" +
            " VALUES (#{question}" +
            " , #{answer}, #{analysis}, #{subject}, #{chapter}, #{knowledge})")
    int insertQuest(BlankQuestionText questionsText);

    @Insert("insert into ai_blank_test (question, answer, analysis, subject" +
            ", chapter, knowledge, img1, img2, img3)" +
            " VALUES (#{question}, #{answer}, #{analysis}, #{subject}" +
            ", #{chapter}, #{knowledge}, #{img1}, #{img2}, #{img3})")
    int insertQuestAndImg(BlankJudgeResult blankJudgeResult, String img1, String img2, String img3);

    @Insert("insert into ai_blank_wrong_question (student_id, question" +
            ",analysis, answer, reply, judge, subject, chapter, knowledge" +
            ", question_id, img1, img2, img3)" +
            " values (#{student_id}, #{question}, #{analysis}, #{answer}" +
            ", #{reply}, #{judge}, #{subject}, #{chapter}, #{knowledge}" +
            ", #{question_id}, #{img1}, #{img2}, #{img3})")
    int insertWrongQuestion(JudgeResult judgeResult);

    @Insert("insert into ai_blank_previous_question (student_id, question" +
            " ,analysis, answer, reply, judge, subject, chapter, knowledge" +
            ", classroom, practice_id, question_id, img1, img2, img3) " +
            "values (#{student_id}, #{question}, #{analysis}, #{answer}" +
            ", #{reply}, #{judge}, #{subject}, #{chapter}, #{knowledge}" +
            ", #{classroom}, #{practice_id}, #{question_id}, #{img1}, #{img2}, #{img3})")
    void insertPreviousQuestion(JudgeResult judgeResult);

    @Delete("delete from ai_blank_test where id = #{id}")
    int deleteQuestion(int id);

    @Delete("delete from ai_blank_wrong_question where id = #{id}")
    int deleteWrongQuestion(int id);

    @Delete("delete from ai_blank_wrong_question where student_id = #{student_id} and judge = 1")
    int deleteAllWrongQuestion(String student_id);

    @Delete("delete from ai_blank_wrong_question where student_id = #{student_id}")
    int deleteAllQuestion(String student_id);

    @Delete("delete from ai_blank_previous_question where student_id = #{student_id}")
    int deleteAllPreviousQuestion(String student_id);

    @Select("select * from ai_blank_test")
    List<BlankJudgeResult> selectAllQuestions();

    @Select("select * from ai_blank_test where id = #{id}")
    BlankJudgeResult selectById(int id);

    @Select("select * from ai_blank_test where chapter = #{chapter} " +
            "and subject = #{subject}")
    List<BlankJudgeResult> selectByChapterId(String chapter, String subject);

    @Select("select * from ai_blank_test where subject = #{subject}")
    List<BlankJudgeResult> selectBySubject(String subject);

    @Select("select * from ai_blank_test where knowledge = #{knowledge}")
    List<BlankJudgeResult> selectByKnowledge(String knowledge);

    @Select("select IFNULL(SUM(id), 0) from ai_blank_test where question = #{question} and answer = #{answer}")
    int selectIdByQuestion(String question, String answer);

    @Select("select * from ai_blank_previous_question where student_id = #{student_id}" +
            " and subject = #{subject}")
    List<BlankJudgeResult> selectPreviousQuestionsTo(String student_id, String subject);

    @Select("select * from ai_blank_previous_question where student_id = #{student_id} " +
            "and subject = #{subject} and chapter = #{chapter} ")
    List<BlankJudgeResult> selectPreviousAnswers(String student_id, String subject, String chapter);

    @Select("select * from ai_blank_wrong_question where student_id = #{student_id} " +
            "and subject = #{subject} and judge = 1 ")
    List<BlankJudgeResult> selectWrongQuestions(String student_id, String subject);

    @Select("select * from ai_blank_wrong_question where student_id = #{student_id}" +
            " and subject = #{subject} and chapter = #{chapter} and judge = 1 ")
    List<BlankJudgeResult> selectWrongAnswers(String student_id, String subject, String chapter);

    @Select("select chapter, knowledge, judge from ai_blank_previous_question " +
            "where student_id = #{student_id} and subject = #{subject}")
    List<StudentAnalysisText> selectPreviousQuestionsToAi(String student_id, String subject);

    @Select("select * from ai_blank_previous_question where classroom = #{classroom} and subject = #{subject}")
    List<TeacherAnalysisText> selectPreviousQuestionToAiByClassroom(String classroom, String subject);

    @Select("select * from ai_blank_previous_question where subject = #{subject} " +
            "and chapter = #{chapter} and #{knowledge} and student_id = #{student_id}")
    List<BlankJudgeResult> selectPreviousQuestionByKnowledge(String student_id, String subject
            , String chapter, String knowledge);

    @Select("select * from ai_blank_wrong_question where subject = #{subject} " +
            "and chapter = #{chapter} and knowledge = #{knowledge} and student_id = #{student_id}")
    List<BlankJudgeResult> selectWrongQuestionByKnowledge(String student_id, String subject
            , String chapter, String knowledge);

    @Select("select * from ai_blank_previous_question where question_id = #{question_id}")
    BlankJudgeResult selectPreviousQuestionByQuestionId(int question_id);

    @Select("select id from ai_blank_test where subject = #{subject} and chapter = #{chapter}" +
            " and knowledge = #{knowledge}")
    Integer[] selectChoiceQuestionIdByKnowledge(String subject, String chapter, String knowledge);

    @Select("select * from ai_blank_previous_question")
    List<JudgeResult> selectAllPreviousQuestion();

    @Select("select * from ai_blank_previous_question where student_id = #{student_id}")
    List<JudgeResult> selectPreviousQuestionByStudentId(String student_id);
}
