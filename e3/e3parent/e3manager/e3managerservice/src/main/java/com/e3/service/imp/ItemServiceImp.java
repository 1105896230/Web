package com.e3.service.imp;

import com.e3.mapper.TbItemMapper;
import com.e3.pojo.TbItem;
import com.e3.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 林其望 on 2017/7/19.
 */
@Service
public class ItemServiceImp implements ItemService {

    @Autowired
    private TbItemMapper mapper;
    @Override
    public TbItem getItemById(long id) {
        return    mapper.selectByPrimaryKey(id);
    }
}
