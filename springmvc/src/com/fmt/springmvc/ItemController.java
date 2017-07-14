package com.fmt.springmvc;

import com.fmt.springmvc.pojo.Items;
import com.fmt.springmvc.pojo.User;
import com.fmt.springmvc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by 否命题 on 2017/7/13.
 */
@Controller
@RequestMapping(value = "/item")
public class ItemController {

//    @Autowired
//    ItemService itemService;
//
//    @RequestMapping(value = "/item/itemlist.action",method = {RequestMethod.POST,RequestMethod.GET})
//    public ModelAndView itemList(){
//        List<Items> itemselect = itemService.getItemselect();
//        ModelAndView mav=new ModelAndView();
//        mav.setViewName("itemList");
//        int i=1/0;
//        return mav;
//    }
//
//
//    @RequestMapping(value = "/item/paramer.action")
//    public ModelAndView getParamer(@RequestParam(value = "age",required = false,defaultValue = "1") int age,Integer id, String name){
//        System.out.println(id);
//        System.out.println(name);
//        List<Items> itemselect = itemService.getItemselect();
//        ModelAndView mav=new ModelAndView();
//        mav.setViewName("itemList");
//        return mav;
//    }
//    @RequestMapping(value = "/item/user.action")
//    public ModelAndView getUser(User user,Date date){
//        System.out.println(user);
//        ModelAndView mav=new ModelAndView();
//        mav.setViewName("itemList");
//        return mav;
//    }
//
//
//    @RequestMapping(value = "update.action")
//    public void file(MultipartFile file) throws IOException {
//        file.transferTo(new File("D:\\"));
//    }

    @RequestMapping(value = "/json.action")
    @ResponseBody
    public User json(@RequestBody  User user){
        return user;
    }
    @RequestMapping(value ="/itemEdit/{id}.action")
    public void test(@PathVariable Integer id){
    }


}
