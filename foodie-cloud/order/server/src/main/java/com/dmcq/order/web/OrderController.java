package com.dmcq.order.web;


import com.dmcq.order.common.response.CommonResponse;
import com.dmcq.order.common.response.CommonResponseUtil;
import com.dmcq.order.domain.convert.OrderForm2OrderDtoConverter;
import com.dmcq.order.domain.dto.OrderDto;
import com.dmcq.order.domain.enums.ResultEnum;
import com.dmcq.order.domain.form.OrderForm;
import com.dmcq.order.exception.OrderException;
import com.dmcq.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Title OrderController
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/4 9:14
 **/
@Api(value = "订单管理接口",tags = "订单管理接口")
@RequestMapping("/order")
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;
    /**
     * @Title create 创建订单
     *
     * TODO 1.参数校验
     * TODO 2.查询商品信息（调用商品服务）
     * TODO 3.计算总价
     * TODO 4.扣库存（调用商品服务）
     * 5.订单入库
     */
    @ApiOperation(value = "创建订单")
    @PostMapping("/create")
    public CommonResponse create(@Valid @RequestBody OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确，orderForm={}",orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getValue(),bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDto dto = OrderForm2OrderDtoConverter.convert(orderForm);
        if(CollectionUtils.isEmpty(dto.getOrderDetailList())){
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }
        OrderDto result = orderService.create(dto);
        return CommonResponseUtil.success(result);
    }

}
