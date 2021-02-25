package com.qixian.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Xing
 * @Date 2021/2/8-14:27
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = {"com.qixian"})
public class BusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
    }
}
