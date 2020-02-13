package com.test.it.framework.handler;

import com.alibaba.fastjson.JSONObject;
import com.test.it.framework.exception.DefaultErrorCodeEnum;
import com.test.it.framework.exception.ErrorHelper;
import com.test.it.framework.exception.PrjException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class,BindException.class})
    @ResponseBody
    public void webRequestValidatorException(HttpServletRequest request, HttpServletResponse response, Object handler, MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        StringBuffer sb = new StringBuffer();
        sb.append("参数");
        for (FieldError error : fieldErrors) {
            sb.append("[").append(error.getField()).append("]").append(error.getDefaultMessage());
        }

        Map<String, Object> map = new HashMap<>();
        map.put("code", DefaultErrorCodeEnum.BAD_REQUEST.getCode());
        map.put("msg", DefaultErrorCodeEnum.BAD_REQUEST.getMsg());
        map.put("detail", sb.toString());

        response.setStatus(400);
        ajaxResponseException(response,map);
    }

    @ExceptionHandler(PrjException.class)
    @ResponseBody
    public void prjException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Map<String, Object> map = new HashMap<>();
        // 非预期异常
        if (!(ex instanceof PrjException)) {
            try {
                ErrorHelper.genExByCode(DefaultErrorCodeEnum.UNKNOWN);
            } catch (PrjException e1) {
                log.error("发生非预期异常");
                map.put("code",DefaultErrorCodeEnum.UNKNOWN.getCode());
                map.put("msg", DefaultErrorCodeEnum.UNKNOWN.getMsg());
                map.put("detail", ex.getMessage());
            }
            response.setStatus(400);
        } else {
            PrjException exception = (PrjException) ex;
            //TODO:未登录异常
            map.put("code", exception.getCode());
            map.put("msg", exception.getMessage());
            map.put("detail", exception.getDetail());
            response.setStatus(exception.getCode() == DefaultErrorCodeEnum.NOT_LOGIN.getCode() ? 401 : 400);
        }

        ajaxResponseException(response,map);

    }

    /**
     * 异常返回
     * @param response
     * @param output
     */
    private void ajaxResponseException(HttpServletResponse response, Map<String,Object> output){
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            if (writer != null) {
                writer.write(JSONObject.toJSONString(output));
                writer.close();
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

}
