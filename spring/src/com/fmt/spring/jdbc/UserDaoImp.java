package com.fmt.spring.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by 林其望 on 2017/7/10.
 */
public class UserDaoImp extends JdbcDaoSupport implements UserDao {


    @Override
    public void save(User user) {
        String sql="insert into t_user values(null,?)";
        super.getJdbcTemplate().update(sql,user.name);
    }

    @Override
    public void find(Integer id) {
        String sql="select * from t_user where id=?";
        super.getJdbcTemplate().queryForObject(sql, (resultSet, i) -> {
            User user = new User();
            user.id=resultSet.getInt("id");
            user.name=resultSet.getString("name");
            return user;
        }, id);
    }

    @Override
    public void delete(Integer id) {
        String sql="delete from t_user where id=?";
        super.getJdbcTemplate().update(sql,1);
    }

    @Override
    public void update(User user) {
        String sql="update  t_user set name=? where id=? ";
        super.getJdbcTemplate().update(sql,user.name,user.id);
    }

    @Override
    public int getTotalCount() {
        String sql="select count(*) from t_user";
        Integer integer =   super.getJdbcTemplate().queryForObject(sql, Integer.class);
        return integer;
    }

    @Override
    public List<User> getUserAll() {
        String sql="select * from t_user";
        List<User> list =   super.getJdbcTemplate().query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.id = resultSet.getInt("id");
                user.name = resultSet.getString("name");
                return user;
            }
        });
        return list;
    }
}
