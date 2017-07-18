package com.fmt;


/**
 * Created by 林其望 on 2017/7/18.
 */
public class App {
    public static void main(String[] args) {
        HelloServiceService helloServiceService = new HelloServiceService();

        com.fmt.HelloService helloServicePort = helloServiceService.getHelloServicePort();
        String str = helloServicePort.sayHello("小明");
        System.out.println(str);
    }
}
