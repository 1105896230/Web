package com.fmt.struct;

import com.fmt.api.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * Created by 林其望 on 2017/7/5.
 */
public class HelloAction implements Preparable{
    private User user=new User();

    public String hello(){


        System.out.println(user);
        return "success";
    }

    @Override
    public void prepare() throws Exception {
        ValueStack valueStack = ActionContext.getContext().getValueStack();
        valueStack.push(user);
    }
}
