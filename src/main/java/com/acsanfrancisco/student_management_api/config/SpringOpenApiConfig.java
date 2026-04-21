package com.acsanfrancisco.student_management_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringOpenApiConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Rest API - Students Management")
                        .description("REST API designed for managing students and their course enrollments, supporting CRUD operations, enrollment tracking, and academic records management.")
                        .version("V1"));
    }
}
