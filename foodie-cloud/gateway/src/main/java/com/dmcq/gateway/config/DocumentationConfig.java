package com.dmcq.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title DocumentationConfig
 * @Description Swagger整合API
 * @Author qinhao
 * @Date 2019/10/4 15:06
 **/
@EnableSwagger2
@Component
@Primary
public class DocumentationConfig  implements SwaggerResourcesProvider {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("#{'${swagger.apis}'.split(',')}")
    private List<String> apis;

    private final String docPath = "/v2/api-docs";
    private final String version = "2.0";

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        // 排除自身, 将其他的服务添加进去
//        discoveryClient.getServices().stream().filter(s -> !s.equals(applicationName)).forEach(name -> {
//            resources.add(swaggerResource(name, "/" + name + docPath, version));
//        });
        List<String> services = discoveryClient.getServices();
        //System.out.println(services);
        discoveryClient.getServices().stream().filter(s -> apis.contains(s)).forEach(name -> {
            resources.add(swaggerResource(name, "/" + name + docPath, version));
        });
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
