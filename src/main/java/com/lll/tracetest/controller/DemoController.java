package com.lll.tracetest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luoling
 * @date 2021/6/25 11:04
 */
@Validated
@RestController
@Slf4j
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/test")
    public String testBean(String name) throws InterruptedException {
        for(int i = 0; i < 100; i++) {
            Thread.sleep(100);
            log.info("hello world:{}", name);
        }
        int i = 10/0;
        return "hello world";
    }
}
