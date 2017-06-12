package com.demo.policy.policydetails.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by a.b.ahuja on 1/19/2017.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket policyDetailsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("PolicyDetails")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.demo.policy.policydetails"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Retrieve Policy Details")
                .description("Application to retrieve policies details")
                .version("1.0")
                .build();
    }
}
