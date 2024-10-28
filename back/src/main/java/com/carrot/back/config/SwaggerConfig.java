package com.carrot.back.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        final Info info = new Info()
                .title("carrot api")
                .version("0.1")
                .description("2024 OKR - DDD 설계");
        return new OpenAPI()
                .info(info);
    }
}
