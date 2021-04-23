package com.md.it.framework.exception.handler;

import com.md.it.framework.exception.DefaultErrorCodeEnum;
import com.md.it.framework.exception.ErrorHelper;
import com.md.it.framework.exception.PrjException;
import com.md.it.framework.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DefaultGlobalExceptionHandler
 *
 * @author zhuhaipeng6 in 2020/2/25 22:52
 * @version 1.0
 **/
public class DefaultPrjExceptionHandler extends BaseExceptionHandler {

    Logger logger = LoggerFactory.getLogger(DefaultPrjExceptionHandler.class);

    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public void webRequestValidatorException(HttpServletRequest request, HttpServletResponse response, Object handler, MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        StringBuffer sb = new StringBuffer();
        for (FieldError error : fieldErrors) {
            sb.append("[").append(error.getField()).append("]").append(error.getDefaultMessage());
        }

        Map<String, Object> rst = getResponseMap(DefaultErrorCodeEnum.BAD_REQUEST, sb.toString());
        response.setStatus(400);
        ResponseUtil.ajaxResponseException(response, rst);
    }

    @ExceptionHandler(PrjException.class)
    public void prjException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Map<String, Object> resultMap = new HashMap<>();
        if (!(ex instanceof PrjException)) {
            // 非预期异常
            try {
                ErrorHelper.genExByCode(DefaultErrorCodeEnum.UNKNOWN);
            } catch (PrjException e1) {
                logger.error("发生非预期异常", e1);
                resultMap = getResponseMap(DefaultErrorCodeEnum.UNKNOWN, ex);
            }
            response.setStatus(400);
        } else {
            logger.error("发生预期异常:{}", ex.getMessage());
            PrjException exception = (PrjException) ex;
            //TODO:未登录异常
            resultMap = getResponseMap(exception);
            response.setStatus(exception.getCode().equals(DefaultErrorCodeEnum.NOT_LOGIN.getCode()) ? 401 : 400);
        }
        ResponseUtil.ajaxResponseException(response, resultMap);
    }

    // 请求方法不支持
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public void methodNotSupportedException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.debug("-------------> req method not support exp");

    }


}
