package com.dmcq.product.common.entity;

import lombok.Data;

/**
 * @Title DeductStockInput
 * @Description 减库存入参
 * @Author qinhao
 * @Date 2019/7/12 9:12
 **/
@Data
public class DeductStockInput {
    /*商品Id*/
    private String productId;

    /*商品库存*/
    private Integer productQuantity;

    public DeductStockInput() {
    }

    public DeductStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
