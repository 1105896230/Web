package com.fmt.forward;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by 林其望 on 2017/7/5.
 */
public class Demo1Action extends ActionSupport{


    @Override
    public String execute() throws Exception {
        System.out.println("Demo1Action");
        return super.execute();
    }
}
