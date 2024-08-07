package com.projects.coursecenter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig {

    @Value("${cors.allowedHeaders}")
    private String allowedHeaders;

    @Value("${cors.allowedMethods}")
    private String allowedMethods;

    @Value("${cors.corsConfiguration}")
    private String corsConfiguration;

    @Value("${cors.allowedOrigin}")
    private String allowedOrigins;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(final CorsRegistry registry) {
                registry.addMapping(corsConfiguration)
                        .allowedHeaders(allowedHeaders)
                        .allowedMethods(allowedMethods)
                        .allowedOrigins(allowedOrigins);
            }
        };
    }

}
