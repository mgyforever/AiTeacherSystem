package com.ccut.teachingaisystem.service.impl.questions;

import com.ccut.teachingaisystem.controller.Code;
import com.ccut.teachingaisystem.dao.questions.ChoiceQuestionDao;
import com.ccut.teachingaisystem.dao.users.UsersDao;
import com.ccut.teachingaisystem.domain.question.rate.Chapter;
import com.ccut.teachingaisystem.domain.question.choice.JudgeResult;
import com.ccut.teachingaisystem.domain.question.choice.QuestionsText;
import com.ccut.teachingaisystem.domain.question.rate.Knowledge;
import com.ccut.teachingaisystem.exception.SystemException;
import com.ccut.teachingaisystem.service.questionsService.ChoiceQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ChoiceQuestionServiceImpl implements ChoiceQuestionService {
    @Autowired
    private ChoiceQuestionDao choiceQuestionDao;

    @Autowired
    private UsersDao usersDao;

    @Override
    public boolean insertChapter(Chapter chapter) {
        try {
            return choiceQuestionDao.insertChapter(chapter) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean insertKnowledge(Knowledge knowledge) {
        try {
            int chapterId = choiceQuestionDao.selectChapterIdByChapter(knowledge.getChapterName()
                    , knowledge.getSubjectName());
            knowledge.setChapter(chapterId);
            return choiceQuestionDao.insertKnowledge(knowledge) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean insertQuestion(QuestionsText questionsText) {
        try {
            if (choiceQuestionDao.selectIdByQuestion(questionsText.getQuestion(), questionsText.getOption1()
                    , questionsText.getOption2(), questionsText.getOption3(), questionsText.getOption4()) == 0) {
                return choiceQuestionDao.insertQuest(questionsText) > 0;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean insertWrongAnswer(JudgeResult judgeResult) {
        try {
            copyQuestions(judgeResult);
            return choiceQuestionDao.insertWrongQuestion(judgeResult) > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean insertWrongAnswers(List<JudgeResult> judgeResults) {
        try {
            if (!judgeResults.isEmpty()) {
                for (JudgeResult judgeResult : judgeResults) {
                    copyQuestions(judgeResult);
                    choiceQuestionDao.insertWrongQuestion(judgeResult);
                }
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean insertPreviousQuestion(List<JudgeResult> judgeResults) {
        try {
            if (!judgeResults.isEmpty()) {
                for (JudgeResult judgeResult : judgeResults) {
                    copyQuestions(judgeResult);
                    choiceQuestionDao.insertPreviousQuestion(judgeResult);
                }
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean insertQuestionAndImg(JudgeResult judgeResult, List<MultipartFile> files) {
        try {
            List<String> filePathList = new ArrayList<>();
            for (MultipartFile file : files) {
                String filePath = "D:\\java\\code\\idea program\\TeachingAISystem\\src\\main\\java" +
                        "\\com\\ccut\\teachingaisystem\\download\\questionimg" +
                        UUID.randomUUID() + file.getOriginalFilename();
                File dest = new File(filePath);
                file.transferTo(dest);
                filePathList.add(file.getOriginalFilename());
            }
            return choiceQuestionDao.insertQuestAndImg(judgeResult, filePathList.get(0)
                    , filePathList.get(1), filePathList.get(2)) > 0;
        } catch (IOException e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean deleteSubject(String subject) {
        try {
            return choiceQuestionDao.deleteSubject(subject) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean deleteChapter(String chapter) {
        try {
            return choiceQuestionDao.deleteChapter(chapter) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean deleteKnowledge(String subject, String chapter, String knowledge) {
        try {
            int chapterId = choiceQuestionDao.selectChapterIdByChapter(subject, chapter);
            return choiceQuestionDao.deleteKnowledge(knowledge, chapterId) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean deleteQuestion(int id) {
        try {
            if (choiceQuestionDao.selectById(id) == null) {
                return false;
            } else {
                return choiceQuestionDao.deleteQuestion(id) > 0;
            }
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean deleteWrongAnswer(int id) {
        try {
            return choiceQuestionDao.deleteWrongQuestion(id) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean deleteAllWrongQuestion(String student_id) {
        try {
            return choiceQuestionDao.deleteAllWrongQuestion(student_id) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean deleteAllQuestion(String student_id) {
        try {
            return choiceQuestionDao.deleteAllQuestion(student_id) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean deletePreviousQuestion(String student_id) {
        try {
            return choiceQuestionDao.deleteAllPreviousQuestion(student_id) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateQuestion(QuestionsText questionsText) {
        try {
            if (choiceQuestionDao.selectById(questionsText.getId()) == null) {
                return false;
            } else {
                choiceQuestionDao.deleteQuestion(questionsText.getId());
                return choiceQuestionDao.insertQuest(questionsText) > 0;
            }
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateChapterById(Chapter chapter) {
        try {
            return choiceQuestionDao.updateChapterById(chapter.getId(), chapter.getChapter()) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateSubjectById(Chapter chapter) {
        try {
            return choiceQuestionDao.updateSubjectById(chapter.getId(), chapter.getSubject()) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateKnowledgeById(Knowledge knowledge) {
        try {
            return choiceQuestionDao.updateKnowledgeById(knowledge) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<Chapter> selectChapter(String subject) {
        try {
            return choiceQuestionDao.selectChapterBySubject(subject);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<Knowledge> selectKnowledge(String chapter, String subject) {
        try {
            int chapterId = choiceQuestionDao.selectChapterIdByChapter(chapter, subject);
            return choiceQuestionDao.selectKnowledgeByChapter(chapterId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<JudgeResult> selectAllQuestions() {
        try {
            return choiceQuestionDao.selectAllQuestions();
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public JudgeResult selectQuestionById(int id) {
        try {
            return choiceQuestionDao.selectById(id);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<JudgeResult> selectPreviousQuestions(String student_id, String subject) {
        try {
            return choiceQuestionDao.selectPreviousQuestions(student_id, subject);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<JudgeResult> selectPreviousAnswers(String student_id, String subject, String chapter) {
        try {
            return choiceQuestionDao.selectPreviousAnswers(student_id, subject, chapter);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<JudgeResult> selectQuestionsByChapter(String chapter, String subject) {
        try {
            return choiceQuestionDao.selectByChapterId(chapter, subject);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<JudgeResult> selectQuestionsBySubject(String subject) {
        try {
            return choiceQuestionDao.selectBySubject(subject);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<JudgeResult> selectQuestionsByKnowledge(String knowledge) {
        try {
            return choiceQuestionDao.selectByKnowledge(knowledge);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<JudgeResult> selectWrongQuestions(String student_id, String subject) {
        try {
            if (usersDao.selectByStudentId(student_id) != null) {
                return choiceQuestionDao.selectWrongQuestions(student_id, subject);
            }
            return null;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<JudgeResult> selectWrongAnswers(String student_id, String subject, String chapter) {
        try {
            if (usersDao.selectByStudentId(student_id) != null) {
                return choiceQuestionDao.selectWrongAnswers(student_id, subject, chapter);
            }
            return null;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<JudgeResult> selectQuestionsByList(int[] list) {
        try {
            List<JudgeResult> questionsList = new ArrayList<>();
            for (int j : list) {
                questionsList.add(selectQuestionById(j));
            }
            return questionsList;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<JudgeResult> selectPreviousQuestionsByKnowledge(String student_id
            , String subject, String chapter, String knowledge) {
        try {
            return choiceQuestionDao.selectPreviousQuestionByKnowledge(student_id, subject, chapter, knowledge);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<JudgeResult> selectWrongQuestionsByKnowledge(String student_id
            , String subject, String chapter, String knowledge) {
        try {
            return choiceQuestionDao.selectWrongQuestionByKnowledge(student_id, subject, chapter, knowledge);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    private void copyQuestions(JudgeResult judgeResult) {
        JudgeResult questionsText = choiceQuestionDao.selectById(judgeResult.getQuestion_id());
        judgeResult.setQuestion(questionsText.getQuestion());
        judgeResult.setAnswer(questionsText.getAnswer());
        judgeResult.setAnalysis(questionsText.getAnalysis());
        judgeResult.setSubject(questionsText.getSubject());
        judgeResult.setChapter(questionsText.getChapter());
        judgeResult.setReply(judgeResult.getReply());
        judgeResult.setOption1(questionsText.getOption1());
        judgeResult.setOption2(questionsText.getOption2());
        judgeResult.setOption3(questionsText.getOption3());
        judgeResult.setOption4(questionsText.getOption4());
        judgeResult.setKnowledge(questionsText.getKnowledge());
    }
}
