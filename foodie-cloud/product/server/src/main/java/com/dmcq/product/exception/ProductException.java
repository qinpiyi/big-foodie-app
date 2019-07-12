package com.dmcq.product.exception;

import com.dmcq.product.domain.enums.ResultEnum;

/**
 * @Title ProductException
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/10 14:53
 **/
public class ProductException extends RuntimeException {
    private Integer code;

    public ProductException(Integer code,String message){
        super(message);
        this.code=code;
    }

    public ProductException(ResultEnum resultEnum){
        super(resultEnum.getText());
        this.code=resultEnum.getValue();
    }
}
