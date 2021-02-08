package com.safetyas.sds.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@ComponentScan("com.safetyas.sds")
@EnableJpaRepositories("com.safetyas.sds.common.repository")
@EntityScan("com.safetyas.sds.common.entity")
@SpringBootApplication
public class ClientApplication {
  public static void main(String[] args) {
    SpringApplication.run(ClientApplication.class, args);
  }

/*  @Bean
  public PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }*/
}
