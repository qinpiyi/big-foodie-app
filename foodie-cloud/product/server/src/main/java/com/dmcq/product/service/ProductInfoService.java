package com.dmcq.product.service;

import com.dmcq.product.domain.dto.SimpleCartDto;
import com.dmcq.product.domain.entity.ProductInfo;

import java.util.List;

/**
 * @Title ProductInfoService
 * @Description TODO
 * @Author qinhao
 * @Date 2019/6/18 14:26
 **/
public interface ProductInfoService {

    /**
     * @param
     * @Title findUpAll
     * @Description 查询所有上架商品
     * @Return
     * @Author qinhao
     * @Date 2019/6/18 14:27
     **/
    public List<ProductInfo> findUpAll();

    /**
     * @Title findByIds
     * @Description 根据id列表查询商品信息列表
     * @Author qinhao
     * @Date 2019/7/10 14:26
     */
    public List<ProductInfo> findByIds(List<String> ids);

    public void deductStock(List<SimpleCartDto> list);
}
