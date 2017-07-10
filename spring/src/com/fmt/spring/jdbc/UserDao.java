package com.fmt.spring.jdbc;

import java.util.List;

/**
 * Created by 林其望 on 2017/7/10.
 */
public interface UserDao {

    void save(User user);

    void find(Integer id);

    void delete(Integer id);

    void update(User user);

    int getTotalCount();

    List<User> getUserAll();
}
