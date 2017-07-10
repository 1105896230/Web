package com.fmt.spring.springaop;

import com.fmt.spring.service.UserInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by 林其望 on 2017/7/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/fmt/spring/springaop/applicationContext.xml")
public class DemoTest {

    @Resource(name= "userServiceTarget")
    private UserInterface us;


    @Test
    public void fun1(){
      us.save();
    }
}
