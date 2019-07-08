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
public enum OrderStatesEnum {
    NEW(0,"新订单"),
    FINISH(1,"完结"),
    CANCEL(2,"取消"),
    ;

    private Integer value;

    private String text;

    OrderStatesEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public OrderStatesEnum getByValue(Integer value){
        return Arrays.asList(OrderStatesEnum.values())
                .stream()
                .filter(item -> item.getValue() == value)
                .collect(Collectors.toList())
                .get(0);
    }

    public OrderStatesEnum getByText(String text){
        return Arrays.asList(OrderStatesEnum.values())
                .stream()
                .filter(item -> item.getText() == text)
                .collect(Collectors.toList())
                .get(0);
    }

}
