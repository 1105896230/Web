package com.mmall.service.impl;

import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.mmall.common.TokenCache;
import com.mmall.dao.UserMapper;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import com.mmall.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.mmall.common.TokenCache.TOKEN_PREFIX;

/**
 * Created by 林其望 on 2017/11/2.
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public ServerResponse<User> login(String username, String password) {
        int resultCount=userMapper.checkUsername(username);
        if (resultCount==0){
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        User user=null;
        String md5PassWord=MD5Util.MD5EncodeUtf8(password);
        user=userMapper.selectLogin(username,md5PassWord);
        if (user==null){
            return ServerResponse.createByErrorMessage("密码错误");
        }
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功",user);
    }

    @Override
    public ServerResponse<String> register(User user) {
        ServerResponse<String> vaildResponse=this.checkVaild(user.getUsername(),Const.USERNAME);
        if (!vaildResponse.isSuccess()){
            return vaildResponse;
        }
        vaildResponse=this.checkVaild(user.getEmail(),Const.EMAIL);
        if (!vaildResponse.isSuccess()){
            return vaildResponse;
        }
        user.setRole(Const.Role.ROLE_CUSTOMER);
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        int resultCount=userMapper.insert(user);
        if (resultCount==0){
            return ServerResponse.createByErrorMessage("注册失败");
        }
        return ServerResponse.createBySuccessMessage("注册成功");
    }


    public ServerResponse<String> checkVaild(String str,String type){
        if (StringUtils.isNoneBlank(str)){
            int resultCount;
            if (Const.USERNAME.equals(type)){
                 resultCount=userMapper.checkUsername(str);
                if (resultCount>0){
                    return ServerResponse.createByErrorMessage("用户名已存在");
                }
            }
            if (Const.EMAIL.equals(type)){
                resultCount=userMapper.checkEmail(str);
                if (resultCount>0){
                    return ServerResponse.createByErrorMessage("改邮箱已存在");
                }
            }
        }else {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        return ServerResponse.createBySuccessMessage("校验成功");
    }


    public ServerResponse forgetQuestion(String username){
        ServerResponse<String> vaild = checkVaild(username, Const.USERNAME);
        if (vaild.isSuccess()){
            return ServerResponse.createByErrorMessage("用户不存在");
        }
        String question=userMapper.selectQuestionByUserName(username);
        if (StringUtils.isNoneBlank(question)){
            return ServerResponse.createBySuccess(question);
        }
        return ServerResponse.createByErrorMessage("找回密码的问题是空的");
    }

    public ServerResponse<String> checkAnswer(String username,String question,String answer){
        int resultCount=userMapper.checkAnswer(username,question,answer);
        if (resultCount>0){
            String forgentToken= UUID.randomUUID().toString();
            TokenCache.setKey(TOKEN_PREFIX+username,forgentToken);
            return ServerResponse.createBySuccess(forgentToken);
        }
        return ServerResponse.createByErrorMessage("答案错误");
    }

    public ServerResponse<String> forgetResetPassWord(String username,String password,String forgetToken){
        if (StringUtils.isBlank(forgetToken)){
            return ServerResponse.createByErrorMessage("需要传递forgetnToken");
        }
        ServerResponse<String> vaild = checkVaild(username, Const.USERNAME);
        if (vaild.isSuccess()){
            return ServerResponse.createByErrorMessage("用户不存在");
        }
        String tokenCache=TokenCache.getKey(TOKEN_PREFIX+username);
        if (StringUtils.isBlank(tokenCache)){
            return ServerResponse.createByErrorMessage("token无效或过期");
        }
        if (StringUtils.equals(tokenCache,forgetToken)){
            String md5=MD5Util.MD5EncodeUtf8(password);
            int rowCount=userMapper.updatePasswordByUser(username,md5);
            if (rowCount>0){
                return ServerResponse.createBySuccessMessage("修改密码成功");
            }
        }else {
            ServerResponse.createByErrorMessage("token 错误");
        }
        return ServerResponse.createByErrorMessage("修改密码失败");
    }

    public ServerResponse<String>  resetPassword(String passwordOld,String passwordnew,User user){
        int resultCount=userMapper.checkPassword(MD5Util.MD5EncodeUtf8(passwordOld),user.getId());
        if (resultCount==0){
            return ServerResponse.createByErrorMessage("旧密码错误");
        }
        user.setPassword(MD5Util.MD5EncodeUtf8(passwordnew));
        int updateCount=userMapper.updateByPrimaryKeySelective(user);
        if (updateCount>0){
            return ServerResponse.createBySuccessMessage("密码更新成功");
        }
        return ServerResponse.createByErrorMessage("密码更新失败");
    }
}
