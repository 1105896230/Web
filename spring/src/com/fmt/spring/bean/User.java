package com.fmt.spring.bean;

/**
 * Created by 林其望 on 2017/7/6.
 */
public class User {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
