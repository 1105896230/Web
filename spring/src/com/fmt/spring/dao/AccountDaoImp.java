package com.fmt.spring.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by 林其望 on 2017/7/11.
 */
public class AccountDaoImp extends JdbcDaoSupport implements AccountDao {
    @Override
    public void addMoney(Integer id, Double money) {
        getJdbcTemplate().update("update t_account set money= money+? where id=?",money,id);
    }

    @Override
    public void decreaseMoeny(Integer id, Double money) {
        getJdbcTemplate().update("update t_account set money= money-? where id=?",money,id);
    }
}
