package com.yikai.springboot.config;


import com.yikai.springboot.component.LoginHandlerInterceptor;
import com.yikai.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author wangyikai
 * @Date 2018/9/12 - 8:28
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter{


    @Bean
    public  WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
//            注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login");
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("/login");
                registry.addViewController("/index.html").setViewName("/login");
                registry.addViewController("/main.html").setViewName("/dashboard");


            }

        };
        return  adapter;
    }


    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
