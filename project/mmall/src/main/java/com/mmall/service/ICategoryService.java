package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;

import java.util.List;

/**
 * Created by 林其望 on 2017/11/6.
 */
public interface ICategoryService {
    ServerResponse addCategory(String categoryName, Integer parentId);
    ServerResponse updateCategoryName(String categoryName,Integer parentId);
    ServerResponse<List<Category>> getChildrenParallerCaetgory(Integer categoryId);
    ServerResponse getChildrenAndChildrenById(Integer categoryId);
}
