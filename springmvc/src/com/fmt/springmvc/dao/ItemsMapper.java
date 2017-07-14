package com.fmt.springmvc.dao;

import com.fmt.springmvc.pojo.Items;

import java.util.List;

public interface ItemsMapper {

    List<Items> getItems();
}