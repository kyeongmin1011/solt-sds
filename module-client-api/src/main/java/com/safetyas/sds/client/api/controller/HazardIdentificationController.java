package com.safetyas.sds.client.api.controller;

import com.safetyas.sds.client.api.response.CommonResult;
import com.safetyas.sds.client.api.response.ResponseService;
import com.safetyas.sds.client.api.service.ClientHazardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"유해물질구분 무료 서비스"})
@RestController
@RequestMapping(value = "/hazard")
@RequiredArgsConstructor
public class HazardIdentificationController {

  private final ResponseService responseService;
  private final ClientHazardService clientHazardService;

  @ApiOperation(value = "유해물질 구분값", notes = "카스번호에 따른 유해물질 구분값을 가져온다")
  @PostMapping(value = "/get-info")
  public CommonResult selectHazardInfo(
      @ApiParam(value = "CAS No 리스트", required = true) @RequestParam String[] casList) {
    return null;
  }

}
