package com.mmall.controller.backend;

import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.ICategoryService;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by 林其望 on 2017/11/6.
 */
@Controller
@RequestMapping("/manage/category/")
public class CategoryManageController {

    @Autowired
    IUserService iUserService;

    @Autowired
    ICategoryService iCategoryService;

    @RequestMapping(value = "add_category.do" ,method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse addCategory(HttpSession session,String categoryName,@RequestParam(value = "parednId",defaultValue ="0") int parentId){
        User user= (User) session.getAttribute(Const.CURRENTUSER);
        if (user==null){
            return ServerResponse.createByErrorMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录");
        }
        ServerResponse<User> response = iUserService.checkAdminRole(user);
        if (response.isSuccess()){
          return iCategoryService.addCategory(categoryName,parentId);
        }else {
            return ServerResponse.createByErrorMessage("无权限处理");
        }

    }

    @RequestMapping("set_category_name.do")
    @ResponseBody
    public ServerResponse setCategoryName(HttpSession session,Integer categoryId,String categoryName){
        User user= (User) session.getAttribute(Const.CURRENTUSER);
        if (user==null){
            return ServerResponse.createByErrorMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录");
        }
        ServerResponse<User> response = iUserService.checkAdminRole(user);
        if (response.isSuccess()){
            return iCategoryService.updateCategoryName(categoryName,categoryId);
        }else {
            return ServerResponse.createByErrorMessage("无权限处理");
        }
    }
    @RequestMapping(value = "get_category.do" ,method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getChildrenParallelCategory(HttpSession session, @RequestParam(value = "categoryId", defaultValue= "0") Integer categoryId){
        User user= (User) session.getAttribute(Const.CURRENTUSER);
        if (user==null){
            return ServerResponse.createByErrorMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录");
        }
        ServerResponse<User> response = iUserService.checkAdminRole(user);
        if (response.isSuccess()){
            return iCategoryService.getChildrenParallerCaetgory(categoryId);
        }else {
            return ServerResponse.createByErrorMessage("无权限处理");
        }
    }
    @RequestMapping("get_deep_category.do")
    @ResponseBody
    public ServerResponse getCategoryAndDeepChildrenCategory(HttpSession session, @RequestParam(value = "categoryId", defaultValue= "0") Integer categoryId){
        User user= (User) session.getAttribute(Const.CURRENTUSER);
        if (user==null){
            return ServerResponse.createByErrorMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录");
        }
        ServerResponse<User> response = iUserService.checkAdminRole(user);
        if (response.isSuccess()){
            return iCategoryService.getChildrenAndChildrenById(categoryId);
        }else {
            return ServerResponse.createByErrorMessage("无权限处理");
        }
    }
}
