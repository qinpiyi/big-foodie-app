package com.dmcq.order.domain.enums;

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
    PARAM_ERROR(1,"参数错误"),
    CART_EMPTY(2,"购物车为空"),
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
