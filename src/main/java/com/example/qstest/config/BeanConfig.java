package com.example.qstest.config;

import com.example.qstest.beans.SupportedParams;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfig {

    @Bean
    SupportedParams supportedParams(){
        return new SupportedParams();
    }
}
