package com.fmt.hibernate.query;

import com.fmt.hibernate.Customer;
import com.fmt.hibernate.api.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

/**
 * Created by 林其望 on 2017/6/30.
 */
public class HqlDemo {

    @Test
    public void fun1(){
        Session session= HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        //书写HQL语句
//        String hql="from com.fmt.hibernate.Customer";
//        String hql="from Customer ";//查询所有Custom对象
        String hql="from Customer where cust_id =2";
        Query query = session.createQuery(hql);
        List<Customer> list = query.list();//返回list
        System.out.print(list);
//        Object o = query.uniqueResult();//接受唯一的查询
        //根据HQL语句创建查询对象
        //根据查询对象获取查询结果

        transaction.commit();
        session.close();
    }

    //条件查询
    @Test
    public void fun2(){
        Session session= HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        //书写HQL语句
//        String hql="from com.fmt.hibernate.Customer";
//        String hql="from Customer ";//查询所有Custom对象
        String hql="from Customer where cust_id =?";
        Query query = session.createQuery(hql);
//        query.setLong(0,2l);
        query.setParameter(0,2l);
        List<Customer> list = query.list();//返回list
        System.out.print(list);
//        Object o = query.uniqueResult();//接受唯一的查询
        //根据HQL语句创建查询对象
        //根据查询对象获取查询结果

        transaction.commit();
        session.close();
    }

    //命名查询
    @Test
    public void fun3(){
        Session session= HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        //书写HQL语句
//        String hql="from com.fmt.hibernate.Customer";
//        String hql="from Customer ";//查询所有Custom对象
        String hql="from Customer where cust_id =:cust_id";
        Query query = session.createQuery(hql);
//        query.setLong(0,2l);
        query.setParameter("cust_id",2l);
        List<Customer> list = query.list();//返回list
        System.out.print(list);
//        Object o = query.uniqueResult();//接受唯一的查询
        //根据HQL语句创建查询对象
        //根据查询对象获取查询结果

        transaction.commit();
        session.close();
    }
    //分页查询
    @Test
    public void fun4(){
        Session session= HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        //书写HQL语句
//        String hql="from com.fmt.hibernate.Customer";
//        String hql="from Customer ";//查询所有Custom对象
        String hql="from Customer ";
        Query query = session.createQuery(hql);
//        query.setLong(0,2l);
        query.setFirstResult(1);
        query.setMaxResults(3);
        List<Customer> list = query.list();//返回list
        System.out.print(list);
//        Object o = query.uniqueResult();//接受唯一的查询
        //根据HQL语句创建查询对象
        //根据查询对象获取查询结果

        transaction.commit();
        session.close();
    }
}
