package com.fmt.intercept;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * Created by 林其望 on 2017/7/6.
 */
public class MyIntercept3  extends MethodFilterInterceptor{
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("处理前");
        //放行
        actionInvocation.invoke();
        System.out.println("处理后");
        return "success";
    }
}
