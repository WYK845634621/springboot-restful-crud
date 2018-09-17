package com.yikai.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author wangyikai
 * @Date 2018/9/11 - 10:34
 */
@Controller
public class HelloController {


    @ResponseBody
    @RequestMapping("/hello")
    public  String hello(){
        return  "hello";
    }


    @RequestMapping("/success")
    public  String testThymeleaf(Map<String, Object> map){
        map.put("hello","范崔静");
        map.put("singers", Arrays.asList("薛之谦", "许嵩","周杰伦"));
        return  "success";
    }

//    @RequestMapping({"/","/index.html"})
//    public  String index(){
//        return  "index";
//    }
}
