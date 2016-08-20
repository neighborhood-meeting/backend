package com.nexters.neighborhood.config;

import com.nexters.neighborhood.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Dark on 2016. 8. 13..
 */
@Configuration
public class NeighborhoodWebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO 운영할때에는 해당 Interceptor 주석을 풀어야 함!
//        registry.addInterceptor(new AuthenticationInterceptor());
    }
}