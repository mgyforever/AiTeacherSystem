package com.ccut.teachingaisystem.controller.ai;

import com.ccut.teachingaisystem.controller.Code;
import com.ccut.teachingaisystem.controller.Result;
import com.ccut.teachingaisystem.dao.AiDao;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.test.AiTest;
import com.ccut.teachingaisystem.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/ai")
public class AiController {

    @Autowired
    private AiService aiService;
    private String url;
    private String teacherId;
    @Autowired
    private AiDao aiDao;

    /**
     * 学生端的建议
     */
    @GetMapping("/getStudentFeedback")
    public Result getStudentFeedback(@RequestParam("studentId") String studentId
            , @RequestParam("subject") String subject) {
        try {
            return aiService.getStudentAnalysisSync(studentId, subject) != null ? new Result(Code.GET_OK
                    , aiService.getStudentAnalysisSync(studentId, subject), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (IOException e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 学生端的分析(历史题目的章节和小结的百分比)
     */
    @GetMapping("/getStudentPercent")
    public Result getStudentPercent(@RequestParam("studentId") String studentId
            , @RequestParam("subject") String subject) {
        try {
            return aiService.getStudentPercentSync(studentId, subject) != null ? new Result(Code.GET_OK
                    , aiService.getStudentPercentSync(studentId, subject), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (IOException e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    @GetMapping("/getTeacherFeedback")
    public Result getTeacherFeedback(@RequestParam("teacherId") String teacherId) {
        try {
            return aiService.getTeacherFeedbackSync(teacherId) != null ? new Result(Code.GET_OK
                    , aiService.getTeacherFeedbackSync(teacherId), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (IOException e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    @GetMapping("/getTeacherPercent")
    public Result getTeacherPercent(@RequestParam("teacherId") String teacherId) {
        try {
            return aiService.getTeacherPercentSync(teacherId) != null ? new Result(Code.GET_OK
                    , aiService.getTeacherPercentSync(teacherId), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (IOException e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    @GetMapping("/getPPTText")
    public Result getPPTText(@RequestParam("subject") String subject, @RequestParam("chapter") String chapter
            , @RequestParam("teacher_id") String teacher_id, @RequestParam("time") String time) {
        try {
            return aiService.getPPTTextBackSync(subject, chapter, teacher_id, time) != null
                    ? new Result(Code.GET_OK, aiService.getPPTTextBackSync(subject, chapter, teacher_id, time)
                    , "生成成功!") : new Result(Code.GET_ERR, "生成失败!");
        } catch (IOException e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    @GetMapping("/getPPT")
    public Result getPPT(@RequestParam("url") String url, @RequestParam("teacher_id") String teacher_id) {
        try {
            return aiService.getPPTSync(url, teacher_id)
                    ? new Result(Code.GET_OK, "保存成功!") :
                    new Result(Code.GET_ERR, "保存失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    @GetMapping("/autoMakeTest")
    public Result autoMakeTest(@RequestParam("subject") String subject, @RequestParam("questionNum") int questionNum
            , @RequestParam("points") int points) {
        try {
            return aiService.getTestPercentSync(subject, questionNum, points) != null ? new Result(Code.GET_OK
                    , aiService.getTestPercentSync(subject, questionNum, points), "组卷成功!")
                    : new Result(Code.GET_ERR, "组卷失败!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }
}
