package com.ccut.teachingaisystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
public class TeachingAiSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeachingAiSystemApplication.class, args);
    }

}
