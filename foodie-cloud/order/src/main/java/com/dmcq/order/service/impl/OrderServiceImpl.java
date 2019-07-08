package com.dmcq.order.service.impl;

import com.dmcq.order.domain.dto.OrderDto;
import com.dmcq.order.domain.entity.OrderDetail;
import com.dmcq.order.domain.entity.OrderMaster;
import com.dmcq.order.domain.enums.OrderStatesEnum;
import com.dmcq.order.domain.enums.PayStatesEnum;
import com.dmcq.order.mapper.OrderDetailMapper;
import com.dmcq.order.mapper.OrderMasterMapper;
import com.dmcq.order.repository.OrderDetailRepository;
import com.dmcq.order.service.OrderService;
import com.dmcq.order.service.base.OrderDetailService;
import com.dmcq.order.service.base.OrderMasterService;
import com.dmcq.order.util.KeyUtil;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Title OrderServiceImpl
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/4 10:06
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private OrderMasterService orderMasterService;
    @Autowired
    OrderDetailRepository orderDetailRepository;

    /**
     * @Title create 创建订单
     *
     * TODO 1.查询商品信息（调用商品服务）
     * TODO 2.计算总价
     * TODO 3.扣库存（调用商品服务）
     * 4.订单入库
     */
    @Transactional
    @Override
    public OrderDto create(OrderDto orderDto) {
        // TODO 查询商品信息（调用商品服务）
        // TODO 计算总价
        // TODO 扣库存（调用商品服务）

        // 订单入库
        orderDto.setOrderId(KeyUtil.createKey());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDto,orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatesEnum.NEW);
        orderMaster.setPayStatus(PayStatesEnum.WAIT);

        List<OrderDetail> detailList = orderDto.getOrderDetailList();
        for(OrderDetail d:detailList){
            d.setDetailId(KeyUtil.createKey());
            d.setOrderId(orderMaster.getOrderId());
        }

        orderMasterService.insert(orderMaster);
        return orderDto;
    }
}
