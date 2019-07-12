package com.dmcq.product.repository;

import com.alibaba.fastjson.JSONArray;
import com.dmcq.product.domain.entity.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Title ProductInfoRepositoryTest
 * @Description TODO
 * @Author qinhao
 * @Date 2019/6/18 13:15
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> byProductStatus = productInfoRepository.findByProductStatus(0);
        String str = JSONArray.toJSONString(byProductStatus);
        System.out.println(str);
    }
}