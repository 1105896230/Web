package com.fmt.hibernate.api;

import com.fmt.hibernate.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by 林其望 on 2017/6/29.
 */
public class CacheDemo {

    @Test
    public void fun1() {
        Configuration conf = new Configuration().configure();
        SessionFactory sessionFactory = conf.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Customer customer1 = session.get(Customer.class, 2l);
        Customer customer2 = session.get(Customer.class, 2l);
        Customer customer3 = session.get(Customer.class, 2l);

        System.out.println(customer1==customer2);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void fun2() {
        Configuration conf = new Configuration().configure();
        SessionFactory sessionFactory = conf.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Customer customer1 = session.get(Customer.class, 2l);

        customer1.setCust_name("jd");
        customer1.setCust_name("tianmao");
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

}
