package com.ccut.teachingaisystem.dao;

import com.ccut.teachingaisystem.domain.question.aiAnalysis.student.AiStudentFeedback;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.student.AiStudentPercent;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.AiTeacherFeedback;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.AiTeacherPercent;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.course.AiTeacherGrade;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.ppt.AiPPTBack;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.ppt.AiPPtTextBack;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.test.AiTest;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.test.AiTestPercent;
import com.ccut.teachingaisystem.domain.question.analysis.MyResponseBody;
import com.ccut.teachingaisystem.domain.question.blank.AiBlankQuestion;
import com.ccut.teachingaisystem.domain.question.pub.AiQuestions;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.ppt.PPTFile;
import com.ccut.teachingaisystem.domain.source.AiSourceResult;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.apache.ibatis.annotations.Mapper;
import retrofit2.Call;
import retrofit2.http.*;


@Mapper
public interface AiDao {
    @GET("/get_ppt_url")
    Call<PPTFile> getPptUrl(@Query("topic") String topic);

    @GET
    Call<ResponseBody> DownloadFile(@Url String url);

    @POST("/generate_choice")
    Call<AiQuestions> getChoiceQuestions(@Body RequestBody body);

    @POST("/generate_blank")
    Call<AiBlankQuestion> getBlankQuestions(@Body RequestBody body);

    @POST("/get")
    Call<MyResponseBody> getAnalysis(@Body RequestBody body);

    @POST("/student_feedback")
    Call<AiStudentFeedback> getStudentFeedback(@Body RequestBody body);

    @POST("/student_feedback_percent")
    Call<AiStudentPercent> getStudentFeedbackPercent(@Body RequestBody body);

    @POST("/exam_feedback")
    Call<AiTeacherFeedback> getExamFeedback(@Body RequestBody body);

    @POST("/exam_feedback_percent")
    Call<AiTeacherPercent> getExamFeedbackPercent(@Body RequestBody body);

    @POST("/get_outline_json")
    Call<AiPPtTextBack> getOutlineJson(@Body RequestBody body);

    @POST("/online_to_ppt_url")
    Call<AiPPTBack> getPPT(@Body RequestBody body);

    @POST("/knowledge_online_in")
    Call<AiSourceResult> insertAiSource(@Body RequestBody body);

    @POST("/generate_exam_paper")
    Call<AiTestPercent> getQuestionsPercent(@Body RequestBody body);

    @POST("/comprehensive_video_evaluation")
    Call<AiTeacherGrade> getTeacherGrade(@Body RequestBody body);
}
