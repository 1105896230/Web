package com.fmt.forward;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by 林其望 on 2017/7/5.
 */
public class DemoAction extends ActionSupport{


    public String dispatcher() throws Exception {
        System.out.println("dispatcher");
        return SUCCESS;
    }

    public String redirect() throws Exception {
        System.out.println("redirect");
        return SUCCESS;
    }

    public String chain() throws Exception {
        System.out.println("chain");
        return SUCCESS;
    }
    public String redirectAction() throws Exception {
        System.out.println("redirectAction");
        return SUCCESS;
    }
}
