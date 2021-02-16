package com.safetyas.sds.client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOrigins("http://localhost:7000", "http://localhost:7001","http://127.0.0.1")
        .allowedMethods(HttpMethod.GET.name(), HttpMethod.PUT.name(), HttpMethod.POST.name(),
            HttpMethod.HEAD.name(), HttpMethod.PATCH.name(), HttpMethod.DELETE.name(),
            HttpMethod.OPTIONS.name());;
  }
}
