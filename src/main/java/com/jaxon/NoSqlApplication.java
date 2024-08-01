package com.jaxon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
//        exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
        )
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.jaxon"})
public class NoSqlApplication {
    public static void main(String[] args) {
        SpringApplication.run(NoSqlApplication.class,args);
    }
}
