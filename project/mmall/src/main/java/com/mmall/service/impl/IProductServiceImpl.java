package com.mmall.service.impl;

import com.mmall.common.ServerResponse;
import com.mmall.dao.ProductMapper;
import com.mmall.pojo.Product;
import com.mmall.service.IProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by 林其望 on 2017/11/7.
 */
@Service("IProductService")
public class IProductServiceImpl implements IProductService {

    @Autowired
    ProductMapper productMapper;
    public ServerResponse saveOrUpdateProduct(Product product){
        if (product!=null){
            if (StringUtils.isNoneBlank(product.getSubImages())){
                String[] split = product.getSubImages().split(",");
                if (split.length>0){
                    product.setMainImage(split[0]);
                }
                if (product.getId()!=null){
                    productMapper.updateByPrimaryKeySelective(product);
                    return ServerResponse.createBySuccessMessage("更新成功");
                }else {
                    int insert = productMapper.insert(product);
                    if (insert>0){
                        return ServerResponse.createBySuccessMessage("增加成功");
                    }else {
                        return ServerResponse.createByErrorMessage("增加失败");
                    }
                }
            }
        }
        return ServerResponse.createByErrorMessage("product is null");
    }
    public ServerResponse setSaleStatus(Integer productId, Integer status){
        if (productId==null||status==null){
            return ServerResponse.createByErrorMessage("参数异常");
        }
        Product product = new Product();
        product.setId(productId);
        product.setStatus(status);
        int rowcount=productMapper.updateByPrimaryKeySelective(product);
        if (rowcount>0){
           return ServerResponse.createBySuccess("修改状态成功");
        }else {
            return ServerResponse.createByErrorMessage("修改状态失败");
        }
    }
}
