package com.ccut.teachingaisystem.service.impl.users;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.ccut.teachingaisystem.controller.Code;
import com.ccut.teachingaisystem.dao.users.UsersDao;
import com.ccut.teachingaisystem.domain.users.*;
import com.ccut.teachingaisystem.exception.SystemException;
import com.ccut.teachingaisystem.service.usersService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    @Value("${file.image_dir}")
    private String imageDir;

    @Autowired
    private UsersDao usersDao;

    @Override
    public List<StudentUsers> selectAll() {
        try {
            return usersDao.selectAllStudent();
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public StudentUsers selectById(int id) {
        try {
            return usersDao.selectByIdStudent(id);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public String selectImage(String student_id) {
        try {
            return usersDao.selectImgStudent(student_id);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public StudentUsers selectByStudentId(String student_id) {
        try {
            return usersDao.selectUserByStudentId(student_id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public String selectPassword(String student_id) {
        try {
            return usersDao.selectStudentPasswordByStudentId(student_id);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public String selectPasswordByPhoneNumber(String PhoneNumber) {
        try {
            return usersDao.selectStudentPasswordByPhoneNumber(PhoneNumber);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
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
    public List<StudentMessage> selectMessageByCollege(String college) {
        try {
            return usersDao.selectStudentMessageByCollege(college);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<StudentMessage> selectMessageByProfessional(String college, String professional) {
        try {
            return usersDao.selectStudentMessageByProfessional(college, professional);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<StudentMessage> selectMessageByClassroom(String college, String classroom, String professional) {
        try {
            return usersDao.selectStudentMessageByClassroom(college, classroom, professional);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<StudentMessage> selectAllStudentMessage() {
        try {
            return usersDao.selectAllStudentMessage();
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public List<StudentSubject> selectSubjectByStudentId(String student_id) {
        try {
            return usersDao.selectSubjectByStudentId(student_id);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean insertStudentIdentify(UsersIdentify identify) {
        try {
            if (selectIdentifyByStudentId(identify.getId()) != null) {
                return false;
            }
            return usersDao.insertStudentIdentify(identify) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean delete(String student_id) {
        try {
            if (usersDao.selectByStudentId(student_id) == null) {
                return false;
            } else {
                return usersDao.deleteStudent(student_id) > 0;
            }
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean deleteStudentIdentify(String student_id) {
        try {
            if (usersDao.selectByStudentId(student_id) == null) {
                return false;
            } else {
                StudentUsers studentUsers = usersDao.selectByStudentId(student_id);
                usersDao.deleteStudentIdentify(studentUsers.getPhoneNumber());
                return true;
            }
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean deleteStudentMessage(String student_id) {
        try {
            return usersDao.deleteStudentMessage(student_id) > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean deleteStudentSubject(String student_id, String subject) {
        try {
            return usersDao.deleteStudentSubject(student_id, subject) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateStudentUsername(int id, String username) {
        try {
            if (usersDao.selectByIdStudent(id) == null) {
                return false;
            } else {
                return usersDao.updateStudentUsername(id, username) > 0;
            }
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateStudent_id(int id, String student_id) {
        try {
            if (usersDao.selectByIdStudent(id) == null) {
                return false;
            } else {
                return usersDao.updateStudent_id(id, student_id) > 0;
            }
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateStudentPassword(int id, String password) {
        try {
            if (usersDao.selectByIdStudent(id) == null) {
                return false;
            } else {
                return usersDao.updateStudentPassword(id, password) > 0;
            }
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateStudentMessage(StudentMessage studentMessage) {
        try {
            StudentUsers studentUsers = usersDao.selectByStudentId(studentMessage.getStudent_id());
            studentUsers.setStudent_id(studentMessage.getStudent_id());
            studentUsers.setYear(studentMessage.getYear());
            studentUsers.setProfessional(studentMessage.getProfessional());
            studentUsers.setClassroom(studentMessage.getClassroom());

            return usersDao.updateStudentsMessage(studentMessage) > 0
                    && usersDao.updateStudentClassroom(studentUsers) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateStudentPassword(TempUsers tempUsers) {
        try {
            return usersDao.updateStudentMessage(tempUsers) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateStudentUsers(TempUsers studentUsers) {
        try {
            return usersDao.updateStudent(studentUsers) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateStudentIdentify(UsersIdentify identify) {
        try {
            String userId = identify.getId();
            if (usersDao.selectByStudentId(userId) == null) {
                return false;
            } else {
                StudentUsers su = usersDao.selectByStudentId(userId);
                if (usersDao.deleteStudentIdentify(su.getPhoneNumber()) > 0) {
                    usersDao.deleteStudentIdentify(su.getPhoneNumber());
                    return usersDao.insertStudentIdentify(identify) > 0;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(), "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateImage(String student_id, MultipartFile file) {
        try {
            if (usersDao.selectByStudentId(student_id) != null) {
                BufferedImage image = ImageIO.read(file.getInputStream());
                if (!file.isEmpty() && image != null) {
                    String basePath = System.getProperty("user.dir") + File.separator;
                    String filePath = basePath + imageDir + UUID.randomUUID() + file.getOriginalFilename();
                    File dest = new File(filePath);
                    file.transferTo(dest);
                    return usersDao.updateStudentImg(student_id, filePath) > 0;
                }
                return false;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean updateEmail(String studentId, String email) {
        try {
            if (usersDao.selectByStudentId(studentId) != null) {
                return usersDao.updateStudentEmail(studentId, email) > 0;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean updateStudent(StudentUsers studentUsers) {
        try {
            return usersDao.updateStudentAll(studentUsers) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean insertStudent(StudentUsers studentUsers) {
        try {
            if (usersDao.selectByStudentId(studentUsers.getPhoneNumber()) == null) {
                return usersDao.insertStudentUsers(studentUsers) > 0;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean insertStudentMessage(MultipartFile file) {
        try {
            InputStream fis = file.getInputStream();
            ExcelReader reader = ExcelUtil.getReader(fis);
            List<TempUsers> tempUsers = reader.readAll(TempUsers.class);
            System.out.println(tempUsers.size());
            System.out.println(tempUsers);
            int[] flag = new int[tempUsers.size() * 3];
            int count = 0;
            String basePath = System.getProperty("user.dir") + File.separator;
            String imgPath = basePath + imageDir +
                    "f1c90710-3adc-47fb-a7c7-4e2b3b898fe2v2-f37c17fa026dfbb46df18af78ef09b1d_r.jpg";
            for (TempUsers tempUser : tempUsers) {
                String userName = "用户" + tempUser.getPhoneNumber();
                if (usersDao.selectIdByPhoneNumber(tempUser.getPhoneNumber()) == null) {
                    tempUser.setUserName(userName);
                    flag[count] = usersDao.insertStudentMessage(tempUser);
                    flag[++count] = usersDao.insertAllStudentUserMessage(tempUser, imgPath);
                    flag[++count] = usersDao.insertStudentsIdentify(tempUser);
                    count++;
                }
            }
            System.out.println(Arrays.toString(flag));
            boolean result = true;
            for (int j : flag) {
                if (j <= 0) {
                    result = false;
                    break;
                }
            }
            return result;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

    @Override
    public boolean insertStudentSubject(StudentSubject studentSubject) {
        try {
            return usersDao.insertStudentSubject(studentSubject.getStudent_id()
                    , studentSubject.getSubject(), studentSubject.getTeacher_id()) > 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, e.getCause(),
                    "系统错误!" + e.getMessage());
        }
    }

}
