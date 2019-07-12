package com.dmcq.product.service;

import com.dmcq.product.ApplicationTest;
import com.dmcq.product.domain.entity.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title ProductCategoryServiceTest
 * @Description TODO
 * @Author qinhao
 * @Date 2019/6/18 15:41
 **/
public class ProductCategoryServiceTest extends ApplicationTest {

    @Autowired
    ProductCategoryService productCategoryService;

    @Test
    public void findByCategoryTypeIn() {
        ArrayList<Integer> categoryTypeList = new ArrayList<>();
        categoryTypeList.add(11);
        categoryTypeList.add(22);
        List<ProductCategory> list = productCategoryService.findByCategoryTypeIn(categoryTypeList);
        System.out.println(list);
    }

}