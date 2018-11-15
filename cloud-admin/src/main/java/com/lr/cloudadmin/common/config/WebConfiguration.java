package com.lr.cloudadmin.common.config;

import com.lr.cloudadmin.common.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

/**
 * 请填写类注释
 *
 * @author shijie.xu
 * @since 2018年11月15日
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    JWTInterceptor jwtInterceptor(){
        return new JWTInterceptor();
    }
    //spring拦截器加载在springcontentText之前，所以这里用@Bean提前加载。否则会导致过滤器中的@AutoWired注入为空


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor()).addPathPatterns("/manage/**")
        .excludePathPatterns(Arrays.asList("/", "/login"));
    }

}

