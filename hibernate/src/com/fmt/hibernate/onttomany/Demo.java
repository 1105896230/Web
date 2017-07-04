package com.fmt.hibernate.onttomany;

import com.fmt.hibernate.Customer;
import com.fmt.hibernate.LinkMan;
import com.fmt.hibernate.api.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by 林其望 on 2017/7/4.
 */
//一对多|多对一关系操作
public class Demo {

    //保存客户及客户下的联系人
    @Test
    public void fun1(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();


        Customer customer = new Customer();
        customer.setCust_name("阿里");
        LinkMan linkMan=new LinkMan();
        linkMan.setLkm_name("马云1");
        LinkMan linkMan1=new LinkMan();
        linkMan1.setLkm_name("马云2");

        customer.getLinkMens().add(linkMan);
        customer.getLinkMens().add(linkMan1);

        session.save(customer);
//        session.save(linkMan);
//        session.save(linkMan1);
        transaction.commit();
        session.close();
    }

    //位客户添加联系人
    @Test
    public void fun2(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class, 18l);
        LinkMan linkMan = new LinkMan();
        linkMan.setLkm_name("马云3");
        customer.getLinkMens().add(linkMan);
        transaction.commit();
        session.close();
    }

    //位客户删除 联系人
    @Test
    public void fun3(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class, 18l);
        LinkMan linkMan = session.get(LinkMan.class, 9l);
        customer.getLinkMens().remove(linkMan);
        session.delete(linkMan);
        transaction.commit();
        session.close();
    }


    //级联删除客户
    @Test
    public void fun4(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.load(Customer.class, 18l);
        System.out.print(customer);
//        session.delete(customer);
        transaction.commit();
        session.close();
    }

}
