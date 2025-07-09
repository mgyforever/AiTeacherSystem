package com.ccut.teachingaisystem.service.questionsService;

import com.ccut.teachingaisystem.domain.question.blank.BlankJudgeResult;
import com.ccut.teachingaisystem.domain.question.choice.JudgeResult;
import com.ccut.teachingaisystem.domain.question.pub.*;
import com.ccut.teachingaisystem.domain.question.rate.QuestionTestRate;
import com.ccut.teachingaisystem.domain.question.rate.QuestionsRate;

import java.util.List;

public interface TestService {
    boolean insertTest(Test test);
    boolean insertStudentTest(StudentTest studentTest);
    boolean insertTestGrade(TestGrade testGrade);
    boolean insertStudentGrade(StudentTest studentTest);
    boolean insertKnowledgeTestRate(Test test);
    boolean insertChapterTestRate(Test test);
    boolean insertPracticeQuestionText(PracticeQuestionText questionsText);
    boolean insertStudentSumGrade(List<String> testIdList, String testName);
    boolean deleteTest(int id);
    boolean deleteTestGrade(String studentId);
    boolean deletePracticeQuestionText(int id);
    boolean deleteStudentSumGrade(String test_id, String student_id);
    boolean updateTest(Test test);
    boolean updateTestGrade(TestGrade testGrade);
    boolean updatePracticeQuestionText(PracticeQuestionText questionsText);
    boolean updateStudentSumGrade(StudentSumGrade studentSumGrade);
    Test getTestByTestId(String test_id);
    List<String> getAllSubject();
    List<Test> getAllTests();
    List<Test> getTestsByTeacherId(String teacher_id);
    List<Test> getTestsByClassroom(String classroom);
    List<Test> getTestsByTime(String time);
    List<TestGrade> getTestGradeByTestId(String test_id);
    List<TestGrade> getTestGradeByClassroom(String classroom);
    List<TestGrade> getTestGradeBySubjectAndClassroom(String classroom, String subject);
    List<TestGrade> getTestGradeBySubject(String subject);
    List<Test> getTestByTimeAndClassroom(String time, String classroom);
    List<QuestionsRate> getQuestionsRateByStudentId(String studentId);
    List<QuestionTestRate> getTestKnowledgeRateByTestId(String test_id);
    List<QuestionTestRate> getTestChapterRateByTestId(String test_id);
    List<JudgeResult> getQuestionByTestIdAndChapter(String test_id, String chapter);
    List<JudgeResult> getQuestionByTestIdAndKnowledge(String test_id, String knowledge);
    List<BlankJudgeResult> getBlankQuestionByTestIdAndChapter(String test_id, String chapter);
    List<BlankJudgeResult> getBlankQuestionByTestIdAndKnowledge(String test_id, String knowledge);
    List<PracticeQuestionText> getPracticeQuestionByTeacherId(String teacher_id);
    List<StudentSumGrade> getStudentSumGradeByTestId(String test_id);
    List<StudentSumGrade> getStudentSumGradeByYear(String year, String test_name);
    List<StudentSumGrade> getStudentSumGradeByProfessional(String year, String professional, String test_name);
    List<StudentSumGrade> getStudentSumGradeByClassroom(String year, String professional
            , String classroom, String test_name);
    List<StudentTest> getStudentGradeByTestId(String test_id);
}
