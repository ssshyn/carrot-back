package com.carrot.back.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        SecurityScheme apiKey = new SecurityScheme()
                .type(SecurityScheme.Type.OAUTH2)
                .in(SecurityScheme.In.HEADER)
                .name(HttpHeaders.AUTHORIZATION)
                .scheme("bearer")
                .bearerFormat("JWT")
                .flows(
                        new OAuthFlows()
                                .password(
                                        new OAuthFlow()
                                                .authorizationUrl("/oauth2/authorize")
                                                .tokenUrl("/oauth2/token")
                                )
                );

        final Info info = new Info()
                .title("carrot api")
                .version("0.1")
                .description("2024 OKR - DDD 설계");

        return new OpenAPI()
                .components(new Components().addSecuritySchemes(HttpHeaders.AUTHORIZATION, apiKey))
                .info(info);
    }
}
