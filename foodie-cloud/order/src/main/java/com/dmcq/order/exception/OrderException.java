package com.dmcq.order.exception;

import com.dmcq.order.domain.enums.ResultEnum;

/**
 * @Title OrderException
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/5 15:08
 **/
public class OrderException extends RuntimeException {
    private Integer code;

    public OrderException(Integer code,String message){
        super(message);
        this.code=code;
    }

    public OrderException(ResultEnum resultEnum){
        super(resultEnum.getText());
        this.code=resultEnum.getValue();
    }
}
