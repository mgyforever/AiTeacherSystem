package com.ccut.teachingaisystem.controller.questions;

import com.ccut.teachingaisystem.controller.Code;
import com.ccut.teachingaisystem.controller.Result;
import com.ccut.teachingaisystem.domain.question.blank.BlankJudgeResult;
import com.ccut.teachingaisystem.domain.question.blank.BlankQuestionText;
import com.ccut.teachingaisystem.domain.question.choice.JudgeResult;
import com.ccut.teachingaisystem.service.questionsService.BlankQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("JavadocDeclaration")
@RestController
@RequestMapping("/blankQuestion")
public class BlankQuestionController {
    @Autowired
    private BlankQuestionService blankQuestionService;

    /**
     * 添加填空题
     * answer
     * analysis
     * subject
     * chapter
     * knowledge
     */
    @PostMapping("/insertQuestion")
    public Result insertQuestion(@RequestBody BlankQuestionText questionsText) {
        try {
            return blankQuestionService.insertQuestion(questionsText)
                    ? new Result(Code.POST_OK, "添加成功!") :
                    new Result(Code.POST_ERR, "添加失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 添加带图的填空题
     * question,
     * answer, analysis,
     * subject, chapter, knowledge
     * files(图片数组)
     * @param files
     * @return
     * @body blankJudgeResult
     */
    @PostMapping("/insertQuestionAndImg")
    public Result insertQuestionAndImg(@RequestBody BlankJudgeResult blankJudgeResult
            , @RequestParam("files") List<MultipartFile> files) {
        try {
            return blankQuestionService.insertBlankQuestionAndImg(blankJudgeResult, files)
                    ? new Result(Code.POST_OK, "添加成功!") :
                    new Result(Code.POST_ERR, "添加失败!");
        } catch (IOException e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 添加错题(或重要的题不分对错)
     * judge
     * questionId:不可更改的那个id
     * reply:学生的答案
     */
    @PostMapping("/insertWrongQuestion")
    public Result insertWrongQuestion(@RequestBody JudgeResult judgeResult) {
        try {
            return blankQuestionService.insertWrongAnswer(judgeResult)
                    ? new Result(Code.POST_OK, "保存成功!") :
                    new Result(Code.POST_ERR, "保存失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 批量添加错题
     * 将insertWrongQuestion中的所有参数看作一个类，再将类封装成一个list集合
     */
    @PostMapping("/insertWrongQuestions")
    public Result insertWrongQuestions(@RequestBody List<JudgeResult> judgeResults) {
        try {
            return blankQuestionService.insertWrongAnswers(judgeResults)
                    ? new Result(Code.POST_OK, "保存成功!") :
                    new Result(Code.POST_ERR, "保存失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 添加历史题目
     * 所需的参数同insertWrongQuestions一样
     */
    @PostMapping("insertPreviousQuestions")
    public Result insertPreviousQuestions(@RequestBody List<JudgeResult> judgeResults) {
        try {
            return blankQuestionService.insertPreviousQuestion(judgeResults)
                    ? new Result(Code.POST_OK, "添加成功!") :
                    new Result(Code.POST_ERR, "添加失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 删除题库中的题目
     * 先将所有题目按照subject、chapter和knowledge分类，用户点击那个就可以删除哪个，再将修改的题目id传回
     */
    @GetMapping("/deleteQuestion")
    public Result deleteQuestion(@RequestParam("id") int id) {
        try {
            return blankQuestionService.deleteQuestion(id)
                    ? new Result(Code.GET_OK, "删除成功!") :
                    new Result(Code.GET_ERR, "删除失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 删除错题
     * 用法同deleteQuestion
     */
    @GetMapping("/deleteWrongQuestions")
    public Result deleteWrongAnswers(@RequestParam("id") int id) {
        try {
            return blankQuestionService.deleteWrongAnswer(id)
                    ? new Result(Code.GET_OK, "删除成功!") :
                    new Result(Code.GET_ERR, "删除失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 清空某个学生的所有错题本中的错题
     * student_id:学号
     */
    @GetMapping("/deleteAllWrongAnswers")
    public Result deleteAllWrongAnswers(@RequestParam("student_id") String student_id) {
        try {
            return blankQuestionService.deleteAllWrongQuestion(student_id)
                    ? new Result(Code.GET_OK, "删除成功!") :
                    new Result(Code.GET_ERR, "删除失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 清空某个学生的所有错题本中的题目，不分对错
     */
    @GetMapping("/deleteAllImportantAnswers")
    public Result deleteAllPreviousAnswers(@RequestParam("student_id") String student_id) {
        try {
            return blankQuestionService.deleteAllQuestion(student_id)
                    ? new Result(Code.GET_OK, "删除成功!") :
                    new Result(Code.GET_ERR, "删除失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 清空某个学生所有的历史题目
     */
    @GetMapping("deleteAllPreviousAnswers")
    public Result deletePreviousAnswers(@RequestParam("student_id") String student_id) {
        try {
            return blankQuestionService.deletePreviousQuestion(student_id)
                    ? new Result(Code.GET_OK, "删除成功!") :
                    new Result(Code.GET_ERR, "删除失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 修改题库中的填空题
     * answer
     * analysis
     * subject
     * chapter
     * knowledge
     * 先将所有题目按照类别列到屏幕上用户点哪个就修改那个，最后将点击的那个的所有信息传递
     */
    @PostMapping("/updateQuestion")
    public Result updateQuestion(@RequestBody BlankQuestionText questionsText) {
        try {
            return blankQuestionService.updateQuestion(questionsText)
                    ? new Result(Code.POST_OK, "修改成功!") :
                    new Result(Code.GET_ERR, "修改失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 获取所有填空题
     * page:
     * num:
     * 用法同上
     */
    @GetMapping("/getAllQuestion")
    public Result getAllQuestion() {
        try {
            return blankQuestionService.selectAllQuestions() != null
                    ? new Result(Code.GET_OK, blankQuestionService.selectAllQuestions()
                    , "查询成功!") : new Result(Code.GET_ERR, "题库为空!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 获取某科目的所有填空题
     * subject:科目
     * page:所在的页数
     * num:每页的题数
     */
    @GetMapping("/getQuestionsBySubject")
    public Result getQuestionsBySubject(@RequestParam("subject") String subject) {
        try {
            return blankQuestionService.selectQuestionsBySubject(subject) != null
                    ? new Result(Code.GET_OK, blankQuestionService.selectQuestionsBySubject(subject)
                    , "查询成功!") : new Result(Code.GET_ERR, "无此类型的题!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 获取某章节所有填空题
     * subject:科目
     * chapter:章节
     * page:所在的页数
     * num:每页的题数
     */
    @GetMapping("/getQuestionsByChapter")
    public Result getQuestionsByChapterId(@RequestParam("chapter") String chapter
            , @RequestParam("subject") String subject) {
        try {
            return blankQuestionService.selectQuestionsByChapter(chapter, subject) != null
                    ? new Result(Code.GET_OK, blankQuestionService.selectQuestionsByChapter
                    (chapter, subject), "查询成功!") : new Result
                    (Code.GET_ERR, "无此类型的题!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 获取某小结所有填空题
     * knowledge:小结
     * page:所在的页数
     * num:每页的题数
     */
    @GetMapping("getQuestionsByKnowledge")
    public Result getQuestionsByKnowledge(@RequestParam("knowledge") String knowledge) {
        try {
            return blankQuestionService.selectQuestionsByKnowledge(knowledge) != null ? new Result
                    (Code.GET_OK, blankQuestionService.selectQuestionsByKnowledge(knowledge), "查询成功!")
                    : new Result(Code.GET_ERR, "题库无此类题目!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 通过题目的id查找填空题题
     */
    @GetMapping("/getQuestionById")
    public Result getQuestionById(@RequestParam("id") int id) {
        try {
            return blankQuestionService.selectQuestionById(id) != null
                    ? new Result(Code.GET_OK, blankQuestionService.selectQuestionById(id)
                    , "查询成功!") : new Result(Code.GET_ERR, "查无此题!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 按科目查看某学生所有历史填空题
     */
    @GetMapping("/getPreviousQuestions")
    public Result getPreviousQuestions(@RequestParam("subject") String subject
            , @RequestParam("student_id") String student_id) {
        try {
            return blankQuestionService.selectPreviousQuestions(student_id, subject) != null
                    ? new Result(Code.GET_OK, blankQuestionService.selectPreviousQuestions(student_id
                    , subject), "查询成功!") : new Result(Code.GET_ERR, "题库无此类题目!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 按章节查看某学生的所有历史填空题
     */
    @GetMapping("/getPreviousAnswers")
    public Result getPreviousAnswers(@RequestParam("subject") String subject
            , @RequestParam("student_id") String student_id, @RequestParam("chapter") String chapter) {
        try {
            return blankQuestionService.selectPreviousAnswers(student_id, subject, chapter) != null
                    ? new Result(Code.GET_OK, blankQuestionService.selectPreviousAnswers(student_id
                    , subject, chapter), "查询成功!") : new Result
                    (Code.GET_ERR, "题库无此类题目!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 按小结查看某学生的所有历史填空题
     * subject
     * student_id
     * chapter
     * knowledge
     */

    @GetMapping("/getPreviousAnswersByKnowledge")
    public Result getPreviousAnswersByKnowledge(@RequestParam("subject") String subject
            , @RequestParam("student_id") String student_id, @RequestParam("chapter") String chapter
            , @RequestParam("knowledge") String knowledge) {
        try {
            return blankQuestionService.selectPreviousQuestionsByKnowledge(student_id, subject
                    , chapter, knowledge) != null ? new Result(Code.GET_OK
                    , blankQuestionService.selectPreviousQuestionsByKnowledge(student_id
                    , subject, chapter, knowledge), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 查看某学生错题本中某科目所有填空题
     */
    @GetMapping("/getWrongAnswerBySubject")
    public Result getWrongAnswer(@RequestParam("student_id") String student_id
            , @RequestParam("subject") String subject) {
        try {
            return blankQuestionService.selectWrongQuestions(student_id, subject) != null
                    ? new Result(Code.GET_OK, blankQuestionService.selectWrongQuestions(student_id
                    , subject), "查询成功!") : new Result(Code.GET_ERR, "题库为空!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 查看某学生错题本中某章节所有填空题
     */
    @GetMapping("/getWrongAnswersByChapter")
    public Result getWrongAnswersDetail(@RequestParam("student_id") String student_id
            , @RequestParam("subject") String subject, @RequestParam("chapter") String chapter) {
        try {
            return blankQuestionService.selectWrongAnswers(student_id, subject, chapter) != null
                    ? new Result(Code.POST_OK, blankQuestionService.selectWrongAnswers
                    (student_id, subject, chapter), "查询成功!")
                    : new Result(Code.POST_ERR, "数据库为空!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 按小结查看某学生错题本中的的所有填空题
     */
    @GetMapping("/getWrongAnswersByKnowledge")
    public Result getWrongAnswersDetail(@RequestParam("student_id") String student_id
            , @RequestParam("subject") String subject, @RequestParam("chapter") String chapter
            , @RequestParam("knowledge") String knowledge) {
        try {
            return blankQuestionService.selectWrongQuestionsByKnowledge(student_id, subject
                    , chapter, knowledge) != null ? new Result(Code.GET_OK
                    , blankQuestionService.selectWrongQuestionsByKnowledge(student_id
                    , subject, chapter, knowledge), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    @GetMapping("/getQuestionsByList")
    public Result getQuestionsByList(@RequestParam("list") int[] list) {
        try {
            return blankQuestionService.selectQuestionsByList(list) != null
                    ? new Result(Code.GET_OK, blankQuestionService.selectQuestionsByList(list), "查询成功!")
                    : new Result(Code.GET_ERR, "题库中并无此题!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }
}
