package com.dmcq.product.domain.entity;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class UserInfo implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = " ")
    @Id
    private String id;

    /**
     *
     */
    @ApiModelProperty(value = " ")
    private String username;

    /**
     *
     */
    @ApiModelProperty(value = " ")
    private String password;

    /**
     * 微信openid
     */
    @ApiModelProperty(value = "微信openid ")
    private String openid;

    /**
     * 1买家2卖家
     */
    @ApiModelProperty(value = "1买家2卖家 ")
    private Boolean role;

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