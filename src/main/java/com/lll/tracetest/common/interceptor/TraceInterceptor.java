package com.lll.tracetest.common.interceptor;

import com.lll.tracetest.common.pojo.TraceIdHolder;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author luoling
 * @date 2021/7/2 16:13
 */
@Component
public class TraceInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        MDC.put("traceId", UUID.randomUUID().toString().replace("-", ""));
        TraceIdHolder.setTraceIdThreadLocal(MDC.get("traceId"));
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        MDC.clear();
    }
}
