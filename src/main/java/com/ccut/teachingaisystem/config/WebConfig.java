package com.ccut.teachingaisystem.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${file.teacher-dir}")
    private String teacherFileUploadDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String basePath = System.getProperty("user.dir") + File.separator;
        String filePath = String.valueOf(Paths.get(basePath, teacherFileUploadDir));
        registry.addResourceHandler("/teacher_files/**")
                .addResourceLocations("file:" + filePath + File.separator)
                .setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS)); // 添加缓存控制‌:ml-citation{ref="6,7" data="citationList"}
    }
}
