package com.abdel.stockmanagement.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.abdel.stockmanagement.utils.Constants.APP_ROOT;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public Docket api() {
        return new Docket(
                DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .description("STOCK MANAGEMENT API DOCUMENTATION")
                                .title("REST API STOCK MANAGEMENT")
                                .build()
                )
                .groupName("")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.abdel.stockmanagement"))
                .paths(PathSelectors.ant(APP_ROOT + "/**"))
                .build();
    }

}
