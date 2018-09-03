package com.lwh.springboot;

import com.lwh.springboot.chp2.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    private Person person;

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void contextLoads() {
        System.out.println(person);
    }

    @Test
    public void containsBean(){
        System.out.println(ctx.containsBean("helloService"));
    }

}
