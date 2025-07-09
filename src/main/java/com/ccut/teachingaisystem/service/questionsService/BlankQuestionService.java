package com.ccut.teachingaisystem.service.questionsService;

import com.ccut.teachingaisystem.domain.question.blank.BlankJudgeResult;
import com.ccut.teachingaisystem.domain.question.blank.BlankQuestionText;
import com.ccut.teachingaisystem.domain.question.choice.JudgeResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BlankQuestionService {
    boolean insertQuestion(BlankQuestionText questionsText);
    boolean insertWrongAnswer(JudgeResult judgeResult);
    boolean insertWrongAnswers(List<JudgeResult> judgeResults);
    boolean insertPreviousQuestion(List<JudgeResult> judgeResults);
    boolean insertBlankQuestionAndImg(BlankJudgeResult questionsText, List<MultipartFile> files) throws IOException;
    boolean deleteQuestion(int id);
    boolean deleteWrongAnswer(int id);
    boolean deleteAllWrongQuestion(String student_id);
    boolean deleteAllQuestion(String student_id);
    boolean deletePreviousQuestion(String student_id);
    boolean updateQuestion(BlankQuestionText questionsText);
    List<BlankJudgeResult> selectAllQuestions();
    BlankJudgeResult selectQuestionById(int id);
    List<BlankJudgeResult> selectPreviousQuestions(String student_id, String subject);
    List<BlankJudgeResult> selectPreviousAnswers(String student_id, String subject, String chapter);
    List<BlankJudgeResult> selectQuestionsByChapter(String chapter, String subject);
    List<BlankJudgeResult> selectQuestionsBySubject(String subject);
    List<BlankJudgeResult> selectQuestionsByKnowledge(String knowledge);
    List<BlankJudgeResult> selectWrongQuestions(String student_id, String subject);
    List<BlankJudgeResult> selectWrongAnswers(String student_id, String subject, String chapter);
    List<BlankJudgeResult> selectQuestionsByList(int[] list);
    List<BlankJudgeResult> selectPreviousQuestionsByKnowledge(String student_id
            , String subject, String chapter, String knowledge);
    List<BlankJudgeResult> selectWrongQuestionsByKnowledge(String student_id
            , String subject, String chapter, String knowledge);
}
