package com.dmcq.order.message;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Title MqSender
 * @Description RabbitMQ发送
 * @Author qinhao
 * @Date 2019/8/13 10:04
 **/
@Component
public class MqSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * @Title send
     * @Description 发送字符串
     * @Author qinhao
     * @Date 2019/8/13 10:35
     */
    public void send(String msg){
        amqpTemplate.convertAndSend("myQueue",msg);
    }

    /**
     * @Title send
     * @Description 发送实体类
     * @Author qinhao
     * @Date 2019/8/13 10:35
     */
    public void send(MqMessage msg){
        amqpTemplate.convertAndSend("myQueue",msg);
    }

    public void sendOrder(MqMessage msg){
        amqpTemplate.convertAndSend("myOrder","fruit",msg);
    }
}
