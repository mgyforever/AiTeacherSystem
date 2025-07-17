package com.ccut.teachingaisystem.service.impl.questions;

import com.ccut.teachingaisystem.controller.Code;
import com.ccut.teachingaisystem.dao.questions.BlankQuestionDao;
import com.ccut.teachingaisystem.dao.users.UsersDao;
import com.ccut.teachingaisystem.domain.question.blank.BlankJudgeResult;
import com.ccut.teachingaisystem.domain.question.blank.BlankQuestionText;
import com.ccut.teachingaisystem.domain.question.choice.JudgeResult;
import com.ccut.teachingaisystem.exception.SystemException;
import com.ccut.teachingaisystem.service.questionsService.BlankQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BlankQuestionServiceImpl implements BlankQuestionService {

    @Value("${file.questionImg-dir}")
    private String questionImgDir;

    @Autowired
    private BlankQuestionDao blankQuestionDao;

    @Autowired
    private UsersDao usersDao;

    @Override
    public boolean insertQuestion(BlankQuestionText questionsText) {
        try {
            if (blankQuestionDao.selectIdByQuestion(questionsText.getQuestion(), questionsText.getAnswer()) == 0) {
                return blankQuestionDao.insertQuest(questionsText) > 0;
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
            return blankQuestionDao.insertWrongQuestion(judgeResult) > 0;
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
                    blankQuestionDao.insertWrongQuestion(judgeResult);
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
                    blankQuestionDao.insertPreviousQuestion(judgeResult);
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
    public boolean insertBlankQuestionAndImg(BlankJudgeResult questionsText, List<MultipartFile> files) {
        try {
            List<String> filePathList = new ArrayList<>();
            for (MultipartFile file : files) {
                String basePath = System.getProperty("user.dir") + File.separator;
                String filePath = basePath + questionImgDir + UUID.randomUUID() + file.getOriginalFilename();
                File dest = new File(filePath);
                file.transferTo(dest);
                filePathList.add(file.getOriginalFilename());
            }

            return blankQuestionDao.insertQuestAndImg(questionsText, filePathList.get(0)
                    , filePathList.get(1), filePathList.get(2)) > 0;
        } catch (IOException e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean deleteQuestion(int id) {
        try {
            if (blankQuestionDao.selectById(id) == null) {
                return false;
            } else {
                return blankQuestionDao.deleteQuestion(id) > 0;
            }
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean deleteWrongAnswer(int id) {
        try {
            if (blankQuestionDao.selectById(id) == null) {
                return false;
            }
            return blankQuestionDao.deleteWrongQuestion(id) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean deleteAllWrongQuestion(String student_id) {
        try {
            return blankQuestionDao.deleteAllWrongQuestion(student_id) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean deleteAllQuestion(String student_id) {
        try {
            return blankQuestionDao.deleteAllQuestion(student_id) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean deletePreviousQuestion(String student_id) {
        try {
            return blankQuestionDao.deleteAllPreviousQuestion(student_id) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateQuestion(BlankQuestionText questionsText) {
        try {
            if (blankQuestionDao.selectById(questionsText.getId()) == null) {
                return false;
            } else {
                blankQuestionDao.deleteQuestion(questionsText.getId());
                return blankQuestionDao.insertQuest(questionsText) > 0;
            }
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<BlankJudgeResult> selectAllQuestions() {
        try {
            return blankQuestionDao.selectAllQuestions();
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public BlankJudgeResult selectQuestionById(int id) {
        try {
            return blankQuestionDao.selectById(id);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<BlankJudgeResult> selectPreviousQuestions(String student_id, String subject) {
        try {
            return blankQuestionDao.selectPreviousQuestionsTo(student_id, subject);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<BlankJudgeResult> selectPreviousAnswers(String student_id, String subject, String chapter) {
        try {
            return blankQuestionDao.selectPreviousAnswers(student_id, subject, chapter);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<BlankJudgeResult> selectQuestionsByChapter(String chapter, String subject) {
        try {
            return blankQuestionDao.selectByChapterId(chapter, subject);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<BlankJudgeResult> selectQuestionsBySubject(String subject) {
        try {
            return blankQuestionDao.selectBySubject(subject);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<BlankJudgeResult> selectQuestionsByKnowledge(String knowledge) {
        try {
            return blankQuestionDao.selectByKnowledge(knowledge);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<BlankJudgeResult> selectWrongQuestions(String student_id, String subject) {
        try {
            if (usersDao.selectByStudentId(student_id) != null) {
                return blankQuestionDao.selectWrongQuestions(student_id, subject);
            }
            return null;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<BlankJudgeResult> selectWrongAnswers(String student_id, String subject, String chapter) {
        try {
            if (usersDao.selectByStudentId(student_id) != null) {
                return blankQuestionDao.selectWrongAnswers(student_id, subject, chapter);
            }
            return null;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<BlankJudgeResult> selectQuestionsByList(int[] list) {
        try {
            List<BlankJudgeResult> questionsList = new ArrayList<>();
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
    public List<BlankJudgeResult> selectPreviousQuestionsByKnowledge(String student_id
            , String subject, String chapter, String knowledge) {
        try {
            return blankQuestionDao.selectPreviousQuestionByKnowledge(student_id, subject, chapter, knowledge);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<BlankJudgeResult> selectWrongQuestionsByKnowledge(String student_id
            , String subject, String chapter, String knowledge) {
        try {
            return blankQuestionDao.selectWrongQuestionByKnowledge(student_id, subject, chapter, knowledge);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    private void copyQuestions(JudgeResult judgeResult) {
        BlankJudgeResult questionsText = blankQuestionDao.selectById(judgeResult.getQuestion_id());
        judgeResult.setQuestion(questionsText.getQuestion());
        judgeResult.setAnswer(questionsText.getAnswer());
        judgeResult.setAnalysis(questionsText.getAnalysis());
        judgeResult.setSubject(questionsText.getSubject());
        judgeResult.setChapter(questionsText.getChapter());
        judgeResult.setReply(judgeResult.getReply());
        judgeResult.setKnowledge(questionsText.getKnowledge());
    }
}
