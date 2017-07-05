package com.fmt.ongl;

import com.fmt.api.User;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by 否命题 on 2017/7/5.
 */
public class TestDemo {

    @Test
    public void fun1() throws OgnlException {
        User rootUser=new User("root",12);

        HashMap<String, User> context = new HashMap<>();

        context.put("user1",new User("root1",13));

        context.put("user2",new User("root2",14));
        OgnlContext ognlContext = new OgnlContext();

        ognlContext.setRoot(rootUser);
        ognlContext.setValues(context);

        //取出root中user对象的name属性
        String name= (String) Ognl.getValue("name",context,ognlContext.getRoot());
        Integer age= (Integer) Ognl.getValue("age",context,ognlContext.getRoot());
       System.out.println(name+"age="+age);

       //#是从context中取值user1位键
        String name1= (String) Ognl.getValue("#user1.name",context,ognlContext.getRoot());
        Integer age1= (Integer) Ognl.getValue("#user1.age",context,ognlContext.getRoot());
        System.out.println(name1+"age="+age1);


        //修改Root中的值
        String name2= (String) Ognl.getValue("name='jack'",context,ognlContext.getRoot());
        Integer age2= (Integer) Ognl.getValue("age",context,ognlContext.getRoot());
        System.out.println(name2+"age="+age2);

        //修改Root中的值
        String name3= (String) Ognl.getValue("#user1.name='tom'",context,ognlContext.getRoot());
        Integer age3= (Integer) Ognl.getValue("#user1.age",context,ognlContext.getRoot());
        System.out.println(name3+"age="+age3);



        //调用root中的对象方法
        Ognl.getValue("setName('lilei')",context,ognlContext.getRoot());
        String name4= (String) Ognl.getValue("getName()",context,ognlContext.getRoot());
        System.out.println(name4);


        //调用map中的对象方法
        String name5= (String) Ognl.getValue("#user1.setName('11'),#user1.getName()",context,ognlContext.getRoot());
        System.out.println(name5);


        //调用静态方法
        String name6=(String)Ognl.getValue("@com.fmt.Utils@echo('hello world')",context,ognlContext.getRoot());
        System.out.println(name6);

        //调用静态方法
        Double pi=(Double)Ognl.getValue("@@PI",context,ognlContext.getRoot());
        System.out.println(pi);

        //创建对象
        Integer size= (Integer) Ognl.getValue("{'1','2','3','4'}.size()",context,ognlContext.getRoot());
        System.out.println(size);
        Character number= (Character) Ognl.getValue("{'1','2','3','4'}[2]",context,ognlContext.getRoot());
        System.out.println(number);
        Character number1= (Character) Ognl.getValue("{'1','2','3','4'}.get(2)",context,ognlContext.getRoot());
        System.out.println(number1);

        //创建map
        Integer map_size= (Integer) Ognl.getValue("#{'name':'tom','age':18}.size()",context,ognlContext.getRoot());
        System.out.println(map_size);
    }
}
