package com.dmcq.product.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Title ProductInfoOutPut
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/11 15:29
 **/
@Data
public class ProductInfoOutPut {
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
}
