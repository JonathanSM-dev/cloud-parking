package com.diocloudparking.config;

import io.swagger.annotations.AuthorizationScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;



@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
                //.apiInfo(metaData());
                //.securityContexts(Arrays.asList(getSecurityContext()));
                //.securitySchemes(Arrays.asList(basicAuthScheme()));
    }
    private SecurityScheme basicAuthScheme() {
        return new BasicAuth("basicAuth");
    }

    private SecurityContext getSecurityContext() {
        return SecurityContext.builder()
                .securityReferences(Arrays.asList(basicAuthReference()))
                .build();
    }

    private SecurityReference basicAuthReference() {
        return new SecurityReference("basicAuth", (springfox.documentation.service.AuthorizationScope[]) new AuthorizationScope[0]);
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Parking REST API")
                .description("Spring Boot REST API for Parking")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .build();
    }

}
