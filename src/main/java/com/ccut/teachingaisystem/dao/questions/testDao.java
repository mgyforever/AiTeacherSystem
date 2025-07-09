package com.ccut.teachingaisystem.dao.questions;

import com.ccut.teachingaisystem.domain.question.pub.*;
import com.ccut.teachingaisystem.domain.question.rate.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface testDao {
    @Insert("insert into ai_test_teacher (test_id, end, classroom, name, begin, teacher_id, duration, subject" +
            ", question_id, question_grade, grade, knowledge_id, chapter_id, year, professional, teacher_name)" +
            " VALUES (#{test_id}, #{end}, #{classroom}, #{name}, #{begin}, #{teacher_id}, #{duration}, #{subject}" +
            ", #{question_id}, #{question_grade}, #{grade}, #{knowledge_id}, #{chapter_id}" +
            ", #{year}, #{professional}, #{teacher_name})")
    int insertTest(Test test);

    @Insert("insert into ai_test_blank_question (test_id, subject, chapter_id, knowledge_id, question_id" +
            ", question_grade) VALUES (#{test_id}, #{subject}, #{blank_chapter_id}, #{blank_knowledge_id}" +
            ", #{blank_question_id}, #{blank_question_grade})")
    int insertBlankTest(Test test);

    @Insert("insert into ai_test_grade (test_id, subject, classroom, student_id" +
            ", name, grade, time, year, professional)" +
            " VALUES (#{test_id}, #{subject}, #{classroom}, #{student_id}" +
            ", #{name}, #{grade}, #{time}, #{year}, #{professional})")
    int insertTestGrade(TestGrade testGrade);

    @Insert("insert into ai_test_student (test_id, test_name, time, classroom, student_id" +
            ", grade, name, year, professional)" +
            " VALUES (#{test_id}, #{test_name}, #{time}, #{classroom}, #{student_id}" +
            ", #{grade}, #{name}, #{year}, #{professional})")
    int insertTestStudent(StudentTest studentTest);

    @Insert("insert into ai_accuracy_rate (student_id, knowledge, rate, student_name" +
            ", classroom, test_id, test_name, subject, chapter, year, professional, num)" +
            " VALUES (#{student_id}, #{knowledge}, #{rate}, #{student_name}" +
            ", #{classroom}, #{test_id}, #{test_name}, #{subject}, #{chapter}" +
            ", #{year}, #{professional}, #{num})")
    int insertAccuracyRate(AccuracyRate accuracyRate);

    @Insert("insert into ai_test_temp (test_id, subject, chapter, knowledge, year, classroom)" +
            " VALUES (#{test_id}, #{subject}, #{chapter}, #{knowledge}, #{year}, #{classroom})")
    void insertTestTemp(RateTemp rateTemp);

    @Insert("insert into ai_test_rate (test_id, subject, chapter, knowledge, classroom_right_num, classroom_num" +
            ", classroom, year, classroom_rate, year_rate, year_right_num, year_num, test_name) " +
            "VALUES (#{test_id}, #{subject}, #{chapter}, #{knowledge}, #{classroom_right_num}" +
            ", #{classroom_num}, #{classroom}, #{year}, #{classroom_rate}, #{year_rate}" +
            ", #{year_right_num}, #{year}, #{test_name})")
    int insertTestKnowledgeRate(TestRate testRate);

    @Insert("insert into ai_test_chapter_rate (test_id, subject, chapter, classroom_right_num, classroom_num" +
            ", classroom, year, classroom_rate, year_rate, year_right_num, year_num, test_name) " +
            "VALUES (#{test_id}, #{subject}, #{chapter}, #{classroom_right_num}" +
            ", #{classroom_num}, #{classroom}, #{year}, #{classroom_rate}, #{year_rate}" +
            ", #{year_right_num}, #{year_num}, #{test_name})")
    int insertTestChapterRate(TestRate testRate);

    @Insert("insert into ai_practice_question (time, practice_name, teacher_id" +
            ", question_id, type, img1, img2, img3) " +
            "VALUES (#{time}, #{practice_name}, #{teacher_id}" +
            ", #{question_id}, #{type}, #{img1}, #{img2}, #{img3})")
    int insertPracticeQuestion(PracticeQuestionText practiceQuestionText);

    @Insert("insert into ai_sum_test (year, professional, classroom, student_id" +
            ", name, grade, test_name)" +
            " VALUES (#{year}, #{professional}, #{classroom}, #{student_id}" +
            ", #{name}, #{grade}, #{test_name})")
    int insertSumGrade(StudentSumGrade studentSumGrade);

    @Delete("delete from ai_test_teacher where id = #{id}")
    int deleteTestById(int id);

    @Delete("delete from ai_test_grade where student_id = #{student_id}")
    int deleteGradeByStudentId(String student_id);

    @Delete("delete from ai_accuracy_rate where student_id = #{student_id}")
    int deleteAccuracyRateByStudentId(String student_id);

    @Delete("delete from ai_practice_question where id = #{id}")
    int deletePracticeQuestionById(int id);

    @Delete("delete from ai_sum_test where test_name = #{test_name} and student_id = #{student_id}")
    int deleteSumGradeByTestId(String test_name, String student_id);

    @Update("update ai_test_teacher set end = #{end}, classroom = #{classroom}" +
            ", name = #{name}, question_id = #{question_id}, begin = #{begin}" +
            ", teacher_id = #{teacher_id}, duration = #{duration}" +
            ", subject = #{subject} where id = #{id}")
    int updateTest(Test test);

    @Update("update ai_test_grade set subject = #{subject}, classroom = #{classroom}" +
            ", student_id = #{student_id}, name = #{name}, grade = #{grade} where id = #{id}")
    int updateTestGrade(TestGrade testGrade);

    @Update("update ai_accuracy_rate set rate = #{rate} where knowledge = #{knowledge}")
    int updateAccuracyRateByKnowledge(int knowledge);

    @Update("update ai_practice_question set practice_name = #{practice_name}," +
            " teacher_id = #{teacher_id}, question_id = #{question_id} where id = #{id}")
    int updatePracticeQuestion(PracticeQuestionText practiceQuestionText);

    @Update("update ai_sum_test set year = #{year}, professional = #{professional}, classroom = #{classroom}" +
            ", name = #{name}, grade = #{grade}, test_name = #{test_name}" +
            " where student_id = #{stduent_id}")
    int updateSumGrade(StudentSumGrade studentSumGrade);

//    @Select("select * from ai_test_teacher where test_id = #{id}")
//    Test selectTestByTestId(int id);

    @Select("select * from ai_test_teacher")
    List<Test> selectAllTests();

    @Select("select * from ai_test_teacher where classroom = #{classroom}")
    List<Test> selectTestsByClassroom(String classroom);

    @Select("select * from ai_test_teacher where teacher_id = #{teacher_id}")
    List<Test> selectTestsByTeacherId(String teacher_id);

    @Select("select * from ai_test_teacher where end = #{end}")
    List<Test> selectTestsByTime(String end);

    @Select("select * from ai_test_teacher where begin = #{begin} and classroom = #{classroom}")
    List<Test> selectTestsByDate(String begin, String classroom);

    @Select("select * from ai_test_teacher where test_id = #{test_id}")
    Test selectTestByTestId(String test_id);

    @Select("select * from ai_test_grade where classroom = #{classroom} ")
    List<TestGrade> selectTestGradeByClassroom(String classroom);

    @Select("select * from ai_test_grade where test_id = #{test_id}")
    List<TestGrade> selectTestGradeByTestId(String test_id);

    @Select("select * from ai_test_grade where classroom = #{classroom} and subject = #{subject}")
    List<TestGrade> selectTestGradeBySubjectAndClassroom(String classroom, String subject);

    @Select("select * from ai_test_grade where subject = #{subject}")
    List<TestGrade> selectTestGradeBySubject(String subject);

    @Select("select id from ai_test_student where test_id = #{test_id} and student_id = #{student_id}")
    Integer selectTestStudentIdByTestIdAndStudent_id(String test_id, String student_id);

    @Select("select * from ai_test_student where test_id = #{test_id}")
    List<StudentTest> selectTestStudentIdByTestId(String test_id);

    @Select("select * from ai_test_student where id = #{id}")
    StudentGradeText selectStudentTestById(int id);

    @Select("select * from ai_test_student where test_id = #{test_id} and student_id = #{student_id}")
    StudentGradeText selectStudentTestByTestId(String test_id, String student_id);

    @Select("select * from ai_accuracy_rate where student_id = #{student_id} ")
    List<QuestionsRate> selectAccuracyRateByStudentId(String student_id);

    @Select("select id from ai_test_temp where test_id = #{test_id}")
    Integer[] selectIdByTestId(String test_id);

    @Select("select id from ai_test_temp where test_id = #{test_id}" +
            " and chapter = #{chapter}")
    Integer[] selectIdByTestIdAndChapter(String test_id, String chapter);

    @Select("select id from ai_test_temp where test_id = #{test_id} and knowledge = #{knowledge}")
    Integer[] selectIdByTestIdAndKnowledge(String test_id, String knowledge);

    @Select("select id from ai_test_temp where test_id = #{test_id}" +
            " and chapter = #{chapter} and classroom = #{classroom}")
    Integer[] selectIdByChapterAndClassroom(String test_id, String chapter, String classroom);

    @Select("select id from ai_test_temp where test_id = #{test_id} " +
            "and knowledge = #{knowledge} and classroom = #{classroom}")
    Integer[] selectIdByKnowledgeAndClassroom(String test_id, String knowledge, String classroom);

    @Select("select id from ai_knowledge where name = #{name}")
    int selectKnowledgeIdByName(String name);

    @Select("select classroom_num, year_num, classroom_rate, year_rate, knowledge " +
            "from ai_test_rate where test_id = #{test_id}")
    List<QuestionTestRate> selectTestKnowledgeRateByTestId(String test_id);

    @Select("select classroom_num, year_num, classroom_rate, year_rate, chapter " +
            "from ai_test_chapter_rate where test_id = #{test_id}")
    List<QuestionTestRate> selectTestChapterRateByTestId(String test_id);

    @Select("select question_id from ai_test_teacher where test_id = #{test_id}")
    int[] selectQuestionIdByTestId(String test_id);

    @Select("select * from ai_test_blank_question where test_id = #{test_id}")
    Test selectTestBlankQuestionByTestId(String test_id);

    @Select("select * from ai_practice_question where teacher_id = #{teacher_id}")
    List<PracticeQuestionText> selectPracticeQuestionByTeacherId(String teacher_id);

    @Select("select * from ai_practice_question where teacher_id = #{teacher_id} and time = #{time}")
    List<PracticeQuestionText> selectPracticeQuestionByTeacherIdAndTime(String teacher_id, String time);

    @Select("select * from ai_sum_test where test_name = #{test_name}")
    List<StudentSumGrade> selectSumTestByTestName(String test_name);

    @Select("select * from ai_sum_test where year = #{year} and test_name = #{test_name}")
    List<StudentSumGrade> selectSumTestByYear(String year, String test_name);

    @Select("select * from ai_sum_test where professional = #{professional} " +
            "and year = #{year} and test_name = #{test_name}")
    List<StudentSumGrade> selectSumTestByProfessional(String year, String professional, String test_name);

    @Select("select * from ai_sum_test where year = #{year} and professional = #{professional}" +
            " and classroom = #{classroom} and test_name = #{test_name}")
    List<StudentSumGrade> selectSumTestByClassroom(String year, String professional
            , String classroom, String test_name);

    @Select("select id from ai_sum_test where test_name = #{test_name} and student_id = #{student_id}")
    Integer selectSumTestIdByTestId(String test_name, String student_id);

    @Select("select * from ai_sum_test where test_name = #{test_name}")
    List<StudentSumGrade> selectAllSumTest(String test_name);

    @Select("select * from ai_test_student where test_id = #{test_id}")
    List<StudentTest> selectStudentGradeByTestId(String test_id);

    @Select("select * from ai_accuracy_rate")
    List<AccuracyRate> selectAllAccuracyRate();
}
