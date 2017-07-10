package com.fmt.spring.service;

/**
 * Created by 林其望 on 2017/7/10.
 */
public class UserInterfaceImpl implements UserInterface {
    @Override
    public void save() {
        System.out.println("save");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }

    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public void find() {
        System.out.println("find");
    }
}
