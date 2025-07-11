package com.ccut.teachingaisystem.controller.users;

import com.ccut.teachingaisystem.controller.Code;
import com.ccut.teachingaisystem.controller.Result;
import com.ccut.teachingaisystem.dao.users.UsersDao;
import com.ccut.teachingaisystem.domain.users.*;
import com.ccut.teachingaisystem.service.usersService.ManagerService;
import com.ccut.teachingaisystem.service.usersService.StudentService;
import com.ccut.teachingaisystem.service.usersService.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * Users
 */


@SuppressWarnings("ALL")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private ManagerService managerService;

    @PostMapping("/register")
    public Result register(@RequestBody StudentUsers studentUsers) {
        try {
            return studentService.insertStudent(studentUsers)
                    ? new Result(Code.POST_OK, "注册成功!") :
                    new Result(Code.POST_ERR, "注册失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    @PostMapping("/registerIdentify")
    public Result registerIdentify(@RequestBody UsersIdentify identify) {
        if (identify.getJudge() == 1) {
            return studentService.insertStudentIdentify(identify)
                    ? new Result(Code.POST_OK, "注册成功!") :
                    new Result(Code.POST_ERR, "账户已存在!");
        } else if (identify.getJudge() == 2) {
            return teacherService.insertTeacherIdentify(identify)
                    ? new Result(Code.POST_OK, "注册成功!") :
                    new Result(Code.POST_ERR, "账户已存在!");
        } else {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 登录
     * stduent_id
     * password
     *
     * @return
     * @body user
     */
    @PostMapping("/login")
    public Result login(@RequestBody TempUsers user) {
        try {
            if (user.getJudge() == 1) {
                return studentService.selectPassword(user.getStudent_id()).equals(user.getPassword())
                        ? new Result(Code.POST_OK, "登陆成功!") :
                        new Result(Code.POST_ERR, "登陆失败!");
            } else if (user.getJudge() == 2) {
                return teacherService.selectPassword(user.getTeacher_id()).equals(user.getPassword())
                        ? new Result(Code.POST_OK, "登陆成功!") :
                        new Result(Code.POST_ERR, "登录失败!");
            } else {
                return new Result(Code.POST_ERR, "未知错误!");
            }
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 登录
     * phoneNumber
     * password
     *
     * @return
     * @body user
     */
    @PostMapping("/loginByPhoneNumber")
    public Result loginByPhoneNumber(@RequestBody TempUsers user) {
        try {
            if (user.getJudge() == 1) {
                return studentService.selectPasswordByPhoneNumber(user.getPhoneNumber()).equals(user.getPassword())
                        ? new Result(Code.POST_OK, "登录成功!") : new Result(Code.POST_ERR, "登陆失败!");
            } else if (user.getJudge() == 2) {
                return teacherService.selectPasswordByPhoneNumber(user.getPassword()).equals(user.getPassword())
                        ? new Result(Code.POST_OK, "登录成功!") : new Result(Code.POST_ERR, "登陆失败!");
            } else {
                return new Result(Code.POST_ERR, "未知错误!");
            }
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * Manage登录
     * userName
     * password
     *
     * @return
     * @body managers
     */
    @PostMapping("/managerLogin")
    public Result managerLogin(@RequestBody Managers managers) {
        try {
            return managerService.getPassword(managers)
                    ? new Result(Code.POST_OK, "登录成功!") :
                    new Result(Code.POST_ERR, "登录失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 外部录入学生信息
     * excel文件
     * student_id, name, sex, age, password, phoneNumber,
     * email, year, professional, classroom ,address, IDNumber
     *
     * @param file
     * @return
     */
    @PostMapping("/insertMessageStudent")
    public Result insertStudentMessage(@RequestParam MultipartFile file) {
        try {
            return studentService.insertStudentMessage(file)
                    ? new Result(Code.POST_OK, "添加成功!") :
                    new Result(Code.POST_ERR, "添加失败!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 学生选课
     * student_id
     * subject
     * teacher_id
     *
     * @return
     * @body studentSubject
     */
    @PostMapping("/choiceSubject")
    public Result choiceSubject(@RequestBody StudentSubject studentSubject) {
        try {
            return studentService.insertStudentSubject(studentSubject)
                    ? new Result(Code.POST_OK, "添加成功!") :
                    new Result(Code.POST_ERR, "添加失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 下载文件
     * judge: 1为学生， 2为老师
     *
     * @param file
     * @param judge
     * @param userId
     * @return
     * @throws IOException
     */
    @PostMapping("/downLoad")
    public Result downLoad(@RequestParam("file") MultipartFile file
            , @RequestParam("judge") int judge
            , @RequestParam("userId") String userId) throws IOException {
        BufferedImage image = ImageIO.read(file.getInputStream());
        if (!file.isEmpty() && image != null) {
            if (judge == 1) {
                return studentService.updateImage(userId, file)
                        ? new Result(Code.POST_OK, "图片保存成功!") :
                        new Result(Code.POST_ERR, "图片保存失败!");
            } else if (judge == 2) {
                return teacherService.updateImage(userId, file)
                        ? new Result(Code.POST_OK, "图片保存成功!") :
                        new Result(Code.POST_ERR, "图片保存失败!");
            }
        } else if (!file.isEmpty() && image == null && judge == 2) {
            return teacherService.insertTeacherFile(userId, file)
                    ? new Result(Code.POST_OK, "文件保存成功!") :
                    new Result(Code.POST_ERR, "文件保存失败!");
        }
        return new Result(Code.POST_ERR, "保存失败!(else)");
    }

    /**
     * 查询文件
     * judge同上
     *
     * @param userId
     * @param judge
     * @return
     */
    @GetMapping("/upload")
    public Result upload(@RequestParam("userId") String userId
            , @RequestParam("judge") int judge) {
        Map<String, String> map = new HashMap<>();
        if (judge == 1) {
            return studentService.selectImage(userId) != null ? new Result(Code.GET_OK,
                    map.put("file", studentService.selectImage(userId)), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } else if (judge == 2) {
            return teacherService.selectImage(userId) != null ? new Result(Code.GET_OK,
                    map.put("file", teacherService.selectImage(userId)), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        }
        return new Result(Code.GET_ERR, "网络错误!");
    }

    /**
     * 录入studentMessage信息, 与/insertMessageStudent一起被调用
     *
     * @param file
     * @return
     */
    @PostMapping("/insertStudentsMessage")
    public Result InsertUsersMessage(@RequestBody MultipartFile file) {
        try {
            return studentService.insertStudentMessage(file)
                    ? new Result(Code.POST_OK, "添加成功!") :
                    new Result(Code.POST_ERR, "添加失败!");
        } catch (Exception e) {
            return new Result(Code.GET_ERR, "网络错误!");
        }
    }

    /**
     * 录入老师信息
     * excel文件
     * teacher_id, name, sex, age, phoneNumber, email, subuject, year, professional, address,
     *
     * @param file
     * @return
     */
    @PostMapping("/insertTeachersMessage")
    public Result InsertTeachersMessage(@RequestBody MultipartFile file) {
        try {
            return teacherService.insertTeacherMessage(file)
                    ? new Result(Code.POST_OK, "添加成功!") :
                    new Result(Code.POST_ERR, "添加失败!");
        } catch (Exception e) {
            return new Result(Code.GET_ERR, "网络错误!");
        }
    }

    /**
     * 删除学生基本信息
     *
     * @param student_id
     * @return
     */
    @GetMapping("/deleteStudentMessage")
    public Result deleteStudentMessage(@RequestParam("student_id") String student_id) {
        try {
            return studentService.deleteStudentMessage(student_id)
                    ? new Result(Code.POST_OK, "删除成功!") :
                    new Result(Code.POST_ERR, "删除失败!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Result(Code.GET_ERR, "网络错误!");
        }
    }

    /**
     * 学生退课
     *
     * @param student_id
     * @param subject
     * @return
     */
    @GetMapping("/deleteStudentSubject")
    public Result deleteStudentSubject(@RequestParam("student_id") String student_id
            , @RequestParam("subject") String subject) {
        try {
            return studentService.deleteStudentSubject(student_id, subject)
                    ? new Result(Code.GET_OK, "删除成功!") :
                    new Result(Code.GET_ERR, "删除失败!");
        } catch (Exception e) {
            return new Result(Code.GET_ERR, "网络错误!");
        }
    }

    /**
     * 查询学生选择的课程
     *
     * @param student_id
     * @return
     */
    @GetMapping("getStudentSubject")
    public Result getStudentSubject(@RequestParam("student_id") String student_id) {
        try {
            return studentService.selectSubjectByStudentId(student_id) != null ? new Result(Code.GET_OK
                    , studentService.selectSubjectByStudentId(student_id), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.GET_ERR, "网络错误!");
        }
    }

    /**
     * 查找选择某个老师的学生信息
     *
     * @param teacher_id
     * @return
     */
    @GetMapping("/getTeacherSubjectNum")
    public Result getTeacherSubjectNum(@RequestParam("teacher_id") String teacher_id) {
        try {
            return teacherService.selectSubjectIdByTeacherId(teacher_id) != null ? new Result(Code.GET_OK
                    , teacherService.selectSubjectIdByTeacherId(teacher_id), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.GET_ERR, "网络错误!");
        }
    }

    /**
     * 查询全部老师或学生的基本信息
     *
     * @param judge
     * @return
     */
    @GetMapping("/getAll")
    public Result selectAll(@RequestParam("judge") int judge) {
        try {
            if (judge == 1) {
                return studentService.selectAll() != null
                        ? new Result(Code.GET_OK, studentService.selectAll(), "查询成功!")
                        : new Result(Code.GET_ERR, "查无此人!");
            } else if (judge == 2) {
                return teacherService.selectAll() != null
                        ? new Result(Code.GET_OK, teacherService.selectAll(), "查询成功!")
                        : new Result(Code.GET_ERR, "查无此人!");
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Result(Code.GET_ERR, "网络错误!");
        }
    }

    /**
     * 查找某个老师或学生的账号信息
     *
     * @param userId
     * @param judge
     * @return
     */
    @GetMapping("/getByUserId")
    public Result getByID(@RequestParam("userId") String userId
            , @RequestParam("judge") int judge) {
        if (judge == 1) {
            return studentService.selectByStudentId(userId) != null ? new Result(Code.GET_OK,
                    studentService.selectByStudentId(userId), "查询成功!")
                    : new Result(Code.GET_ERR, "查无此人!");
        } else if (judge == 2) {
            return teacherService.selectByTeacherId(userId) != null ? new Result(Code.GET_OK,
                    teacherService.selectByTeacherId(userId), "查询成功!")
                    : new Result(Code.GET_ERR, "查无此人!");
        } else {
            return new Result(Code.GET_ERR, "网络错误!");
        }
    }

    /**
     * 查找某学科所有老师
     *
     * @param subject
     * @return
     */
    @GetMapping("/getTeachersBySubject")
    public Result getTeachersBySubject(@RequestParam("subject") String subject) {
        try {
            return teacherService.selectAllTeacherBySubject(subject) != null ?
                    new Result(Code.GET_OK, teacherService.selectAllTeacherBySubject(subject)
                            , "查询成功!") : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.GET_ERR, "网络错误!");
        }
    }

    /**
     * 查账某老师或学生的个人信息
     *
     * @param judge
     * @param userId
     * @return
     */
    @GetMapping("/getUsersIdentify")
    public Result getStudentIdentify(@RequestParam("judge") int judge
            , @RequestParam("userId") String userId) {
        if (judge == 1) {
            return teacherService.selectIdentifyByStudentId(userId) != null ?
                    new Result(Code.GET_OK, teacherService.selectIdentifyByStudentId(userId)
                            , "查询成功!") : new Result(Code.GET_ERR, "查无此人!");
        } else if (judge == 2) {
            return teacherService.selectIdentifyByTeacherId(userId) != null ?
                    new Result(Code.GET_OK, teacherService.selectIdentifyByTeacherId(userId)
                            , "查询成功!") : new Result(Code.GET_ERR, "查无此人!");
        } else {
            return new Result(Code.GET_ERR, "网络错误!");
        }
    }

    /**
     * 查找所有老师或学生的个人信息
     *
     * @param judge
     * @return
     */
    @GetMapping("/getAllIdentify")
    public Result selectAllIdentify(@RequestParam("judge") int judge) {
        if (judge == 1) {
            return teacherService.selectAllStudentIdentify() != null ? new Result(Code.GET_OK,
                    teacherService.selectAllStudentIdentify(), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } else if (judge == 2) {
            return teacherService.selectAllTeacherIdentify() != null ? new Result(Code.GET_OK,
                    teacherService.selectAllTeacherIdentify(), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } else {
            return new Result(Code.GET_ERR, "网络错误!");
        }
    }

    /**
     * 查找某个专业老师的个人信息
     *
     * @param judge
     * @param professional
     * @return
     */
    @GetMapping("/getClassroomIdentify")
    public Result selectAllClassroomIdentify(@RequestParam("judge") int judge
            , @RequestParam("professional") String professional) {
        if (judge == 1) {
            return teacherService.selectClassroomStudentIdentify(professional) != null ?
                    new Result(Code.GET_OK, teacherService.selectClassroomStudentIdentify(professional)
                            , "查询成功!") : new Result(Code.GET_ERR, "查询失败!");
        } else if (judge == 2) {
            return teacherService.selectClassroomTeacherIdentify(professional) != null ?
                    new Result(Code.GET_OK, teacherService.selectClassroomTeacherIdentify(professional)
                            , "查询成功!") : new Result(Code.GET_ERR, "查询失败!");
        } else {
            return new Result(Code.GET_ERR, "网络错误!");
        }
    }

    /**
     * 获取全部导入的学生信息
     *
     * @return
     */
    @PostMapping("/getAllStudentMessage")
    public Result selectAllStudentMessage() {
        try {
            return studentService.selectAllStudentMessage() != null ? new Result(Code.POST_OK
                    , studentService.selectAllStudentMessage(), "查询成功!")
                    : new Result(Code.POST_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 弃用
     *
     * @param year
     * @return
     */
    @GetMapping("/getStudentMessageByYear")
    public Result getStudentMessageByYear(@RequestParam("year") String year) {
        try {
            return studentService.selectMessageByCollege(year) != null ? new Result(Code.GET_OK
                    , studentService.selectMessageByCollege(year), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 弃用
     *
     * @param year
     * @param prof
     * @return
     */
    @GetMapping("/getStudentMessageByProfessional")
    public Result getStudentMessageByProfessional(@RequestParam("year") String year
            , @RequestParam("professional") String prof) {
        try {
            return studentService.selectMessageByProfessional(year, prof) != null ? new Result(Code.GET_OK
                    , studentService.selectMessageByProfessional(year, prof), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 弃用
     *
     * @param year
     * @param prof
     * @param classroom
     * @return
     */
    @GetMapping("/getStudentMessageByClassroom")
    public Result getStudentMessageByClassroom(@RequestParam("year") String year
            , @RequestParam("professional") String prof, @RequestParam("classroom") String classroom) {
        try {
            return studentService.selectMessageByClassroom(year, prof, classroom) != null ? new Result(Code.GET_OK
                    , studentService.selectMessageByClassroom(year, prof, classroom), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 获取老师的文件
     *
     * @param teacherId
     * @param fileName
     * @return
     * @throws UnknownHostException
     */
    @GetMapping("/getFileUrl")
    public Result getFileUrl(@RequestParam("teacherId") String teacherId,
                             @RequestParam("fileName") String fileName) throws UnknownHostException {
        try {
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            String fullName = teacherId + fileName;
            return new Result(Code.GET_OK, ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .host(hostAddress)
                    .port(83)
                    .pathSegment("teacher_files", fullName) // 自动在两个片段之间补 /
                    .toUriString(), "查询成功!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 获取老师文件名字
     *
     * @param teacher_id
     * @return
     */
    @GetMapping("/getTeacherFileName")
    public Result getFileName(@RequestParam("teacher_id") String teacher_id) {
        try {
            return teacherService.getTeacherAllFilesName(teacher_id) != null ? new Result(Code.GET_OK
                    , teacherService.getTeacherAllFilesName(teacher_id), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 删除老师上传的文件
     *
     * @param id
     * @return
     */
    @GetMapping("/deleteTeacherFile")
    public Result deleteTeacherFile(@RequestParam("id") int id) {
        return teacherService.deleteTeacherFile(id)
                ? new Result(Code.GET_OK, "删除成功!") :
                new Result(Code.GET_ERR, "删除失败!");
    }

    /**
     * 删除某个学生或老师的账号管理用
     *
     * @param user_id
     * @param judge
     * @return
     */
    @PostMapping("/delete")
    public Result delete(@RequestParam("user_id") String user_id
            , @RequestParam("judge") int judge) {
        if (judge == 1) {
            return studentService.delete(user_id)
                    ? new Result(Code.POST_OK, "删除成功!") :
                    new Result(Code.POST_ERR, "删除失败!");
        } else if (judge == 2) {
            return teacherService.delete(user_id)
                    ? new Result(Code.POST_OK, "删除成功!") :
                    new Result(Code.POST_ERR, "删除失败!");
        } else {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 删除某个学生或老师的个人信息
     *
     * @param user_id
     * @param judge
     * @return
     */
    @GetMapping("/deleteIdentify")
    public Result deleteIdentify(@RequestParam("user_id") String user_id
            , @RequestParam("judge") int judge) {
        if (judge == 1) {
            return studentService.deleteStudentIdentify(user_id)
                    ? new Result(Code.GET_OK, "删除成功!") :
                    new Result(Code.GET_ERR, "删除失败!");
        } else if (judge == 2) {
            return teacherService.deleteTeacherIdentify(user_id)
                    ? new Result(Code.GET_OK, "删除成功!") :
                    new Result(Code.GET_ERR, "删除失败!");
        } else {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 弃用
     *
     * @param id
     * @param user_id
     * @param judge
     * @return
     */
    @PostMapping("/updateUser_id")
    public Result update(@RequestParam("id") int id, @RequestParam("user_id") String user_id
            , @RequestParam("judge") int judge) {
        if (judge == 1) {
            return studentService.updateStudent_id(id, user_id)
                    ? new Result(Code.POST_OK, "修改成功!") :
                    new Result(Code.POST_ERR, "修改失败!");
        } else if (judge == 2) {
            return teacherService.updateTeacher_id(id, user_id)
                    ? new Result(Code.POST_OK, "修改成功!") :
                    new Result(Code.POST_ERR, "修改失败!");
        } else {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 修改用户账号信息
     * userName, phoneNumber, email
     *
     * @param users
     * @return
     */
    @PostMapping("/updateUsers")
    public Result update(@RequestBody TempUsers users) {
        if (users.getId() == 1) {
            return studentService.updateStudentUsers(users)
                    ? new Result(Code.POST_OK, "修改成功!") :
                    new Result(Code.POST_ERR, "修改失败!");
        } else if (users.getId() == 2) {
            return teacherService.updateTeacherUsers(users)
                    ? new Result(Code.POST_OK, "修改成功!") :
                    new Result(Code.POST_ERR, "修改失败!");
        } else {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 修改某个学生或老师的昵称
     *
     * @param id
     * @param username
     * @param judge
     * @return
     */
    @PostMapping("/updateUsername")
    public Result updateUsername(@RequestParam("id") int id
            , @RequestParam("username") String username
            , @RequestParam("judge") int judge) {
        if (judge == 1) {
            return studentService.updateStudentUsername(id, username)
                    ? new Result(Code.POST_OK, "修改成功!") :
                    new Result(Code.POST_ERR, "修改失败!");
        } else if (judge == 2) {
            return teacherService.updateTeacherUsername(id, username)
                    ? new Result(Code.POST_OK, "修改成功!") :
                    new Result(Code.POST_ERR, "修改失败!");
        } else {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 修改某个老师或学生的密码管理用
     *
     * @param id
     * @param Password
     * @param judge
     * @return
     */
    @PostMapping("/updatePassword")
    public Result updatePassword(@RequestParam("id") int id
            , @RequestParam("password") String Password
            , @RequestParam("judge") int judge) {
        if (judge == 1) {
            return studentService.updateStudentPassword(id, Password)
                    ? new Result(Code.POST_OK, "修改成功!") :
                    new Result(Code.POST_ERR, "修改失败!");
        } else if (judge == 2) {
            return teacherService.updateTeacherPassword(id, Password)
                    ? new Result(Code.POST_OK, "修改成功!") :
                    new Result(Code.POST_ERR, "修改失败!");
        } else {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 修改某个老师或学生的个人信息
     *
     * @param usersIdentify
     * @return
     */
    @PostMapping("/updateUserIdentify")
    public Result updateUserIdentify(@RequestBody UsersIdentify usersIdentify) {
        if (usersIdentify.getJudge() == 1) {
            return studentService.updateStudentIdentify(usersIdentify)
                    ? new Result(Code.POST_OK, "修改成功!") :
                    new Result(Code.POST_ERR, "修改失败!");
        } else if (usersIdentify.getJudge() == 2) {
            return teacherService.updateTeacherIdentify(usersIdentify)
                    ? new Result(Code.POST_OK, "修改成功!") :
                    new Result(Code.POST_ERR, "修改失败!");
        } else {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 弃用
     *
     * @param userId
     * @param judge
     * @return
     */
    @PostMapping("/updateUserEmail")
    public Result updateUserEmail(@RequestParam("userId") String userId
            , @RequestParam("judge") int judge, @RequestParam("email") String email) {
        if (judge == 1) {
            return studentService.updateEmail(userId, email)
                    ? new Result(Code.POST_OK, "修改成功!") :
                    new Result(Code.POST_ERR, "修改失败!");
        } else if (judge == 2) {
            return teacherService.updateEmail(userId, email)
                    ? new Result(Code.POST_OK, "修改成功!") :
                    new Result(Code.POST_ERR, "修改失败!");
        } else {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 修改某个老师或学生的头像
     *
     * @param userId
     * @param file
     * @param judge
     * @return
     */
    @PostMapping("/updateUserFile")
    public Result updateUserImage(@RequestParam("userId") String userId
            , @RequestParam("file") MultipartFile file
            , @RequestParam("judge") int judge) {
        if (judge == 1) {
            return studentService.updateImage(userId, file)
                    ? new Result(Code.POST_OK, "修改成功!") :
                    new Result(Code.POST_ERR, "修改失败!");
        } else if (judge == 2) {
            return teacherService.updateImage(userId, file)
                    ? new Result(Code.POST_OK, "修改成功!") :
                    new Result(Code.POST_ERR, "修改失败!");
        } else {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 弃用
     *
     * @return
     * @body tempUsers
     */
    @PostMapping("/drop1")
    public Result updateUsers(@RequestBody TempUsers tempUsers) {
        try {
            if (tempUsers.getJudge() == 1) {
                StudentUsers studentUsers = studentService.selectByStudentId(tempUsers.getStudent_id());
                studentUsers.setUserName(tempUsers.getUserName());
                studentUsers.setPassword(tempUsers.getPassword());
                studentUsers.setAccount(tempUsers.getAccount());
                studentUsers.setEmail(tempUsers.getEmail());
                studentUsers.setClassroom(tempUsers.getClassroom());
                studentUsers.setPhoneNumber(tempUsers.getPhoneNumber());
                return studentService.updateStudent(studentUsers)
                        ? new Result(Code.GET_OK, "修改成功!") :
                        new Result(Code.GET_ERR, "修改失败!");
            } else if (tempUsers.getJudge() == 2) {
                TeacherUsers teacherUsers = usersDao.selectByTeacherId(tempUsers.getTeacher_id());
                teacherUsers.setUserName(tempUsers.getUserName());
                teacherUsers.setPassword(tempUsers.getPassword());
                teacherUsers.setAccount(tempUsers.getAccount());
                teacherUsers.setEmail(tempUsers.getEmail());
                teacherUsers.setClassroom(tempUsers.getClassroom());
                teacherUsers.setPhoneNumber(tempUsers.getPhoneNumber());
                teacherUsers.setSubject(tempUsers.getSubject());
                return teacherService.updateTeacher(teacherUsers)
                        ? new Result(Code.GET_OK, "修改成功!") :
                        new Result(Code.GET_ERR, "修改失败!");
            } else {
                return new Result(Code.POST_ERR, "网络错误!");
            }
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 修改某个学生的基本信息(管理用)
     * year, professional, classroom, student_id, name, age, sex, address
     *
     * @return
     * @body studentMessage
     */
    @PostMapping("/updateStudentMessage")
    public Result updateStudentMessage(@RequestBody StudentMessage studentMessage) {
        try {
            return studentService.updateStudentMessage(studentMessage)
                    ? new Result(Code.POST_OK, "修改成功!") :
                    new Result(Code.POST_ERR, "修改成功!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }

    /**
     * 查询日志
     *
     * @return
     */
    @GetMapping("/getLog")
    public Result getLog() {
        try {
            return managerService.getAllOperationLog() != null ? new Result(Code.GET_OK
                    , managerService.getAllOperationLog(), "查询成功!")
                    : new Result(Code.GET_ERR, "查询失败!");
        } catch (Exception e) {
            return new Result(Code.POST_ERR, "网络错误!");
        }
    }
}