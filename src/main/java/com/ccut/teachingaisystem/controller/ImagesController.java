package com.ccut.teachingaisystem.controller;

import com.ccut.teachingaisystem.service.usersService.StudentService;
import com.ccut.teachingaisystem.service.usersService.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/images")
public class ImagesController {

    @Value("${file.teacher-dir}")
    private String imageFileUploadDir;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/getUserImages")
    public ResponseEntity<UrlResource> getImage(@RequestParam("userId") String userId
            , @RequestParam("judge") int judge) throws MalformedURLException {
        String fileName;
        if (judge == 1) {
            fileName = studentService.selectImage(userId);
        } else {
            fileName = teacherService.selectImage(userId);
        }
        String basePath = System.getProperty("user.dir") + File.separator;
        Path file = Paths.get(basePath, imageFileUploadDir).resolve(fileName);
        UrlResource urlResource = new UrlResource(file.toUri());

        if (urlResource.exists()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(urlResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}