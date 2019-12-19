package com.ideyatech.opentides.um.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;




@EnableSwagger2
@Configuration
//@PropertySource("classpath:/swagger.properties")
public class SwaggerConfig {

@Bean
public Docket proposalApis(){
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
           // .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
            .apis(RequestHandlerSelectors.basePackage("com.ideyatech.opentides.um.controller"))
           // .apis(RequestHandlerSelectors.basePackage("com.gamify.elearning.controller"))
            .build()
            .apiInfo(testApiInfo());
}

private ApiInfo testApiInfo() {
    ApiInfo apiInfo = new ApiInfoBuilder().title("Elearning APIs").description("GET POST PUT methods are supported ").version("V1").build();
    return apiInfo;
}


}