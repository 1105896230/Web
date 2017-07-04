package com.fmt.hibernate.manytomany;

import com.fmt.hibernate.Customer;
import com.fmt.hibernate.LinkMan;
import com.fmt.hibernate.api.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by 林其望 on 2017/7/4.
 */
public class Demo {

    @Test
    public void fun1(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();


        User u1=new User();
        u1.setUser_name("小明");
        User u2=new User();
        u2.setUser_name("小红");

        Role r1=new Role();
        r1.setRole_name("保洁");

        Role r2=new Role();
        r2.setRole_name("教师");


        //用户表达关系
        u1.getRoles().add(r1);
        u1.getRoles().add(r2);

        u2.getRoles().add(r1);
        u2.getRoles().add(r2);


        //角色表达关系
        r1.getUsers().add(u1);
        r1.getUsers().add(u2);

        r2.getUsers().add(u1);
        r2.getUsers().add(u2);

        session.save(u1);
        session.save(u2);
        session.save(r1);
        session.save(r2);

        transaction.commit();
        session.close();
    }


    //新增一个角色
    @Test
    public void fun2(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        User user = session.get(User.class, 13l);
        Role role = new Role();
        role.setRole_name("运动员");
        user.getRoles().add(role);

//        session.save(role);
        transaction.commit();
        session.close();
    }

    //解除角色
    @Test
    public void fun3(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        User user = session.get(User.class, 13l);

        Role role1 = session.get(Role.class, 11l);
        Role role2 = session.get(Role.class, 12l);
        user.getRoles().remove(role1);
        user.getRoles().remove(role2);
//        session.save(role);
        transaction.commit();
        session.close();
    }

}
