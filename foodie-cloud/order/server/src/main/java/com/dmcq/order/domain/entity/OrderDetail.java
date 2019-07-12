package com.dmcq.order.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;



/**
* @Title OrderDetail
* @Description 订单商品详情
* @Author qinhao
* @Date 2019/7/2 10:36
**/
@Data
@Entity
public class OrderDetail {
	/**主键 */
	@Id
	@ApiModelProperty(value = "主键 ")
	private String detailId;

	/**订单ID */
	@ApiModelProperty(value = "订单ID ")
	private String orderId;

	/**商品ID */
	@ApiModelProperty(value = "商品ID ")
	private String productId;

	/** 商品名称 */
	@ApiModelProperty(value = "商品名称 ")
	private String productName;

	/** 当前价格,单位分 */
	@ApiModelProperty(value = "当前价格,单位分 ")
	private BigDecimal productPrice;

	/** 数量 */
	@ApiModelProperty(value = "数量 ")
	private Integer productQuantity;

	/** 小图 */
	@ApiModelProperty(value = "小图 ")
	private String productIcon;

	/** 创建时间 */
	@ApiModelProperty(value = "创建时间 ")
	private Date createTime;

	/** 修改时间 */
	@ApiModelProperty(value = "修改时间 ")
	private Date updateTime;

}