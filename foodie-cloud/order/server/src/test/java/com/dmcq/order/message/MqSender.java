package com.dmcq.order.message;

import com.dmcq.order.OrderApplicationTests;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Title MqSender
 * @Description MQ发送测试
 * @Author qinhao
 * @Date 2019/7/30 13:53
 **/
@Component
public class MqSender extends OrderApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void sendMessage(){
        amqpTemplate.convertAndSend("myQueue","now:"+new Date());
    }
}
