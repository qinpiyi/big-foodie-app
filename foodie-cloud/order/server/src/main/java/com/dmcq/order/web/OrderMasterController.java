package com.dmcq.order.web;

import com.dmcq.order.domain.entity.OrderMaster;
import com.qinpiyi.common.controller.BaseController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title OrderDetailController
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/2 10:47
 **/
@Api(value = "订单基础管理",tags = "订单基础管理")
@RestController
@RequestMapping("/order/master")
public class OrderMasterController extends BaseController<OrderMaster> {
}
