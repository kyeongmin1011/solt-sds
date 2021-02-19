package com.safetyas.sds.client.api.controller;

import com.safetyas.sds.client.api.response.ResponseService;
import com.safetyas.sds.client.api.response.SingleResult;
import com.safetyas.sds.client.api.service.ClientHazardService;
import com.safetyas.sds.common.model.HazardIdentificationDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
  @GetMapping("/info")
  public SingleResult<List<HazardIdentificationDTO>> selectHazardInfo(
      @ApiParam(value = "CAS No 리스트", required = true) @RequestParam String cas) {

    return responseService.getSingleResult(clientHazardService.selectHazardInfo(cas));
  }

}
