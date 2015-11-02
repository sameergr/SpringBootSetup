package com.app.spring.social;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.app.spring.social")
public class SpringSocialBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSocialBootApplication.class, args);
    }
}
