package com.dmdk.common.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.WebFluxRequestHandlerProvider;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 类  名：com.dmdk.common.config.SwaggerConfig
 * 类描述： Swagger配置文件
 *      成分：
 *          * Docket类型的Bean：接口文档，可以多个Docket，可以自定义：文档信息(apiInfo[title、description])、接口集(apis[按照包、按照注解等])、请求头信息等.....
 * 创建人：张皓
 * 创建时间：2023/8/4 17:48
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @Author zhanghao
 * @Date    2023/8/4 17:48
 * @Version 1.0
 */
@Configuration
public class SwaggerConfig {

    /**
     * swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     *
     * @return Docket
     */
    @Bean
    public Docket commonApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("commonApi")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dmdk.common.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * swagger主页名
     *
     * @return ApiInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口文档")
                .description("swagger接口文档")
                .version("1.0")
                .build();
    }


    /**
     * 设置自定义swagger请求头
     * @return ApiKey
     */
//    @Bean
//    SecurityScheme securityScheme() {
//        return new ApiKey("Access-Token", "Access-Token", "header");
//    }

    /**
     * 新增 securityContexts 保持登录状态
     */
//    private List<SecurityContext> securityContexts() {
//        return new ArrayList(
//                Collections.singleton(SecurityContext.builder()
//                        .securityReferences(defaultAuth())
//                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
//                        .build())
//        );
//    }

    /**
     * 配置
     */
//    private List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return new ArrayList(
//                Collections.singleton(new SecurityReference("Access-Token", authorizationScopes)));
//    }


    /**
     * JWT token
     * @return setHeaderToken
     */
//    private List<Parameter> setHeaderToken() {
//        ParameterBuilder tokenPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<>();
//        tokenPar.name("Access-Token").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
//        pars.add(tokenPar.build());
//        return pars;
//    }

}


