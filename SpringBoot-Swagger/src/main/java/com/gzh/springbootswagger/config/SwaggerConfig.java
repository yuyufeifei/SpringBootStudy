package com.gzh.springbootswagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author GZH
 * @date 2021-12-11
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    //可设置多个Docket

    @Bean
    public Docket myDocket(Environment environment) {

        //设置只在开发环境使用
        Profiles profiles = Profiles.of("dev");
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())

                //是否启用
                .enable(flag)

                .groupName("GZH")

                .select()
                // basePackage：指定扫描的包
                // any()：扫描全部
                // none()：不扫描
                // withMethodAnnotation()：扫描方法上的注解
                // withClassAnnotation()：扫描类上的注解
                .apis(RequestHandlerSelectors.basePackage("com.gzh.springbootswagger.controller"))
                // ant()：过滤指定路径
                // any()：所有
                // none()：不过滤
                // regex()：过滤正则
                .paths(PathSelectors.ant("/userRecord/**"))

                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger3接口文档")
                .description("别动，不许动！")
                .version("1.0")
                .termsOfServiceUrl("https://yuyufeifei.github.io/")
                .contact(new Contact("GZH", "https://yuyufeifei.github.io/", "guozhihaochn@qq.com"))
                .license(ApiInfo.DEFAULT.getLicense())
                .licenseUrl(ApiInfo.DEFAULT.getLicenseUrl())
                .build();
    }

    @Bean
    public Docket defaultDocket() {
        return new Docket(DocumentationType.OAS_30).groupName("默认");
    }

}
