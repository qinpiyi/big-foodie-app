package com.dmcq.product.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        // 添加head参数start
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("Auth-Token").description("令牌").modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        pars.add(tokenPar.build());

        String[] basePackages = new String[]{"com.dmcq.product.web"};
        Predicate<RequestHandler> selector = new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler input) {
                String pkName = input.declaringClass().getPackage().getName();
                for (String basePackage : basePackages) {
                    if (pkName.startsWith(basePackage)) {
                        return true;
                    }
                }
                return false;
            }
        };

        return new Docket(DocumentationType.SWAGGER_2).groupName("后台界面接口").apiInfo(apiInfo()).select().apis(selector)
                .paths(PathSelectors.any()).build().globalOperationParameters(pars);
    }

    @Bean
    public Docket createMobileApi() {
        // 添加head参数start
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("Auth-Token").description("令牌").modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        pars.add(tokenPar.build());

        String[] basePackages = new String[]{"com.dmcq.product.web"};
        Predicate<RequestHandler> selector = new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler input) {
                String pkName = input.declaringClass().getPackage().getName();
                for (String basePackage : basePackages) {
                    if (pkName.startsWith(basePackage)) {
                        return true;
                    }
                }
                return false;
            }
        };

        return new Docket(DocumentationType.SWAGGER_2).groupName("手机端请求接口").apiInfo(mobileApiInfo()).select()
                .apis(selector).paths(PathSelectors.any()).build().globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("商品服务 RESTful APIs").description("后台api接口文档").version("1.1").build();
    }

    private ApiInfo mobileApiInfo() {
        return new ApiInfoBuilder().title("商品服务 RESTful APIs").description("手机api接口文档").version("1.1").build();
    }

}
