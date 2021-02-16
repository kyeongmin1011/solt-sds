package com.safetyas.sds.client.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import java.net.URL;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Api(tags = {"고객 인증"})
@RestController
@RequiredArgsConstructor
public class ClientAuthController {

  Logger log = LoggerFactory.getLogger(this.getClass());

/*  private final RestTemplate restTemplate;

  private static final String REGISTRATION_URL = "http://localhost:8080/register";
  private static final String AUTHENTICATION_URL = "http://localhost:8080/authenticate";
  private static final String CLIENT_MAIN = "http://localhost:8080/sds-api";
  private static final String REFRESH_TOKEN = "http://localhost:8080/refresh-token";

  private String token;

  @GetMapping(value = "/getResponse")
  public String getResponse() throws JsonProcessingException {
    String response = null;

    return null;
  }*/


}
