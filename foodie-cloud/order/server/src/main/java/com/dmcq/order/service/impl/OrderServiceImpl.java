package com.dmcq.order.service.impl;

import com.dmcq.order.domain.dto.OrderDto;
import com.dmcq.order.domain.entity.OrderDetail;
import com.dmcq.order.domain.entity.OrderMaster;
import com.dmcq.order.domain.enums.OrderStatesEnum;
import com.dmcq.order.domain.enums.PayStatesEnum;
import com.dmcq.order.repository.OrderDetailRepository;
import com.dmcq.order.service.OrderService;
import com.dmcq.order.service.base.OrderDetailService;
import com.dmcq.order.service.base.OrderMasterService;
import com.dmcq.order.util.KeyUtil;
import com.dmcq.product.client.ProductClient;
import com.dmcq.product.common.entity.DeductStockInput;
import com.dmcq.product.common.entity.ProductInfoOutPut;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    @Autowired
    ProductClient productClient;

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
        List<OrderDetail> detailList = orderDto.getOrderDetailList();
        // 查询商品信息（调用商品服务）
        List<String> productIds = detailList.stream().map(item -> item.getProductId()).collect(Collectors.toList());
        List<ProductInfoOutPut> productInfoList = productClient.quaryListByIds(productIds);
        Map<String, ProductInfoOutPut> productMap = productInfoList.stream().collect(Collectors.toMap(ProductInfoOutPut::getProductId, ProductInfoOutPut -> ProductInfoOutPut));

        // 构造数据对象，计算总价
        //构造orderMaster订单对象
        orderDto.setOrderId(KeyUtil.createKey());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDto,orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatesEnum.NEW);
        orderMaster.setPayStatus(PayStatesEnum.WAIT);
        //总价
        BigDecimal amount = new BigDecimal(0);
        //构建购物车
        ArrayList<DeductStockInput> simpleCartDtos = new ArrayList<>();
        for(OrderDetail d:detailList){
            ProductInfoOutPut productInfo = productMap.get(d.getProductId());
            BeanUtils.copyProperties(productInfo,d);
            d.setDetailId(KeyUtil.createKey());
            d.setOrderId(orderMaster.getOrderId());
            d.setCreateTime(null);
            d.setUpdateTime(null);

            simpleCartDtos.add(new DeductStockInput(d.getProductId(),d.getProductQuantity()));
            amount.add(productInfo.getProductPrice().multiply(new BigDecimal(d.getProductQuantity())));
        }
        // 扣库存（调用商品服务）
        productClient.deductStock(simpleCartDtos);
        // 订单入库
        orderDetailRepository.saveAll(detailList);
//        orderDetailService.batchInsert(detailList);
        orderMasterService.insert(orderMaster);
        return orderDto;
    }
}
