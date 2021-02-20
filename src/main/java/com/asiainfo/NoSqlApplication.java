package com.asiainfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(
//        exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
        )
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.asiainfo"})
public class NoSqlApplication {
    public static void main(String[] args) {
        SpringApplication.run(NoSqlApplication.class,args);
    }
}
