package com.fmt.mybatis.junit;

import com.fmt.mybatis.OrderMapper;
import com.fmt.mybatis.pojo.Orders;
import com.fmt.mybatis.pojo.QueryVo;
import com.fmt.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/*
 * Created by 否命题 on 2017/7/13.
 */
public class MyOrderTest {

    @Test
    public void fun1() throws IOException {
//        加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //创建sqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建sqlsession
        SqlSession sqlSession = factory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Orders> orders = mapper.selectOrderList();
        for (Orders or:orders){
            System.out.println(or);
        }
    }

    @Test
    public void fun2() throws IOException {
//        加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //创建sqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建sqlsession
        SqlSession sqlSession = factory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        User user = new User();
//        user.setSex("1");
        user.setUsername("张小明");
        List<User> users = mapper.selectUserBySexAndUserName(user);
        for (User or:users){
            System.out.println(or);
        }
    }

    @Test
    public void fun3() throws IOException {
//        加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //创建sqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建sqlsession
        SqlSession sqlSession = factory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        QueryVo queryVo = new QueryVo();
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(24);
        integers.add(22);
        queryVo.setList_ids(integers);

        List<User> users = mapper.selectUserByIds(queryVo);
        for (User or:users){
            System.out.println(or);
        }
    }

    @Test
    public void fun4() throws IOException {
//        加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //创建sqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建sqlsession
        SqlSession sqlSession = factory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        Integer[] integers=new Integer[2];
        integers[0]=24;
        integers[1]=22;

        List<User> users = mapper.selectUserByIds(integers);
        for (User or:users){
            System.out.println(or);
        }
    }

    @Test
    public void fun5() throws IOException {
//        加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //创建sqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建sqlsession
        SqlSession sqlSession = factory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<Orders> selectOrdersList = mapper.selectOrders();

        for (Orders orders : selectOrdersList) {
            System.out.println(orders);
        }

    }

    @Test
    public void fun6() throws IOException {
//        加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //创建sqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建sqlsession
        SqlSession sqlSession = factory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<User> users = mapper.selectUserList();
        for (User user : users) {
            System.out.println(user);
        }

    }
}

