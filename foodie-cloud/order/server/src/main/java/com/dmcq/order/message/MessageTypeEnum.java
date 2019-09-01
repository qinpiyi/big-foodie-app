package com.dmcq.order.message;

import com.dmcq.order.domain.enums.ResultEnum;
import lombok.Getter;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Title MessageTypeEnum
 * @Description TODO
 * @Author qinhao
 * @Date 2019/8/13 10:09
 **/
@Getter
public enum MessageTypeEnum {
    TEST(100001,"测试"),
    ;

    private Integer value;

    private String text;

    MessageTypeEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public MessageTypeEnum getByValue(Integer value){
        return Arrays.asList(MessageTypeEnum.values())
                .stream()
                .filter(item -> item.getValue() == value)
                .collect(Collectors.toList())
                .get(0);
    }

    public MessageTypeEnum getByText(String text){
        return Arrays.asList(MessageTypeEnum.values())
                .stream()
                .filter(item -> item.getText() == text)
                .collect(Collectors.toList())
                .get(0);
    }
}
