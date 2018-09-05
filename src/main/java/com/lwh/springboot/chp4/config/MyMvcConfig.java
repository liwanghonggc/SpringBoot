package com.lwh.springboot.chp4.config;

import com.lwh.springboot.chp4.component.LoginHandlerInterceptor;
import com.lwh.springboot.chp4.component.MyLocaleResolver;
import org.springframework.boot.autoconfigure.web.WebMvcProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * WebMvcConfigureAdapter可以扩展SpringMvc的功能
 * 既保留了所有的自动配置,也能扩展我们的配置
 */

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(("/test")).setViewName("success");
    }

    /** 所有的WebMvcConfigureAdapter组件会一起起作用 **/
    /** 将组件注册到容器中 **/
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            /** 注册拦截器 **/
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                /** (/**)拦截所有请求,但是exclude中的三个请求不拦截 **/
                /** SpringBoot已经做好了静态资源映射,我们不用处理 **/
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/login.html", "/", "/user/login");
            }
        };

        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
