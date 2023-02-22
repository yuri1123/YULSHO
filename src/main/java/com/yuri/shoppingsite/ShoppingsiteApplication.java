package com.yuri.shoppingsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing
@SpringBootApplication
public class ShoppingsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingsiteApplication.class, args);
    }
}

