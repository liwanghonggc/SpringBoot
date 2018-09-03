package com.lwh.springboot.chp2.config;

import com.lwh.springboot.chp2.bean.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 指明当前类是一个配置类,替代之前的Spring配置文件
 */
@Configuration
public class MyAppConfig {

    /**
     * 将方法的返回值添加到容器中,容器中这个组件的默认id就是方法名
     * @return
     */
    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
