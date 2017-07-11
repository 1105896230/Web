package com.fmt.ssh.service;

import com.fmt.ssh.domain.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by 林其望 on 2017/7/11.
 */
//为HibernateDaoSupport 注入sessionFactory
public class UserServiceImp extends HibernateDaoSupport implements UserService{


    @Override
    public User getUserByCodePassWord(String pwd) {
//        //hql
//      return   getHibernateTemplate().execute(session -> {
//            String hql="from User where user_code=?";
//            Query query = session.createQuery(hql);
//            query.setParameter(0,pwd);
//            User user = (User) query.uniqueResult();
//            return user;
//        });

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
        detachedCriteria.add(Restrictions.eq("user_code",pwd));
        List<User> criteria = (List<User>) getHibernateTemplate().findByCriteria(detachedCriteria);
        if (criteria!=null&&criteria.size()>0){
            return criteria.get(0);
        }
        return null;
    }
}
