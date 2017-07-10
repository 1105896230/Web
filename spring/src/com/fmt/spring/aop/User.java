package com.fmt.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Created by 林其望 on 2017/7/6.
 */
//<bean name="user" class="com.fmt.spring.bean.User/>
@Component("user")
  @Service("user")//service层
  @Controller("user")//web层
  @Repository("user")//dao层
//指定对象的作用范围
@Scope(scopeName = "prototype")
public class User {
    @Value("tom")
    public String name;
    @Value("18")
    public Integer age;


    //自动装配，如果碰到多个类型一直的对象，将无法选择具体注入那个对象
    @Autowired
    public Car car;

//    @Qualifier("car2")//使用注解告诉spring容器，去取那个Car对象
//    public Car car2;


    @PostConstruct//对象被创建后，调用init-method
    public void init(){

    }
    @PreDestroy//对象即将被销毁钱调用，destory-method
    public void destory(){

    }


    @Resource(name="car2")//手动注入，指定注入那个名称的bean对象
    public Car car3;
    @Value("jack")
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                ", car3=" + car3 +
                '}';
    }
}
