package com.Springboot.EAMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class ObjectInterceptorAppConfig extends WebMvcConfigurerAdapter {
    @Autowired
    ObjectInterceptor objectInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(objectInterceptor);
    }

}
