package com.fmt.spring.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.beans.PropertyVetoException;
import java.util.List;

/**
 * Created by 林其望 on 2017/7/10.
 */
//jdbc
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/fmt/spring/jdbc/applicationContext.xml")
public class Demo {

    @Resource(name = "userDao")
    private UserDao userDao;
    @Test
    public void fun1(){
        //准备连接池

        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        try {
            comboPooledDataSource.setDriverClass("com.jdbc.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        comboPooledDataSource.setJdbcUrl("jdbc:mysql:///jdbctest");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("123456");

        //创建JDBC末班对象
        JdbcTemplate jt=new JdbcTemplate();

        jt.setDataSource(comboPooledDataSource);
        //书写sql语句
        String sql="insert into t_user values(null,'rose')";
        jt.update(sql);


    }
    @Test
    public void fun2(){
        //准备连接池

        User user = new User();
        user.name="xxx";
        userDao.delete(1);


    }
}
