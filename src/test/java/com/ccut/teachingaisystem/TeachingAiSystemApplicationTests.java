package com.ccut.teachingaisystem;

import com.ccut.teachingaisystem.dao.questions.ChoiceQuestionDao;
import com.ccut.teachingaisystem.dao.users.UsersDao;
import com.ccut.teachingaisystem.domain.question.choice.JudgeResult;
import com.ccut.teachingaisystem.domain.question.choice.ChoiceQuestionsBody;
import com.ccut.teachingaisystem.domain.question.choice.QuestionsText;
import com.ccut.teachingaisystem.domain.question.pub.JudgeQuestions;
import com.ccut.teachingaisystem.domain.question.pub.StudentTest;
import com.ccut.teachingaisystem.domain.source.AiSourceChapter;
import com.ccut.teachingaisystem.domain.source.AiSourceSubject;
import com.ccut.teachingaisystem.domain.source.mysql.MCQ;
import com.ccut.teachingaisystem.service.AiService;
import com.ccut.teachingaisystem.service.impl.mysql.PDFParser;
import com.ccut.teachingaisystem.service.impl.mysql.WordWriter;
import com.ccut.teachingaisystem.service.questionsService.ChoiceQuestionService;
import com.ccut.teachingaisystem.service.questionsService.TestService;
import com.ccut.teachingaisystem.service.usersService.TeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@SpringBootTest
class TeachingAiSystemApplicationTests {
    @Autowired
    private ChoiceQuestionService choiceQuestionService;

    @Autowired
    private ChoiceQuestionDao choiceQuestionDao;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private AiService aiService;

    private ChoiceQuestionsBody choiceQuestionsBody;
    @Autowired
    private TestService testService;
    @Autowired
    private UsersDao usersDao;

    @Test
    void contextLoads() {
    }

    @Test
    void InsertPrevious(){
        JudgeResult judgeResult = new JudgeResult(1, 1,"1", "a");
        List<JudgeResult> judgeResults = new ArrayList<>();
        judgeResults.add(judgeResult);
        choiceQuestionService.insertPreviousQuestion(judgeResults);
    }

    @Test
    void InsertNext() {
        aiService.getPPTUrl("TensorFlow.js应用开发", "1");
    }

    @Test
    void getAiQuestions() {
        aiService.getBlankQuestionsSync("Linux嵌入式开发", "TensorFlow.js应用开发", 20);
    }

    @Test
    void saveQuestions()throws IOException {
        Scanner scanner = new Scanner(System.in);
        String filePath = "D:\\java\\code\\idea program\\TeachingAISystem\\src\\main\\java\\com" +
                "\\ccut\\teachingaisystem\\download\\file\\questions\\choicceQuestions.txt";
        int ch;
        List<StringBuilder> builders = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            builders.add(new StringBuilder());
        }
        FileReader fr = new FileReader(filePath);
        while ((ch = fr.read()) != -1) {
            if ((char)ch == '@'){
                int count = 0;
                while ((ch = fr.read()) != '@') {
                    if ((char)ch == '#'){
                        count++;
                        ch = fr.read();
                        if (count > 9){
                            count = 0;
                        }
                    } else {
                        builders.get(count).append((char)ch);
                    }
                }
                int i = 0;
                String question = builders.get(i).toString().trim();
                String option1 = builders.get(i + 1).toString().trim();
                String option2 = builders.get(i + 2).toString().trim();
                String option3 = builders.get(i + 3).toString().trim();
                String option4 = builders.get(i + 4).toString().trim();
                String answer = builders.get(i + 5).toString().trim();
                String analysis = builders.get(i + 6).toString().trim();
                String subject = builders.get(i + 7).toString().trim();
                String chapter = builders.get(i + 8).toString().trim();
                String knowledge = builders.get(i + 9).toString().trim();
                QuestionsText questionsText = new QuestionsText(question, option1, option2, option3
                        , option4, answer, analysis, subject, chapter, knowledge);
                choiceQuestionService.insertQuestion(questionsText);
                for (StringBuilder builder : builders) {
                    builder.setLength(0);
                }
            }
        }
        fr.close();
    }

    @Test
    void getChoiceQuestions() {
        Date date = new Date();
        Time time = new Time(date.getTime());
        Instant instant = Instant.ofEpochMilli(time.getTime());
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateString = localDateTime.format(formatter);
        System.out.println(dateString);
    }

    @Test
    void getFeedback() throws IOException {
        aiService.getStudentAnalysisSync("1", "");
    }

    @Test
    void getStudentFeedback() {
        JudgeResult questionsText;
        int judge;
        String reply = "C";
        questionsText = choiceQuestionDao.selectById(9);
        if (questionsText.getAnswer().equals(reply)){
            judge = 0;
        } else {
            judge = 1;
        }
        JudgeResult judgeResult = new JudgeResult(judge, questionsText.getId(), "1"
                , questionsText.getQuestion(), questionsText.getOption1(), questionsText.getOption2()
                , questionsText.getOption3(), questionsText.getOption4(), questionsText.getAnswer()
                , questionsText.getAnalysis(), questionsText.getSubject(), questionsText.getChapter()
                , questionsText.getKnowledge(), reply);
        choiceQuestionDao.insertPreviousQuestion(judgeResult);
    }

    @Test
    void getTeacherFeedback() {
    }

    @Test
    void insertStudentTest() {
        List<JudgeQuestions> list = new ArrayList<>(6);
            list.add(new JudgeQuestions(5, 1, 0, "C"));
            list.add(new JudgeQuestions(6, 1, 0, "B"));
            list.add(new JudgeQuestions(7, 1, 0, "B"));
            list.add(new JudgeQuestions(8, 1, 0, "B"));
            list.add(new JudgeQuestions(9, 1, 0, "A"));
            list.add(new JudgeQuestions(10, 1, 0, "A"));
        StudentTest studentTest = new StudentTest("2a3d695b-6392-4d1f-be89-fdf71f03b506", "2"
                , "2025-01-01 21:24:30", "1", "张三", "20243067", list);
        testService.insertStudentTest(studentTest);
    }

//    @Test
//    void insertSumGrade() {
//        List<String> list = new ArrayList<>();
//        list.add("2a3d695b-6392-4d1f-be89-fdf71f03b506");
//        testService.insertStudentSumGrade(list);
//    }

//    @Test
//    void getPPtText() throws IOException {
//        aiService.getPPTTextBackSync("嵌入式Linux开发实践教程", "嵌入式Linux内核与模块编程"
//                , "1", "2025-06-17 17:57:17");
//    }

//    @Test
//    void getTeacherFilePath() {
//        List<String> paths = usersDao.selectFileByTeacherId("1");
//        for (String path : paths) {
//            System.out.println(path.substring(105));
//        }
//        String s = "D:\\java\\code\\idea program\\TeachingAISystem\\src\\main\\java" +
//                "\\com\\ccut\\teachingaisystem\\download\\file\\teacher\\";
//        System.out.println(s.length());
//    }

    @Test
    void insertAiSource() {
        AiSourceSubject aiSourceSubject = new AiSourceSubject();
        AiSourceChapter aiSourceChapter = new AiSourceChapter();
//        aiService.insertAiSource()
    }

    @Test
    void getMysqlSource() throws IOException {
        PDFParser pdfParser;
        WordWriter writer;
        List<MCQ> m = PDFParser.parsePDF("D:\\java\\code\\idea program\\TeachingAISystem" +
                "\\src\\main\\resources\\mysql\\2025年303数学(三)真题回忆.pdf");
        System.out.println(m);
        WordWriter.writeMCQsToWord(m, "D:\\java\\code\\idea program\\TeachingAISystem" +
                "\\src\\main\\resources\\mysql\\choice.docx");
    }
}

