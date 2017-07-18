package com.fmt;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * Created by 林其望 on 2017/7/18.
 */
@WebService
public class HelloService {

    public String sayHello(String name){
        System.out.println("服务器端SayHello被调用");
        return "hello"+name;
    }

    public static void main(String[] args) {
        String address="http://172.16.16.102:8080/hello";
        Object implmentor=new HelloService();
        Endpoint.publish(address,implmentor);
    }
}
