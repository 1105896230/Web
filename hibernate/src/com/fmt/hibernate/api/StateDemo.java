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
//测试对象的三种状态
public class StateDemo {


    @Test
    //保存客户
    public void fun1(){
        Configuration conf=new Configuration();
        conf.configure();
        SessionFactory sessionFactory = conf.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Customer customer=new Customer();//没有id,没有与session关联

        customer.setCust_name("jd");//瞬时状态
        session.save(customer);//持久化状态，由id,有关联

        transaction.commit();//提交
        session.close();//游离|托管状态。有id。没关联
        sessionFactory.close();
    }


    @Test
    //持久化状态的特点：持久化对象的任何变化都会自动同步到数据库中
    public void fun2(){
        Configuration conf=new Configuration();
        conf.configure();
        SessionFactory sessionFactory = conf.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class, 2l);
        customer.setCust_name("tianmao");

        transaction.commit();//提交
        session.close();//游离|托管状态。有id。没关联
        sessionFactory.close();
    }
}
