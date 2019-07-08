package com.dmcq.product.service.impl;

import com.dmcq.product.domain.entity.ProductInfo;
import com.dmcq.product.domain.enums.ProductStatusEnum;
import com.dmcq.product.repository.ProductInfoRepository;
import com.dmcq.product.service.ProductInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Title ProductInfoServiceImpl
 * @Description TODO
 * @Author qinhao
 * @Date 2019/6/18 14:30
 **/
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Resource
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
