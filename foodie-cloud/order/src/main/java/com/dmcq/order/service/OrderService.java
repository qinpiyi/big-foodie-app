package com.dmcq.order.service;

import com.dmcq.order.domain.dto.OrderDto;

/**
 * @Title OrderService
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/4 9:11
 **/
public interface OrderService {

    /**
    * @Title create
    * @Description 创建订单
    * @param orderDto
    * @Return
    * @Author qinhao
    * @Date 2019/7/4 10:04
    **/
    OrderDto create(OrderDto orderDto);

}
