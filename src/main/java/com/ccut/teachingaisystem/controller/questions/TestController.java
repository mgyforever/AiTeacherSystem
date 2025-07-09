package com.ccut.teachingaisystem.controller.questions;

import com.ccut.teachingaisystem.controller.Code;
import com.ccut.teachingaisystem.controller.Result;
import com.ccut.teachingaisystem.domain.question.pub.*;
import com.ccut.teachingaisystem.service.questionsService.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("JavadocDeclaration")
@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    /**
     * 必须的参数:
     * String begin(year-month-day h:m:s)
     * String end(year-month-day h:m:s)
     * String classroom
     * String name
     * String subject
     * int[] question_id(每道题的id)
     * double[] question_grade(每道题的分数)
     * String teacher_id
     * int duration
     * 例子:
     * {
     * "begin":"2025-1-1 21:24:30",
     * "end":"2025-1-1 21:25:30",
     * "classroom":"1",
     * "name":"1",
     * "subject":"Linux嵌入式开发",
     * "question_id":[
     * 5, 6, 7
     * ],
     * "question_grade":[
     * 1, 2, 1
     * ],
     * "teacher_id":"1",
     * "duration":"1"
     * }
     */

    @PostMapping("/insertTest")
    public Result insertTest(@RequestBody Test test) {
        Result result;
        try {
            result = testService.insertTest(test) ? new Result(Code.POST_OK, "添加成功!")
                    : new Result(Code.POST_ERR, "添加失败!");
        } catch (Exception e) {
            result = new Result(Code.POST_ERR, "网络错误!");
        }
        return result;
    }

    /**
     * 必须的参数:
     * String test_id(试卷的id)
     * String test_name
     * String time(考试开始时间)
     * String classroom
     * String student_id
     * String name(学生姓名)
     * judge_questions{
     * String question_id(每道题的id)
     * int grade(每道题的分数)
     * int type(0为选择， 1为填空)
     * String answer(学生答案)
     * }
     * 例子:
     * {
     * "test_id":"2a3d695b-6392-4d1f-be89-fdf71f03b506",
     * "Test-name":"1",
     * "time":"2025-01-01 21:24:30",
     * "classroom":"1",
     * "student_id":"20243067",
     * "name":"张三",
     * "judge_questions":[
     * {
     * "question_id":"5",
     * "grade":"1",
     * "type":"0",
     * "answer":"C"
     * },
     * {
     * "question_id":"6",
     * "grade":"1",
     * "type":"0",
     * "answer":"B"
     * },
     * {
     * "question_id":"7",
     * "grade":"1",
     * "type":"0",
     * "answer":"B"
     * }
     * ]
     * }
     */

    @PostMapping("/insertStudentGrade")
    public Result insertStudentGrade(@RequestBody StudentTest studentTest) {
        try {
            return testService.insertStudentGrade(studentTest) ? new Result(Code.POST_OK, "添加成功!") :
                    new Result(Code.POST_ERR, "添加失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 添加考试正确率
     * String test_id
     * String year:年级
     * String classroom
     * String name:考试名称
     * String subject
     * int[] chapter_id
     * int[] knowledge_id
     */

    @PostMapping("/insertTestRate")
    public Result insertTestRate(@RequestBody Test test) {
        try {
            return testService.insertChapterTestRate(test)
                    ? new Result(Code.POST_OK, testService.insertChapterTestRate(test), "添加成功!")
                    : new Result(Code.POST_ERR, "添加失败!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 添加课后题
     * time, practice_name, teacher_id, question_id, type(1为填空, 2为选择), img1, img2, img3
     *
     * @return
     * @body practiceQuestionText
     */
    @PostMapping("/insertPracticeQuestion")
    public Result insertPracticeQuestion(@RequestBody PracticeQuestionText practiceQuestionText) {
        try {
            return testService.insertPracticeQuestionText(practiceQuestionText)
                    ? new Result(Code.POST_OK, "添加成功!") :
                    new Result(Code.POST_ERR, "添加失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 将系列考试的学生总分进行加和
     *
     * @param test_ids
     * @return
     */
    @GetMapping("/insertStudentSumGrade")
    public Result insertStudentSumGrade(@RequestParam List<String> test_ids, @RequestParam String testName) {
        try {
            return testService.insertStudentSumGrade(test_ids, testName)
                    ? new Result(Code.GET_OK, "添加成功!") :
                    new Result(Code.POST_ERR, "添加失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * id为自动增加的id
     */

    @GetMapping("/deleteTest")
    public Result deleteTest(@RequestParam int id) {
        try {
            return testService.deleteTest(id) ? new Result(Code.GET_OK, "删除成功!")
                    : new Result(Code.GET_ERR, "删除失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 弃用
     *
     * @param student_id
     * @return
     */
    @GetMapping("/deleteGrade")
    public Result deleteGrade(@RequestParam String student_id) {
        try {
            return testService.deleteTestGrade(student_id) ? new Result(Code.GET_OK, "删除成功!")
                    : new Result(Code.GET_ERR, "删除失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 删除课后题id
     *
     * @param id
     * @return
     */
    @GetMapping("/deletePracticeQuestion")
    public Result deletePracticeQuestion(@RequestParam int id) {
        try {
            return testService.deletePracticeQuestionText(id)
                    ? new Result(Code.GET_OK, "删除成功!") :
                    new Result(Code.GET_ERR, "删除失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 删除某个学生的总分
     *
     * @param test_name
     * @param student_id
     * @return
     */
    @GetMapping("/deleteStudentSumGrade")
    public Result deleteStudentSumGrade(@RequestParam("test_id") String test_name, @RequestParam String student_id) {
        try {
            return testService.deleteStudentSumGrade(test_name, student_id)
                    ? new Result(Code.GET_OK, "删除成功!") :
                    new Result(Code.GET_ERR, "删除失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 必须的参数:
     * String begin(year-month-day h:m:s):考试开始时间
     * String end(year-month-day h:m:s):考试结束时间
     * String classroom
     * String name
     * String subject
     * int[] question_id:每道题的id
     * String teacher_id
     * String question_text
     * int duration:考试持续时间(分钟)
     * <p>
     * 例子:
     * {
     * "id":10,
     * "begin":"2025-01-01 21:24:30",
     * "classroom":"1",
     * "name":"2",
     * "teacher_id":"1",
     * "duration":"1",
     * "end":"2025-1-1 21:25:30",
     * "subject":"Linux嵌入式开发",
     * "question_id":[
     * 5, 6, 7
     * ]
     * }
     */

    @PostMapping("/updateTest")
    public Result updateTest(@RequestBody Test test) {
        try {
            return testService.updateTest(test) ? new Result(Code.GET_OK, "修改成功!")
                    : new Result(Code.GET_ERR, "修改失败!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            log.error("e: ", e);
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 必须的参数:
     * String subject
     * String classroom
     * String student_id
     * String name
     * int grade
     * <p>
     * 例子:
     * {
     * "id":11,
     * "subject":"Linux嵌入式开发",
     * "classroom":"1",
     * "student_id":"1",
     * "name":"张三",
     * "grade":"3"
     * }
     */

    @PostMapping("/updateGrade")
    public Result updateGrade(@RequestBody TestGrade testGrade) {
        try {
            return testService.updateTestGrade(testGrade) ? new Result(Code.POST_OK, "修改成功!")
                    : new Result(Code.POST_ERR, "修改失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 修改课后题
     *
     * @return
     * @body practiceQuestionText
     */
    @PostMapping("/updatePracticeQuestion")
    public Result updatePracticeQuestion(@RequestBody PracticeQuestionText practiceQuestionText) {
        try {
            return testService.updatePracticeQuestionText(practiceQuestionText)
                    ? new Result(Code.POST_OK, "修改成功!") :
                    new Result(Code.POST_ERR, "修改失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    @PostMapping("/updateStudentSumGrade")
    public Result updateStudentSumGrade(@RequestBody StudentSumGrade studentSumGrade) {
        try {
            return testService.updateStudentSumGrade(studentSumGrade)
                    ? new Result(Code.GET_OK, "修改成功!") :
                    new Result(Code.POST_ERR, "修改失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * page:当前页码
     * num:每页题的数量
     */

    @GetMapping("/getAllTest")
    public Result getAllTest() {
        try {
            return testService.getAllTests() != null
                    ? new Result(Code.GET_OK, testService.getAllTests()
                    , "查询成功!") : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 根据test_id查询考试
     *
     * @param test_id
     * @return
     */
    @GetMapping("/getTestById")
    public Result getTestById(@RequestParam String test_id) {
        try {
            return testService.getTestByTestId(test_id) != null ?
                    new Result(Code.GET_OK, testService.getTestByTestId(test_id)
                            , "查询成功!") : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 根据班级查询考试
     *
     * @param classroom
     * @return
     */
    @GetMapping("/getTestByClassroom")
    public Result getTestByClassroom(@RequestParam String classroom) {
        try {
            return testService.getTestsByClassroom(classroom) != null
                    ? new Result(Code.GET_OK, testService.getTestsByClassroom(classroom)
                    , "查询成功!") : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 根据老师的id查询考试
     *
     * @param teacher_id
     * @return
     */
    @GetMapping("/getTestByTeacher_id")
    public Result getTestByTeacher_id(@RequestParam String teacher_id) {
        try {
            return testService.getTestsByTeacherId(teacher_id) != null
                    ? new Result(Code.GET_OK, testService.getTestsByTeacherId(teacher_id)
                    , "查询成功!") : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 根据时间查询考试
     *
     * @param time
     * @return
     */
    @GetMapping("/getTestByTime")
    public Result getTestByTime(@RequestParam String time) {
        try {
            return testService.getTestsByTime(time) != null
                    ? new Result(Code.GET_OK, testService.getTestsByTime(time)
                    , "查询成功!") : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * time:考试开始时间
     */

    @GetMapping("/getTestsByTimeAndClassroom")
    public Result getTestsByTimeAndClassroom(@RequestParam("time") String time
            , @RequestParam("classroom") String classroom) {
        try {
            return testService.getTestByTimeAndClassroom(time, classroom) != null ? new Result(Code.GET_OK
                    , testService.getTestByTimeAndClassroom(time, classroom), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 弃用
     *
     * @param test_id
     * @return
     */
    @GetMapping("/getGradeByTestId")
    public Result getGradeByTestId(@RequestParam String test_id) {
        try {
            return testService.getTestGradeByTestId(test_id) != null ? new Result(Code.GET_OK
                    , testService.getTestGradeByTestId(test_id), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 弃用
     *
     * @param classroom
     * @return
     */
    @GetMapping("/getGradeByClassroom")
    public Result getGradeByClassroom(@RequestParam("classroom") String classroom) {
        try {
            return testService.getTestGradeByClassroom(classroom) != null ? new Result(Code.GET_OK
                    , testService.getTestGradeByClassroom(classroom), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 弃用
     *
     * @param subject
     * @return
     */
    @GetMapping("/getGradeBySubject")
    public Result getGradeBySubject(@RequestParam String subject) {
        try {
            return testService.getTestGradeBySubject(subject) != null ? new Result(Code.GET_OK
                    , testService.getTestGradeBySubject(subject), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 弃用
     *
     * @param subject
     * @param classroom
     * @return
     */
    @GetMapping("/getGradeBySubjectAndClassroom")
    public Result getGradeBySubject(@RequestParam("subject") String subject
            , @RequestParam("classroom") String classroom) {
        try {
            return testService.getTestGradeBySubjectAndClassroom(subject, classroom) != null ? new Result(Code.GET_OK
                    , testService.getTestGradeBySubjectAndClassroom(subject, classroom), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 获取某个学生某次考试的正确率
     *
     * @param student_id
     * @return
     */
    @GetMapping("/getStudentKnowledgeRate")
    public Result getStudentKnowledgeRate(@RequestParam("student_id") String student_id) {
        try {
            return testService.getQuestionsRateByStudentId(student_id) != null ? new Result(Code.GET_OK
                    , testService.getQuestionsRateByStudentId(student_id), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 弃用
     *
     * @param test_id
     * @return
     */
    @GetMapping("/getTestChapterRate")
    public Result getTestRate(@RequestParam("test_id") String test_id) {
        try {
            return testService.getTestChapterRateByTestId(test_id) != null ? new Result(Code.GET_OK
                    , testService.getTestChapterRateByTestId(test_id), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 弃用
     *
     * @param test_id
     * @return
     */
    @GetMapping("/getTestKnowledgeRate")
    public Result getTestKnowledgeRate(@RequestParam("test_id") String test_id) {
        try {
            return testService.getTestKnowledgeRateByTestId(test_id) != null ? new Result(Code.GET_OK
                    , testService.getTestKnowledgeRateByTestId(test_id), "查询成功!") :
                    new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 获取某个老师的课后题
     *
     * @param teacher_id
     * @return
     */
    @GetMapping("/getPracticeQuestionsByTeacherId")
    public Result getPracticeQuestionsByTeacherId(@RequestParam String teacher_id) {
        try {
            return testService.getPracticeQuestionByTeacherId(teacher_id) != null ? new Result(Code.GET_OK
                    , testService.getPracticeQuestionByTeacherId(teacher_id), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 获取某学院某几次考试的学生总分
     *
     * @param year
     * @param test_name
     * @return
     */
    @GetMapping("/getStudentSumGradeByYear")
    public Result getStudentSumGradeByYear(@RequestParam("year") String year
            , @RequestParam("test_name") String test_name) {
        try {
            return testService.getStudentSumGradeByYear(year, test_name) != null ? new Result(Code.GET_OK
                    , testService.getStudentSumGradeByYear(year, test_name), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 获取某专业某几次考试的学生总分
     *
     * @param year
     * @param professional
     * @param test_name
     * @return
     */
    @GetMapping("/getStudentSumGradeByProfessional")
    public Result getStudentSumGradeByProfessional(@RequestParam("year") String year
            , @RequestParam("professional") String professional, @RequestParam("test_name") String test_name) {
        try {
            return testService.getStudentSumGradeByProfessional(year, professional, test_name) != null
                    ? new Result(Code.GET_OK, testService.getStudentSumGradeByProfessional(year, professional, test_name)
                    , "查询成功!") : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 获取某班级某几次考试的学生总分
     *
     * @param year
     * @param professional
     * @param classroom
     * @param test_name
     * @return
     */
    @GetMapping("/getStudentSumGradeByClassroom")
    public Result getStudentSumGradeByClassroom(@RequestParam("year") String year
            , @RequestParam("professional") String professional, @RequestParam("classroom") String classroom
            , @RequestParam("test_name") String test_name) {
        try {
            return testService.getStudentSumGradeByClassroom(year, professional, classroom, test_name) != null
                    ? new Result(Code.GET_OK, testService.getStudentSumGradeByClassroom(year, professional
                    , classroom, test_name), "查询成功!") : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }
}
