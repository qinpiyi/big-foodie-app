package com.dmcq.order.web;

import com.dmcq.order.domain.dto.OrderDto;
import com.dmcq.order.domain.entity.OrderDetail;
import com.dmcq.order.message.MessageTypeEnum;
import com.dmcq.order.message.MqMessage;
import com.dmcq.order.message.MqSender;
import com.dmcq.order.message.stream.StreamClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title EnvController
 * @Description 统一配置中心测试
 * @Author qinhao
 * @Date 2019/7/23 14:57
 **/
@Api(value = "MQ测试",tags = "MQ测试")
@RestController
@RequestMapping("/mq")
public class MqTestController {

    @Autowired
    private MqSender mqSender;

    @Autowired
    private StreamClient streamClient;

    @ApiOperation(value = "发送")
    @GetMapping("/print")
    public void send(OrderDetail order){
        mqSender.send(new MqMessage(order));
    }

    @ApiOperation(value = "发送")
    @GetMapping("/sendOrder")
    public void sendOrder(OrderDetail order){
        mqSender.sendOrder(new MqMessage(order));
    }

    @ApiOperation(value = "Stream发送")
    @GetMapping("/streamSend")
    public void streamSend(OrderDetail order){
        streamClient.output().send(MessageBuilder.withPayload(order).build());
    }
}
