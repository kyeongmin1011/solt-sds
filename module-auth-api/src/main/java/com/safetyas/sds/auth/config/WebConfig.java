package com.safetyas.sds.auth.config;

import lombok.ToString.Include;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpMethod.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  private static final long MAX_AGE_SECS = 3600;

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOrigins("*")
        .allowedHeaders("*")
        .allowedMethods(HttpMethod.GET.name(), HttpMethod.PUT.name(), HttpMethod.POST.name(),
            HttpMethod.HEAD.name(), HttpMethod.PATCH.name(), HttpMethod.DELETE.name(),
            HttpMethod.OPTIONS.name())
        .allowCredentials(true)
        .maxAge(MAX_AGE_SECS);
  }
}
