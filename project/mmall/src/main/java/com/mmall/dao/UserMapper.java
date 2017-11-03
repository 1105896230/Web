package com.mmall.dao;

import com.mmall.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUsername(String username);
    int checkEmail(String email);
    User selectLogin(@Param("username")String username,@Param("username")String password);

    String selectQuestionByUserName(String username);

    int checkAnswer(String username,String question,String answer);

    int updatePasswordByUser(@Param("username")String username,@Param("passwordnew") String password);

    int checkPassword(@Param("password")String password,@Param("userId")Integer userid);

    int checkEmailByUserId(@Param("emaill")String emaill,@Param("userId")Integer userId);
}