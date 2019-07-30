package com.dmcq.order.web;


import com.dmcq.product.client.ProductClient;
import com.qinpiyi.common.response.CommonResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Title ClientController
 * @Description 跨服务通讯的四种方式
 * @Author qinhao
 * @Date 2019/7/8 19:42
 **/
@Api(value = "客户端管理",tags = "客户端")
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    //方式1(直接使用restTemplate，url写死)
    @GetMapping("/msg1")
    public CommonResponse productMsg1(){
        RestTemplate restTemplate = new RestTemplate();
        CommonResponse resp = restTemplate.getForObject("http://localhost:9002/server/msg", CommonResponse.class);
        System.out.println("1:"+resp.getMsg());
        return resp;
    }

    //方式2（使用loadBalancerClient通过应用名获取url，再使用restTemplate）
    @GetMapping("/msg2")
    public CommonResponse productMsg2(){
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance instance = loadBalancerClient.choose("PRODUCT-SERVER");
        String url = String.format("http://%s:%s", instance.getHost(), instance.getPort())+"/server/msg";
        System.out.println("url:"+url);
        CommonResponse resp=restTemplate.getForObject(url,CommonResponse.class);

        System.out.println("2: "+resp.getMsg());
        return resp;
    }

    //方式3（使用@LoadBalanced注解，restTemplate可使用应用名直接代替ip:port）
    @GetMapping("/msg3")
    public CommonResponse productMsg3(){
        CommonResponse resp=restTemplate.getForObject("http://PRODUCT-SERVER/server/msg",CommonResponse.class);
        System.out.println("3: "+resp.getMsg());
        return resp;
    }

    //方式4（使用feign）
//    @GetMapping("/msg4")
//    public CommonResponse productMsg4(){
//        CommonResponse resp = productClient.getMsg();
//        System.out.println("4: "+resp.getMsg());
//        return resp;
//    }
}
