package com.ccut.teachingaisystem.controller;

import com.alibaba.excel.EasyExcel;
import com.ccut.teachingaisystem.dao.LogDao;
import com.ccut.teachingaisystem.domain.log.OperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class TableController {

    @Value("${file.log-dir}")
    private String logDir;

    @Autowired
    private LogDao logDao;
    private final JdbcTemplate jdbcTemplate;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public TableController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Scheduled(cron = "0 0 0 31 12 ?")
    public void clearAi_previous_question() {
        jdbcTemplate.execute("TRUNCATE TABLE ai_previous_question;");
        jdbcTemplate.execute("TRUNCATE TABLE ai_blank_previous_question;");
        jdbcTemplate.execute("TRUNCATE TABLE ai_test_student;");
        System.out.println("Table cleared at: " + System.currentTimeMillis());
    }

    // 每30天执行一次，测试可以改为每天（"0 0 0 * * ?" 表示每天0点）
    @Scheduled(cron = "0 0 0 1 */1 ?") // 每月1号0点执行
    public void archiveOldLogs() {
        List<OperationLog> oldLogs = logDao.selectOperationLog();
        if (oldLogs.isEmpty()) {
            System.out.println("无旧日志需要归档。");
            return;
        }

        // 构建文件名
        String basePath = System.getProperty("user.dir") + File.separator;
        String archiveDate = FORMATTER.format(LocalDateTime.now());
        String fileName = "operation_log_archive_" + archiveDate + ".xlsx";
        String path = basePath + logDir + fileName;

        // 写入 Excel 文件
        try {
            EasyExcel.write(path, OperationLog.class)
                    .sheet("归档日志")
                    .doWrite(oldLogs);
            System.out.println("已成功归档日志至：" + path);
        } catch (Exception e) {
            System.err.println("归档失败：" + e.getMessage());
            return;
        }

        jdbcTemplate.execute("TRUNCATE TABLE operation_log;");
    }
}
