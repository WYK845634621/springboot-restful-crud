package com.yikai.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author wangyikai
 * @Date 2018/9/12 - 10:35
 */
@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public  String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String,Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("loginUser",username);
//            登陆成功之后，为了防止页面表单重复提交，可以重定向到主页
            return "redirect:/main.html";
        }else {
            map.put("msg","用户名密码错误");
            return "login";
        }
    }
}