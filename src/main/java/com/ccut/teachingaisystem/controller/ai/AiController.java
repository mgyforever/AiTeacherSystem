package com.ccut.teachingaisystem.controller.ai;

import com.ccut.teachingaisystem.controller.Code;
import com.ccut.teachingaisystem.controller.Result;
import com.ccut.teachingaisystem.dao.AiDao;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.course.AiTeacherGrade;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.ppt.AiPPT;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.test.AiTest;
import com.ccut.teachingaisystem.domain.source.AiSourceSubject;
import com.ccut.teachingaisystem.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@SuppressWarnings("JavadocDeclaration")
@RestController
@RequestMapping("/ai")
public class AiController {

    private final AiService aiService;

    @Autowired
    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    /**
     * 给ai添加新的科目
     *
     * @param subject
     * @return
     */
    @PostMapping("/insertAiSource")
    public Result insertAiSource(@RequestBody AiSourceSubject subject) {
        try {
            return aiService.insertAiSource(subject)
                    ? new Result(Code.POST_OK, "添加成功!") :
                    new Result(Code.POST_ERR, "添加失败!");
        } catch (IOException e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

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

    /**
     * 教师端对于每个学生的反馈
     *
     * @param teacherId
     * @return
     */
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

    /**
     * 教师端对每个学生做题的错误率
     *
     * @param teacherId
     * @return
     */
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

    /**
     * 获取PPT的大纲
     *
     * @param subject
     * @param chapter
     * @param teacher_id
     * @param time
     * @return
     */
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

    /**
     * 获取ppt
     * @param teacherId
     * @body aiPPT
     * @return
     */
    @PostMapping("/getAiPPT")
    public Result getAiPPT(@RequestParam("teacherId") String teacherId, @RequestBody AiPPT aiPPT) {
        try {
            return aiService.getPPTUrlSync(teacherId, aiPPT) != null ? new Result(Code.POST_OK
                    , aiService.getPPTUrlSync(teacherId, aiPPT), "查询成功!")
                    : new Result(Code.POST_ERR, "查询失败!");
        } catch (IOException e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }
    /**
     * 弃用
     *
     * @param url
     * @param teacher_id
     * @return
     */
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

    /**
     * 自动组卷
     *
     * @param subject
     * @param questionNum
     * @param points
     * @return
     */
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

    /**
     * 学生模拟考试
     *
     * @param subject
     * @param questionNum
     * @param points
     * @param studentId
     * @return
     */
    @GetMapping("/autoMakeTestToStudent")
    public Result autoMakeTestToStudent(@RequestParam("subject") String subject, @RequestParam("questionNum") int questionNum
            , @RequestParam("points") int points, @RequestParam("studentId") String studentId) {
        try {
            return aiService.getTestPercentToStudentSync(subject, questionNum, points, studentId) != null
                    ? new Result(Code.GET_OK, aiService.getTestPercentToStudentSync(subject, questionNum
                    , points, studentId), "查询成功!") : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 教师教学质量
     *
     * @param teacherId
     * @param subject
     * @param chapter
     * @param file
     * @return
     */
    @PostMapping("/getTeacherGrade")
    public Result getTeacherGrade(@RequestParam("teacherId") String teacherId, @RequestParam("subject") String subject
            , @RequestParam("chapter") String chapter, @RequestParam("videoFile") MultipartFile file) {
        try {
            AiTeacherGrade teacherGradeSync = aiService.getTeacherGradeSync(teacherId, subject, chapter, file);
            return teacherGradeSync != null ? new Result(Code.POST_OK
                    , teacherGradeSync,"查询成功!")
                    : new Result(Code.POST_ERR, "查询失败!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 获取选择题
     *
     * @param subject
     * @param chapter
     * @param choiceNum
     * @return
     */
    @GetMapping("/getChoiceQuestions")
    public Result getChoiceQuestions(@RequestParam("subject") String subject, @RequestParam("chapter") String chapter
            , @RequestParam("choiceNum") int choiceNum) {
        try {
            return aiService.getChoiceQuestionsSync(subject, chapter, choiceNum) != null ? new Result(Code.GET_OK
                    , aiService.getChoiceQuestionsSync(subject, chapter, choiceNum), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取填空题
     *
     * @param subject
     * @param chapter
     * @param choiceNum
     * @return
     */
    @GetMapping("/getBlankQuestions")
    public Result getBlankQuestions(@RequestParam("subject") String subject, @RequestParam("chapter") String chapter
            , @RequestParam("choiceNum") int choiceNum) {
        try {
            return aiService.getBlankQuestionsSync(subject, chapter, choiceNum) != null ? new Result(Code.GET_OK
                    , aiService.getBlankQuestionsSync(subject, chapter, choiceNum), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
