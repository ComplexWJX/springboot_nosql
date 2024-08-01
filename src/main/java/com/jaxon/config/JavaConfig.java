package com.jaxon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jaxon.service.FunctionService;
import com.jaxon.service.IUserService;
import com.jaxon.service.impl.FunctionServiceImpl;
import com.jaxon.service.impl.UserServiceImpl;

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
