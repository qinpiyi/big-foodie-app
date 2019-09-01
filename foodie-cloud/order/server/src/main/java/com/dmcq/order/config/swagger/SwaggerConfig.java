package com.dmcq.order.config.swagger;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket createRestApi() {
        // 添加head参数token
        List<Parameter> pars = createParameters();

        Predicate<RequestHandler> selector = createSelector();

        return new Docket(DocumentationType.SWAGGER_2).groupName("后台界面接口").apiInfo(apiInfo()).select().apis(selector)
                .paths(PathSelectors.any()).build().globalOperationParameters(pars);
    }

    @Bean
    public Docket createMobileApi() {
        // 添加head参数token
        List<Parameter> pars = createParameters();

        Predicate<RequestHandler> selector = createSelector();

        return new Docket(DocumentationType.SWAGGER_2).groupName("手机端请求接口").apiInfo(mobileApiInfo()).select()
                .apis(selector).paths(PathSelectors.any()).build().globalOperationParameters(pars);
    }

    private List<Parameter> createParameters(){
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("token").description("令牌").modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }

    private Predicate<RequestHandler> createSelector(){
        String[] basePackages = new String[]{"com.dmcq.order.web"};
        return new Predicate<RequestHandler>() {
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
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("订单服务 RESTful APIs").description("后台api接口文档").version("1.2").build();
    }

    private ApiInfo mobileApiInfo() {
        return new ApiInfoBuilder().title("订单服务 RESTful APIs").description("手机api接口文档").version("1.2").build();
    }

}
