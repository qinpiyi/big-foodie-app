package com.dmcq.order.message.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Title MessageClient
 * @Description TODO
 * @Author qinhao
 * @Date 2019/8/19 13:12
 **/
public interface StreamClient {

    public static final String INPUT = "myMessage";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.INPUT)
    MessageChannel output();

    public static final String INPUT2 = "myMessage2";

    @Input(StreamClient.INPUT2)
    SubscribableChannel input2();

    @Output(StreamClient.INPUT2)
    MessageChannel output2();

}
