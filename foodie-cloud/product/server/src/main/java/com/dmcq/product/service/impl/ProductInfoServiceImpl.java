package com.dmcq.product.service.impl;

import com.dmcq.product.domain.dto.SimpleCartDto;
import com.dmcq.product.domain.entity.ProductInfo;
import com.dmcq.product.domain.enums.ProductStatusEnum;
import com.dmcq.product.domain.enums.ResultEnum;
import com.dmcq.product.exception.ProductException;
import com.dmcq.product.repository.ProductInfoRepository;
import com.dmcq.product.service.ProductInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<ProductInfo> findByIds(List<String> ids) {
        return productInfoRepository.findProductInfosByProductIdIn(ids);
    }

    @Transactional
    @Override
    public void deductStock(List<SimpleCartDto> list) {
        for (SimpleCartDto dto:list){
            Optional<ProductInfo> optional = productInfoRepository.findById(dto.getProductId());
            if(!optional.isPresent()){
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = optional.get();
            int stock=productInfo.getProductStock()-dto.getProductQuantity();
            if(stock<0){
                throw new ProductException(ResultEnum.OUT_OF_STOCK);
            }
            productInfo.setProductStock(stock);
            productInfoRepository.save(productInfo);
        }
    }
}
