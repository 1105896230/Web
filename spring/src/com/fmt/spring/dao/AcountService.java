package com.fmt.spring.dao;

/**
 * Created by 林其望 on 2017/7/11.
 */
public interface AcountService {

    //转账方法
    void transfer(Integer from,Integer to,Double money);

}
