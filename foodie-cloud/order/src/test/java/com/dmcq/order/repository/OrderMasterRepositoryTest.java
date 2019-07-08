package com.dmcq.order.repository;

import com.dmcq.order.OrderApplicationTests;
import com.dmcq.order.domain.entity.OrderMaster;
import com.dmcq.order.domain.enums.OrderStatesEnum;
import com.dmcq.order.domain.enums.PayStatesEnum;
import com.dmcq.order.util.KeyUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


/**
 * @Title OrderMasterRepositoryTest
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/8 14:12
 **/
@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave(){
        OrderMaster master = new OrderMaster();
        master.setOrderId(KeyUtil.createKey());
        master.setOrderAmount(new BigDecimal("5"));
        master.setPayStatus(PayStatesEnum.WAIT);
        master.setOrderStatus(OrderStatesEnum.NEW);
        master.setBuyerAddress("石门路1号");
        master.setBuyerName("张三");
        master.setBuyerOpenid("dhg12t43q12hahaiaug");
        master.setBuyerPhone("15645853256");
        OrderMaster save = orderMasterRepository.save(master);
        System.out.println(save);
    }
}