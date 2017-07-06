package com.fmt.spring.bean;

/**
 * Created by 林其望 on 2017/7/6.
 */
public class UserFactory {
    public static User createUser(){
        return new User();
    }

    public  User createUser2(){
        return new User();
    }
}
