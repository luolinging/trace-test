package com.lll.tracetest.common.config;

import com.lll.tracetest.common.interceptor.TraceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author luoling
 * @date 2021/7/7 21:25
 */
@Configuration
public class InterceptorAdapter implements WebMvcConfigurer {
    @Autowired
    private TraceInterceptor traceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //添加拦截器
        registry.addInterceptor(traceInterceptor)
                .addPathPatterns("/**");
    }
}
