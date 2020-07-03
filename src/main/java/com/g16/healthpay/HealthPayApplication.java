package com.g16.healthpay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.g16.healthpay.mapper")
public class HealthPayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthPayApplication.class, args);
    }

}
