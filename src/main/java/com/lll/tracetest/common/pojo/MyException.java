package com.lll.tracetest.common.pojo;

import lombok.Data;

/**
 * @author luoling
 * @date 2021/7/9 13:01
 */
@Data
public class MyException extends RuntimeException{
    private Integer code;

    public MyException(String msg, Integer code) {
        super(msg);
        this.code = code;
    }
}
