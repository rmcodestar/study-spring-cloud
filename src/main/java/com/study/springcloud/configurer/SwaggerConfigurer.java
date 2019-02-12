package com.study.springcloud.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


/**
 * Created by rmcodestar on 2019. 2. 12..
 */
@Configuration
public class SwaggerConfigurer implements WebMvcConfigurer {
    @Bean
    public Docket api(ApiInfo apiInfo) {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.study.springcloud"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo);
    }

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Person Api Documentation")
                .contact(new Contact("rmcodestar", "https://rmcodestar.github.io/", "rmcodestar@naver.com"))
                .build();
    }
}
