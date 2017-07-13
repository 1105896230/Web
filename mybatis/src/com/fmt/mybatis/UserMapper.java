package com.fmt.mybatis;

import com.fmt.mybatis.pojo.QueryVo;
import com.fmt.mybatis.pojo.User;

import java.util.List;

/**
 * Created by 否命题 on 2017/7/13.
 */
public interface UserMapper {

    //遵循4个原则
    //接口名字==User.xml中的id
    //返回类型与Mapper.xml中的返回类型一直
    //方法的入参与Mapper.xml的入参一致
    //命名空间绑定接口
    public User findUserById(Integer id);

    List<User> findUserByQueryVo(QueryVo vo);

    public Integer countUser();

}
