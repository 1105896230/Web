package com.fmt.spring.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

/**
 * Created by 林其望 on 2017/7/10.
 */
//jdbc
public class Demo {

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
}
