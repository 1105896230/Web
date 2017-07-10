package com.fmt.spring.service;

import org.junit.Test;

/**
 * Created by 林其望 on 2017/7/10.
 */
public class Demo {

    @Test
    public void fun1(){
        UserInterfaceImpl userInterface = new UserInterfaceImpl();
        UserServiceProxyFactory userServiceProxyFactory = new UserServiceProxyFactory(userInterface);
        UserInterface userInterfaceProxy = userServiceProxyFactory.getUserInterfaceProxy();
        userInterfaceProxy.save();
        userInterfaceProxy.delete();
        userInterfaceProxy.update();
    }
}
