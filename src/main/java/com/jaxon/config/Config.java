package com.jaxon.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author WJX
 * 2018年11月3日
 */
@Configuration
@ComponentScan("com.jaxon")
public class Config {
    //@Configuration声明当前类是一个配置类，与@ComponentScan结合使用，代替xml配置中<component-scan>
}
