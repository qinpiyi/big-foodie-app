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

    public static final String INPUT = "myMessage_input";
    public static final String OUTPUT = "myMessage_output";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();

    public static final String INPUT1 = "myMessage1_input";
    public static final String OUTPUT1 = "myMessage1_output";

    @Input(StreamClient.INPUT1)
    SubscribableChannel input2();

    @Output(StreamClient.OUTPUT1)
    MessageChannel output2();

}
