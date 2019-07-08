package com.dmcq.product.service;

import com.dmcq.product.ApplicationTest;
import com.dmcq.product.domain.entity.ProductInfo;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.List;

/**
 * @Title ProductInfoServiceTest
 * @Description TODO
 * @Author qinhao
 * @Date 2019/6/18 14:58
 **/
public class ProductInfoServiceTest extends ApplicationTest {

    @Resource
    ProductInfoService productInfoService;

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productInfoService.findUpAll();
        System.out.println(list);
    }

}