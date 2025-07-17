package com.ccut.teachingaisystem.service.usersService;

import com.ccut.teachingaisystem.domain.users.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    List<StudentUsers> selectAll();
    StudentUsers selectById(int id);
    String selectImage(String student_id);
    StudentUsers selectByStudentId(String student_id);
    String selectPassword(String student_id);
    String selectPasswordByPhoneNumber(String PhoneNumber);
    boolean insertStudentIdentify(UsersIdentify identify);
    boolean delete(String student_id);
    boolean deleteStudentIdentify(String student_id);
    boolean deleteStudentMessage(String student_id);
    boolean deleteStudentSubject(String student_id, String subject);
    boolean updateStudentUsername(int id, String username);
    boolean updateStudent_id(int id, String student_id);
    boolean updateStudentPassword(int id, String password);
    boolean updateStudentMessage(StudentMessage studentMessage);
    boolean updateStudentPassword(TempUsers tempUsers);
    boolean updateStudentUsers(TempUsers studentUsers);
    UsersIdentify selectIdentifyByStudentId(String student_id);
    List<StudentMessage> selectMessageByCollege(String college);
    List<StudentMessage> selectMessageByProfessional(String college, String professional);
    List<StudentMessage> selectMessageByClassroom(String college, String classroom, String professional);
    List<StudentMessage> selectAllStudentMessage();
    List<StudentSubject> selectSubjectByStudentId(String student_id);
    boolean updateStudentIdentify(UsersIdentify identify);
    boolean updateImage(String student_id, MultipartFile file);
    boolean updateEmail(String studentId, String email);
    boolean updateStudent(StudentUsers studentUsers);
    boolean insertStudent(StudentUsers studentUsers);
    boolean insertStudentMessage(MultipartFile file);
    boolean insertStudentSubject(StudentSubject studentSubject);
    boolean insertStudentActions(UserActions UserActions);
    List<UserActions> selectStudentActionsByStudentId(String user_id, int judge);
}
