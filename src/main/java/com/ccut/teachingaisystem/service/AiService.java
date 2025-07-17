package com.ccut.teachingaisystem.service;

import com.ccut.teachingaisystem.domain.question.aiAnalysis.student.AiStudentFeedback;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.student.AiStudentPercent;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.AiTeacherFeedback;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.AiTeacherPercent;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.course.AiTeacherGrade;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.ppt.AiPPT;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.ppt.AiPPTBack;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.ppt.AiPPtTextBack;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.test.AiTestPercent;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.test.AiTestQuestions;
import com.ccut.teachingaisystem.domain.question.analysis.MyResponseBody;
import com.ccut.teachingaisystem.domain.question.analysis.Test;
import com.ccut.teachingaisystem.domain.question.blank.AiBlankQuestion;
import com.ccut.teachingaisystem.domain.question.pub.AiQuestions;
import com.ccut.teachingaisystem.domain.question.pub.ChoiceAndBlankQuestion;
import com.ccut.teachingaisystem.domain.source.AiSourceSubject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AiService {
    boolean insertAiSource(AiSourceSubject subject) throws IOException;
    List<String> getPPTUrl(String topic, String teacherId);
    AiQuestions getChoiceQuestionsSync(String subject, String chapter, int choiceNum);
    AiBlankQuestion getBlankQuestionsSync(String subject, String chapter, int choiceNum);
    MyResponseBody getAnalysisSync(List<Test> tests);
    AiStudentFeedback getStudentAnalysisSync(String student_id, String subject) throws IOException;
    AiStudentPercent getStudentPercentSync(String student_id, String subject) throws IOException;
    AiTeacherFeedback getTeacherFeedbackSync(String teacher_id) throws IOException;
    AiTeacherPercent getTeacherPercentSync(String teacher_id) throws IOException;
    AiPPtTextBack getPPTTextBackSync(String subject, String chapter, String teacher_id, String time) throws IOException;
    AiPPTBack getPPTUrlSync(String teacher_id, AiPPT aiPPT) throws IOException;
    boolean getPPTSync(String url, String teacher_id);

    AiTestQuestions getTestPercentToStudentSync(String subject, int questionNum
            , int points, String studentId);

    AiTestQuestions getTestPercentSync(String subject, int questionNum, int points);
    AiTeacherGrade getTeacherGradeSync(String teacher_id, String subject, String chapter
            , MultipartFile videoFile) throws IOException;
}
