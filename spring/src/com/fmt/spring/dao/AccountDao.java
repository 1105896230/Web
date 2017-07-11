package com.fmt.spring.dao;

/**
 * Created by 林其望 on 2017/7/11.
 */
public interface AccountDao {

    void addMoney(Integer id,Double money);

    void decreaseMoeny(Integer id,Double money);

}
