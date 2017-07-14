package com.fmt.springmvc;

import com.fmt.springmvc.pojo.Items;
import com.fmt.springmvc.pojo.User;
import com.fmt.springmvc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

import java.util.Date;
import java.util.List;

/**
 * Created by 否命题 on 2017/7/13.
 */
@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/item/itemlist.action")
    public ModelAndView itemList(){
        List<Items> itemselect = itemService.getItemselect();
        ModelAndView mav=new ModelAndView();
        mav.setViewName("itemList");
        return mav;
    }


    @RequestMapping(value = "/item/paramer.action")
    public ModelAndView getParamer(@RequestParam(value = "age",required = false,defaultValue = "1") int age,Integer id, String name){
        System.out.println(id);
        System.out.println(name);
        List<Items> itemselect = itemService.getItemselect();
        ModelAndView mav=new ModelAndView();
        mav.setViewName("itemList");
        return mav;
    }
    @RequestMapping(value = "/item/user.action")
    public ModelAndView getUser(User user,Date date){
        System.out.println(user);
        ModelAndView mav=new ModelAndView();
        mav.setViewName("itemList");
        return mav;
    }

}
