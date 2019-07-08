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
public enum PayStatesEnum {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功"),
    ;

    private Integer value;

    private String text;

    PayStatesEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public PayStatesEnum getByValue(Integer value){
        return Arrays.asList(PayStatesEnum.values())
                .stream()
                .filter(item -> item.getValue() == value)
                .collect(Collectors.toList())
                .get(0);
    }

    public PayStatesEnum getByText(String text){
        return Arrays.asList(PayStatesEnum.values())
                .stream()
                .filter(item -> item.getText() == text)
                .collect(Collectors.toList())
                .get(0);
    }

}
