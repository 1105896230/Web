package com.fmt.mybatis.junit;

import com.fmt.mybatis.UserMapper;
import com.fmt.mybatis.pojo.QueryVo;
import com.fmt.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/*
 * Created by 否命题 on 2017/7/13.
 */
public class MyBatisTest {

    @Test
    public void fun1() throws IOException {
//        加载核心配置文件
        String resource="sqlMapConfig.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //创建sqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建sqlsession
        SqlSession sqlSession = factory.openSession();
        User o = sqlSession.selectOne("test.findUserById", 10);
        System.out.println(o);

        List<User> users=sqlSession.selectList("test.findUserByName","五");
        for (User u:users){
            System.out.println(u);
        }
    }
    @Test
    public void fun2() throws IOException {
//        加载核心配置文件
        String resource="sqlMapConfig.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //创建sqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建sqlsession
        SqlSession sqlSession = factory.openSession();
        User user = new User();
        user.setAddress("北京");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setUsername("富媒体");
        int i= sqlSession.insert("test.addUser",user);
        sqlSession.commit();

        Integer id = user.getId();
        System.out.println(id);
    }

    @Test
    public void fun3() throws IOException {
//        加载核心配置文件
        String resource="sqlMapConfig.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //创建sqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建sqlsession
        SqlSession sqlSession = factory.openSession();
        User user = new User();

        user.setAddress("上海");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setUsername("富媒体");
        user.setId(28);
        int i= sqlSession.update("test.updateUserById",user);
        sqlSession.commit();

    }

    @Test
    public void fun4() throws IOException {
//        加载核心配置文件
        String resource="sqlMapConfig.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //创建sqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建sqlsession
        SqlSession sqlSession = factory.openSession();
        int i= sqlSession.delete("test.deleteUserById",28);
        sqlSession.commit();
    }

    @Test
    public void fun5() throws IOException {
//        加载核心配置文件
        String resource="sqlMapConfig.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //创建sqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建sqlsession
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("五");
        queryVo.setUser(user);
        List<User> userByQueryVo = mapper.findUserByQueryVo(queryVo);
        for (User u:userByQueryVo){
            System.out.println(u);
        }
        System.out.println(mapper.countUser());
    }

}
