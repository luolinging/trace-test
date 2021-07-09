package com.lll.tracetest.common.interceptor;

import com.lll.tracetest.common.pojo.MyException;
import com.lll.tracetest.common.pojo.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 * @author luoling
 * @date 2021/7/9 11:54
 */
@Aspect
@Slf4j
@Order(2)
public class ExceptionAspect {
    @Pointcut("execution(* com.lll.tracetest.controller.*.*(..))")
    private void pointOut() {}

    @Around("pointOut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
        } catch (MyException e) {
            //todo 判断返回值类型是否是result
            if (proceed instanceof ResponseResult) {
                log.error("方法返回值不为result类型");
                return null;
            }
            return ResponseResult.getErrorResult(e.getCode(), e.getMessage());
        } catch (MethodArgumentNotValidException e) {
            //其他可以给客户看的异常
        } catch (Throwable throwable) {
            return ResponseResult.getErrorResult(-1, "系统内部错误");
        }
        return proceed;
    }
}
