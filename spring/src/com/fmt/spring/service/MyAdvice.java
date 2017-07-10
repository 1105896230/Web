package com.fmt.spring.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by 林其望 on 2017/7/10.
 */
//通知类
@Aspect
//表示该类是通知类
public class MyAdvice {

    //前置通知：目标方法运行之前调用
    @Before("execution(* com.fmt.spring.service..*InterfaceImpl.*(..))")
    public void before(){
        System.out.println("前置通知");
    }
    //后置通知，如果方法出现异常不会调用
    @AfterReturning("execution(* com.fmt.spring.service..*InterfaceImpl.*(..))")
    public void afterReturn(){
        System.out.println("后置通知");
    }

    //环绕通知,方法之前之后都会调用
    @Around("execution(* com.fmt.spring.service..*InterfaceImpl.*(..))")
    public void around(ProceedingJoinPoint pjp){

        System.out.println("环绕通知之前的部分");
        try {
            pjp.proceed();//调用目标方法
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("这是后置通知（如果出现异常不会调用）！！");
    }
    //异常通知
    @AfterThrowing("execution(* com.fmt.spring.service..*InterfaceImpl.*(..))")
    public void afterException(){
        System.out.println("异常时调用");
    }
    //后置通知出现异常也会调用
    @After("execution(* com.fmt.spring.service..*InterfaceImpl.*(..))")
    public void after(){
        System.out.println("这是后置通知（出现异常也会调用）");
    }



}
