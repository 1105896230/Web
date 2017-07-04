package com.fmt.hibernate.lazy;

import com.fmt.hibernate.Customer;
import com.fmt.hibernate.LinkMan;
import com.fmt.hibernate.api.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by 林其望 on 2017/7/4.
 */
public class Demo {

    @Test
    public void fun1(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, 22l);
//        Set<LinkMan> linkMens = customer.getLinkMens();
//        System.out.println(linkMens);
        transaction.commit();
        session.close();
    }


    @Test
    public void fun2(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "from Customer ";
        Query query = session.createQuery(hql);
        List<Customer> list = query.list();

        for(Customer c:list){
            System.out.println(c);
        }

        transaction.commit();
        session.close();
    }
}
