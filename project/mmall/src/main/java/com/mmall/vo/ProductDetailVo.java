package com.mmall.vo;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 林其望 on 2017/11/7.
 */
public class ProductDetailVo {
    public Integer id;
    public Integer categoryId;
    public String name;
    public String subtitle;
    public String mainImage;
    public String subImages;
    public BigDecimal price;
    public Integer stock;
    public Integer status;
    public String detail;

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public void setSubImages(String subImages) {
        this.subImages = subImages;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String createTime;
    public String updateTime;
    private String imageHost;
    public Integer parentCategoryId;

}
