package com.dmcq.product.message;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public void sendStocks(String msg){
        amqpTemplate.convertAndSend("stockQueue",msg);
    }

}
