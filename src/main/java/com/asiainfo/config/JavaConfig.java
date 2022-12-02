package com.asiainfo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.asiainfo.service.FunctionService;
import com.asiainfo.service.IUserService;
import com.asiainfo.service.impl.FunctionServiceImpl;
import com.asiainfo.service.impl.UserServiceImpl;

@Configuration
public class JavaConfig {
    @Bean
    public FunctionService functionService(){
        return new FunctionServiceImpl();
    }

    @Bean
    public IUserService iUserService(FunctionService functionService){
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        userServiceImpl.setFunctionService(functionService);
        return userServiceImpl;
    }
}
