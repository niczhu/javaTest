package com.test.it.framework.exception.handler;

import com.test.it.framework.exception.DefaultErrorCodeEnum;
import com.test.it.framework.exception.ErrorHelper;
import com.test.it.framework.exception.PrjException;
import com.test.it.framework.exception.handler.BaseExceptionHandler;
import com.test.it.framework.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class DefaultGlobalExceptionHandler extends BaseExceptionHandler {

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
                log.error("发生非预期异常");
                resultMap = getResponseMap(DefaultErrorCodeEnum.UNKNOWN, ex);
            }
            response.setStatus(400);
        } else {
            PrjException exception = (PrjException) ex;
            //TODO:未登录异常
            resultMap = getResponseMap(exception);
            response.setStatus(exception.getCode() == DefaultErrorCodeEnum.NOT_LOGIN.getCode() ? 401 : 400);
        }
        ResponseUtil.ajaxResponseException(response, resultMap);
    }

    // 请求方法不支持
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public void methodNotSupportedException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("-------------req method not support exp");

    }


}
