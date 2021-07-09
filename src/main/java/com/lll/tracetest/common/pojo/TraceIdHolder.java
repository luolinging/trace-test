package com.lll.tracetest.common.pojo;

/**
 * @author luoling
 * @date 2021/7/9 19:09
 */
public class TraceIdHolder {
    private static ThreadLocal<String> traceIdThreadLocal = new ThreadLocal<>();

    public static void setTraceIdThreadLocal(String traceId) {
        traceIdThreadLocal.set(traceId);
    }

    public static String getTraceIdThreadLocal() {
        return traceIdThreadLocal.get();
    }

}
