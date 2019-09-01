package com.dmcq.order.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title EnvController
 * @Description 统一配置中心测试
 * @Author qinhao
 * @Date 2019/7/23 14:57
 **/
@Api(value = "统一配置中心测试",tags = "统一配置中心测试")
@RestController
@RequestMapping("/env")
@RefreshScope
public class EnvController {

    @Value("${env}")
    private String env;

    @ApiOperation(value = "输出")
    @GetMapping("/print")
    public String print(){
        return env;
    }
}
