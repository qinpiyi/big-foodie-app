package com.dmcq.order.repository;

import com.dmcq.order.domain.entity.OrderDetail;
import com.dmcq.order.domain.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Title OrderDetailRepository
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/8 14:08
 **/
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
