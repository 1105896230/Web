package com.fmt.hibernate.query;

import com.fmt.hibernate.Customer;
import com.fmt.hibernate.api.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

/**
 * Created by 林其望 on 2017/6/30.
 */
public class SqlDemo {



    @Test
    public void fun1(){
        Session session= HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        String sql="select * from cst_customer";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.addEntity(Customer.class);
        List list = sqlQuery.list();
        System.out.print(list);
//        List<Object[]> list = sqlQuery.list();
//        for (Object[] objs:list){
//            for (Object o:objs){
//                System.out.println(o);
//            }
//        }


        transaction.commit();
        session.close();
    }

    @Test
    public void fun2(){
        Session session= HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        String sql="select * from cst_customer where cust_id =?";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.setParameter(0,2l);
        sqlQuery.addEntity(Customer.class);
        List list = sqlQuery.list();
        System.out.print(list);


        transaction.commit();
        session.close();
    }

    @Test
    public void fun3(){
        Session session= HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        String sql="select * from cst_customer limit ?,?";
        SQLQuery sqlQuery = session.createSQLQuery(sql);

        sqlQuery.setParameter(0,0);
        sqlQuery.setParameter(1,1);
        sqlQuery.addEntity(Customer.class);
        List list = sqlQuery.list();
        System.out.print(list);



        transaction.commit();
        session.close();
    }
}
