package com.ccut.teachingaisystem.service.impl;

import com.ccut.teachingaisystem.controller.Code;
import com.ccut.teachingaisystem.dao.questions.BlankQuestionDao;
import com.ccut.teachingaisystem.dao.questions.ChoiceQuestionDao;
import com.ccut.teachingaisystem.dao.questions.testDao;
import com.ccut.teachingaisystem.dao.users.UsersDao;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.*;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.student.*;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.course.AiTeacherGrade;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.course.AiVideo;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.ppt.*;
import com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.test.*;
import com.ccut.teachingaisystem.domain.question.analysis.MyResponseBody;
import com.ccut.teachingaisystem.domain.question.analysis.Test;
import com.ccut.teachingaisystem.domain.question.blank.*;
import com.ccut.teachingaisystem.domain.question.choice.JudgeResult;
import com.ccut.teachingaisystem.domain.question.pub.AiQuestions;
import com.ccut.teachingaisystem.domain.question.choice.Choice;
import com.ccut.teachingaisystem.domain.question.choice.ChoiceQuestionsBody;
import com.ccut.teachingaisystem.domain.question.choice.QuestionsText;
import com.ccut.teachingaisystem.domain.question.pub.ChoiceAndBlankQuestion;
import com.ccut.teachingaisystem.domain.question.pub.PracticeQuestionText;
import com.ccut.teachingaisystem.domain.question.rate.AccuracyRate;
import com.ccut.teachingaisystem.domain.question.rate.Chapter;
import com.ccut.teachingaisystem.domain.question.rate.Knowledge;
import com.ccut.teachingaisystem.domain.question.rate.QuestionsRate;
import com.ccut.teachingaisystem.domain.source.AiSourceChapter;
import com.ccut.teachingaisystem.domain.source.AiSourceResult;
import com.ccut.teachingaisystem.domain.source.AiSourceSubject;
import com.ccut.teachingaisystem.domain.users.StudentSubject;
import com.ccut.teachingaisystem.domain.users.StudentUsers;
import com.ccut.teachingaisystem.domain.users.TeacherUsers;
import com.ccut.teachingaisystem.exception.SystemException;
import com.ccut.teachingaisystem.service.AiService;
import com.ccut.teachingaisystem.dao.AiDao;
import com.ccut.teachingaisystem.service.questionsService.TestService;
import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class AiServiceImpl implements AiService {

    @Value("${file.teacher-dir}")
    private String teacherDir;

    @Value("${myAi.service.ip}")
    private String baseIp;

    @Value("${myAi.service.port}")
    private String basePort;

    private AiDao aiDao;

    private final UsersDao usersDao;

    private final ChoiceQuestionDao choiceQuestionDao;

    private final BlankQuestionDao blankQuestionDao;

    private final TestService testService;

    private final testDao testDao;

    @Autowired
    public AiServiceImpl(AiDao aiDao, UsersDao usersDao, ChoiceQuestionDao choiceQuestionDao, BlankQuestionDao blankQuestionDao, TestService testService, testDao testDao) {
        this.aiDao = aiDao;
        this.usersDao = usersDao;
        this.choiceQuestionDao = choiceQuestionDao;
        this.blankQuestionDao = blankQuestionDao;
        this.testService = testService;
        this.testDao = testDao;
    }

    @Override
    public boolean insertAiSource(AiSourceSubject subject) {
        try {
            setClient();
            RequestBody body = RequestBody.create(
                    new Gson().toJson(new Gson().toJson(subject)),
                    MediaType.parse("application/json")
            );
            Call<AiSourceResult> call = aiDao.insertAiSource(body);
            Response<AiSourceResult> execute = call.execute();
            int sumNum = 0;
            List<AiSourceChapter> chapters = subject.getChapters();
            for (AiSourceChapter chapter : chapters) {
                sumNum += chapter.getKnowledge().size();
            }
            int[] num = new int[sumNum];
            int count = 0;
            boolean flag;
            boolean bl = true;
            if (execute.body() != null) {
                String responseBody = execute.body().toString();
                Gson gson = new Gson();
                AiSourceResult result = gson.fromJson(responseBody, AiSourceResult.class);
                flag = result.getStatue() == 0;
                Chapter chapter = new Chapter();
                Knowledge knowledge = new Knowledge();
                if (flag) {
                    for (int i = 0; i < subject.getChapters().size(); i++) {
                        String chapterName = subject.getChapters().get(i).getChapter();
                        String subjectName = subject.getSubject();
                        chapter.setChapter(chapterName);
                        chapter.setSubject(subjectName);
                        num[count++] = choiceQuestionDao.insertChapter(chapter);
                        for (int j = 0; j < subject.getChapters().get(i).getKnowledge().size(); j++) {
                            String knowledgeName = subject.getChapters().get(i).getKnowledge().get(j);
                            int chapterId = choiceQuestionDao.selectChapterIdByChapter(chapterName, subjectName);
                            knowledge.setChapter(chapterId);
                            knowledge.setName(knowledgeName);
                            num[count++] = choiceQuestionDao.insertKnowledge(knowledge);
                        }
                    }
                }
                for (int i : num) {
                    if (i <= 0) {
                        bl = false;
                        break;
                    }
                }
                return bl;
            }
            return bl;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }

    }

    @Override
    public List<String> getPPTUrl(String topic, String teacherId) {
        setClient();
        Call<PPTFile> call = aiDao.getPptUrl(topic);
        try {
            Response<PPTFile> response = call.execute();
            if (response.body() != null) {
                String responseBody = response.body().toString();
                PPTFile pptFile = new Gson().fromJson(responseBody, PPTFile.class);
                String pptUrl = pptFile.getPptUrl();
                String outlineUrl = pptFile.getOutlineUrl();
                String officeUrl = pptFile.getOfficeUrl();
                if (pptUrl != null && outlineUrl != null) {
                    downFile(pptUrl, teacherId);
                    downFile(outlineUrl, teacherId);
                }
                List<String> list = new ArrayList<>();
                list.add(pptUrl);
                list.add(outlineUrl);
                list.add(officeUrl);
                return list;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public AiQuestions getChoiceQuestionsSync(String subject, String chapter, int choiceNum) {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(1000, TimeUnit.SECONDS)  // 读取超时设为30秒
                .connectTimeout(1000, TimeUnit.SECONDS)
                .writeTimeout(1000, TimeUnit.SECONDS)
                .callTimeout(1000, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://" + baseIp + basePort)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        AiDao aiDao = retrofit.create(AiDao.class);
        RequestBody body = RequestBody.create(
                new Gson().toJson(new ChoiceQuestionsBody(subject, chapter, choiceNum)),
                MediaType.parse("application/json")
        );
        Call<AiQuestions> call = aiDao.getChoiceQuestions(body);
        try {
            Response<AiQuestions> response = call.execute(); // 同步请求
            if (response.body() != null) {
                String responseBody = response.body().toString();
                Gson gson = new Gson();
                AiQuestions aiQuestions = gson.fromJson(responseBody, AiQuestions.class);
                Choice choice = aiQuestions.getChoice();
                List<QuestionsText> questions = choice.getChoicesQuestions();
                for (QuestionsText question : questions) {
                    if (choiceQuestionDao.selectIdByQuestion(question.getQuestion(), question.getOption1()
                            , question.getOption2(), question.getOption3(), question.getOption4()) == 0) {
                        choiceQuestionDao.insertQuest(question);
                    }
                }
                return aiQuestions;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
        return null;
    }

    @Override
    public AiBlankQuestion getBlankQuestionsSync(String subject, String chapter, int choiceNum) {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(1000, TimeUnit.SECONDS)  // 读取超时设为30秒
                .connectTimeout(1000, TimeUnit.SECONDS)
                .writeTimeout(1000, TimeUnit.SECONDS)
                .callTimeout(1000, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://" + baseIp + basePort)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        AiDao aiDao = retrofit.create(AiDao.class);
        RequestBody body = RequestBody.create(
                new Gson().toJson(new BlankQuestionsBody(subject, chapter, choiceNum)),
                MediaType.parse("application/json")
        );
        Call<AiBlankQuestion> call = aiDao.getBlankQuestions(body);
        try {
            Response<AiBlankQuestion> response = call.execute(); // 同步请求
            if (response.body() != null) {
                String responseBody = response.body().toString();
                Gson gson = new Gson();
                AiBlankQuestion aiBlankQuestion = gson.fromJson(responseBody, AiBlankQuestion.class);
                Blank blank = aiBlankQuestion.getBlank();
                List<BlankQuestionText> questions = blank.getBlankQuestionTexts();
                for (BlankQuestionText question : questions) {
                    if (blankQuestionDao.selectIdByQuestion(question.getQuestion(), question.getAnswer()) == 0) {
                        blankQuestionDao.insertQuest(question);
                    }
                }
                return aiBlankQuestion;
            }
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
        return null;
    }

    @Override
    public MyResponseBody getAnalysisSync(List<Test> tests) {
        setClient();
        RequestBody body = RequestBody.create(
                new Gson().toJson(tests),
                MediaType.parse("application/json")
        );
        Call<MyResponseBody> call = aiDao.getAnalysis(body);
        try {
            Response<MyResponseBody> execute = call.execute();
            if (execute.body() != null) {
                String responseBody = execute.body().toString();
                Gson gson = new Gson();
                return gson.fromJson(responseBody, MyResponseBody.class);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public AiStudentFeedback getStudentAnalysisSync(String student_id, String subject) throws IOException {
        setClient();
        List<StudentAnalysisText> list = choiceQuestionDao.selectPreviousQuestionToAi(student_id, subject);
        List<StudentAnalysisText> tempList = blankQuestionDao.selectPreviousQuestionsToAi(student_id, subject);
        list.addAll(tempList);
        AiStudentAnalysis analysis = new AiStudentAnalysis(list, subject);
        RequestBody body = RequestBody.create(
                new Gson().toJson(analysis),
                MediaType.parse("application/json")
        );
        Call<AiStudentFeedback> call = aiDao.getStudentFeedback(body);
        Response<AiStudentFeedback> execute = call.execute();
        String responseBody = null;
        if (execute.body() != null) {
            responseBody = execute.body().toString();
        }
        Gson gson = new Gson();
        return gson.fromJson(responseBody, AiStudentFeedback.class);
    }

    @Override
    public AiStudentPercent getStudentPercentSync(String student_id, String subject) throws IOException {
        setClient();
        List<StudentAnalysisText> List = choiceQuestionDao.selectPreviousQuestionToAi(student_id, subject);
        List<StudentAnalysisText> tempList = blankQuestionDao.selectPreviousQuestionsToAi(student_id, subject);
        List.addAll(tempList);
        AiStudentAnalysis analysis = new AiStudentAnalysis(List, subject);
        RequestBody body = RequestBody.create(
                new Gson().toJson(analysis),
                MediaType.parse("application/json")
        );
        Call<AiStudentPercent> call = aiDao.getStudentFeedbackPercent(body);
        Response<AiStudentPercent> execute = call.execute();
        if (execute.body() != null) {
            String responseBody = execute.body().toString();
            Gson gson = new Gson();
            return gson.fromJson(responseBody, AiStudentPercent.class);
        }
        return null;
    }

    @Override
    public AiTeacherFeedback getTeacherFeedbackSync(String teacher_id) throws IOException {
        setClient();
        TeacherUsers teacherUsers = usersDao.selectByTeacherId(teacher_id);
        List<StudentSubject> students = usersDao.selectSubjectIdByTeacherId(teacher_id);
        List<String> classrooms = new ArrayList<>();
        for (StudentSubject studentSubject : students) {
            StudentUsers users = usersDao.selectByStudentId(studentSubject.getStudent_id());
            classrooms.add(users.getClassroom());
        }
        List<TeacherAnalysisText> finalList = new ArrayList<>();
        String subject = teacherUsers.getSubject();
        Set<String> classroomSet = new HashSet<>(classrooms);
        for (String classroom : classroomSet) {
            List<TeacherAnalysisText> list = choiceQuestionDao.selectPreviousQuestionToAiByClassroom(subject, classroom);
            List<TeacherAnalysisText> tempList = blankQuestionDao.selectPreviousQuestionToAiByClassroom(subject, classroom);
            finalList.addAll(tempList);
            finalList.addAll(list);
        }
        AiTeacherAnalysis feedback = new AiTeacherAnalysis(finalList);
        RequestBody body = RequestBody.create(
                new Gson().toJson(feedback),
                MediaType.parse("application/json")
        );
        Call<AiTeacherFeedback> call = aiDao.getExamFeedback(body);
        Response<AiTeacherFeedback> execute = call.execute();
        if (execute.body() != null) {
            String responseBody = execute.body().toString();
            Gson gson = new Gson();
            return gson.fromJson(responseBody, AiTeacherFeedback.class);
        }
        return null;
    }

    @Override
    public AiTeacherPercent getTeacherPercentSync(String teacher_id) throws IOException {
        setClient();
        TeacherUsers teacherUsers = usersDao.selectByTeacherId(teacher_id);
        List<StudentSubject> students = usersDao.selectSubjectIdByTeacherId(teacher_id);
        List<String> classrooms = new ArrayList<>();
        for (StudentSubject studentSubject : students) {
            StudentUsers users = usersDao.selectByStudentId(studentSubject.getStudent_id());
            classrooms.add(users.getClassroom());
        }
        List<TeacherAnalysisText> finalList = new ArrayList<>();
        String subject = teacherUsers.getSubject();
        Set<String> classroomSet = new HashSet<>(classrooms);
        for (String classroom : classroomSet) {
            List<TeacherAnalysisText> list = choiceQuestionDao.selectPreviousQuestionToAiByClassroom(subject, classroom);
            List<TeacherAnalysisText> tempList = blankQuestionDao.selectPreviousQuestionToAiByClassroom(subject, classroom);
            finalList.addAll(tempList);
            finalList.addAll(list);
        }
        AiTeacherAnalysis feedback = new AiTeacherAnalysis(finalList);
        RequestBody body = RequestBody.create(
                new Gson().toJson(feedback),
                MediaType.parse("application/json")
        );
        Call<AiTeacherPercent> call = aiDao.getExamFeedbackPercent(body);
        Response<AiTeacherPercent> execute = call.execute();
        if (execute.body() != null) {
            String responseBody = execute.body().toString();
            Gson gson = new Gson();
            return gson.fromJson(responseBody, AiTeacherPercent.class);
        }
        return null;
    }

    @Override
    public AiPPtTextBack getPPTTextBackSync(String subject, String chapter, String teacher_id, String time)
            throws IOException {
        setClient();
        List<PracticeQuestionText> pq = testDao.selectPracticeQuestionByTeacherIdAndTime(teacher_id, time);
        List<PPTQuestionText> questionTexts = new ArrayList<>();
        List<PPTBlankText> blankTexts = new ArrayList<>();
        AiPPTText aiPPTText = new AiPPTText();
        for (PracticeQuestionText practiceQuestionText : pq) {
            if (practiceQuestionText.getType() == 1) {
                int question_id = practiceQuestionText.getQuestion_id();
                JudgeResult judgeResult = choiceQuestionDao.selectPreviousQuestionByQuestionId(question_id);
                if (judgeResult != null) {
                    PPTQuestionText pptQuestionText = new PPTQuestionText(judgeResult.getQuestion()
                            , judgeResult.getOption1(), judgeResult.getOption2(), judgeResult.getOption3()
                            , judgeResult.getOption4(), judgeResult.getAnswer(), judgeResult.getAnalysis()
                            , judgeResult.getSubject(), judgeResult.getChapter(), judgeResult.getJudge());
                    questionTexts.add(pptQuestionText);
                }
            } else {
                int question_id = practiceQuestionText.getQuestion_id();
                BlankJudgeResult judgeResult = blankQuestionDao.selectPreviousQuestionByQuestionId(question_id);
                if (judgeResult != null) {
                    PPTBlankText blankText = new PPTBlankText(judgeResult.getQuestion(), judgeResult.getAnswer()
                            , judgeResult.getAnalysis(), judgeResult.getSubject(), judgeResult.getChapter()
                            , judgeResult.getJudge());
                    blankTexts.add(blankText);
                }
            }
        }
        aiPPTText.setSubject(subject);
        aiPPTText.setChapter(chapter);
        aiPPTText.setQuestions_choice(questionTexts);
        aiPPTText.setQuestions_blank(blankTexts);
        RequestBody body = RequestBody.create(
                new Gson().toJson(aiPPTText),
                MediaType.parse("application/json")
        );
        Call<AiPPtTextBack> call = aiDao.getOutlineJson(body);
        Response<AiPPtTextBack> execute = call.execute();
        if (execute.body() != null) {
            String responseBody = execute.body().toString();
            Gson gson = new Gson();
            return gson.fromJson(responseBody, AiPPtTextBack.class);
        }
        return null;
    }

    @Override
    public AiPPTBack getPPTUrlSync(String teacher_id, AiPPT aiPPT) throws IOException {
        setClient();
        RequestBody body = RequestBody.create(
                new Gson().toJson(aiPPT),
                MediaType.parse("application/json")
        );
        Call<AiPPTBack> call = aiDao.getPPT(body);
        Response<AiPPTBack> execute = call.execute();
        if (execute.body() != null) {
            String responseBody = execute.body().toString();
            Gson gson = new Gson();
            return gson.fromJson(responseBody, AiPPTBack.class);
        }
        return null;
    }

    public boolean getPPTSync(String url, String teacher_id) {
        return downFile(url, teacher_id);
    }

    @Override
    public AiTestQuestions getTestPercentToStudentSync(String subject, int questionNum
            , int points, String studentId) {
        try {
            setClient();
            AiTest aiTest = new AiTest();
            List<SubjectText> subjectTexts = new ArrayList<>();
            AiTestPercent aiTestPercent;
            AiTestQuestions aiTestQuestions = new AiTestQuestions();
            List<JudgeResult> choiceJudges = choiceQuestionDao.selectPreviousQuestionByStudentId(studentId);
            List<JudgeResult> blankJudges = blankQuestionDao.selectPreviousQuestionByStudentId(studentId);
            choiceJudges.addAll(blankJudges);
            List<AccuracyRate> accuracyRates = testDao.selectAllAccuracyRateByStudentId(studentId);
            for (AccuracyRate accuracyRate : accuracyRates) {
                String knowledgeName = choiceQuestionDao.selectKnowledgeNameById(accuracyRate.getKnowledge());
                accuracyRate.setKnowledgeName(knowledgeName);
                int num = accuracyRate.getNum();
                int right = (int) Math.round(accuracyRate.getRate() * num);
                for (int i = 0; i < right; i++) {
                    SubjectText subjectText = new SubjectText();
                    subjectText.setChapter(accuracyRate.getChapter());
                    subjectText.setKnowledge(accuracyRate.getKnowledgeName());
                    subjectText.setJudge(0);
                    subjectTexts.add(subjectText);
                }
                for (int i = 0; i < num - right; i++) {
                    SubjectText subjectText = new SubjectText();
                    subjectText.setChapter(accuracyRate.getChapter());
                    subjectText.setKnowledge(accuracyRate.getKnowledgeName());
                    subjectText.setJudge(1);
                    subjectTexts.add(subjectText);
                }
            }
            for (JudgeResult judgeResult : choiceJudges) {
                SubjectText subjectText = new SubjectText();
                subjectText.setChapter(judgeResult.getChapter());
                subjectText.setKnowledge(judgeResult.getKnowledge());
                subjectText.setJudge(judgeResult.getJudge());
                subjectTexts.add(subjectText);
            }
            aiTest.setSubject_name(subject);
            aiTest.setQuestion_num(questionNum);
            aiTest.setPoints(points);
            aiTest.setSubject(subjectTexts);
            RequestBody body = RequestBody.create(
                    new Gson().toJson(aiTest),
                    MediaType.parse("application/json")
            );
            Call<AiTestPercent> call = aiDao.getQuestionsPercent(body);
            Response<AiTestPercent> execute = call.execute();
            if (execute.body() != null) {
                String responseBody = execute.body().toString();
                Gson gson = new Gson();
                aiTestPercent = gson.fromJson(responseBody, AiTestPercent.class);
                List<ChoiceAndBlankQuestion> testQuestions = getTestQuestionsSync(aiTestPercent, subject);
                aiTestQuestions.setAiTestPercent(aiTestPercent);
                aiTestQuestions.setQuestions(testQuestions);
                return aiTestQuestions;
            }
            return null;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public AiTestQuestions getTestPercentSync(String subject, int questionNum, int points) {
        try {
            setClient();
            AiTest aiTest = new AiTest();
            AiTestPercent aiTestPercent;
            AiTestQuestions aiTestQuestions = new AiTestQuestions();
            List<SubjectText> knowledgeMessages = new ArrayList<>();
            List<AccuracyRate> accuracyRates = testDao.selectAllAccuracyRate();
            List<JudgeResult> blankPrevious = blankQuestionDao.selectAllPreviousQuestion();
            List<JudgeResult> studentPrevious = choiceQuestionDao.selectAllPreviousQuestion();
            studentPrevious.addAll(blankPrevious);
            for (AccuracyRate accuracyRate : accuracyRates) {
                String knowledgeName = choiceQuestionDao.selectKnowledgeNameById(accuracyRate.getKnowledge());
                accuracyRate.setKnowledgeName(knowledgeName);
                int num = accuracyRate.getNum();
                int right = (int) Math.round(accuracyRate.getRate() * num);
                for (int i = 0; i < right; i++) {
                    SubjectText subjectText = new SubjectText();
                    subjectText.setChapter(accuracyRate.getChapter());
                    subjectText.setKnowledge(accuracyRate.getKnowledgeName());
                    subjectText.setJudge(0);
                    knowledgeMessages.add(subjectText);
                }
                for (int i = 0; i < num - right; i++) {
                    SubjectText subjectText = new SubjectText();
                    subjectText.setChapter(accuracyRate.getChapter());
                    subjectText.setKnowledge(accuracyRate.getKnowledgeName());
                    subjectText.setJudge(1);
                    knowledgeMessages.add(subjectText);
                }
            }
            for (JudgeResult judgeResult : studentPrevious) {
                SubjectText subjectText = new SubjectText();
                subjectText.setChapter(judgeResult.getChapter());
                subjectText.setKnowledge(judgeResult.getKnowledge());
                subjectText.setJudge(judgeResult.getJudge());
                knowledgeMessages.add(subjectText);
            }
            aiTest.setSubject_name(subject);
            aiTest.setQuestion_num(questionNum);
            aiTest.setPoints(points);
            aiTest.setSubject(knowledgeMessages);
            RequestBody body = RequestBody.create(
                    new Gson().toJson(aiTest),
                    MediaType.parse("application/json")
            );
            Call<AiTestPercent> call = aiDao.getQuestionsPercent(body);
            Response<AiTestPercent> execute = call.execute();
            if (execute.body() != null) {
                String responseBody = execute.body().toString();
                Gson gson = new Gson();
                aiTestPercent = gson.fromJson(responseBody, AiTestPercent.class);
                List<ChoiceAndBlankQuestion> testQuestions = getTestQuestionsSync(aiTestPercent, subject);
                aiTestQuestions.setAiTestPercent(aiTestPercent);
                aiTestQuestions.setQuestions(testQuestions);
                return aiTestQuestions;
            }
        } catch (IOException e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
        return null;
    }

    @Override
    public AiTeacherGrade getTeacherGradeSync(String teacher_id, String subject
            , String chapter, MultipartFile videoFile) {
        try {
            String fileName = saveFile(videoFile, teacher_id);
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            String fullName = teacher_id + fileName;
            String videoUrl = ServletUriComponentsBuilder.newInstance()
                    .scheme("http")
                    .host(hostAddress)
                    .port(83)
                    .pathSegment("teacher_files", fullName)
                    .toUriString();
            AiVideo aiVideo = new AiVideo(videoUrl, subject, chapter);
            setClient();
            RequestBody body = RequestBody.create(
                    new Gson().toJson(aiVideo),
                    MediaType.parse("application/json")
            );
            Call<AiTeacherGrade> call = aiDao.getTeacherGrade(body);
            Response<AiTeacherGrade> execute = call.execute();
            if (execute.body() != null) {
                String responseBody = execute.body().toString();
                Gson gson = new Gson();
                return gson.fromJson(responseBody, AiTeacherGrade.class);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
        return null;
    }

    public String saveFile(MultipartFile file, String teacherId) throws IOException {
        if (usersDao.selectByTeacherId(teacherId) != null) {
            String basePath = System.getProperty("user.dir") + File.separator;
            String filePath = basePath + teacherDir + UUID.randomUUID() + teacherId + file.getOriginalFilename();
            File dest = new File(filePath);
            file.transferTo(dest);
            usersDao.insertTeacherFile(teacherId, filePath);
            return file.getOriginalFilename();
        }
        return null;
    }

    //自动组卷
    public List<ChoiceAndBlankQuestion> getTestQuestionsSync(AiTestPercent aiTestPercent, String subject) {
        try {
            List<ChoiceAndBlankQuestion> ChoiceAndBlankQuestions = new ArrayList<>();
            List<ChapterPointsText> chapterPointsTexts = aiTestPercent.getQuestion();
            for (ChapterPointsText chapterPointsText : chapterPointsTexts) {
                String chapter = chapterPointsText.getChapter();
                List<KnowledgePointsText> knowledgePointsTexts = chapterPointsText.getKnowledges();
                for (KnowledgePointsText knowledgePointsText : knowledgePointsTexts) {
                    ChoiceAndBlankQuestion choiceQuestion = new ChoiceAndBlankQuestion();
                    ChoiceAndBlankQuestion blankQuestion = new ChoiceAndBlankQuestion();
                    Integer[] choiceIds = choiceQuestionDao.selectChoiceQuestionIdByKnowledge(subject
                            , chapter, knowledgePointsText.getKnowledge());
                    Integer[] blankIds = blankQuestionDao.selectChoiceQuestionIdByKnowledge(subject
                            , chapter, knowledgePointsText.getKnowledge());
                    int choiceKnowledgeNum;
                    int blankKnowledgeNum;
                    if (knowledgePointsText.getKnowledge_num() == 1) {
                        choiceKnowledgeNum = 1;
                        blankKnowledgeNum = 0;
                    } else {
                        choiceKnowledgeNum = (int) Math.round(knowledgePointsText.getKnowledge_num() * 0.6);
                        blankKnowledgeNum = knowledgePointsText.getKnowledge_num() - choiceKnowledgeNum;
                    }
                    int[] choiceRandomNum = getRandomNum(choiceIds.length, choiceKnowledgeNum);
                    int[] blankRandomNum = getRandomNum(blankIds.length, blankKnowledgeNum);
                    int[] choiceQuestionIds = new int[choiceKnowledgeNum];
                    int[] blankQuestionIds = new int[blankKnowledgeNum];
                    if (choiceRandomNum.length < choiceKnowledgeNum) {
                        int[] tempChoiceIds = new int[choiceRandomNum.length];
                        for (int i : choiceRandomNum) {
                            tempChoiceIds[i] = choiceIds[i];
                        }
                        choiceQuestion.setChoiceIds(tempChoiceIds);
                        choiceQuestion.setChoiceStr("题库中本知识点的题目过少!");
                    } else {
                        for (int i : choiceRandomNum) {
                            choiceQuestionIds[i] = choiceIds[i];
                        }
                        choiceQuestion.setChoiceIds(choiceQuestionIds);
                        choiceQuestion.setBlankStr("题库中本知识点的题目充足!");
                    }
                    if (blankRandomNum.length < blankKnowledgeNum) {
                        int[] tempBlankIds = new int[blankRandomNum.length];
                        for (int i : blankRandomNum) {
                            tempBlankIds[i] = blankIds[i];
                        }
                        blankQuestion.setBlankIds(tempBlankIds);
                        blankQuestion.setBlankStr("题库中本知识点的题目过少!");
                    } else {
                        for (int i : blankRandomNum) {
                            blankQuestionIds[i] = blankIds[i];
                        }
                        blankQuestion.setBlankIds(blankQuestionIds);
                        blankQuestion.setBlankStr("题库中本知识点的题目充足!");
                    }
                    choiceQuestion.setChapter(chapter);
                    choiceQuestion.setKnowledge(knowledgePointsText.getKnowledge());
                    choiceQuestion.setGrade(knowledgePointsText.getKnowledge_grade());
                    ChoiceAndBlankQuestions.add(choiceQuestion);
                    blankQuestion.setChapter(chapter);
                    blankQuestion.setKnowledge(knowledgePointsText.getKnowledge());
                    blankQuestion.setGrade(knowledgePointsText.getKnowledge_grade());
                    ChoiceAndBlankQuestions.add(blankQuestion);
                }
            }
            return ChoiceAndBlankQuestions;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    //  random < max 得到不重复的随机数 num为数组的大小
    public int[] getRandomNum(int max, int num) {
        int count = 0;
        int[] randomNums = new int[num];
        randomNums[num - 1] = -1;
        if (max <= num) {
            int[] tempNum = new int[max];
            for (int i = 0; i < max; i++) {
                tempNum[i] = i;
            }
            return tempNum;
        }
        while (randomNums[num - 1] == -1) {
            for (int i = 0; i < randomNums.length; i++) {
                Random random = new Random();
                int flag = 0;
                int value = random.nextInt(0, max);
                for (int randomNum : randomNums) {
                    if (value == randomNum) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    randomNums[count++] = value;
                }
            }
        }
        return randomNums;
    }

    private boolean downFile(String fileUrl, String teacherId) {
        int judge = 0;
        setClient();
        Response<ResponseBody> responseBodyCall;
        try {
            responseBodyCall = aiDao.DownloadFile(fileUrl).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (responseBodyCall.body() != null && responseBodyCall.isSuccessful()
                && usersDao.selectIdByTeacherId(teacherId) > 0) {
            InputStream inputStream = responseBodyCall.body().byteStream();
            String fileName = UUID.randomUUID().toString();
            String basePath = System.getProperty("user.dir") + File.separator;
            String filePath = basePath + teacherDir + fileName;
            try {
                FileOutputStream fos = new FileOutputStream(filePath);
                int len;
                byte[] buffer = new byte[1024];
                while ((len = inputStream.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                judge = usersDao.insertTeacherFile(teacherId, filePath);
            } catch (Exception e) {
                throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                        "系统错误!" + e.getMessage());
            }
        }
        return judge > 0;
    }

    private void setClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(1000, TimeUnit.SECONDS)  // 读取超时设为30秒
                .connectTimeout(1000, TimeUnit.SECONDS)
                .writeTimeout(1000, TimeUnit.SECONDS)
                .callTimeout(1000, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://" + baseIp + basePort)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        aiDao = retrofit.create(AiDao.class);
    }
}
