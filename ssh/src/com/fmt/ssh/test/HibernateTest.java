package com.fmt.ssh.test;

import com.fmt.ssh.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by 林其望 on 2017/7/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    @Test
    public void fun1(){
        Configuration conf=new Configuration();
        conf.configure();
        Session session = conf.buildSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setUser_code("tom");
        user.setUser_name("tom");
        user.setUser_password("1234");
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Test
    public void fun2(){
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setUser_code("jack");
        user.setUser_name("jack");
        user.setUser_password("1234");
        session.save(user);
        transaction.commit();
        session.close();
    }
    @Test
    public void fun3(){
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setUser_code("jock");
        user.setUser_name("jock");
        user.setUser_password("1234");
        session.save(user);
        transaction.commit();
        session.close();
    }
}
