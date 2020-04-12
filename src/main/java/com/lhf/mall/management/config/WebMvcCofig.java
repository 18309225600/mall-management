package com.lhf.mall.management.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcCofig extends WebMvcConfigurationSupport {


    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);

//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/login/**");

    }
}
