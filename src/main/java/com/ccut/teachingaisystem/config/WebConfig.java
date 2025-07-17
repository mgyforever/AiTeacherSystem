package com.ccut.teachingaisystem.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${file.upload-dir}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/teacher_files/**")
                .addResourceLocations("file:D:/java/code/idea program/TeachingAISystem/src/main/java/com/ccut/teachingaisystem/download/file/teacher/")
                .setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS)); // 添加缓存控制‌:ml-citation{ref="6,7" data="citationList"}
    }
}
