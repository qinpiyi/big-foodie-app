package com.dmcq.order;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Title GirlConfig
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/29 20:07
 **/
@Data
@Component
@ConfigurationProperties("girl")
@RefreshScope
public class GirlConfig {
    private String name;

    private Integer age;
}
