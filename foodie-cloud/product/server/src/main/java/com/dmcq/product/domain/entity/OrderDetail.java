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
public class OrderDetail implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = " ")
    @Id
    private String detailId;

    /**
     *
     */
    @ApiModelProperty(value = " ")
    private String orderId;

    /**
     *
     */
    @ApiModelProperty(value = " ")
    private String productId;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称 ")
    private String productName;

    /**
     * 当前价格,单位分
     */
    @ApiModelProperty(value = "当前价格,单位分 ")
    private BigDecimal productPrice;

    /**
     * 数量
     */
    @ApiModelProperty(value = "数量 ")
    private Integer productQuantity;

    /**
     * 小图
     */
    @ApiModelProperty(value = "小图 ")
    private String productIcon;

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