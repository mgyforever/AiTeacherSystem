package com.ccut.teachingaisystem.config;

import com.ccut.teachingaisystem.dao.LogDao;
import com.ccut.teachingaisystem.domain.log.OperationLog;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class OperationLogAspect {

    @Autowired
    private LogDao logDao;

    @Autowired
    private HttpServletRequest request;

    @Around("execution(* com.ccut.teachingaisystem.controller..*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        OperationLog logRecord = new OperationLog();

        // 获取请求信息
        logRecord.setRequestUri(request.getRequestURI());
        logRecord.setHttpMethod(request.getMethod());
        logRecord.setIpAddress(request.getRemoteAddr());
        logRecord.setUserAgent(request.getHeader("User-Agent"));
        logRecord.setOperationTime(LocalDateTime.now());

        // 类和方法信息
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logRecord.setClassName(signature.getDeclaringTypeName());
        logRecord.setMethodName(signature.getName());

        // 请求参数
        Object[] args = joinPoint.getArgs();
        try {
            logRecord.setRequestParams(new ObjectMapper().writeValueAsString(args));
        } catch (Exception e) {
            logRecord.setRequestParams("参数解析失败");
        }

        Object result = null;
        try {
            result = joinPoint.proceed(); // 执行原方法
            logRecord.setSuccess(true);
            logRecord.setStatusCode(HttpServletResponse.SC_OK);
            logRecord.setResponseData(new ObjectMapper()
                    .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                    .writeValueAsString(result));
        } catch (Exception e) {
            logRecord.setSuccess(false);
            logRecord.setStatusCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logRecord.setExceptionName(e.getClass().getName());
            logRecord.setExceptionMsg(e.getMessage());
            throw e; // 不吞异常
        } finally {
            long elapsed = System.currentTimeMillis() - startTime;
            logRecord.setExecutionTimeMs(elapsed);
            logDao.insertOperationLog(logRecord);
        }

        return result;
    }
}


