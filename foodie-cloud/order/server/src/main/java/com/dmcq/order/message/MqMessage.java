package com.dmcq.order.message;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

/**
 * @Title MqMessage
 * @Description TODO
 * @Author qinhao
 * @Date 2019/8/13 10:06
 **/
@Data
public class MqMessage implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer code;
    private String message;
    private Object data;

    public MqMessage(){
    }

    public MqMessage(String msg){
        JSONObject obj = JSONObject.parseObject(msg);
        code = (Integer)obj.get("code");
        message = (String)obj.get("message");
        data = obj.get("data");
    }

    public MqMessage(Object data,Integer code,String message){
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public MqMessage(Object data,MessageTypeEnum type){
        this.code = type.getValue();
        this.message = type.getText();
        this.data = data;
    }

    public MqMessage(Object data){
        this(data,MessageTypeEnum.TEST);
    }

    public String toString(){
        return JSONObject.toJSONString(this);
    }

}
