package com.fmt.spring.service;

import org.junit.Test;

/**
 * Created by 林其望 on 2017/7/10.
 */
public class Demo {

    //动态代理
    @Test
    public void fun1(){
        UserInterfaceImpl userInterface = new UserInterfaceImpl();
        UserServiceProxyFactory userServiceProxyFactory = new UserServiceProxyFactory(userInterface);
        UserInterface userInterfaceProxy = userServiceProxyFactory.getUserInterfaceProxy();
        userInterfaceProxy.save();
        userInterfaceProxy.delete();
        userInterfaceProxy.update();
        //代理对象和被代理对象实现了相同的接口
        //代理对象和被代理对象没有继承关系
        System.out.println(userInterfaceProxy instanceof UserInterfaceImpl);
    }

    //cgi
    @Test
    public void fun2(){
        UserServiceProxyFactory2 userServiceProxyFactory = new UserServiceProxyFactory2();
        UserInterface userInterface = userServiceProxyFactory.getUserInterface();
        userInterface.save();
        userInterface.delete();
        userInterface.update();
    }
}
