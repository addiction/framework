package com.zws.demo.web.controller;

import com.zws.core.support.SecurityEnum;
import com.zws.core.support.SimpleResponse;
import com.zws.core.validate.ValidateCodeException;
import com.zws.demo.web.validate.ValidateException;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @author zws
 * @email 2848392861@qq.com
 * date 2018/9/28
 */
@RestControllerAdvice
@Log
public class ControllerException {

    @ExceptionHandler(ValidateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ObjectError> handlerValidateException(ValidateException validateException) {
        return validateException.getErrors();
    }

    @ExceptionHandler(ValidateCodeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerValidateCodeException(ValidateCodeException validateCodeException) {
        return validateCodeException.getMessage();
    }




    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public SimpleResponse handlerValidateCodeException(Exception exception) {
        return new SimpleResponse(SecurityEnum.SYSTEM_ERROR);
    }
}