package com.ccut.teachingaisystem.service.impl.questions;

import com.ccut.teachingaisystem.controller.Code;
import com.ccut.teachingaisystem.dao.questions.BlankQuestionDao;
import com.ccut.teachingaisystem.dao.questions.ChoiceQuestionDao;
import com.ccut.teachingaisystem.dao.questions.testDao;
import com.ccut.teachingaisystem.dao.users.UsersDao;
import com.ccut.teachingaisystem.domain.question.blank.BlankJudgeResult;
import com.ccut.teachingaisystem.domain.question.choice.JudgeResult;
import com.ccut.teachingaisystem.domain.question.pub.*;
import com.ccut.teachingaisystem.domain.question.rate.*;
import com.ccut.teachingaisystem.domain.users.StudentUsers;
import com.ccut.teachingaisystem.exception.SystemException;
import com.ccut.teachingaisystem.service.questionsService.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.text.DecimalFormat;
import java.util.*;

@Service
public class TestServiceImpl implements TestService {

    private static final Logger log = LoggerFactory.getLogger(TestServiceImpl.class);
    @Autowired
    private testDao testDao;

    @Autowired
    private ChoiceQuestionDao choiceQuestionDao;

    @Autowired
    private BlankQuestionDao blankQuestionDao;

    @Autowired
    private UsersDao usersDao;

    @Override
    public boolean insertTest(Test test) {
        try {
            test.setTest_id(UUID.randomUUID().toString());
            return testDao.insertTest(test) > 0 && testDao.insertBlankTest(test) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    public boolean insertStudentTest(StudentTest studentTest) {
        try {
            if (testDao.selectTestStudentIdByTestIdAndStudent_id(studentTest.getTest_id(), studentTest.getStudent_id()) != null) {
                return false;
            } else {
                double grade = 0;
                List<JudgeQuestions> judgeList = studentTest.getJudge_questions();
                for (JudgeQuestions judgeQuestions : judgeList) {
                    int judge;
                    String answer;
                    JudgeResult questionsText;
                    BlankJudgeResult blankQuestionText;
                    int question_id = judgeQuestions.getQuestion_id();
                    String student_answer = judgeQuestions.getAnswer();
                    String test_name = testDao.selectTestByTestId(studentTest.getTest_id()).getName();
                    studentTest.setTest_name(test_name);
                    if (judgeQuestions.getType() == 0) {
                        answer = choiceQuestionDao.selectById(question_id).getAnswer();
                    } else {
                        answer = blankQuestionDao.selectById(question_id).getAnswer();
                    }
                    if (answer.equals(student_answer)) {
                        judge = 0;
                    } else {
                        judge = 1;
                    }
                    if (judgeQuestions.getType() == 0) {
                        questionsText = choiceQuestionDao.selectById(question_id);
                        JudgeResult judgeResult = new JudgeResult(judge, studentTest.getStudent_id()
                                , questionsText.getQuestion(), questionsText.getOption1()
                                , questionsText.getOption2(), questionsText.getOption3()
                                , questionsText.getOption4(), questionsText.getAnswer()
                                , questionsText.getAnalysis(), questionsText.getSubject()
                                , questionsText.getChapter(), questionsText.getKnowledge()
                                , student_answer, studentTest.getClassroom());
                        choiceQuestionDao.insertPreviousQuestion(judgeResult);
                    } else {
                        blankQuestionText = blankQuestionDao.selectById(question_id);
                        JudgeResult judgeResult = new JudgeResult(judge, studentTest.getStudent_id()
                                , blankQuestionText.getQuestion(), blankQuestionText.getAnswer()
                                , blankQuestionText.getAnalysis(), blankQuestionText.getSubject()
                                , blankQuestionText.getChapter(), blankQuestionText.getKnowledge()
                                , student_answer, studentTest.getClassroom());
                        blankQuestionDao.insertPreviousQuestion(judgeResult);
                    }
                    judgeQuestions.setJudge(judge);
                    if (judge == 0) {
                        grade += judgeQuestions.getGrade();
                    }
                }
                studentTest.setGrade(grade);
                return testDao.insertTestStudent(studentTest) > 0 && insertAccuracyRates(studentTest);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    public boolean insertTestGrade(TestGrade testGrade) {
        try {
            return testDao.insertTestGrade(testGrade) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean insertStudentGrade(StudentTest studentTest) {
        try {
            int id = studentTest.getJudge_questions().get(1).getQuestion_id();
            int type = studentTest.getJudge_questions().get(1).getType();
            String subject;
            if (type == 0) {
                subject = choiceQuestionDao.selectById(id).getSubject();
            } else {
                subject = blankQuestionDao.selectById(id).getSubject();
            }
            boolean judgeStudentTest = insertStudentTest(studentTest);
            StudentGradeText st = testDao.selectStudentTestByTestId(studentTest.getTest_id(), studentTest.getStudent_id());
            TestGrade testGrade = new TestGrade(st.getTest_id(), subject, st.getClassroom()
                    , st.getStudent_id(), st.getName(), st.getTime(), st.getGrade(), st.getYear(), st.getProfessional());
            boolean judgeGrade = insertTestGrade(testGrade);
            return judgeStudentTest && judgeGrade;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }


    @Override
    public boolean deleteTest(int id) {
        try {
            return testDao.deleteTestById(id) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean deleteTestGrade(String studentId) {
        try {
            return testDao.deleteGradeByStudentId(studentId) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean deletePracticeQuestionText(int id) {
        try {
            return testDao.deletePracticeQuestionById(id) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean deleteStudentSumGrade(String test_name, String student_id) {
        try {
            return testDao.deleteSumGradeByTestId(test_name, student_id) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateTest(Test test) {
        try {
            return testDao.updateTest(test) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateTestGrade(TestGrade testGrade) {
        try {
            return testDao.updateTestGrade(testGrade) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updatePracticeQuestionText(PracticeQuestionText questionsText) {
        try {
            return testDao.updatePracticeQuestion(questionsText) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateStudentSumGrade(StudentSumGrade studentSumGrade) {
        try {
            return testDao.updateSumGrade(studentSumGrade) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }


    @Override
    public Test getTestByTestId(String test_id) {
        try {
            return testDao.selectTestByTestId(test_id);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<String> getAllSubject() {
        try {
            return choiceQuestionDao.selectAllSubject();
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<Test> getAllTests() {
        try {
            List<Test> tests = testDao.selectAllTests();
            for (Test test : tests) {
                String test_id = test.getTest_id();
                Test blankTest = testDao.selectTestBlankQuestionByTestId(test_id);
                test.setBlank_chapter_id(blankTest.getBlank_chapter_id());
                test.setBlank_question_id(blankTest.getBlank_question_id());
                test.setBlank_knowledge_id(blankTest.getBlank_knowledge_id());
                test.setBlank_question_grade(blankTest.getBlank_question_grade());
            }
            return tests;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<Test> getTestsByTeacherId(String teacher_id) {
        try {
            List<Test> tests = testDao.selectTestsByTeacherId(teacher_id);
            for (Test test : tests) {
                String test_id = test.getTest_id();
                Test blankTest = testDao.selectTestBlankQuestionByTestId(test_id);
                test.setBlank_chapter_id(blankTest.getBlank_chapter_id());
                test.setBlank_question_id(blankTest.getBlank_question_id());
                test.setBlank_knowledge_id(blankTest.getBlank_knowledge_id());
                test.setBlank_question_grade(blankTest.getBlank_question_grade());
            }
            return tests;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }


    @Override
    public List<Test> getTestsByClassroom(String classroom) {
        try {
            List<Test> tests = testDao.selectTestsByClassroom(classroom);
            for (Test test : tests) {
                String test_id = test.getTest_id();
                Test blankTest = testDao.selectTestBlankQuestionByTestId(test_id);
                test.setBlank_chapter_id(blankTest.getBlank_chapter_id());
                test.setBlank_question_id(blankTest.getBlank_question_id());
                test.setBlank_knowledge_id(blankTest.getBlank_knowledge_id());
                test.setBlank_question_grade(blankTest.getBlank_question_grade());
            }
            return tests;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<Test> getTestsByTime(String time) {
        try {
            List<Test> tests = testDao.selectTestsByTime(time);
            for (Test test : tests) {
                String test_id = test.getTest_id();
                Test blankTest = testDao.selectTestBlankQuestionByTestId(test_id);
                test.setBlank_chapter_id(blankTest.getBlank_chapter_id());
                test.setBlank_question_id(blankTest.getBlank_question_id());
                test.setBlank_knowledge_id(blankTest.getBlank_knowledge_id());
                test.setBlank_question_grade(blankTest.getBlank_question_grade());
            }
            return tests;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<TestGrade> getTestGradeByTestId(String test_id) {
        try {
            return testDao.selectTestGradeByTestId(test_id);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<TestGrade> getTestGradeByClassroom(String classroom) {
        try {
            return testDao.selectTestGradeByClassroom(classroom);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<TestGrade> getTestGradeBySubjectAndClassroom(String classroom, String subject) {
        try {
            return testDao.selectTestGradeBySubjectAndClassroom(classroom, subject);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<TestGrade> getTestGradeBySubject(String subject) {
        try {
            return testDao.selectTestGradeBySubject(subject);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<Test> getTestByTimeAndClassroom(String time, String classroom) {
        try {
            return testDao.selectTestsByDate(time, classroom);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<QuestionsRate> getQuestionsRateByStudentId(String studentId) {
        try {
            List<QuestionsRate> list = testDao.selectAccuracyRateByStudentId(studentId);
            for (QuestionsRate questionsRate : list) {
                questionsRate.setKnowledge_name(choiceQuestionDao.selectKnowledgeNameById(questionsRate.getKnowledge()));
            }
            return list;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<QuestionTestRate> getTestKnowledgeRateByTestId(String test_id) {
        try {
            return testDao.selectTestKnowledgeRateByTestId(test_id);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<QuestionTestRate> getTestChapterRateByTestId(String test_id) {
        try {
            return testDao.selectTestChapterRateByTestId(test_id);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<JudgeResult> getQuestionByTestIdAndChapter(String test_id, String chapter) {
        try {
            int[] question_id = testDao.selectQuestionIdByTestId(test_id);
            List<JudgeResult> questionsTexts = new ArrayList<>(List.of());
            List<JudgeResult> questionChapter = new ArrayList<>(List.of());
            for (int i : question_id) {
                JudgeResult test = choiceQuestionDao.selectById(i);
                questionsTexts.add(test);
            }
            for (JudgeResult questionsText : questionsTexts) {
                if (questionsText.getChapter().equals(chapter)) {
                    questionChapter.add(questionsText);
                }
            }
            return questionChapter;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<JudgeResult> getQuestionByTestIdAndKnowledge(String test_id, String knowledge) {
        try {
            int[] question_id = testDao.selectQuestionIdByTestId(test_id);
            List<JudgeResult> questionsTexts = new ArrayList<>(List.of());
            List<JudgeResult> questionKnowledge = new ArrayList<>(List.of());
            for (int i : question_id) {
                JudgeResult test = choiceQuestionDao.selectById(i);
                questionsTexts.add(test);
            }
            for (JudgeResult questionsText : questionsTexts) {
                if (questionsText.getKnowledge().equals(knowledge)) {
                    questionKnowledge.add(questionsText);
                }
            }
            return questionKnowledge;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<BlankJudgeResult> getBlankQuestionByTestIdAndChapter(String test_id, String chapter) {
        try {
            int[] choiceQuestionsId = testDao.selectQuestionIdByTestId(test_id);
            List<BlankJudgeResult> questionsTexts = new ArrayList<>(List.of());
            List<BlankJudgeResult> questionChapter = new ArrayList<>(List.of());
            for (int i : choiceQuestionsId) {
                BlankJudgeResult test = blankQuestionDao.selectById(i);
                questionsTexts.add(test);
            }
            for (BlankJudgeResult questionsText : questionsTexts) {
                if (questionsText.getChapter().equals(chapter)) {
                    questionChapter.add(questionsText);
                }
            }
            return questionChapter;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<BlankJudgeResult> getBlankQuestionByTestIdAndKnowledge(String test_id, String knowledge) {
        try {
            int[] choiceQuestionsId = testDao.selectQuestionIdByTestId(test_id);
            List<BlankJudgeResult> questionsTexts = new ArrayList<>(List.of());
            List<BlankJudgeResult> questionKnowledge = new ArrayList<>(List.of());
            for (int i : choiceQuestionsId) {
                BlankJudgeResult test = blankQuestionDao.selectById(i);
                questionsTexts.add(test);
            }
            for (BlankJudgeResult questionsText : questionsTexts) {
                if (questionsText.getKnowledge().equals(knowledge)) {
                    questionKnowledge.add(questionsText);
                }
            }
            return questionKnowledge;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PracticeQuestionText> getPracticeQuestionByTeacherId(String teacher_id) {
        try {
            return testDao.selectPracticeQuestionByTeacherId(teacher_id);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<StudentSumGrade> getStudentSumGradeByTestId(String test_id) {
        try {
            return testDao.selectSumTestByTestName(test_id);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<StudentSumGrade> getStudentSumGradeByYear(String year, String test_name) {
        try {
            return testDao.selectSumTestByYear(year, test_name);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<StudentSumGrade> getStudentSumGradeByProfessional(String year
            , String professional, String test_name) {
        try {
            return testDao.selectSumTestByProfessional(year, professional, test_name);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<StudentSumGrade> getStudentSumGradeByClassroom(String year, String professional
            , String classroom, String test_name) {
        try {
            return testDao.selectSumTestByClassroom(year, professional, classroom, test_name);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<StudentTest> getStudentGradeByTestId(String test_id) {
        try {
            return testDao.selectStudentGradeByTestId(test_id);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean insertKnowledgeTestRate(Test test) {
        try {
            TestRate testRate = new TestRate();
            int[] chapterId = test.getChapter_id();
            int[] knowledgeId = test.getKnowledge_id();
            int[] flag = new int[knowledgeId.length];
            Integer[] yearNum = usersDao.selectStudentIdByYear(test.getYear());
            Integer[] classroomNum = usersDao.selectStudentIdByClassroom(test.getYear(), test.getClassroom());
            testRate.setYear_num(yearNum.length);
            testRate.setClassroom_num(classroomNum.length);
            testRate.setTest_id(test.getTest_id());
            testRate.setSubject(test.getSubject());
            testRate.setClassroom(test.getClassroom());
            testRate.setYear(test.getYear());
            testRate.setTest_name(test.getName());
            for (int k : chapterId) {
                String chapter = choiceQuestionDao.selectChapterById(k);
                int count = 0;
                for (int i : knowledgeId) {
                    String chapterName = choiceQuestionDao.selectChapterById(i);
                    if (!chapter.equals(chapterName)) {
                        continue;
                    }
                    String knowledge = choiceQuestionDao.selectKnowledgeNameById(i);
                    int[] knowledgeNum = getKnowledgeNum(test.getTest_id(), knowledge, test.getClassroom());
                    testRate.setChapter(chapter);
                    testRate.setKnowledge(knowledge);
                    testRate.setYear_right_num(knowledgeNum[0]);
                    testRate.setClassroom_right_num(knowledgeNum[1]);
                    double yearRate = (double) testRate.getYear_right_num() / testRate.getYear_num();
                    double classRate = (double) testRate.getClassroom_right_num() / testRate.getClassroom_num();
                    testRate.setYear_rate(yearRate);
                    testRate.setClassroom_rate(classRate);
                    flag[count] = testDao.insertTestKnowledgeRate(testRate);
                    count++;
                }
            }
            boolean bl = true;
            for (int i : flag) {
                if (i <= 0) {
                    bl = false;
                    break;
                }
            }
            return bl;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean insertChapterTestRate(Test test) {
        try {
            TestRate testRate = new TestRate();
            int[] chapterId = test.getChapter_id();
            int[] flag = new int[chapterId.length];
            Integer[] yearNum = usersDao.selectStudentIdByYear(test.getYear());
            Integer[] classroomNum = usersDao.selectStudentIdByClassroom(test.getYear(), test.getClassroom());
            testRate.setYear_num(yearNum.length);
            testRate.setClassroom_num(classroomNum.length);
            testRate.setTest_id(test.getTest_id());
            testRate.setSubject(test.getSubject());
            testRate.setClassroom(test.getClassroom());
            testRate.setYear(test.getYear());
            testRate.setTest_name(test.getName());
            int count = 0;
            for (int k : chapterId) {
                String chapter = choiceQuestionDao.selectChapterById(k);
                testRate.setChapter(chapter);
                int[] chapterNum = getChapterNum(test.getTest_id(), chapter, test.getClassroom());
                testRate.setYear_right_num(chapterNum[0]);
                testRate.setClassroom_right_num(chapterNum[1]);
                double yearRate = (testRate.getYear_num() == 0) ? 0.0 : (double) testRate.getYear_right_num() / testRate.getYear_num();
                double classRate = (testRate.getClassroom_num() == 0) ? 0.0 : (double) testRate.getClassroom_right_num() / testRate.getClassroom_num();
                testRate.setYear_rate(yearRate);
                testRate.setClassroom_rate(classRate);
                flag[count] = testDao.insertTestChapterRate(testRate);
                count++;
            }
            boolean bl = true;
            for (int k : flag) {
                if (k <= 0) {
                    bl = false;
                    break;
                }
            }
            return bl;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean insertPracticeQuestionText(PracticeQuestionText questionsText) {
        try {
            return testDao.insertPracticeQuestion(questionsText) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    //管理员选择考试的test_id进行汇总
    @Override
    public boolean insertStudentSumGrade(List<String> testIdList, String testName) {
        try {
            List<StudentSumGrade> studentSumGradeList = new ArrayList<>();
            MultiValueMap<String, Double> studentGrade = new LinkedMultiValueMap<>();
            List<Integer> blList = new ArrayList<>();
            boolean bl = true;
            for (String id : testIdList) {
                StudentSumGrade studentSumGrade = new StudentSumGrade();
                List<StudentTest> tempTest = testDao.selectTestStudentIdByTestId(id);
                for (StudentTest testGrade : tempTest) {
                    for (StudentSumGrade studentSumGrade1 : studentSumGradeList) {
                        if (studentSumGrade1.getStudent_id().equals(testGrade.getStudent_id())) {
                            break;
                        }
                    }
                    studentSumGrade.setStudent_id(testGrade.getStudent_id());
                    studentSumGrade.setClassroom(testGrade.getClassroom());
                    studentSumGrade.setYear(testGrade.getYear());
                    studentSumGrade.setProfessional(testGrade.getProfessional());
                    String studentName = usersDao.selectMessageByStudentId(testGrade.getStudent_id()).getName();
                    studentSumGrade.setTest_name(testName);
                    studentSumGrade.setName(studentName);
                    studentSumGradeList.add(studentSumGrade);
                }
                for (StudentTest testGrade : tempTest) {
                    studentGrade.add(testGrade.getStudent_id(), testGrade.getGrade());
                }
            }
            studentGrade.forEach((k, v) -> {
                double sum = 0;
                for (Double value : v) {
                    sum = 0;
                    sum += value;
                }
                v.add(sum);
                for (StudentSumGrade studentSumGrade : studentSumGradeList) {
                    if (studentSumGrade.getStudent_id().equals(k)) {
                        studentSumGrade.setGrade(v.get(v.size() - 1));
                    }
                    if (testDao.selectSumTestIdByTestId(studentSumGrade.getTest_id()
                            , studentSumGrade.getStudent_id()) == null) {
                        blList.add(testDao.insertSumGrade(studentSumGrade));
                    }
                }
            });
            for (Integer i : blList){
                if (i <= 0){
                    bl = false;
                    break;
                }
            }
            return bl;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    private boolean insertAccuracyRates(StudentTest studentTest) {
        int num;
        int flag = 1;
        List<JudgeQuestions> judgeQuestions = studentTest.getJudge_questions();
        AccuracyRate accuracyRate = new AccuracyRate();
        String studentId = studentTest.getStudent_id();
        Set<String> knowledgeSet = new HashSet<>();
        MultiValueMap<String, Integer> map = new LinkedMultiValueMap<>();
        HashMap<String, Double> rateMap = new HashMap<>();
        for (JudgeQuestions judgeQuestion : judgeQuestions) {
            int questionId = judgeQuestion.getQuestion_id();
            String knowledge = choiceQuestionDao.selectById(questionId).getKnowledge();
            map.add(knowledge, judgeQuestion.getJudge());
            knowledgeSet.add(knowledge);
        }
        num = knowledgeSet.size();
        int[] questionNum = new int[num];
        List<String> list = new ArrayList<>(knowledgeSet);
        for (int i = 0; i < num; i++) {
            for (String knowledge : list) {
                final double[] count1 = {0};
                final double[] count2 = {0};
                final double[] count3 = {0};
                map.forEach((k, v) -> {
                    if (knowledge.equals(k)) {
                        count1[0] = v.size();
                        for (Integer integer : v) {
                            if (integer == 0) {
                                count2[0]++;
                            }
                        }
                    }
                });
                count3[0] = count2[0] / count1[0];
                questionNum[i] = (int) count1[0];
                rateMap.put(knowledge, count3[0]);
            }
        }
        for (int i = 0; i < num; i++) {
            if (choiceQuestionDao.selectKnowledgeId(list.get(i)) == null) {
                continue;
            }
            if (usersDao.selectByStudentId(studentId) == null) {
                break;
            }
            int knowledgeId = choiceQuestionDao.selectKnowledgeId(list.get(i));
            StudentUsers studentUsers = usersDao.selectByStudentId(studentId);
            Test test = testDao.selectTestByTestId(studentTest.getTest_id());
            String phoneNumber = studentUsers.getPhoneNumber();
            String name = usersDao.selectStudentIdentify(phoneNumber).getName();
            String classroom = studentUsers.getClassroom();
            String test_id = studentTest.getTest_id();
            String test_name = studentTest.getTest_name();
            int chapterId = choiceQuestionDao.selectChapterIdByKnowledgeId(knowledgeId);
            accuracyRate.setTest_id(test_id);
            accuracyRate.setTest_name(test_name);
            accuracyRate.setStudent_name(name);
            accuracyRate.setClassroom(classroom);
            accuracyRate.setStudent_id(studentId);
            accuracyRate.setSubject(test.getSubject());
            accuracyRate.setChapter(choiceQuestionDao.selectChapterById(chapterId));
            accuracyRate.setKnowledge(knowledgeId);
            DecimalFormat df = new DecimalFormat("#.##");
            double rate = Double.parseDouble(df.format(rateMap.get(list.get(i))));
            accuracyRate.setRate(rate);
            accuracyRate.setNum(questionNum[i]);
            accuracyRate.setYear(studentTest.getYear());
            accuracyRate.setProfessional(studentTest.getProfessional());
            flag = testDao.insertAccuracyRate(accuracyRate);
            if (flag <= 0) {
                break;
            }
        }
        return flag > 0;
    }

    //弃用
    private void insertTestTemp(StudentTest studentTest, List<JudgeQuestions> judgeQuestions) {
        int num = studentTest.getJudge_questions().size();
        List<RateTemp> list = new ArrayList<>(num);
        Test test = testDao.selectTestByTestId(studentTest.getTest_id());
        for (int i = 0; i < num; i++) {
            String year = usersDao.selectByStudentId(studentTest.getStudent_id()).getYear();
            RateTemp rateTemp = new RateTemp();
            rateTemp.setTest_id(studentTest.getTest_id());
            rateTemp.setTest_name(studentTest.getTest_name());
            rateTemp.setSubject(test.getSubject());
            rateTemp.setYear(year);
            rateTemp.setClassroom(studentTest.getClassroom());
            for (JudgeQuestions judgeQuestion : judgeQuestions) {
                if (judgeQuestion.getJudge() == 0) {
                    int questionId = judgeQuestion.getQuestion_id();
                    String knowledge = choiceQuestionDao.selectById(questionId).getKnowledge();
                    String chapter = choiceQuestionDao.selectById(questionId).getChapter();
                    rateTemp.setKnowledge(knowledge);
                    rateTemp.setChapter(chapter);
                    testDao.insertTestTemp(rateTemp);
                }
            }
        }
    }

    private int getAllNum(String test_id) {
        Integer[] num = testDao.selectIdByTestId(test_id);
        int[] intArray = Arrays.stream(num)
                .mapToInt(Integer::intValue)
                .toArray();
        return intArray.length;
    }

    private int[] getChapterNum(String test_id, String chapter, String classroom) {
        Integer[] num = testDao.selectIdByTestIdAndChapter(test_id, chapter);
        Integer[] num1 = testDao.selectIdByChapterAndClassroom(test_id, chapter, classroom);
        int[] intArray = Arrays.stream(num)
                .mapToInt(Integer::intValue)
                .toArray();
        int[] intArray1 = Arrays.stream(num1)
                .mapToInt(Integer::intValue)
                .toArray();
        int[] result = new int[2];
        result[0] = intArray.length;
        result[1] = intArray1.length;
        return result;
    }

    private int[] getKnowledgeNum(String test_id, String knowledge, String classroom) {
        Integer[] num = testDao.selectIdByTestIdAndKnowledge(test_id, knowledge);
        Integer[] num1 = testDao.selectIdByKnowledgeAndClassroom(test_id, knowledge, classroom);
        int[] intArray = Arrays.stream(num)
                .mapToInt(Integer::intValue)
                .toArray();
        int[] intArray1 = Arrays.stream(num1)
                .mapToInt(Integer::intValue)
                .toArray();
        int[] result = new int[2];
        result[0] = intArray.length;
        result[1] = intArray1.length;
        return result;
    }
}