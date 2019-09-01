package com.dmcq.order.message;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.dmcq.product.common.entity.ProductInfoOutPut;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Title MqReceiver
 * @Description MQ接收端
 * @Author qinhao
 * @Date 2019/7/30 13:46
 **/
@Component
@Slf4j
public class MqReceiver {

    private static final String STOCK_KEY="PRODUCT_STOCK_%s";

    @Autowired
    StringRedisTemplate redisTemplate;

    //1.需在mq管理页面中手动创建队列
    //@RabbitListener(queues = "myQueue")
    //2.自动创建队列
    @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    public void process(MqMessage message){
        log.info("MqReceiver: {}",message);
//        MqMessage mqMessage = new MqMessage(message);
        System.out.println(message.getData());
    }

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "fruit",value = @Queue("fruitOrder")))
    public void processOrder(MqMessage message){
        log.info("MqReceiver: {}",message);
//        MqMessage mqMessage = new MqMessage(message);
        System.out.println(message.getData());
    }

    @RabbitListener(queuesToDeclare = @Queue("stockQueue"))
    public void processOrderStock(String message){
        List<ProductInfoOutPut> productInfoOutPutList = JSONObject.parseArray(message, ProductInfoOutPut.class);
//        productInfoOutPutList.stream().forEach(item -> {
//            redisTemplate.opsForValue().set(String.format(MqReceiver.STOCK_KEY,item.getProductId()),String.valueOf(item.getProductStock()));
//        });
        for(ProductInfoOutPut p:productInfoOutPutList){
            redisTemplate.opsForValue().set(
                    String.format(MqReceiver.STOCK_KEY,p.getProductId()),
                    String.valueOf(p.getProductStock()));
            System.out.println(String.format(MqReceiver.STOCK_KEY,p.getProductId()));
            System.out.println(p.getProductStock());
        }
    }
}
