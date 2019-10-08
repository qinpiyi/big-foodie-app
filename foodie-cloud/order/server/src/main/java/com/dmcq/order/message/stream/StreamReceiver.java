package com.dmcq.order.message.stream;

import com.dmcq.order.message.MqMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @Title StreamReceiver
 * @Description TODO
 * @Author qinhao
 * @Date 2019/8/19 13:19
 **/
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.INPUT1)
    public String process(Object message){
        log.info("StreamMessage: {}",message);
        return "received!";
    }

    @StreamListener(StreamClient.INPUT1)
    public void process2(Object message){
        log.info("StreamMessage2: {}",message);
    }
}
