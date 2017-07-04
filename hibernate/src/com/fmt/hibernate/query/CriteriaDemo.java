package com.fmt.hibernate.query;

import com.fmt.hibernate.Customer;
import com.fmt.hibernate.api.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;

/**
 * Created by 林其望 on 2017/6/30.
 */
public class CriteriaDemo {


    @Test
    public void fun1(){
        Session session= HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        //查询所有Customer
        Criteria criteria = session.createCriteria(Customer.class);
        List<Customer> list = criteria.list();
        Customer customer = (Customer) criteria.uniqueResult();

        System.out.println(list);
        transaction.commit();
        session.close();
    }
    @Test
    /**
     * 条件查询
     * HQL中，不可能出现任何数据库相关的信息
     * >                gt
     * >=               ge
     * <                lt
     * <=               le
     * ==               eq
     * !=               ne
     * in               in
     * between and      between
     * like             like
     * is not null      isNotNull
     * is null          isNull
     * or               or
     * and              and
     */
    public void fun2(){
        Session session= HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        //查询所有Customer
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.ne("cust_id",2l));
        List<Customer> list = criteria.list();

        System.out.println(list);
        transaction.commit();
        session.close();
    }

    @Test
    /**
     * 分页
     */
    public void fun3(){
        Session session= HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        //查询所有Customer
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.setFirstResult(0);
        criteria.setMaxResults(2);
        List<Customer> list = criteria.list();

        System.out.println(list);
        transaction.commit();
        session.close();
    }

    //聚合函数
    @Test
    public void fun4(){
        Session session= HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        //查询所有Customer
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.setProjection(Projections.rowCount());
        Long number = (Long) criteria.uniqueResult();

        System.out.println(number);
        transaction.commit();
        session.close();
    }

    //离线查询
    @Test
    public void fun5(){
        DetachedCriteria dc=DetachedCriteria.forClass(Customer.class);
        dc.add(Restrictions.idEq(61));

        Session session= HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        Criteria executableCriteria = dc.getExecutableCriteria(session);
        List list = executableCriteria.list();
        System.out.print(list);
        transaction.commit();
        session.close();
    }
}
