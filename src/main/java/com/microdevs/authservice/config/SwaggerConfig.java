package com.microdevs.authservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

public class SwaggerConfig {
    @Bean
    public GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder()
                .group("MicroDevs")
                .displayName("Micro Devs")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("User Service Application API")
                        .contact(new Contact()
                                .email("mertkaya2455@gmail.com")
                                .url("https://github.com/Micro-Devs/user-service")
                                .name("User Service Developer"))
                        .description("User Service Application Open Api Documentation")
                        .license(new License()
                                .name("Apache License Version 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0"))
                        .version("0.0.1-SNAPSHOT"));

    }
}
