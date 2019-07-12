package com.dmcq.order.domain.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * @Title OrderForm
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/5 14:25
 **/
@Data
public class OrderForm {
    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "手机号必填")
    private String phone;

    @NotEmpty(message = "地址必填")
    private String address;

    @NotEmpty(message = "openid必填")
    private String openid;

    @NotEmpty(message = "购物车不可为空")
    private List<SimpleCartDto> items;
}
