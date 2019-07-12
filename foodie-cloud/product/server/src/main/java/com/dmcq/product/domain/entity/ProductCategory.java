package com.dmcq.product.domain.entity;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class ProductCategory implements Serializable {
    /**
     * 类目ID
     */
    @ApiModelProperty(value = "类目ID ")
    @Id
    @GeneratedValue
    private Integer categoryId;

    /**
     * 类目名字
     */
    @ApiModelProperty(value = "类目名字 ")
    private String categoryName;

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