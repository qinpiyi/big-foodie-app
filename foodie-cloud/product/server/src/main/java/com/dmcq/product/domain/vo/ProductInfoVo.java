package com.dmcq.product.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Title ProductInfoVo
 * @Description TODO
 * @Author qinhao
 * @Date 2019/6/18 16:00
 **/
@Data
public class ProductInfoVo {

    @JsonProperty("id")
    private String productId;

    /**
     * 商品名称
     */
    @JsonProperty("name")
    private String productName;

    /**
     * 单价
     */
    @JsonProperty("price")
    private BigDecimal productPrice;

    /**
     * 描述
     */
    @JsonProperty("description")
    private String productDescription;

    /**
     * 小图
     */
    @JsonProperty("icon")
    private String productIcon;

}
