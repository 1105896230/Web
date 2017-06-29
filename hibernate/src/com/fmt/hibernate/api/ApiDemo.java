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
//学习Configuration 对象
    //Configuration功能：配置加载类，用于加载主配置，orm元数据加载
public class ApiDemo {


    @Test
    public void fun1(){
        //1创建，调用空参构造
        Configuration conf=new Configuration();
        //2读取配置文件,j加载src下的Hibernate.cfg.xml文件
        conf.configure();

        //根据配置，创建SessionFactory对象
        //SessionFaction就是用来创建Session的
        //sessionFactory 负责保存和使用所有配置信息，消耗内存资源较大
        //sessionFactory 属于线程安全的对象设计
        //所以SessionnFactory全局唯一
        SessionFactory sessionFactory = conf.buildSessionFactory();

        //session对象是表达hibernate框架与数据库之间的连接可以理解为JDBC中的connection对象，但同时可以操作sql，是hibernate的核心对象
        //获取Session
        Session session = sessionFactory.openSession();
        //获取线程绑定的session
//        Session currentSession = sessionFactory.getCurrentSession();

        //获取操作事务
//        Transaction transaction = session.getTransaction();
        //开启事务病获得操作事务（建议使用)
        Transaction transaction1 = session.beginTransaction();

        /*

        Customer customer=new Customer();
        customer.setCust_name("jd");
        session.save(customer);
         */


        Customer customer=new Customer();

        customer.setCust_name("jd");
        session.save(customer);

        transaction1.commit();//提交
//        transaction1.rollback();//回滚
        session.close();//释放资源
        sessionFactory.close();//释放资源

    }

    @Test
    //查询
    public void fun2(){
        //1创建，调用空参构造
        Configuration conf=new Configuration();
        //2读取配置文件,j加载src下的Hibernate.cfg.xml文件
        conf.configure();

        //根据配置，创建SessionFactory对象
        //SessionFaction就是用来创建Session的
        //sessionFactory 负责保存和使用所有配置信息，消耗内存资源较大
        //sessionFactory 属于线程安全的对象设计
        //所以SessionnFactory全局唯一
        SessionFactory sessionFactory = conf.buildSessionFactory();

        //session对象是表达hibernate框架与数据库之间的连接可以理解为JDBC中的connection对象，但同时可以操作sql，是hibernate的核心对象
        //获取Session
        Session session = sessionFactory.openSession();
        //获取线程绑定的session
//        Session currentSession = sessionFactory.getCurrentSession();

        //获取操作事务
//        Transaction transaction = session.getTransaction();
        //开启事务病获得操作事务（建议使用)
        Transaction transaction1 = session.beginTransaction();


        Customer customer = session.get(Customer.class, 1l);

        System.out.println(customer);
        transaction1.commit();//提交
//        transaction1.rollback();//回滚
        session.close();//释放资源
        sessionFactory.close();//释放资源

    }


    @Test
    //修改
    public void fun3(){
        //1创建，调用空参构造
        Configuration conf=new Configuration();
        //2读取配置文件,j加载src下的Hibernate.cfg.xml文件
        conf.configure();

        //根据配置，创建SessionFactory对象
        //SessionFaction就是用来创建Session的
        //sessionFactory 负责保存和使用所有配置信息，消耗内存资源较大
        //sessionFactory 属于线程安全的对象设计
        //所以SessionnFactory全局唯一
        SessionFactory sessionFactory = conf.buildSessionFactory();

        //session对象是表达hibernate框架与数据库之间的连接可以理解为JDBC中的connection对象，但同时可以操作sql，是hibernate的核心对象
        //获取Session
        Session session = sessionFactory.openSession();
        //获取线程绑定的session
//        Session currentSession = sessionFactory.getCurrentSession();

        //获取操作事务
//        Transaction transaction = session.getTransaction();
        //开启事务病获得操作事务（建议使用)
        Transaction transaction1 = session.beginTransaction();


        Customer customer = session.get(Customer.class, 1l);

        customer.setCust_name("百度");
        session.update(customer);
        transaction1.commit();//提交
//        transaction1.rollback();//回滚
        session.close();//释放资源
        sessionFactory.close();//释放资源

    }


    @Test
    //删除
    public void fun4(){
        //1创建，调用空参构造
        Configuration conf=new Configuration();
        //2读取配置文件,j加载src下的Hibernate.cfg.xml文件
        conf.configure();

        //根据配置，创建SessionFactory对象
        //SessionFaction就是用来创建Session的
        //sessionFactory 负责保存和使用所有配置信息，消耗内存资源较大
        //sessionFactory 属于线程安全的对象设计
        //所以SessionnFactory全局唯一
        SessionFactory sessionFactory = conf.buildSessionFactory();

        //session对象是表达hibernate框架与数据库之间的连接可以理解为JDBC中的connection对象，但同时可以操作sql，是hibernate的核心对象
        //获取Session
        Session session = sessionFactory.openSession();
        //获取线程绑定的session
//        Session currentSession = sessionFactory.getCurrentSession();

        //获取操作事务
//        Transaction transaction = session.getTransaction();
        //开启事务病获得操作事务（建议使用)
        Transaction transaction1 = session.beginTransaction();


        Customer customer = session.get(Customer.class, 1l);

        customer.setCust_name("百度");
        session.delete(customer);
        transaction1.commit();//提交
//        transaction1.rollback();//回滚
        session.close();//释放资源
        sessionFactory.close();//释放资源

    }
}
