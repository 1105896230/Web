package com.mmall.controller.backend;

import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.pojo.User;
import com.mmall.service.IProductService;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by 林其望 on 2017/11/7.
 */
@Controller
@RequestMapping("/manage/product/")
public class ProductManagerController {
    @Autowired
    IUserService iUserService;

    @Autowired
    IProductService iProductService;
    @RequestMapping("save.do")
    @ResponseBody
    public ServerResponse productSave(HttpSession session, Product product){
        User user= (User) session.getAttribute(Const.CURRENTUSER);
        if (user==null){
            return ServerResponse.createByErrorMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录");
        }
        ServerResponse<User> response = iUserService.checkAdminRole(user);
        if (response.isSuccess()){
            return iProductService.saveOrUpdateProduct(product);
        }else {
            return ServerResponse.createByErrorMessage("无权限处理");
        }
    }

    @RequestMapping("set_sale_status.do")
    @ResponseBody
    public ServerResponse setSaleProduct(HttpSession session, Integer productId,Integer status){
        User user= (User) session.getAttribute(Const.CURRENTUSER);
        if (user==null){
            return ServerResponse.createByErrorMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录");
        }
        ServerResponse<User> response = iUserService.checkAdminRole(user);
        if (response.isSuccess()){
            return iProductService.setSaleStatus(productId,status);
        }else {
            return ServerResponse.createByErrorMessage("无权限处理");
        }
    }
}
