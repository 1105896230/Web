package com.fmt.spring.test;

import com.fmt.spring.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 林其望 on 2017/7/6.
 */
public class Demo {

    @Test
    public void fun1(){

        //1.创建容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.向容器要user对象
        User user = (User) ac.getBean("user");
        //打印user
        System.out.println(user);
    }

    @Test
    public void fun12(){

        //1.创建容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.向容器要user对象
        User user = (User) ac.getBean("user1");
        //打印user
        System.out.println(user);
    }
    @Test
    public void fun3(){

        //1.创建容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.向容器要user对象
        User user = (User) ac.getBean("user2");
        //打印user
        System.out.println(user);
    }
}
