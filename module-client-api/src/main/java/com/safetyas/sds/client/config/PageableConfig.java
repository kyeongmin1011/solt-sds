package com.safetyas.sds.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;

@Configuration
public class PageableConfig {

  @Bean
  public PageableHandlerMethodArgumentResolverCustomizer customizer(){


    return p -> p.setOneIndexedParameters(true);
  }
}
