package org.hld.hugold;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Comparator;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * http://localhost:8080/swagger-ui/
 */
@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    @Bean
    public Docket itemApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.hld.hugold.controller"))
                .paths(regex("/customers.*"))
                .build()
                .apiInfo(metaData())
                .useDefaultResponseMessages(false);
        // .operationOrdering(Comparator.comparing(op -> op.getQueryParameters().first().getName()));
    }

    private ApiInfo metaData() {
        return new ApiInfo(
                "Spring Boot REST API CEFIM 2021",
                "Spring Boot REST API Exercise",
                "1.0",
                "Terms of service",
                new Contact("PYL", "https://legeay.info", "fake@email.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }
}