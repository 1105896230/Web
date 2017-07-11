package com.fmt.spring.dao;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.beans.Transient;

/**
 * Created by 林其望 on 2017/7/11.
 */
@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED)
public class AcountServiceImp implements AcountService{



    public void setAd(AccountDao ad) {
        this.ad = ad;
    }

    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    private AccountDao ad;
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void transfer(Integer from, Integer to, Double money) {
        ad.decreaseMoeny(from,money);
        int i=20/0;
        ad.addMoney(to,money);
//        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
//                ad.decreaseMoeny(from,money);
//                ad.addMoney(to,money);
//            }
//        });
    }
}
