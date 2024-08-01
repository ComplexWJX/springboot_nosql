package com.jaxon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaxon.service.FunctionService;
import com.jaxon.service.IUserService;

/**
 * @author rukawa
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private FunctionService functionService;

    public FunctionService getFunctionService() {
        return functionService;
    }

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    @Override
    public Object sayHello(String name) {
        return functionService.process(new String[]{name});
    }

}
