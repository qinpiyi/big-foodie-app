package com.dmcq.product.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Title ProductCategoryVo
 * @Description TODO
 * @Author qinhao
 * @Date 2019/6/18 15:54
 **/
@Data
public class ProductCategoryVo {

    /**
     * 类目名字
     */
    @JsonProperty("name")
    private String categoryName;

    /**
     * 类目编号
     */
    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;
}
