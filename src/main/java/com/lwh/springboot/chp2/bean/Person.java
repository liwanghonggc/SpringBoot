package com.lwh.springboot.chp2.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件中配置的每个属性的值,映射到这个组件中
 * @ConfigurationProperties 告诉SpringBoot将本类中所有属性的和配置文件中的值进行绑定
 *                          prefix = "person" 配置文件中哪个下面的所有属性进行一一映射
 * 只有这个组件是容器中的组件,容器才能提供@ConfigurationProperties功能
 * 默认从全局配置文件中获取值
 */
@Component
@ConfigurationProperties(prefix = "person")
//@PropertySource(value = {"classpath:person.properties"})
@Data
public class Person {

    private String lastName;

    private Integer age;

    private Boolean boss;

    private Date birth;

    private Map<String, Object> map;

    private List<Object> list;

    private Dog dog;
}
