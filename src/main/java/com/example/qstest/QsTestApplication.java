package com.example.qstest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class QsTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(QsTestApplication.class, args);
    }

}
