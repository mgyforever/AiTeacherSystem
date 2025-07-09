package com.ccut.teachingaisystem.controller;

import com.ccut.teachingaisystem.service.usersService.StudentService;
import com.ccut.teachingaisystem.service.usersService.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/images")
public class ImagesController {

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
        Path file = Paths.get("D:\\java\\code\\idea program\\TeachingAISystem\\src\\" +
                "main\\java\\com\\ccut\\teachingaisystem\\download\\usersimage").resolve(fileName);
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
