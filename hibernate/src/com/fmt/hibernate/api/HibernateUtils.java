package com.fmt.hibernate.api;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by 林其望 on 2017/6/29.
 */
public class HibernateUtils {

    private static  SessionFactory sessionFactory;
    static {
        Configuration conf=new Configuration().configure();
        sessionFactory= conf.buildSessionFactory();
    }
    public static Session openSession(){
       return sessionFactory.openSession();
    }
    public static Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
}
