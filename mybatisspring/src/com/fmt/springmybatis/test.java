package com.fmt.springmybatis;

import com.fmt.springmybatis.map.UserMap;
import com.fmt.springmybatis.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 否命题 on 2017/7/13.
 */
public class test {
    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserMap userMapper = (UserMap) ac.getBean("userMapper");
        UserMap userMap=ac.getBean(UserMap.class);
        User userById = userMap.findUserById(10);
        System.out.print(userById);
    }
}
