package com.ccut.teachingaisystem.dao.users;

import com.ccut.teachingaisystem.domain.users.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersDao {

    @Insert("insert into ai_student_users (phoneNumber, password)" +
            " values (#{phoneNumber}, #{password})")
    int insertStudentUsers(StudentUsers studentUsers);

    @Insert("insert into ai_student_users (student_id, password, classroom" +
            ", phoneNumber, email, year, professional) " +
            "VALUES (#{student_id},#{password}, #{classroom}" +
            ", #{phoneNumber}, #{email}, #{year}, #{professional})")
    int insertStudent(TempUsers tempUsers);

    @Insert("insert into ai_teacher_users (teacher_id, password, phoneNumber, subject, email, year, professional) " +
            "VALUES (#{teacher_id}, #{password}, #{phoneNumber}, #{subject}, #{email}, #{year}, #{professional})")
    int insertTeacherUsers(TempUsers tempUsers);

    @Select("select * from ai_student_users")
    List<StudentUsers> selectAllStudent();

    @Insert("insert into ai_student_identify (name, age, sex, phoneNumber, IDNumber) " +
            "VALUES (#{name}, #{age}, #{sex}, #{phoneNumber}, #{IDNumber})")
    int insertStudentIdentify(UsersIdentify usersIdentify);

    @Insert("insert into ai_student_identify (name, age, sex, phoneNumber, IDNumber)" +
            " VALUES (#{name}, #{age}, #{sex}, #{phoneNumber}, #{IDNumber})")
    int insertStudentsIdentify(TempUsers tempUsers);

    @Insert("insert into ai_teacher_identify (name, age, sex, phoneNumber, IDNumber) " +
            "VALUES (#{name}, #{age}, #{sex}, #{phoneNumber}, #{IDNumber})")
    int insertTeacherIdentify(UsersIdentify usersIdentify);

    @Insert("insert into ai_teacher_identify (name, age, sex, phoneNumber, IDNumber) " +
            "VALUES (#{name}, #{age}, #{sex}, #{phoneNumber}, #{IDNumber})")
    int insertTeachersIdentify(TempUsers tempUsers);

    @Insert("insert into ai_teacher_file (teacher_id, file_path)" +
            " values (#{teacher_id}, #{file_path})")
    int insertTeacherFile(String teacher_id, String file_path);

    @Insert("insert into ai_student_message (year, professional, classroom, student_id, name, age, sex, address)" +
            " VALUES (#{year}, #{professional}, #{classroom}, #{student_id}, #{name}, #{age}, #{sex}, #{address})")
    int insertStudentMessage(TempUsers tempUsers);

    @Insert("insert into ai_student_subject (student_id, subject, teacher_id) " +
            "VALUES (#{student_id}, #{subject}, #{teacher_id})")
    int insertStudentSubject(String student_id, String subject, String teacher_id);

    @Select("select * from ai_student_users where id = #{id}")
    StudentUsers selectByIdStudent(int id);

    @Select("select img from ai_student_users where student_id = #{student_id}")
    String selectImgStudent(String student_id);

    @Select("select * from ai_student_users where student_id = #{student_id}")
    StudentUsers selectByStudentId(String student_id);

    @Select("select id, username, classroom, phoneNumber, img, email, student_id, year, professional" +
            " from ai_student_users where student_id = #{student_id}")
    StudentUsers selectUserByStudentId(String student_id);

    @Select("select password from ai_student_users where student_id = #{student_id}")
    String selectStudentPasswordByStudentId(String student_id);

    @Select("select password from ai_student_users where phoneNumber = #{phoneNumber}")
    String selectStudentPasswordByPhoneNumber(String phoneNumber);

    @Select("select name, sex, age, phoneNumber from ai_student_identify " +
            "where phoneNumber = #{phoneNumber}")
    UsersIdentify selectStudentIdentify(String phoneNumber);

    @Select("select ai_student_users.student_id, ai_student_users.phoneNumber" +
            ", ai_student_identify.name," +
            " ai_student_identify.sex, ai_student_identify.age " +
            "from ai_student_users " +
            "inner join ai_student_identify " +
            "on ai_student_users.phoneNumber = ai_student_identify.phoneNumber " +
            "where ai_student_users.phoneNumber " +
            "in (select ai_student_users.phoneNumber from ai_student_users " +
            "where classroom = #{classroom})")
    List<UsersIdentify> selectClassroomStudentIdentify(String classroom);

    @Select("select ai_student_users.student_id, ai_student_users.phoneNumber" +
            ", ai_student_identify.name," +
            " ai_student_identify.sex, ai_student_identify.age " +
            "from ai_student_users " +
            "inner join ai_student_identify " +
            "on ai_student_users.phoneNumber = ai_student_identify.phoneNumber")
    List<UsersIdentify> selectAllStudentIdentify();

    @Insert("insert into ai_teacher_users (teacher_id, username, password) " +
            "VALUES (#{teacher_id}, #{userName}, #{password})")
    int insertTeacher(TeacherUsers teacherUsers);

    @Select("select id from ai_teacher_users where teacher_id = #{teacher_id}")
    int selectIdByTeacherId(String teacher_id);

    @Select("select * from ai_teacher_users")
    List<TeacherUsers> selectAllTeacher();

    @Select("select * from ai_teacher_users where teacher_id = #{Teacher_id}")
    TeacherUsers selectByTeacherId(String Teacher_id);

    @Select("select id, teacher_id, username, phoneNumber, img, subject, email, year, professional, account" +
            " from ai_teacher_users where teacher_id = #{teacher_id}")
    TeacherUsers selectByTeacherIdNoPassword(String Teacher_id);

    @Select("select password from ai_teacher_users where teacher_id = #{teacher_id}")
    String selectTeacherPasswordByTeacherId(String teacher_id);

    @Select("select password from ai_teacher_users where phoneNumber = #{phoneNumber}")
    String selectTeacherPasswordByPhoneNumber(String phoneNumber);

    @Select("select img from ai_teacher_users where teacher_id = #{teacher_id}")
    String selectImgTeacher(String Teacher_id);

    @Select("select * from ai_teacher_users where id = #{id}")
    TeacherUsers selectByIdTeacher(int id);

    @Select("select * from ai_teacher_users where account = #{account}")
    TeacherUsers selectAccount(String account);

    @Select("select * from ai_teacher_users where subject = #{subject}")
    List<TeacherUsers> selectTeacherBySubject(String subject);

    @Select("select * from ai_teacher_identify where phoneNumber = #{phoneNumber}")
    UsersIdentify selectTeacherIdentifyByPhoneNumber(String phoneNumber);

    @Select("select ai_teacher_users.teacher_id, ai_teacher_users.phoneNumber" +
            ", ai_teacher_identify.name," +
            " ai_teacher_identify.sex, ai_teacher_identify.age " +
            "from ai_teacher_users " +
            "inner join ai_teacher_identify " +
            "on ai_teacher_users.phoneNumber = ai_teacher_identify.phoneNumber")
    List<UsersIdentify> selectAllTeacherIdentify();

    @Select("select * from ai_teacher_identify where phoneNumber = " +
            "(select phoneNumber from ai_teacher_users where professional = #{professional})")
    List<UsersIdentify> selectProfessionalTeacherIdentify(String professional);

    @Select("select username from ai_manager")
    List<String> selectAllManager();

    @Select("select password from ai_manager where username = #{userName}")
    String selectManagerPasswordByUserName(String userName);

    @Select("select id from ai_student_users where year = #{year}")
    Integer[] selectStudentIdByYear(String year);

    @Select("select id from ai_student_users where year = #{year} and classroom = #{classroom}")
    Integer[] selectStudentIdByClassroom(String year, String classroom);

    @Select("select * from ai_student_message where year = #{college}")
    List<StudentMessage> selectStudentMessageByCollege(String college);

    @Select("select * from ai_student_message where year = #{year} and professional = #{professional}")
    List<StudentMessage> selectStudentMessageByProfessional(String year, String professional);

    @Select("select * from ai_student_message where year = #{college} and" +
            " classroom = #{classroom} and professional = #{professional}")
    List<StudentMessage> selectStudentMessageByClassroom(String college, String classroom, String professional);

    @Delete("delete from ai_student_users where student_id = #{student_id}")
    int deleteStudent(String student_id);

    @Delete("delete from ai_teacher_users where teacher_id = #{teacher_id}")
    int deleteTeacher(String teacher_id);

    @Delete("delete from ai_teacher_file where id = #{id}")
    int deleteTeacherFile(int id);

    @Delete("delete from ai_student_identify where phoneNumber = #{phoneNumber}")
    int deleteStudentIdentify(String phoneNumber);

    @Delete("delete from ai_Teacher_identify where phoneNumber = #{phoneNumber}")
    int deleteTeacherIdentify(String phoneNumber);

    @Delete("delete from ai_student_message where student_id = #{student_id}")
    int deleteStudentMessage(String student_id);

    @Delete("delete from ai_student_subject where student_id = #{student_id} and subject = #{subject}")
    int deleteStudentSubject(String student_id, String subject);

    @Update("update ai_student_users set username = #{userName}" +
            ", phoneNumber = #{phoneNumber}, email = #{email} where student_id = #{student_id}")
    int updateStudent(TempUsers studentUsers);

    @Update("update ai_student_users set username = #{username} where id = #{id}")
    int updateStudentUsername(int id, String username);

    @Update("update ai_student_users set student_id = #{student_id}, classroom = #{classroom}" +
            ", year = #{year}, email = #{email} where phoneNumber = #{phoneNumber}")
    int updateStudentMessage(TempUsers tempUsers);

    @Update("update ai_student_message set student_id = #{student_id} where id = #{id}")
    int updateStudent_id(int id, String student_id);

    @Update("update ai_student_users set password = #{password} where id = #{id}")
    int updateStudentPassword(int id, String password);

    @Update("update ai_student_users set img = #{img} where student_id = #{student_id}")
    int updateStudentImg(String student_id, String img);

    @Update("update ai_teacher_users set  username = #{userName}, password = #{password}, " +
            "phoneNumber = #{phoneNumber}, email = #{email} where teacher_id = #{teacher_id}")
    int updateTeacher(TempUsers teacherUsers);

    @Update("update ai_student_users set email = #{email} where student_id = #{student_id}")
    int updateStudentEmail(String student_id, String email);

    @Update("update ai_Teacher_users set username = #{username} where id = #{id}")
    int updateTeacherUsername(int id, String username);

    @Update("update ai_Teacher_users set Teacher_id = #{student_id} where id = #{id}")
    int updateTeacher_id(int id, String student_id);

    @Update("update ai_Teacher_users set password = #{password} where id = #{id}")
    int updateTeacherPassword(int id, String password);

    @Update("update ai_teacher_users set img = #{img} where teacher_id = #{teacher_id}")
    int updateTeacherImg(String teacher_id, String img);

    @Update("update ai_teacher_users set email = #{email} where teacher_id = #{teacher_id}")
    int updateTeacherEmail(String teacher_id, String email);

    @Update("update ai_student_users set student_id = #{student_id}, username = #{userName}" +
            ", password = #{password}, classroom = #{classroom}, phoneNumber = #{phoneNumber}" +
            ", email = #{email}, year = #{year}, professional = #{professional}" +
            " where student_id = #{student_id}")
    int updateStudentAll (StudentUsers studentUsers);

    @Update("update ai_student_users set year = #{year}, professional = #{professional}" +
            ", classroom = #{professional} where student_id = #{student_id}")
    int updateStudentClassroom (StudentUsers studentUsers);

    @Update("update ai_teacher_users set teacher_id = #{teacherId}, username = #{userName}" +
            ", password = #{password}, phoneNumber = #{phoneNumber}" +
            ", subject = #{subject}, email = #{email}, account = #{account}" +
            " where teacher_id = #{teacherId}")
    int updateTeacherAll (TeacherUsers teacherUsers);

    @Update("update ai_student_message set year = #{college}" +
            ", professional = #{professional}, classroom = #{classroom}, name = #{name}" +
            ", age = #{age}, sex = #{sex}, address = #{address} where student_id = #{student_id}")
    int updateStudentsMessage(StudentMessage tempUsers);

    @Select("select id from ai_student_users where phoneNumber = #{phoneNumber}")
    Integer selectIdByPhoneNumber(String phoneNumber);

    @Select("select * from ai_student_subject where student_id = #{student_id}")
    List<StudentSubject> selectSubjectByStudentId(String student_id);

    @Select("select * from ai_student_subject where teacher_id = #{teacher_id}")
    List<StudentSubject> selectSubjectIdByTeacherId(String teacher_id);

    @Select("select * from ai_student_message where student_id = #{student_id}")
    StudentMessage selectMessageByStudentId(String student_id);

    @Select("select * from ai_teacher_file where teacher_id = #{teacher_id} ")
    List<TeacherFile> selectFileByTeacherId(String teacher_id);

    @Select("select file_path from ai_teacher_file where id = #{id}")
    String selectFileById(int id);

    @Select("select * from ai_student_message")
    List<StudentMessage> selectAllStudentMessage();
}
