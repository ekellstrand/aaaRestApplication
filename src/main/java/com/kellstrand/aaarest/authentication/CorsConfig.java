package com.kellstrand.aaarest.authentication;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.kellstrand.aaarest.authentication.AuthenticationService.AUTH_TOKEN_HEADER_NAME;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply to all endpoints
                .allowedOrigins("http://example.com")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("Content-Type", "Authorization", AUTH_TOKEN_HEADER_NAME)
                .allowCredentials(true)
                .maxAge(3600);
    }
}