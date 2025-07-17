package com.ccut.teachingaisystem.controller.questions;

import com.ccut.teachingaisystem.controller.Code;
import com.ccut.teachingaisystem.controller.Result;
import com.ccut.teachingaisystem.dao.questions.ChoiceQuestionDao;
import com.ccut.teachingaisystem.domain.question.rate.Chapter;
import com.ccut.teachingaisystem.domain.question.choice.JudgeResult;
import com.ccut.teachingaisystem.domain.question.choice.QuestionsText;
import com.ccut.teachingaisystem.domain.question.rate.Knowledge;
import com.ccut.teachingaisystem.service.questionsService.ChoiceQuestionService;
import com.ccut.teachingaisystem.service.questionsService.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/choiceTest")
public class ChoiceQuestionController {
    @Autowired
    private ChoiceQuestionService choiceQuestionService;
    @Autowired
    private TestService testService;
    @Autowired
    private ChoiceQuestionDao choiceQuestionDao;

    /**
     * 添加章节
     * chapter:章节
     */
    @PostMapping("/insertChapter")
    public Result insertChapter(@RequestBody List<Chapter> chapter) {
        try {
            return choiceQuestionService.insertChapter(chapter)
                    ? new Result(Code.POST_OK, "添加成功!") :
                    new Result(Code.POST_ERR, "添加失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 添加知识点
     * name:知识点名称
     * chapterName:章节名称
     * subjectName:学科名称
     */
    @PostMapping("/insertKnowledge")
    public Result insertKnowledge(@RequestBody Knowledge knowledge) {
        try {
            return choiceQuestionService.insertKnowledge(knowledge)
                    ? new Result(Code.POST_OK, "添加成功!") :
                    new Result(Code.POST_ERR, "添加失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 添加选择题
     * question:题目
     * option1:选项A
     * option2:选项B
     * option3:选项C
     * option4:选项D
     * answer
     * analysis
     * subject
     * chapter
     * knowledge
     */
    @PostMapping("/insertQuestion")
    public Result insertQuestion(@RequestBody QuestionsText questionsText) {
        try {
            return choiceQuestionService.insertQuestion(questionsText)
                    ? new Result(Code.POST_OK, "添加成功!") :
                    new Result(Code.POST_ERR, "添加失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 添加带图的选择题
     * question,
     * option1, option2, option3, option4,
     * answer, analysis,
     * subject, chapter, knowledge
     * files(图片数组)
     *
     * @param files
     * @return
     * @body questionsText
     */
    @PostMapping("/insertQuestionAndImg")
    public Result insertQuestionAndImg(@RequestBody JudgeResult questionsText
            , @RequestParam("files") List<MultipartFile> files) {
        try {
            return choiceQuestionService.insertQuestionAndImg(questionsText, files)
                    ? new Result(Code.POST_OK, "添加成功!") :
                    new Result(Code.POST_ERR, "添加失败!");
        } catch (Exception e) {
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
            return choiceQuestionService.insertWrongAnswer(judgeResult)
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
            return choiceQuestionService.insertWrongAnswers(judgeResults)
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
    @PostMapping("/insertPreviousQuestions")
    public Result insertPreviousQuestions(@RequestBody List<JudgeResult> judgeResults) {
        try {
            return choiceQuestionService.insertPreviousQuestion(judgeResults)
                    ? new Result(Code.POST_OK, "添加成功!") :
                    new Result(Code.POST_ERR, "添加失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 删除学科
     * subject:科目
     */
    @GetMapping("/deleteSubject")
    public Result deleteSubject(@RequestParam String subject) {
        try {
            return choiceQuestionService.deleteSubject(subject)
                    ? new Result(Code.GET_OK, "删除成功!") :
                    new Result(Code.GET_ERR, "删除失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 删除章节
     * subject:名字
     * chapter:名字
     */
    @GetMapping("/deleteChapter")
    public Result deleteChapter(@RequestParam String chapter) {
        try {
            return choiceQuestionService.deleteChapter(chapter)
                    ? new Result(Code.GET_OK, "删除成功!") :
                    new Result(Code.GET_ERR, "删除失败!");
        } catch (Exception e) {
            return new Result(Code.GET_ERR, "网络错误!");
        }
    }

    /**
     * 删除小结
     * subject
     * chapter
     * knowledge
     */
    @GetMapping("/deleteKnowledge")
    public Result deleteKnowledge(@RequestParam("subject") String subject, @RequestParam("chapter") String chapter
            , @RequestParam("knowledge") String knowledge) {
        try {
            return choiceQuestionService.deleteKnowledge(subject, chapter, knowledge)
                    ? new Result(Code.GET_OK, "删除成功!") :
                    new Result(Code.GET_ERR, "删除失败!");
        } catch (Exception e) {
            return new Result(Code.GET_ERR, "网络错误!");
        }
    }

    /**
     * 删除题库中的题目
     * 先将所有题目按照subject、chapter和knowledge分类，用户点击那个就可以删除哪个，再将修改的题目id传回
     */
    @GetMapping("/deleteQuestion")
    public Result deleteQuestion(@RequestParam("id") int id) {
        try {
            return choiceQuestionService.deleteQuestion(id)
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
            return choiceQuestionService.deleteWrongAnswer(id)
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
            return choiceQuestionService.deleteAllWrongQuestion(student_id)
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
            return choiceQuestionService.deleteAllQuestion(student_id)
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
            return choiceQuestionService.deletePreviousQuestion(student_id)
                    ? new Result(Code.GET_OK, "删除成功!") :
                    new Result(Code.GET_ERR, "删除失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 修改科目名称
     * subject:科目
     * chapter:
     * knowledge:
     * 先将所有科目和章节列到屏幕上用户点哪个就修改那个，最后将点击的那个的所有信息传递(subject, chapter, knowledge)
     */
    @PostMapping("/updateSubject")
    public Result updateSubject(@RequestBody Chapter chapter) {
        try {
            return choiceQuestionService.updateSubjectById(chapter)
                    ? new Result(Code.POST_OK, "修改成功!") :
                    new Result(Code.POST_ERR, "修改失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 修改章节名称
     * subject:
     * chapter:章节
     * knowledge:
     * 用法同上
     */
    @PostMapping("/updateChapter")
    public Result updateChapter(@RequestBody Chapter chapter) {
        try {
            return choiceQuestionService.updateChapterById(chapter)
                    ? new Result(Code.POST_OK, "修改成功!") :
                    new Result(Code.POST_ERR, "修改失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 修改章节名称
     * subject:
     * chapter:
     * knowledge:小结
     * 用法同上
     */
    @PostMapping("/updateKnowledge")
    public Result updateKnowledge(@RequestBody Knowledge knowledge) {
        try {
            return choiceQuestionService.updateKnowledgeById(knowledge)
                    ? new Result(Code.POST_OK, "修改成功!") :
                    new Result(Code.POST_ERR, "修改失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 修改题库中的选择题
     * question
     * option1
     * option2
     * option3
     * option4
     * answer
     * analysis
     * subject
     * chapter
     * knowledge
     * 先将所有题目按照类别列到屏幕上用户点哪个就修改那个，最后将点击的那个的所有信息传递
     */
    @PostMapping("/updateQuestion")
    public Result updateQuestion(@RequestBody QuestionsText questionsText) {
        try {
            return choiceQuestionService.updateQuestion(questionsText)
                    ? new Result(Code.POST_OK, "修改成功!") :
                    new Result(Code.GET_ERR, "修改失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 查询所有科目
     */
    @GetMapping("/getAllSubject")
    public Result getAllSubject() {
        try {
            return testService.getAllSubject() != null ? new Result(Code.GET_OK
                    , testService.getAllSubject(), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 获取所有章节
     * subject:章节所属科目
     * page:所在页码
     * num:每页的数量
     */
    @GetMapping("/getChapters")
    public Result getChapters(@RequestParam("subject") String subject) {
        try {
            return choiceQuestionService.selectChapter(subject) != null
                    ? new Result(Code.GET_OK, choiceQuestionService.selectChapter(subject)
                    , "查询成功!") : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 查询知识点
     * subject
     * chapter
     */
    @GetMapping("/getKnowledge")
    public Result getKnowledge(@RequestParam("subject") String subject, @RequestParam("chapter") String chapter) {
        try {
            return choiceQuestionService.selectKnowledge(chapter, subject) != null ? new Result(Code.GET_OK
                    , choiceQuestionService.selectKnowledge(chapter, subject), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 获取所有选择题
     * page:
     * num:
     * 用法同上
     */
    @GetMapping("/getAllQuestion")
    public Result getAllQuestion() {
        try {
            return choiceQuestionService.selectAllQuestions() != null
                    ? new Result(Code.GET_OK, choiceQuestionService.selectAllQuestions()
                    , "查询成功!") : new Result(Code.GET_ERR, "题库为空!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 获取某科目的所有选择题
     * subject:科目
     * page:所在的页数
     * num:每页的题数
     */
    @GetMapping("/getQuestionsBySubject")
    public Result getQuestionsBySubject(@RequestParam("subject") String subject) {
        try {
            return choiceQuestionService.selectQuestionsBySubject(subject) != null
                    ? new Result(Code.GET_OK, choiceQuestionService.selectQuestionsBySubject(subject)
                    , "查询成功!") : new Result(Code.GET_ERR, "无此类型的题!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 获取某章节所有选择题
     * subject:科目
     * chapter:章节
     * page:所在的页数
     * num:每页的题数
     */
    @GetMapping("/getQuestionsByChapter")
    public Result getQuestionsByChapterId(@RequestParam("chapter") String chapter
            , @RequestParam("subject") String subject) {
        try {
            return choiceQuestionService.selectQuestionsByChapter(chapter, subject) != null
                    ? new Result(Code.GET_OK, choiceQuestionService.selectQuestionsByChapter
                    (chapter, subject), "查询成功!") : new Result
                    (Code.GET_ERR, "无此类型的题!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 获取某小结所有选择题
     * knowledge:小结
     * page:所在的页数
     * num:每页的题数
     */
    @GetMapping("/getQuestionsByKnowledge")
    public Result getQuestionsByKnowledge(@RequestParam("knowledge") String knowledge) {
        try {
            return choiceQuestionService.selectQuestionsByKnowledge(knowledge) != null ? new Result
                    (Code.GET_OK, choiceQuestionService.selectQuestionsByKnowledge(knowledge), "查询成功!")
                    : new Result(Code.GET_ERR, "题库无此类题目!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 通过题目的id查找选择题题
     */
    @GetMapping("/getQuestionById")
    public Result getQuestionById(@RequestParam("id") int id) {
        try {
            return choiceQuestionService.selectQuestionById(id) != null
                    ? new Result(Code.GET_OK, choiceQuestionService.selectQuestionById(id)
                    , "查询成功!") : new Result(Code.GET_ERR, "查无此题!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 按科目查看某学生所有历史选择题
     */
    @GetMapping("/getPreviousQuestions")
    public Result getPreviousQuestions(@RequestParam("subject") String subject
            , @RequestParam("student_id") String student_id) {
        try {
            return choiceQuestionService.selectPreviousQuestions(student_id, subject) != null
                    ? new Result(Code.GET_OK, choiceQuestionService.selectPreviousQuestions(student_id
                    , subject), "查询成功!") : new Result(Code.GET_ERR, "题库无此类题目!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 按章节查看某学生的所有历史选择题
     */
    @GetMapping("/getPreviousAnswers")
    public Result getPreviousAnswers(@RequestParam("subject") String subject
            , @RequestParam("student_id") String student_id, @RequestParam("chapter") String chapter) {
        try {
            return choiceQuestionService.selectPreviousAnswers(student_id, subject, chapter) != null
                    ? new Result(Code.GET_OK, choiceQuestionService.selectPreviousAnswers(student_id
                    , subject, chapter), "查询成功!") : new Result
                    (Code.GET_ERR, "题库无此类题目!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 按小结查看某学生的所有历史选择题
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
            return choiceQuestionService.selectPreviousQuestionsByKnowledge(student_id, subject
                    , chapter, knowledge) != null ? new Result(Code.GET_OK
                    , choiceQuestionService.selectPreviousQuestionsByKnowledge(student_id
                    , subject, chapter, knowledge), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 查看某学生错题本中某科目所有选择题
     */
    @GetMapping("/getWrongAnswerBySubject")
    public Result getWrongAnswer(@RequestParam("student_id") String student_id
            , @RequestParam("subject") String subject) {
        try {
            return choiceQuestionService.selectWrongQuestions(student_id, subject) != null
                    ? new Result(Code.GET_OK, choiceQuestionService.selectWrongQuestions(student_id
                    , subject), "查询成功!") : new Result(Code.GET_ERR, "题库为空!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }


    /**
     * 查看某学生错题本中某章节所有选择题
     */
    @GetMapping("/getWrongAnswersByChapter")
    public Result getWrongAnswersDetail(@RequestParam("student_id") String student_id
            , @RequestParam("subject") String subject, @RequestParam("chapter") String chapter) {
        try {
            return choiceQuestionService.selectWrongAnswers(student_id, subject, chapter) != null
                    ? new Result(Code.POST_OK, choiceQuestionService.selectWrongAnswers
                    (student_id, subject, chapter), "查询成功!")
                    : new Result(Code.POST_ERR, "数据库为空!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 按小结查看某学生错题本中的的所有选择题
     */
    @GetMapping("/getWrongAnswersByKnowledge")
    public Result getWrongAnswersDetail(@RequestParam("student_id") String student_id
            , @RequestParam("subject") String subject, @RequestParam("chapter") String chapter
            , @RequestParam("knowledge") String knowledge) {
        try {
            return choiceQuestionService.selectWrongQuestionsByKnowledge(student_id, subject
                    , chapter, knowledge) != null ? new Result(Code.GET_OK
                    , choiceQuestionService.selectWrongQuestionsByKnowledge(student_id
                    , subject, chapter, knowledge), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }


    @GetMapping("/getQuestionsByList")
    public Result getQuestionsByList(@RequestParam("list") int[] list) {
        try {
            return choiceQuestionService.selectQuestionsByList(list) != null
                    ? new Result(Code.GET_OK, choiceQuestionService.selectQuestionsByList(list), "查询成功!")
                    : new Result(Code.GET_ERR, "题库中并无此题!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    @GetMapping("/getKnowledgeIdByKnowledge")
    public Result getKnowledgeIdByKnowledge(@RequestParam("knowledge") String knowledge) {
        try {
            return choiceQuestionDao.selectKnowledgeId(knowledge) != null ? new Result(Code.GET_OK
                    , choiceQuestionDao.selectKnowledgeId(knowledge), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }
}
