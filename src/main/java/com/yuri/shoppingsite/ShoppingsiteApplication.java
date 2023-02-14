package com.yuri.shoppingsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;

@SpringBootApplication
public class ShoppingsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingsiteApplication.class, args);
    }
}

