package com.dmcq.order.domain.dto;

import com.dmcq.order.domain.entity.OrderDetail;
import com.dmcq.order.domain.enums.OrderStatesEnum;
import com.dmcq.order.domain.enums.PayStatesEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Title OrderService
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/4 9:53
 **/
@Data
public class OrderDto {
    /**订单ID */
    @ApiModelProperty(value = "订单ID ")
    private String orderId;

    /** 买家名字 */
    @ApiModelProperty(value = "买家名字 ")
    private String buyerName;

    /** 买家电话 */
    @ApiModelProperty(value = "买家电话 ")
    private String buyerPhone;

    /** 买家地址 */
    @ApiModelProperty(value = "买家地址 ")
    private String buyerAddress;

    /** 买家微信openid */
    @ApiModelProperty(value = "买家微信openid ")
    private String buyerOpenid;

    /** 订单总金额 */
    @ApiModelProperty(value = "订单总金额 ")
    private BigDecimal orderAmount;

    /** 订单状态, 默认为新下单 */
    @ApiModelProperty(value = "订单状态, 默认为新下单 ")
    private OrderStatesEnum orderStatus;

    /** 支付状态, 默认未支付 */
    @ApiModelProperty(value = "支付状态, 默认未支付 ")
    private PayStatesEnum payStatus;

    /**订单商品详情列表 */
    private List<OrderDetail> orderDetailList;
}
