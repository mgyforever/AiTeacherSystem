package com.ccut.teachingaisystem.controller.exceptions;

import com.ccut.teachingaisystem.controller.Code;
import com.ccut.teachingaisystem.controller.Result;
import com.ccut.teachingaisystem.exception.BusinessException;
import com.ccut.teachingaisystem.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(SystemException.class)
    public Result handleSystemException(SystemException e) {
        return new Result(Code.SYSTEM_ERR, e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result handleBusinessException(BusinessException e) {
        return new Result(Code.BUSINESS_ERR, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public void handleException(Exception ex) {
        System.out.println("未知异常!" + ex.getMessage() + ex.getCause());
    }
}
