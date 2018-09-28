package com.ys.inventory.common.configurer.spring;


import com.ys.inventory.common.core.Result;
import com.ys.inventory.common.exception.BusinessException;
import com.ys.inventory.common.exception.InterfaceBusinessException;
import com.ys.inventory.common.validator.ValidatorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.sql.SQLException;

/**
 * @author wyh
 */

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ValidatorException.class)
    public Result handlerValidatorException(ValidatorException ex) {
        log.error("数据验证失败", ex);
        return Result.error(500, ex.getMessage(), ex);
    }

    @ExceptionHandler(BusinessException.class)
    public Result handlerBusinessException(BusinessException ex) {
        log.error("业务异常", ex);
        return Result.error(500, ex.getMessage(), ex);
    }

    @ExceptionHandler(InterfaceBusinessException.class)
    public Result handlerInterfaceBusinessException(InterfaceBusinessException ex){
        log.error("业务异常", ex);
        return Result.error(400, ex.getMessage(), ex);
    }

    @ExceptionHandler({SQLException.class, DataAccessException.class})
    public Result handlerSQLException(SQLException ex) {
        log.error("数据访问出错", ex);
        return Result.error(500, "数据访问出错", ex);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public Result handlerHttpRequestMethodNotSupportedException(NoHandlerFoundException ex) {
        log.error("访问的页面不存在", ex);
        return Result.error(404, "访问的页面不存在", ex);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result handlerException(HttpRequestMethodNotSupportedException ex) {
        log.error("HttpRequestMethodNotSupportedException", ex);
        return Result.error(500, "HttpRequestMethodNotSupportedException", ex);
    }

    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception ex) {
        log.error("未知异常", ex);
        return Result.error(500, "未知异常", ex);
    }
}
