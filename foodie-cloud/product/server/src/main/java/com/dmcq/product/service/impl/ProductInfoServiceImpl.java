package com.dmcq.product.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dmcq.product.common.entity.ProductInfoOutPut;
import com.dmcq.product.domain.dto.SimpleCartDto;
import com.dmcq.product.domain.entity.ProductInfo;
import com.dmcq.product.domain.enums.ProductStatusEnum;
import com.dmcq.product.domain.enums.ResultEnum;
import com.dmcq.product.exception.ProductException;
import com.dmcq.product.message.MqSender;
import com.dmcq.product.repository.ProductInfoRepository;
import com.dmcq.product.service.ProductInfoService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Autowired
    MqSender mqSender;


    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findByIds(List<String> ids) {
        return productInfoRepository.findProductInfosByProductIdIn(ids);
    }

    @Override
    public void deductStock(List<SimpleCartDto> list) {
        List<ProductInfoOutPut> productInfoOutPutList = deductStockProcess(list);
        if(!productInfoOutPutList.isEmpty()){
            String s = JSONObject.toJSONString(productInfoOutPutList);
            mqSender.sendStocks(s);
        }
    }

    @Transactional
    public List<ProductInfoOutPut> deductStockProcess(List<SimpleCartDto> list) {
        List<ProductInfoOutPut> productInfoOutPutList = new ArrayList<>();
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
            ProductInfoOutPut productInfoOutPut = new ProductInfoOutPut();
            BeanUtils.copyProperties(productInfo,productInfoOutPut);
            productInfoOutPutList.add(productInfoOutPut);
        }
        return productInfoOutPutList;
    }
}
