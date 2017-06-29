package com.fmt.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by 林其望 on 2017/6/29.
 */


public class Demo {

    @Test
    public void fun1(){
        Configuration configuration=new Configuration().configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
//        -------------------------------------------
        Customer c=new Customer();
        c.setCust_name("百度");
        c.setCust_level("5");
        session.save(c);

//        ----------------------------------------
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
