package com.fmt.spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by 林其望 on 2017/7/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)//帮我们创建容器
//指定创建容器时使用那个配置文件
@ContextConfiguration("classpath:com/fmt/spring/aop/applicationContext.xml")
public class Demo {

    @Resource(name="car2")
    private Car car;

    @Test
    public void fun1(){
        System.out.println(car);
    }
}
