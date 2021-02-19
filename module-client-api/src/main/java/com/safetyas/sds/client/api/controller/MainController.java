package com.safetyas.sds.client.api.controller;

import com.safetyas.sds.client.api.response.ResponseService;
import com.safetyas.sds.client.api.response.SingleResult;
import com.safetyas.sds.client.api.service.ClientMainService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"SDS Main  메인"})
@RestController
@RequestMapping(value = "/sds-api")
@RequiredArgsConstructor
public class MainController {

  private final ResponseService responseService;
  private final ClientMainService clientMainService;

  @GetMapping("/main")
  public SingleResult<?> selectClientMain() {

     clientMainService.selectClientMain();

    return null;
  }
}
