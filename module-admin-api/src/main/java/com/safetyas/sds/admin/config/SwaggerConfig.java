package com.safetyas.sds.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.safetyas.sds.admin.api.controller"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false); //기본 세팅되는 200,401,403,404 표시 안함
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Sol-T.SDS API Documentation")
                .description("Sol-T.SDS apis")
                .license("all rights reserved sds.safety-as.com")
                .version("v1")
                .build();
    }
}
