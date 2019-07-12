package com.dmcq.product.service;

import com.dmcq.product.domain.entity.ProductCategory;

import java.util.List;

/**
 * @Title ProductCategoryService
 * @Description TODO
 * @Author qinhao
 * @Date 2019/6/18 15:39
 **/
public interface ProductCategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
