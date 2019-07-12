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
public class ProductInfo implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = " ")
    @Id
    private String productId;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称 ")
    private String productName;

    /**
     * 单价
     */
    @ApiModelProperty(value = "单价 ")
    private BigDecimal productPrice;

    /**
     * 库存
     */
    @ApiModelProperty(value = "库存 ")
    private Integer productStock;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述 ")
    private String productDescription;

    /**
     * 小图
     */
    @ApiModelProperty(value = "小图 ")
    private String productIcon;

    /**
     * 商品状态,0正常1下架
     */
    @ApiModelProperty(value = "商品状态,0正常1下架 ")
    private Integer productStatus;

    /**
     * 类目编号
     */
    @ApiModelProperty(value = "类目编号 ")
    private Integer categoryType;

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