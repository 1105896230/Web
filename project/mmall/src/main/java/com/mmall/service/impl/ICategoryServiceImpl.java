package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mmall.common.ServerResponse;
import com.mmall.dao.CategoryMapper;
import com.mmall.pojo.Category;
import com.mmall.service.ICategoryService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by 林其望 on 2017/11/6.
 */
@Service("ICategoryService")
public class ICategoryServiceImpl implements ICategoryService {

    private org.slf4j.Logger logger= LoggerFactory.getLogger(ICategoryServiceImpl.class);
    @Autowired
    CategoryMapper categoryMapper;
    public ServerResponse addCategory(String categoryName,Integer parentId){
        if (parentId==null|| StringUtils.isBlank(categoryName)){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        Category category = new Category();

        category.setName(categoryName);
        category.setParentId(parentId);
        category.setStatus(true);
        int insert = categoryMapper.insert(category);
        if (insert>0){
            return ServerResponse.createBySuccessMessage("添加品类成功");
        }else {
            return ServerResponse.createByErrorMessage("添加失败");
        }
    }

    public ServerResponse updateCategoryName(String categoryName,Integer parentId){
        if (parentId==null|| StringUtils.isBlank(categoryName)){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        Category category = new Category();

        category.setName(categoryName);
        category.setParentId(parentId);

        int count = categoryMapper.updateByPrimaryKeySelective(category);
        if (count>0){
            return ServerResponse.createBySuccessMessage("更新成功");
        }else {
            return ServerResponse.createByErrorMessage("更新失败");
        }
    }

    public ServerResponse<List<Category>> getChildrenParallerCaetgory(Integer categoryId){
        List<Category> categories = categoryMapper.selectCategoryChildrenByParentId(categoryId);
        if (CollectionUtils.isEmpty(categories)){
            logger.info("未找到当前分类的子分类");
        }
        return ServerResponse.createBySuccess(categories);
    }

    public ServerResponse getChildrenAndChildrenById(Integer categoryId){
        Set<Category> categories= Sets.newHashSet();
        findChildCategory(categories,categoryId);

        ArrayList<Integer> objects = Lists.newArrayList();
        if (categoryId!=null){
            for (Category category:categories){
                objects.add(category.getId());
            }
        }
        return ServerResponse.createBySuccess(objects);
    }



    private Set<Category> findChildCategory(Set<Category>categories,Integer categoryId){
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        if (category!=null){
            categories.add(category);
        }
        List<Category> categoryList = categoryMapper.selectCategoryChildrenByParentId(categoryId);
        for (Category c:categoryList){
            findChildCategory(categories,c.getId());
        }
        return categories;
    }
}
