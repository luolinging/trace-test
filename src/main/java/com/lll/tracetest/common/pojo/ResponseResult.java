package com.lll.tracetest.common.pojo;

import lombok.Data;

/**
 * @author luoling
 * @date 2021/7/9 12:46
 */
@Data
public class ResponseResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> ResponseResult<T> getSuccessResult(T data) {
        ResponseResult<T> result = new ResponseResult<T>();
        result.setCode(200);
        result.setData(data);
        return result;
    }

    public static <T> ResponseResult<T> getErrorResult(Integer code, String msg) {
        ResponseResult<T> result = new ResponseResult<T>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
