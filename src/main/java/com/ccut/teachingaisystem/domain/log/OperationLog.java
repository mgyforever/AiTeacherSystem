package com.ccut.teachingaisystem.domain.log;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
public class OperationLog {
    private String ipAddress;
    private String userAgent;
    private String requestUri;
    private String httpMethod;
    private String className;
    private String methodName;
    private String requestParams;
    private String responseData;
    private Integer statusCode;
    private Boolean success;
    private String exceptionName;
    private String exceptionMsg;
    private Long executionTimeMs;
    private LocalDateTime operationTime;

    public OperationLog() {
    }

    public OperationLog(String ipAddress
            , String userAgent, String requestUri, String httpMethod, String className
            , String methodName, String requestParams, String responseData, Integer statusCode
            , Boolean success, String exceptionName, String exceptionMsg, Long executionTimeMs
            , LocalDateTime operationTime) {
        this.ipAddress = ipAddress;
        this.userAgent = userAgent;
        this.requestUri = requestUri;
        this.httpMethod = httpMethod;
        this.className = className;
        this.methodName = methodName;
        this.requestParams = requestParams;
        this.responseData = responseData;
        this.statusCode = statusCode;
        this.success = success;
        this.exceptionName = exceptionName;
        this.exceptionMsg = exceptionMsg;
        this.executionTimeMs = executionTimeMs;
        this.operationTime = operationTime;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public void setExecutionTimeMs(Long executionTimeMs) {
        this.executionTimeMs = executionTimeMs;
    }

    public void setOperationTime(LocalDateTime operationTime) {
        this.operationTime = operationTime;
    }
}

