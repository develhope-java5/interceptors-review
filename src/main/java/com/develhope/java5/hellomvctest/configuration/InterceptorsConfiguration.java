package com.develhope.java5.hellomvctest.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.develhope.java5.hellomvctest.interceptors.SupplierHeaderInterceptor;

@Configuration
public class InterceptorsConfiguration implements WebMvcConfigurer {
    @Value("${interceptors.supplier_key}")
    private boolean enableSupplierKeyInterceptor;

    @Bean
    public SupplierHeaderInterceptor supplierHeaderInterceptor() {
        return new SupplierHeaderInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if(enableSupplierKeyInterceptor)
            registry.addInterceptor(supplierHeaderInterceptor());
    }
}
