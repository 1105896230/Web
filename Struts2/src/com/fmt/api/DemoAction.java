package com.fmt.api;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by 林其望 on 2017/7/5.
 */
public class DemoAction extends ActionSupport implements ServletRequestAware{

    HttpServletRequest request;
    @Override
    public String execute() throws Exception {

        //session域
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("name","session");
        //application
        Map<String, Object> application = ActionContext.getContext().getApplication();
        application.put("name","application");
        /**
         *  //request域（struct2并不推荐使用原生的request域中）
            Map<String, Object>  request = (Map<String, Object>) ActionContext.getContext().get("request");
         */
        //直接使用,推荐
        ActionContext.getContext().put("name","request域");

        return super.execute();
    }

    public String execute1() throws Exception {

        //原生的request
        javax.servlet.http.HttpServletRequest request = ServletActionContext.getRequest();

        //原生的Response
        HttpServletResponse response = ServletActionContext.getResponse();

        //原生的ServletContext
        ServletContext servletContext = ServletActionContext.getServletContext();

        //获取session对象
        HttpSession session = request.getSession();
        return super.execute();
    }


    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
         this.request=httpServletRequest;
    }


//    public User mUser=new User();
//    private String name;
//    public void get(){
//        System.out.println(mUser.toString());
//    }
//
//    @Override
//    public User getModel() {
//        return mUser;
//    }



//    public User getmUser() {
//        return mUser;
//    }
//
//    public void setmUser(User mUser) {
//        this.mUser = mUser;
//    }

    //    public String getName(){
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
}
