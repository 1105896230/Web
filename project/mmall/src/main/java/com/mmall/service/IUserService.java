package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 * Created by 林其望 on 2017/11/2.
 */
public interface IUserService {
    ServerResponse<User> login(String username, String password);
    ServerResponse<String> register(User user);
    ServerResponse<String> checkVaild(String str,String type);
    ServerResponse forgetQuestion(String username);
    ServerResponse<String> checkAnswer(String username,String question,String answer);
    ServerResponse<String> forgetResetPassWord(String username,String password,String forgetToken);
    ServerResponse<String>  resetPassword(String passwordOld,String passwordnew,User user);
    ServerResponse<User> updateUserInfomations(User user);
    ServerResponse<User> getInformation(Integer userId);
}
