package com.ccut.teachingaisystem.service.questionsService;

import com.ccut.teachingaisystem.domain.question.rate.Chapter;
import com.ccut.teachingaisystem.domain.question.choice.JudgeResult;
import com.ccut.teachingaisystem.domain.question.choice.QuestionsText;
import com.ccut.teachingaisystem.domain.question.rate.Knowledge;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ChoiceQuestionService {
    boolean insertChapter(List<Chapter> chapter);
    boolean insertKnowledge(Knowledge knowledge);
    boolean insertQuestion(QuestionsText questionsText);
    boolean insertWrongAnswer(JudgeResult judgeResult);
    boolean insertWrongAnswers(List<JudgeResult> judgeResults);
    boolean insertPreviousQuestion(List<JudgeResult> judgeResults);
    boolean insertQuestionAndImg(JudgeResult judgeResult, List<MultipartFile> files);
    boolean deleteSubject(String subject);
    boolean deleteChapter(String chapter);
    boolean deleteKnowledge(String subject, String chapter, String knowledge);
    boolean deleteQuestion(int id);
    boolean deleteWrongAnswer(int id);
    boolean deleteAllWrongQuestion(String student_id);
    boolean deleteAllQuestion(String student_id);
    boolean deletePreviousQuestion(String student_id);
    boolean updateQuestion(QuestionsText questionsText);
    boolean updateChapterById(Chapter chapter);
    boolean updateSubjectById(Chapter chapter);
    boolean updateKnowledgeById(Knowledge knowledge);
    List<Chapter> selectChapter(String subject);
    List<Knowledge> selectKnowledge(String chapter, String subject);
    List<JudgeResult> selectAllQuestions();
    JudgeResult selectQuestionById(int id);
    List<JudgeResult> selectPreviousQuestions(String student_id, String subject);
    List<JudgeResult> selectPreviousAnswers(String student_id, String subject, String chapter);
    List<JudgeResult> selectQuestionsByChapter(String chapter, String subject);
    List<JudgeResult> selectQuestionsBySubject(String subject);
    List<JudgeResult> selectQuestionsByKnowledge(String knowledge);
    List<JudgeResult> selectWrongQuestions(String student_id, String subject);
    List<JudgeResult> selectWrongAnswers(String student_id, String subject, String chapter);
    List<JudgeResult> selectQuestionsByList(int[] list);
    List<JudgeResult> selectPreviousQuestionsByKnowledge(String student_id
            , String subject, String chapter, String knowledge);
    List<JudgeResult> selectWrongQuestionsByKnowledge(String student_id
            , String subject, String chapter, String knowledge);
}
