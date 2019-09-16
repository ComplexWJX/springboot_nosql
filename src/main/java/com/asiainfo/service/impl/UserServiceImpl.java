package com.asiainfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.service.FunctionService;
import com.asiainfo.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    FunctionService functionService;

//    public FunctionService getFunctionService()
//    {
//        return functionService;
//    }
//
//    public void setFunctionService(FunctionService functionService)
//    {
//        this.functionService = functionService;
//    }

    @Override
    public Object sayHello(String name) {
        return functionService.process(new String[]{name});
    }

}
