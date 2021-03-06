package com.dmcq.product.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class OrderMaster implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = " ")
    @Id
    private String orderId;

    /**
     * 买家名字
     */
    @ApiModelProperty(value = "买家名字 ")
    private String buyerName;

    /**
     * 买家电话
     */
    @ApiModelProperty(value = "买家电话 ")
    private String buyerPhone;

    /**
     * 买家地址
     */
    @ApiModelProperty(value = "买家地址 ")
    private String buyerAddress;

    /**
     * 买家微信openid
     */
    @ApiModelProperty(value = "买家微信openid ")
    private String buyerOpenid;

    /**
     * 订单总金额
     */
    @ApiModelProperty(value = "订单总金额 ")
    private BigDecimal orderAmount;

    /**
     * 订单状态, 默认为新下单
     */
    @ApiModelProperty(value = "订单状态, 默认为新下单 ")
    private Byte orderStatus;

    /**
     * 支付状态, 默认未支付
     */
    @ApiModelProperty(value = "支付状态, 默认未支付 ")
    private Byte payStatus;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间 ")
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间 ")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

}