package com.fmt.spring.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 林其望 on 2017/7/10.
 */
public class UserServiceProxyFactory implements InvocationHandler{
    private UserInterface us;

    public UserServiceProxyFactory(UserInterface us) {
        this.us = us;
    }

    public UserInterface getUserInterfaceProxy(){
        UserInterface  userInterface = (UserInterface) Proxy.newProxyInstance(UserServiceProxyFactory.class.getClassLoader(),
                UserInterfaceImpl.class.getInterfaces(), this
        );
       return userInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("打开事务");
        Object invoke = method.invoke(us, args);
        System.out.println("关闭事务");
        return invoke;
    }
}
