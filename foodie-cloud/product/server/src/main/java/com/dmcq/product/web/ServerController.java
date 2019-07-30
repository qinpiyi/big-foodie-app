package com.dmcq.product.web;

import com.qinpiyi.common.response.CommonResponse;
import com.qinpiyi.common.response.CommonResponseUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title ServerController
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/8 16:37
 **/
@Api(value = "服务",tags = "服务")
@RestController
@RequestMapping("/server")
public class ServerController {

    @GetMapping("/msg")
    public CommonResponse msg(){
        return CommonResponseUtil.success("This is a product msg!");
    }

    @GetMapping("/msg1")
    public CommonResponse msg1(){
        return CommonResponseUtil.success("This is a product msg1111!");
    }

}
