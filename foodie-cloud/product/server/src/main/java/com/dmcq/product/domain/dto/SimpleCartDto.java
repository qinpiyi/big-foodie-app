package com.dmcq.product.domain.dto;

import lombok.Data;

/**
 * @Title ProductStockDto
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/10 14:43
 **/
@Data
public class SimpleCartDto {
    /*商品Id*/
    private String productId;

    /*商品库存*/
    private Integer productQuantity;
}
