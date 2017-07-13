package com.fmt.mybatis;

import com.fmt.mybatis.pojo.Orders;
import com.fmt.mybatis.pojo.QueryVo;
import com.fmt.mybatis.pojo.User;

import java.util.List;

/**
 * Created by 否命题 on 2017/7/13.
 */
public interface OrderMapper {
    List<Orders> selectOrderList();


    List<User> selectUserBySexAndUserName(User user);

    List<User> selectUserByIds(Integer[] ids);
    List<User> selectUserByIds(List<Integer> ids);
    List<User> selectUserByIds(QueryVo queryVo);


    //一对一关联 查询  以订单为中心 关联用户
    public List<Orders> selectOrders();

    //一对多关联
    public List<User> selectUserList();
}
