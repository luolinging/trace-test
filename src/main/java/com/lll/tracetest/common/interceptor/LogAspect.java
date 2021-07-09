package com.lll.tracetest.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

/**
 * @author luoling
 * @date 2021/7/9 10:25
 */
@Aspect
@Slf4j
@Order(1)
public class LogAspect {
    @Pointcut("execution(* com.lll.tracetest.controller.*.*(..))")
    private void pointOut() {}

    @Around("pointOut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Object result;
        Object[] args = proceedingJoinPoint.getArgs();
        log.info("入参：{}", args);
        try {
            result = proceedingJoinPoint.proceed();
            log.info("result:{}", result);
        } catch (Throwable throwable) {
            log.error("异常信息：", throwable);
            throw new RuntimeException(throwable);
        }
        return result;
    }
}
