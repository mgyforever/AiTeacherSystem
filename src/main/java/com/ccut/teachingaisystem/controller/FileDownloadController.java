package com.ccut.teachingaisystem.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FileDownloadController {

    @Value("${file.teacher-dir}")
    private String teacherFileUploadDir;

    /**
     * 访问示例：
     *   GET /teacher_files/1%E6%96%B0%E5%BB%BA%20Microsoft%20Excel%20%E5%B7%A5%E4%BD%9C%E8%A1%A8.xlsx
     */
    @GetMapping("/teacher_files/{fullName:.+}")
    public ResponseEntity<Resource> download(@PathVariable String fullName) throws IOException {

        String basePath = System.getProperty("user.dir") + File.separator;
        Path filePath = Paths.get(basePath, teacherFileUploadDir);

        // fullName = "1新建 Microsoft Excel 工作表.xlsx"
        Path file = filePath.resolve(fullName).normalize();
        if (!Files.exists(file)) {
            return ResponseEntity.notFound().build();
        }

        Resource res = new UrlResource(file.toUri());
        MediaType mt = MediaTypeFactory.getMediaType(res)
                .orElse(MediaType.APPLICATION_OCTET_STREAM);

        return ResponseEntity.ok()
                .contentType(mt)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename*=UTF-8''" +
                                URLEncoder.encode(file.getFileName().toString(), StandardCharsets.UTF_8))
                .body(res);
    }
}


