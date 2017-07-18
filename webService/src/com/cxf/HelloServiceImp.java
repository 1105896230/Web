package com.cxf;

/**
 * Created by 林其望 on 2017/7/18.
 */
public class HelloServiceImp implements HelloService {

    public String sayHello(String name){
        System.out.println("基于CXF的服务器端被调用");
        return "cxf+hello"+name;
    }
}
