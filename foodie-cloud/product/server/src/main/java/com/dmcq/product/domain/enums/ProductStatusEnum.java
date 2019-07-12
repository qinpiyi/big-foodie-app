package com.dmcq.product.domain.enums;

import lombok.Getter;

/**
 * @Title ProductStatusEnum
 * @Description 商品上下架状态
 * @Author qinhao
 * @Date 2019/6/18 14:45
 **/
@Getter
public enum ProductStatusEnum {
    UP(0, "上架"),
    DOWN(1, "下架"),
    ;
    private Integer code;

    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
