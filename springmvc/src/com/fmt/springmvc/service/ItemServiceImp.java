package com.fmt.springmvc.service;

import com.fmt.springmvc.dao.ItemsMapper;
import com.fmt.springmvc.pojo.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 否命题 on 2017/7/13.
 */
@Service
public class ItemServiceImp implements ItemService {

    @Autowired
    private ItemsMapper itemsMapper;

     public List<Items> getItemselect(){
        return itemsMapper.getItems();
     }
}
