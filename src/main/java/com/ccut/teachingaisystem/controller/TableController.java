package com.ccut.teachingaisystem.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TableController {
    private final JdbcTemplate jdbcTemplate;

    public TableController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 每周日凌晨 0 点执行
    @Scheduled(cron = "0 0 0 * * 0")
    public void clearAi_test_student() {
        jdbcTemplate.execute("TRUNCATE TABLE ai_test_student;");
        System.out.println("Table cleared at: " + System.currentTimeMillis());
    }

    @Scheduled(cron = "0 0 0 31 12 ?")
    public void clearAi_previous_question() {
        jdbcTemplate.execute("TRUNCATE TABLE ai_previous_question;");
        jdbcTemplate.execute("TRUNCATE TABLE ai_blank_previous_question;");
        System.out.println("Table cleared at: " + System.currentTimeMillis());
    }
}
