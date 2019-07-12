package com.dmcq.product.domain.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Title OrderState
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/3 13:29
 **/
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(1,"商品不存在"),
    OUT_OF_STOCK(2,"库存不足"),
    ;

    private Integer value;

    private String text;

    ResultEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public ResultEnum getByValue(Integer value){
        return Arrays.asList(ResultEnum.values())
                .stream()
                .filter(item -> item.getValue() == value)
                .collect(Collectors.toList())
                .get(0);
    }

    public ResultEnum getByText(String text){
        return Arrays.asList(ResultEnum.values())
                .stream()
                .filter(item -> item.getText() == text)
                .collect(Collectors.toList())
                .get(0);
    }

}
