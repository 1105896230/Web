package com.fmt.spring.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by 林其望 on 2017/7/7.
 */
@Component("car")
public class Car {

    @Value("本田")
    public String name;
    @Value("红色")
    public String color;


    public Car() {
    }
    public Car(String name,String color) {
        this.name=name;
        this.color=color;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
