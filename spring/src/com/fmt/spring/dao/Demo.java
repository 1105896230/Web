package com.fmt.spring.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by 林其望 on 2017/7/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/fmt/spring/dao/applicationContext.xml")
public class Demo {

    @Resource(name = "accountService")
    private AcountService acountService;
    @Test
    public void fun1(){
      acountService.transfer(1,2,100d);
    }
}
