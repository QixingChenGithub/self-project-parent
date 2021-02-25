package com.qixian.tool.handler;

import com.qixian.tool.entity.Errors;
import com.qixian.tool.exception.EntityExistException;
import com.qixian.tool.exception.EntityNotFoundException;
import com.qixian.tool.exception.IllegalParamException;
import com.qixian.tool.util.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * @Author Xing
 * @Date 2021/2/4-9:32
 * @Version 1.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = EntityNotFoundException.class)
    public BaseResult<?> entityNotFoundException(EntityNotFoundException e) {
        log.error("对象不存在{}", e.getMessage());
        return BaseResult.failed(Errors.NOT_FOUND_ERROR, e.getMsg());
    }

    @ExceptionHandler(value = EntityExistException.class)
    public BaseResult<?> entityExistException(EntityExistException e) {
        log.error("已存在该对象{}", e.getMessage());
        return BaseResult.failed(Errors.NOT_FOUND_ERROR, e.getMsg());
    }

    @ExceptionHandler(value = IllegalParamException.class)
    public BaseResult<?> illegalParamException(IllegalParamException e) {
        log.error("非法参数{}", e.getMessage());
        return BaseResult.failed(Errors.ILLEGAL_ERROR, e.getMsg());
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public BaseResult<?> missingServletRequestParameter(MissingServletRequestParameterException e) {
        log.error("非法参数{}",e.getMessage());
        return BaseResult.failed(Errors.ILLEGAL_ERROR, e.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public BaseResult<?> handleConstraintViolationException(ConstraintViolationException e) {
        log.error("非法参数{}",e.getMessage());
        return BaseResult.failed(Errors.ILLEGAL_ERROR, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResult<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("非法参数{}",e.getMessage());
        return BaseResult.failed(Errors.ILLEGAL_ERROR, e.getMessage());
    }
}
