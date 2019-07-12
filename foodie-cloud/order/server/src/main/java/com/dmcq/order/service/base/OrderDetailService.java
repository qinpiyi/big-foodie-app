package com.dmcq.order.service.base;

import com.dmcq.order.common.service.BaseService;
import com.dmcq.order.domain.entity.OrderDetail;

import java.util.List;

/**
 * @Title OrderDetailService
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/2 10:41
 **/
public interface OrderDetailService extends BaseService<OrderDetail> {

    List<OrderDetail> batchInsert(List<OrderDetail> objs);
}
