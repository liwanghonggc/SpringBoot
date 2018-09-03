package com.lwh.springboot.chp2.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件中配置的每个属性的值,映射到这个组件中
 * @ConfigurationProperties 告诉SpringBoot将本类中所有属性的和配置文件中的值进行绑定
 */
@ConfigurationProperties(prefix = "person")
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
