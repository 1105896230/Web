package com.fmt.ongl;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by 否命题 on 2017/7/5.
 */
public class DemoTest extends ActionSupport{
    @Override
    public String execute() throws Exception {

        System.out.println("DemoTest");

        return SUCCESS;
    }
}
