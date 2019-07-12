package com.dmcq.product.service.impl;

import com.dmcq.product.domain.entity.ProductCategory;
import com.dmcq.product.repository.ProductCategoryRepository;
import com.dmcq.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title ProductCategoryServiceImpl
 * @Description TODO
 * @Author qinhao
 * @Date 2019/6/18 15:40
 **/
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
