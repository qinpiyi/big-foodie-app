package com.dmcq.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Title MqReceiver
 * @Description MQ接收端
 * @Author qinhao
 * @Date 2019/7/30 13:46
 **/
@Component
@Slf4j
public class MqReceiver {

    //1.需在mq管理页面中手动创建队列
    //@RabbitListener(queues = "myQueue")
    //2.自动创建队列
    @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    public void process(String message){
        log.info("MqReceiver: {}",message);
    }
}
