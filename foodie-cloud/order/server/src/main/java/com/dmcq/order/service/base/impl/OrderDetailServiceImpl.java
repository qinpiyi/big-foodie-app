package com.dmcq.order.service.base.impl;

import com.dmcq.order.domain.entity.OrderDetail;
import com.dmcq.order.service.base.OrderDetailService;
import com.qinpiyi.common.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title OrderDetailServiceImpl
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/2 10:46
 **/
@Service
public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail> implements OrderDetailService {
    @Override
    public List<OrderDetail> batchInsert(List<OrderDetail> objs) {
        mapper.insertList(objs);
        return objs;
    }
}
