package com.fmt.springmybatis.map;

import com.fmt.springmybatis.pojo.User;

/**
 * Created by 否命题 on 2017/7/13.
 */

public interface UserMap {

    public User findUserById(Integer id);
}
