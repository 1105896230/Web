package com.fmt.spring.service;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by 林其望 on 2017/7/10.
 */
public class UserServiceProxyFactory2 implements MethodInterceptor {

    public UserInterface getUserInterface(){
        Enhancer enhancer=new Enhancer();//帮我们生成代理对象
        enhancer.setSuperclass(UserInterfaceImpl.class);//设置对谁代理
        enhancer.setCallback(this);
        return (UserInterface) enhancer.create();
    }

    @Override
    public Object intercept(Object prxoyobj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("打开事务");
        //调用原有方法
        Object o = methodProxy.invokeSuper(prxoyobj, args);

        System.out.println("关闭事务");
        return o;
    }
}
