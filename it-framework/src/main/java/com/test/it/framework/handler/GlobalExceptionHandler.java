package com.test.it.framework.handler;

import com.test.it.framework.exception.DefaultErrorCodeEnum;
import com.test.it.framework.exception.PrjException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private static ModelAndView MODAL_AND_VIEW = new ModelAndView();

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object validatorException(HttpServletRequest request, HttpServletResponse response, Object handler, MethodArgumentNotValidException ex) {

        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        StringBuffer sb = new StringBuffer();
        for (FieldError error : fieldErrors) {
            sb.append("参数[").append(error.getField()).append("]").append(error.getDefaultMessage());
        }

        Map<String, Object> map = new HashMap<>();
        map.put("code", DefaultErrorCodeEnum.MISS_PARAMETER.getCode());
        map.put("msg", DefaultErrorCodeEnum.MISS_PARAMETER.getMsg());
        map.put("detail", sb.toString());

        return map;
    }

    @ExceptionHandler(PrjException.class)
    @ResponseBody
    public Object prjException(HttpServletRequest request, HttpServletResponse response, Object handler, PrjException ex) {
        // 非预期异常
        if (!(ex instanceof PrjException)) {
            log.error("发生非预期异常");

        } else {
            PrjException exception = (PrjException) ex;

            //TODO:未登录异常
            Map<String, Object> map = new HashMap<>();
            map.put("code", exception.getCode());
            map.put("msg", exception.getMessage());
            map.put("detail", exception.getDetail());
            return map;
        }

        return null;
    }

}
