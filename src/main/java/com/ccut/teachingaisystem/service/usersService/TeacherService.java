package com.ccut.teachingaisystem.service.usersService;

import com.ccut.teachingaisystem.domain.users.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TeacherService {
    List<TeacherUsers> selectAll();
    TeacherUsers selectByTeacherId(String Teacher_id);
    String selectPassword(String Teacher_id);
    String selectPasswordByPhoneNumber(String phoneNumber);
    String selectImage(String teacher_id);
    TeacherUsers selectByIdTeacher(int id);
    boolean insert(TeacherUsers user);
    boolean insertTeacherMessage(MultipartFile file);
    boolean insertTeacherIdentify(UsersIdentify identify);
    boolean insertTeacherFile(String teacher_id, MultipartFile file);
    boolean delete(String Teacher_id);
    boolean deleteTeacherFile(int id);
    boolean deleteTeacherIdentify(String teacher_id);
    boolean updateTeacherUsername(int id, String username);
    boolean updateTeacher_id(int id, String Teacher_id);
    boolean updateTeacherPassword(int id, String password);
    boolean updateTeacherUsers(TempUsers teacherUsers);
    UsersIdentify selectIdentifyByTeacherId(String teacher_id);
    List<UsersIdentify> selectAllStudentIdentify();
    UsersIdentify selectIdentifyByStudentId(String student_id);
    List<UsersIdentify> selectClassroomStudentIdentify(String classroom);
    List<UsersIdentify> selectClassroomTeacherIdentify(String classroom);
    List<UsersIdentify> selectAllTeacherIdentify();
    List<TeacherUsers> selectAllTeacherBySubject(String subject);
    List<StudentSubject> selectSubjectIdByTeacherId(String Teacher_id);
    boolean updateTeacherIdentify(UsersIdentify identify);
    boolean updateImage(String Teacher_id, MultipartFile file);
    boolean updateEmail(String TeacherId, String email);
    boolean updateTeacher(TeacherUsers teacherUsers);
    List<TeacherFile> getTeacherAllFilesName(String teacher_id);
}
