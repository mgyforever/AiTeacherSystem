package com.ccut.teachingaisystem.service.impl.users;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.ccut.teachingaisystem.controller.Code;
import com.ccut.teachingaisystem.dao.users.UsersDao;
import com.ccut.teachingaisystem.domain.users.*;
import com.ccut.teachingaisystem.exception.SystemException;
import com.ccut.teachingaisystem.service.usersService.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SuppressWarnings("JavadocDeclaration")
@Service
public class TeacherServiceImpl implements TeacherService {

    private static final Logger log = LoggerFactory.getLogger(TeacherServiceImpl.class);

    @Value("${file.teacher-dir}")
    private String teacherDir;

    @Value("${file.image_dir}")
    private String imageDir;

    @Autowired
    private UsersDao usersDao;

    @Override
    public List<TeacherUsers> selectAll() {
        try {
            return usersDao.selectAllTeacher();
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误(TeacherSelectAll)!" + e.getMessage());
        }
    }

    @Override
    public TeacherUsers selectByTeacherId(String Teacher_id) {
        try {
            return usersDao.selectByTeacherIdNoPassword(Teacher_id);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public String selectPassword(String Teacher_id) {
        try {
            return usersDao.selectTeacherPasswordByTeacherId(Teacher_id);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public String selectPasswordByPhoneNumber(String phoneNumber) {
        try {
            return usersDao.selectTeacherPasswordByPhoneNumber(phoneNumber);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public String selectImage(String teacher_id) {
        try {
            return usersDao.selectImgTeacher(teacher_id);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public TeacherUsers selectByIdTeacher(int id) {
        try {
            return usersDao.selectByIdTeacher(id);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public UsersIdentify selectIdentifyByTeacherId(String teacher_id) {
        try {
            if (usersDao.selectByTeacherId(teacher_id) != null) {
                String phoneNumber = usersDao.selectByTeacherId(teacher_id).getPhoneNumber();
                return usersDao.selectTeacherIdentifyByPhoneNumber(phoneNumber);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new SystemException(Code.BUSINESS_ERR, e.getCause()
                    , "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<UsersIdentify> selectClassroomTeacherIdentify(String classroom) {
        try {
            return usersDao.selectProfessionalTeacherIdentify(classroom);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause()
                    , "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<UsersIdentify> selectAllTeacherIdentify() {
        try {
            return usersDao.selectAllTeacherIdentify();
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause()
                    , "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<UsersIdentify> selectAllStudentIdentify() {
        try {
            return usersDao.selectAllStudentIdentify();
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause()
                    , "系统错误!" + e.getMessage());
        }
    }

    @Override
    public UsersIdentify selectIdentifyByStudentId(String student_id) {
        try {
            if (usersDao.selectByStudentId(student_id) != null) {
                String phoneNumber = usersDao.selectByStudentId(student_id).getPhoneNumber();
                return usersDao.selectStudentIdentify(phoneNumber);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new SystemException(Code.BUSINESS_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<UsersIdentify> selectClassroomStudentIdentify(String classroom) {
        try {
            return usersDao.selectClassroomStudentIdentify(classroom);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause()
                    , "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<TeacherUsers> selectAllTeacherBySubject(String subject) {
        try {
            return usersDao.selectTeacherBySubject(subject);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<StudentSubject> selectSubjectIdByTeacherId(String Teacher_id) {
        try {
            List<StudentSubject> subjects = usersDao.selectSubjectIdByTeacherId(Teacher_id);
            for (StudentSubject subject : subjects) {
                StudentUsers studentUser = usersDao.selectByStudentId(subject.getStudent_id());
                StudentMessage studentMessage = usersDao.selectMessageByStudentId(subject.getStudent_id());
                subject.setClassroom(studentUser.getClassroom());
                subject.setProfessional(studentUser.getProfessional());
                subject.setYear(studentUser.getYear());
                subject.setStudent_name(studentMessage.getName());
            }
            return subjects;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean insert(TeacherUsers user) {
        try {
            if (usersDao.selectByIdTeacher(user.getId()) != null) {
                return false;
            }
            return usersDao.insertTeacher(user) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean insertTeacherMessage(MultipartFile file) {
        try {
            InputStream fis = file.getInputStream();
            ExcelReader reader = ExcelUtil.getReader(fis);
            List<TempUsers> tempUsers = reader.readAll(TempUsers.class);
            int[] flag = new int[tempUsers.size() * 2];
            int count = 0;
            boolean bl = true;
            for (TempUsers tempUser : tempUsers) {
                flag[count] = usersDao.insertTeacherUsers(tempUser);
                flag[count + 1] = usersDao.insertTeachersIdentify(tempUser);
                count++;
            }
            for (int i : flag) {
                if (i <= 0) {
                    bl = false;
                    break;
                }
            }
            return bl;
        } catch (IOException e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean insertTeacherIdentify(UsersIdentify identify) {
        try {
            if (selectIdentifyByTeacherId(identify.getId()) != null) {
                return false;
            }
            return usersDao.insertTeacherIdentify(identify) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean insertTeacherFile(String teacher_id, MultipartFile file) {
        try {
            if (usersDao.selectByTeacherId(teacher_id) != null) {
                String basePath = System.getProperty("user.dir") + File.separator;
                String fileName = teacher_id + file.getOriginalFilename();
                String filePath = String.valueOf(Paths.get(basePath,teacherDir,fileName));
                File dest = new File(filePath);
                file.transferTo(dest);
                return usersDao.insertTeacherFile(teacher_id, filePath) > 0;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean delete(String teacher_id) {
        try {
            if (usersDao.selectByTeacherId(teacher_id) == null) {
                return false;
            } else {
                return usersDao.deleteTeacher(teacher_id) > 0;
            }
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean deleteTeacherFile(int id) {
        try {
            return usersDao.deleteTeacherFile(id) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean deleteTeacherIdentify(String teacher_id) {
        try {
            if (usersDao.selectByTeacherId(teacher_id) == null) {
                return false;
            } else {
                TeacherUsers teacherUsers = usersDao.selectByTeacherId(teacher_id);
                usersDao.deleteTeacherIdentify(teacherUsers.getPhoneNumber());
                return true;
            }
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateTeacherUsername(int id, String username) {
        try {
            if (usersDao.selectByIdTeacher(id) == null) {
                return false;
            } else {
                return usersDao.updateTeacherUsername(id, username) > 0;
            }
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateTeacher_id(int id, String Teacher_id) {
        try {
            if (usersDao.selectByIdTeacher(id) == null) {
                return false;
            } else {
                return usersDao.updateTeacher_id(id, Teacher_id) > 0;
            }
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateTeacherPassword(int id, String password) {
        try {
            if (usersDao.selectByIdTeacher(id) == null) {
                return false;
            } else {
                return usersDao.updateTeacherPassword(id, password) > 0;
            }
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateTeacherUsers(TempUsers teacherUsers) {
        try {
            return usersDao.updateTeacher(teacherUsers) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateTeacherIdentify(UsersIdentify identify) {
        try {
            String userId = identify.getId();
            if (usersDao.selectByTeacherId(userId) == null) {
                return false;
            } else {
                TeacherUsers tu = usersDao.selectByTeacherId(userId);
                if (usersDao.deleteTeacherIdentify(tu.getPhoneNumber()) > 0) {
                    usersDao.deleteTeacherIdentify(tu.getPhoneNumber());
                    return usersDao.insertTeacherIdentify(identify) > 0;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateImage(String Teacher_id, MultipartFile file) {
        if (usersDao.selectByTeacherId(Teacher_id) != null) {
            try {
                if (usersDao.selectByTeacherId(Teacher_id) != null) {
                    BufferedImage image = ImageIO.read(file.getInputStream());
                    if (!file.isEmpty() && image != null) {
                        String basePath = System.getProperty("user.dir") + File.separator;
                        String filePath = basePath + imageDir + UUID.randomUUID() + file.getOriginalFilename();
                        File dest = new File(filePath);
                        file.transferTo(dest);
                        return usersDao.updateTeacherImg(Teacher_id, filePath) > 0;
                    }
                    return false;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    @Override
    public boolean updateEmail(String TeacherId, String email) {
        try {
            if (usersDao.selectByTeacherId(TeacherId) != null) {
                return usersDao.updateTeacherEmail(TeacherId, email) > 0;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateTeacher(TeacherUsers teacherUsers) {
        try {
            return usersDao.updateTeacherAll(teacherUsers) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    /**
     * 获取老师的文件名字
     *
     * @param teacher_id
     * @return
     */
    @Override
    public List<TeacherFile> getTeacherAllFilesName(String teacher_id) {
        try {
            List<TeacherFile> teacherFiles = usersDao.selectFileByTeacherId(teacher_id);
            List<String> filePath = new ArrayList<>();
            for (TeacherFile path1 : teacherFiles) {
                filePath.add(path1.getFile_path().substring(105 + teacher_id.length()));
            }
            for (int i = 0; i < teacherFiles.size(); i++) {
                teacherFiles.get(i).setFile_name(filePath.get(i));
            }
            return teacherFiles;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

}
