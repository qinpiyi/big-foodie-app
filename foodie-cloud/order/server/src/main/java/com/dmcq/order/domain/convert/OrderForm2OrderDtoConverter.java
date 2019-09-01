package com.dmcq.order.domain.convert;

import com.dmcq.order.domain.dto.OrderDto;
import com.dmcq.order.domain.entity.OrderDetail;
import com.dmcq.order.domain.form.OrderForm;
import com.dmcq.product.common.entity.DeductStockInput;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title OrderForm2OrderDto
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/5 15:27
 **/
@Slf4j
public class OrderForm2OrderDtoConverter {

    public static OrderDto convert(OrderForm orderForm) {
        OrderDto dto=new OrderDto();
        dto.setBuyerName(orderForm.getName());
        dto.setBuyerAddress(orderForm.getAddress());
        dto.setBuyerPhone(orderForm.getPhone());
        dto.setBuyerOpenid(orderForm.getOpenid());

//        List<OrderDetail> orderDetailList= JSONObject.parseArray(orderForm.getItems(), OrderDetail.class);
        List<OrderDetail> orderDetailList=new ArrayList<OrderDetail>();
        List<DeductStockInput> items = orderForm.getItems();

        for(DeductStockInput item:items){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProductId(item.getProductId());
            orderDetail.setProductQuantity(item.getProductQuantity());
            orderDetailList.add(orderDetail);
        }
        dto.setOrderDetailList(orderDetailList);
        return dto;
    }
}
