package com.fmt.ssh.action;

import com.fmt.ssh.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by 林其望 on 2017/7/11.
 */
public class UserAction extends ActionSupport{

    private UserService us;

    public void setUs(UserService us) {
        this.us = us;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(us);
        return super.execute();
    }
}
