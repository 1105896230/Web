package com.fmt.springmvc.service;

import com.fmt.springmvc.pojo.Items;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 否命题 on 2017/7/13.
 */
@Service
public interface ItemService {

    List<Items> getItemselect();

}
