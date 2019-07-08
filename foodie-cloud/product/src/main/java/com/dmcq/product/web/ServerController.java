package com.dmcq.product.web;

import com.qinpiyi.common.response.CommonResponse;
import com.qinpiyi.common.response.CommonResponseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title ServerController
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/8 16:37
 **/
@RestController
@RequestMapping("/server")
public class ServerController {

    @GetMapping("/msg")
    public CommonResponse msg(){
        return CommonResponseUtil.success("This is a product msg!");
    }
}
