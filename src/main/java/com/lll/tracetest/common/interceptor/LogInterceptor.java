/*
package com.lll.tracetest.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;

*/
/**
 * @author luoling
 * @date 2021/7/2 16:13
 *//*

@Slf4j
@Component
public class LogInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

       InputStream is = httpServletRequest.getInputStream ();
        StringBuilder responseStrBuilder = new StringBuilder ();
        BufferedReader streamReader = new BufferedReader (new InputStreamReader(is,"UTF-8"));
        String inputStr;
        while ((inputStr = streamReader.readLine ()) != null)
            responseStrBuilder.append (inputStr);
        String parameters = responseStrBuilder.toString();
        HandlerMethod handlerMethod = (HandlerMethod) o;

        log.info("begin method:{}, args:{}", handlerMethod.getMethod().getName(), parameters);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println(httpServletResponse);
//        log.info("method complete, response:{handlerMethod}", handlerMethod.getMethod().getName(), parameters);
    }
}
*/
