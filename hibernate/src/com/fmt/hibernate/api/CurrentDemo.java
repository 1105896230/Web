package com.fmt.hibernate.api;

import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by 林其望 on 2017/6/30.
 */
//通过getCurrentSession方法获得到的session当食物提交时，session会自动关闭，不要手动close关闭
public class CurrentDemo {

    @Test
    public void fun1(){
        Session currentSession = HibernateUtils.getCurrentSession();
        Session currentSession1 = HibernateUtils.getCurrentSession();
        Session session = HibernateUtils.openSession();
        System.out.println(currentSession==currentSession1);
        System.out.println(currentSession==session);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Session currentSession2 = HibernateUtils.getCurrentSession();
                Session currentSession3 = HibernateUtils.getCurrentSession();
                System.out.println(currentSession2==currentSession3);
            }
        });
        thread.run();
    }
}
