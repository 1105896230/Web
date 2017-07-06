package com.fmt.ognl;

import com.fmt.api.User;
import ognl.OgnlContext;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by 林其望 on 2017/7/5.
 */
public class Demo {


    @Test
    public void fun1(){

        User user1=new User("小明1",19);
        HashMap<String, User> context = new HashMap<>();
        context.put("user1",user1);
        context.put("user2",new User("小明2",19));
        context.put("user3",new User("小明3",19));
        OgnlContext ognlContext = new OgnlContext();
        ognlContext.setRoot(user1);
        ognlContext.setValues(context);
    }
}
