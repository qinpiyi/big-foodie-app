package com.dmcq.order.web;

import com.dmcq.order.common.controller.BaseController;
import com.dmcq.order.domain.entity.OrderDetail;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title OrderDetailController
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/2 10:47
 **/
@Api(value = "订单商品基础详情",tags = "订单商品详情基础管理")
@RestController
@RequestMapping("/order/detail")
public class OrderDetailController extends BaseController<OrderDetail> {
}
