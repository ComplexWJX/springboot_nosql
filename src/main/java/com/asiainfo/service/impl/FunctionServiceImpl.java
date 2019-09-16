package com.asiainfo.service.impl;

import org.springframework.stereotype.Service;

import com.asiainfo.service.FunctionService;

@Service
public class FunctionServiceImpl implements FunctionService {

    @Override
    public Object process(String... args) {
        StringBuffer sb = new StringBuffer();
        sb.append("Hello,").append(args[0]);
        System.out.println(sb.toString());
        return null;
    }

}
