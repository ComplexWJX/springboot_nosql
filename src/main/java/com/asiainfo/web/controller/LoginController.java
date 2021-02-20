package com.asiainfo.web.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Koala
 * @description
 * @date 2020/3/23 0023
 */
@RestController
//@Controller
@RequestMapping("/v2")
public class LoginController {
        @GetMapping("/test")
//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    @ResponseBody
    public String test(HttpResponse httpResponse){
        HttpEntity entity = httpResponse.getEntity();
//        EntityUtils.toString(entity).replaceAll("","");
        return "success";
    }
}

