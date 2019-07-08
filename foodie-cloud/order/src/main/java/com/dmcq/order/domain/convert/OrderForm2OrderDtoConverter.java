package com.dmcq.order.domain.convert;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.dmcq.order.domain.dto.OrderDto;
import com.dmcq.order.domain.entity.OrderDetail;
import com.dmcq.order.domain.form.OrderForm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title OrderForm2OrderDto
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/5 15:27
 **/
public class OrderForm2OrderDtoConverter {

    public static OrderDto convert(OrderForm orderForm) {
        OrderDto dto=new OrderDto();
        dto.setBuyerName(orderForm.getName());
        dto.setBuyerAddress(orderForm.getAddress());
        dto.setBuyerPhone(orderForm.getPhone());
        dto.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList= JSONObject.parseArray(orderForm.getItems(), OrderDetail.class);
        dto.setOrderDetailList(orderDetailList);
        return dto;
    }
}
