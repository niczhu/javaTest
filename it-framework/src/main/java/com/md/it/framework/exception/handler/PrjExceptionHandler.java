package com.md.it.framework.exception.handler;

import com.alibaba.fastjson.JSONObject;
import com.md.it.framework.exception.DefaultErrorCodeEnum;
import com.md.it.framework.exception.PrjException;
import com.md.it.framework.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * prjExceptionHandler
 *
 * @author zhuhaipeng6 in 2020/7/29 18:10
 * @version 1.0
 **/
public class PrjExceptionHandler extends AbstractHandlerExceptionResolver {
    Logger logger = LoggerFactory.getLogger(PrjExceptionHandler.class);

    public PrjExceptionHandler() {
        System.out.println("prj exception handler...");
    }

    @Override
    protected ModelAndView doResolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        HashMap<String, Object> resultMap = new HashMap<>();

        if (ex instanceof PrjException) {
            PrjException exception = (PrjException) ex;
            logger.error("extends 发生预期异常:{}-{}", exception.getMessage(), exception.getDetail());
            ResponseUtil.ajaxResponseException(httpServletResponse, resultMap);
        } else {
            logger.error("extends 发生非预期异常:{}", ex.getMessage());
        }
        return new ModelAndView();
    }

//    public static void ajaxReponse(HttpServletResponse response, PrjException exception) {
//        Map<String, Object> output = new HashMap<>();
//        output.put("code", exception.getCode());
//        output.put("msg", exception.getMessage());
//        output.put("detail", exception.getDetail());
//        output.put("success", false);
//        response.setStatus(exception.getCode().equals(DefaultErrorCodeEnum.NOT_LOGIN.getCode()) ? 401 : 400);
//        ResponseUtil.ajaxResponseException(response, output);
//    }

//    public static void ajaxReponse(HttpServletResponse response, Map<String, Object> output) {
//        if (response.getStatus() < 400) {
//            response.setStatus(200);
//        }
//
//        if (!output.containsKey("code")) {
//            Map<String, Object> map = new HashMap<>();
//            map.put("data", output);
//            map.put("code", 0);
//            map.put("msg", "success");
//            output.clear();
//            output.putAll(map);
//        }
//
//        try {
//            response.setContentType("application/json");
//            response.setCharacterEncoding("UTF-8");
//            PrintWriter writer = response.getWriter();
//            if (writer != null) {
//                writer.write(JSONObject.toJSONString(output));
//                writer.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
}
