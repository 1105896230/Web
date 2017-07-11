package com.fmt.ssh.service;

import com.fmt.ssh.domain.User;

/**
 * Created by 林其望 on 2017/7/11.
 */
public interface UserService {

    User getUserByCodePassWord(String pwd);
}
