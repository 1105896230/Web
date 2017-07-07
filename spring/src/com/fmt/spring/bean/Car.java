package com.fmt.spring.bean;

/**
 * Created by 林其望 on 2017/7/7.
 */
public class Car {

    public String name;
    public String color;

    public Car() {
    }

    public Car(String name, String color) {
        this.name = name;
        this.color = color;
        System.out.println("car ");
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
