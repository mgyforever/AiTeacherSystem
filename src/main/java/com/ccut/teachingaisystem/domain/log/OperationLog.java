package com.ccut.teachingaisystem.domain.log;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@SuppressWarnings("LombokSetterMayBeUsed")
@Data
public class OperationLog {
    @ExcelProperty("IP地址")
    private String ipAddress;

    @ExcelProperty("User-Agent")
    private String userAgent;

    @ExcelProperty("请求路径")
    private String requestUri;

    @ExcelProperty("请求方法")
    private String httpMethod;

    @ExcelProperty("类名")
    private String className;

    @ExcelProperty("方法名")
    private String methodName;

    @ExcelProperty("请求参数")
    private String requestParams;

    @ExcelProperty("响应数据")
    private String responseData;

    @ExcelProperty("状态码")
    private Integer statusCode;

    @ExcelProperty("是否成功")
    private Boolean success;

    @ExcelProperty("异常名称")
    private String exceptionName;

    @ExcelProperty("异常信息")
    private String exceptionMsg;

    @ExcelProperty("执行时间(ms)")
    private Long executionTimeMs;

    @ExcelProperty("操作时间")
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

