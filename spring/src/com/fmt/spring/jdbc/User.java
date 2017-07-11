package com.fmt.spring.jdbc;

/**
 * Created by 林其望 on 2017/7/10.
 */
public class User {
    public Integer id;
    public String name;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
