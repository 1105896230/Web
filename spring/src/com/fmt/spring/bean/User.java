package com.fmt.spring.bean;

/**
 * Created by 林其望 on 2017/7/6.
 */
public class User {
    public String name;
    public Integer age;

    public Car car;

    public User(String name, Integer age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    public User(String name, Car car) {
        System.out.println("User(String name, Car car)!!");
        this.name = name;
        this.car = car;
    }

    public User(Car car,String name) {
        System.out.println("User(Car car,String name)!!");
        this.name = name;
        this.car = car;
    }

    public User(Integer name, Car car) {
        System.out.println("User(Integer name, Car car)!!");
        this.name = name+"";
        this.car = car;
    }

    public User() {
        System.out.println("无参构造函数");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void init(){
        System.out.println("init");
    }
    public void destory(){
        System.out.println("destory");
    }
}
