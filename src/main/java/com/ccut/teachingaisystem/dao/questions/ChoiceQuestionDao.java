package com.ccut.teachingaisystem.dao.questions;

import com.ccut.teachingaisystem.domain.question.aiAnalysis.student.StudentAnalysisText;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.TeacherAnalysisText;
import com.ccut.teachingaisystem.domain.question.choice.JudgeResult;
import com.ccut.teachingaisystem.domain.question.rate.Chapter;
import com.ccut.teachingaisystem.domain.question.choice.QuestionsText;
import com.ccut.teachingaisystem.domain.question.rate.Knowledge;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChoiceQuestionDao {

    @Insert("insert into ai_subject (subject) values (#{subject})")
    int insertSubject(String subject);

    @Insert("insert into ai_chapter (ai_chapter.subject, ai_chapter.chapter)" +
            " values (#{subject}, #{chapter})")
    int insertChapter(Chapter chapter);

    @Insert("insert into ai_knowledge (name, chapter) VALUES (#{name}, #{chapter})")
    int insertKnowledge(Knowledge knowledge);

    @Insert("insert into ai_testtable (question, option1, option2, option3, option4 " +
            ",answer, analysis, subject, chapter, knowledge)" +
            " VALUES (#{question}, #{option1}, #{option2}, #{option3}, #{option4}" +
            " , #{answer}, #{analysis}, #{subject}, #{chapter},#{knowledge})")
    int insertQuest(QuestionsText questionsText);

    @Insert("insert into ai_testtable (question, option1, option2, option3, option4" +
            ", answer, analysis, subject, chapter, knowledge, img1, img2, img3)" +
            " VALUES (#{question}, #{option1}, #{option2}, #{option3}, #{option4}" +
            ", #{answer}, #{analysis}, #{subject}, #{chapter}, #{knowledge}, #{img1}, #{img2}, #{img3})")
    int insertQuestAndImg(JudgeResult judgeResult, String img1, String img2, String img3);

    @Insert("insert into ai_wrong_question (student_id, question, option1, option2, option3" +
            "            , option4 ,analysis, answer, reply, judge, subject, chapter" +
            ", knowledge, question_id, img1, img2, img3)" +
            " values (#{student_id}, #{question}, #{option1}, #{option2}" +
            ",  #{option3}, #{option4}, #{analysis}, #{answer}" +
            ", #{reply}, #{judge}, #{subject}, #{chapter}, #{knowledge}" +
            ", #{question_id}, #{img1}, #{img2}, #{img3})")
    int insertWrongQuestion(JudgeResult judgeResult);

    @Insert("insert into ai_previous_question (student_id, question, option1, option2, option3" +
            ", option4 ,analysis, answer, reply, judge, subject, chapter, knowledge, classroom" +
            ", practice_id, question_id, img1, img2, img3) " +
            "values (#{student_id}, #{question}, #{option1}, #{option2}" +
            ", #{option3}, #{option4}, #{analysis}, #{answer}" +
            ", #{reply}, #{judge}, #{subject}, #{chapter}, #{knowledge}" +
            ", #{classroom}, #{practice_id}, #{question_id}, #{img1}, #{img2}, #{img3})")
    void insertPreviousQuestion(JudgeResult judgeResult);

    @Delete("delete from ai_chapter where subject = #{subject}")
    int deleteSubject(String subject);

    @Delete("delete from ai_chapter where chapter = #{chapter}")
    int deleteChapter(String chapter);

    @Delete("delete from ai_knowledge where name = #{knowledge} and chapter = #{chapterId}")
    int deleteKnowledge(String knowledge, int chapterId);

    @Delete("delete from ai_testtable where id = #{id}")
    int deleteQuestion(int id);

    @Delete("delete from ai_wrong_question where id = #{id}")
    int deleteWrongQuestion(int id);

    @Delete("delete from ai_wrong_question where student_id = #{student_id} and judge = 1")
    int deleteAllWrongQuestion(String student_id);

    @Delete("delete from ai_wrong_question where student_id = #{student_id}")
    int deleteAllQuestion(String student_id);

    @Delete("delete from ai_previous_question where student_id = #{student_id}")
    int deleteAllPreviousQuestion(String student_id);

    @Update("update ai_chapter set chapter = #{chapter} where id = #{id}")
    int updateChapterById(int id, String chapter);

    @Update("update ai_knowledge set name = #{name} where id = #{id}")
    int updateKnowledgeById(Knowledge knowledge);

    @Update("update ai_chapter set subject = #{subject} where id = #{id}")
    int updateSubjectById(int id, String subject);

    @Select("select * from ai_testtable")
    List<JudgeResult> selectAllQuestions();

    @Select("select * from ai_testtable where id = #{id}")
    JudgeResult selectById(int id);

    @Select("select * from ai_testtable where chapter = #{chapter} " +
            "and subject = #{subject}")
    List<JudgeResult> selectByChapterId(String chapter, String subject);

    @Select("select * from ai_testtable where subject = #{subject} ")
    List<JudgeResult> selectBySubject(String subject);

    @Select("select * from ai_testtable where knowledge = #{knowledge}")
    List<JudgeResult> selectByKnowledge(String knowledge);

    @Select("select IFNULL(SUM(id), 0) from ai_testtable where question = #{question} " +
            "and option1 = #{option1} and option2 = #{option2} " +
            "and option3 = #{option3} and option4 = #{option4}")
    int selectIdByQuestion(String question, String option1, String option2, String option3, String option4);

    @Select("select * from ai_previous_question where student_id = #{student_id}" +
            " and subject = #{subject}")
    List<JudgeResult> selectPreviousQuestions(String student_id, String subject);

    @Select("select * from ai_previous_question where student_id = #{student_id} " +
            "and subject = #{subject} and chapter = #{chapter}")
    List<JudgeResult> selectPreviousAnswers(String student_id, String subject, String chapter);

    @Select("select * from ai_wrong_question where student_id = #{student_id} " +
            "and subject = #{subject}")
    List<JudgeResult> selectWrongQuestions(String student_id, String subject);

    @Select("select * from ai_wrong_question where student_id = #{student_id}" +
            " and subject = #{subject} and chapter = #{chapter} ")
    List<JudgeResult> selectWrongAnswers(String student_id, String subject, String chapter);

    @Select("select subject from ai_subject")
    List<String> selectAllSubject();

    @Select("select * from ai_chapter where subject = #{subject}")
    List<Chapter> selectChapterBySubject(String subject);

    @Select("select * from ai_knowledge where chapter = #{chapter}")
    List<Knowledge> selectKnowledgeByChapter(int chapter);

    @Select("select id from ai_knowledge where name = #{knowledge}")
    Integer selectKnowledgeId(String knowledge);

    @Select("select id from ai_chapter where chapter = #{chapter} and subject = #{subject}")
    Integer selectChapterIdByChapter(String chapter, String subject);

    @Select("select chapter, knowledge, judge from ai_previous_question " +
            "where student_id = #{student_id} and subject = #{subject}")
    List<StudentAnalysisText> selectPreviousQuestionToAi(String student_id, String subject);

    @Select("select * from ai_previous_question where subject = #{subject} and classroom = #{classroom}")
    List<TeacherAnalysisText> selectPreviousQuestionToAiByClassroom(String subject, String classroom);

    @Select("select chapter from ai_chapter where id = #{id}")
    String selectChapterById(int id);

    @Select("select chapter from ai_knowledge where id = #{id}")
    Integer selectChapterIdByKnowledgeId(int id);

    @Select("select name from ai_knowledge where id = #{id}")
    String selectKnowledgeNameById(int id);

    @Select("select * from ai_previous_question where subject = #{subject} " +
            "and chapter = #{chapter} and knowledge = #{knowledge} and student_id = #{student_id}")
    List<JudgeResult> selectPreviousQuestionByKnowledge(String student_id, String subject
            , String chapter, String knowledge);

    @Select("select * from ai_wrong_question where subject = #{subject} " +
            "and chapter = #{chapter} and knowledge = #{knowledge} and student_id = #{student_id}")
    List<JudgeResult> selectWrongQuestionByKnowledge(String student_id, String subject
            , String chapter, String knowledge);

    @Select("select * from ai_previous_question where question_id = #{question_id}")
    JudgeResult selectPreviousQuestionByQuestionId(int question_id);

    @Select("select id from ai_testtable where subject = #{subject} and chapter = #{chapter}" +
            " and knowledge = #{knowledge}")
    Integer[] selectChoiceQuestionIdByKnowledge(String subject, String chapter, String knowledge);
}
