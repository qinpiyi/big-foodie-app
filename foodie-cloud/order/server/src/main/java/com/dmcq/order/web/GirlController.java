package com.dmcq.order.web;

import com.dmcq.order.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title GirlController
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/29 20:09
 **/
@RestController
@RequestMapping("/girl")
public class GirlController {

    @Autowired
    private GirlConfig girlConfig;

    @GetMapping("/print")
    public String print(){
        return "name:"+girlConfig.getName()+" age:"+girlConfig.getAge();
    }
}
