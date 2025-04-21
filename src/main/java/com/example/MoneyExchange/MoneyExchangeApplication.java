package com.example.MoneyExchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MoneyExchangeApplication {
    public static void main(String[] args) {
        SpringApplication.run(MoneyExchangeApplication.class, args);
    }
}