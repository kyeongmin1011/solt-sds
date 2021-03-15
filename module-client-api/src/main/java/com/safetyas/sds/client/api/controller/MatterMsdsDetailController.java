package com.safetyas.sds.client.api.controller;

import com.safetyas.sds.client.api.response.CommonResult;
import com.safetyas.sds.client.api.response.ResponseService;
import com.safetyas.sds.client.api.service.ClientMatterMsdsService;
import com.safetyas.sds.client.api.service.ClientProductMatterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"물질 MSDS 문서 디테일 작성"})
@RestController
@RequestMapping(value = "/matter-msds")
@RequiredArgsConstructor
public class MatterMsdsDetailController {

  private final ResponseService responseService;
  private final ClientProductMatterService clientProductMatterService;
  private final ClientMatterMsdsService clientMatterMsdsService;

  @PostMapping("/step1")
  @ApiOperation("step1 작성 업데이트")
  public CommonResult selectStep1() {

    clientMatterMsdsService.updateStep1();
    return responseService.getSuccessResult();
  }

  @PostMapping("/step2")
  @ApiOperation("step2 작성 업데이트")
  public CommonResult selectStep2() {
    return responseService.getSingleResult(null);
  }

  @PostMapping("/step3")
  @ApiOperation("step3 작성 업데이트")
  public CommonResult selectStep3() {
    return responseService.getSingleResult(null);
  }

  @PostMapping("/step4")
  @ApiOperation("step4 작성 업데이트")
  public CommonResult selectStep4() {
    return responseService.getSingleResult(null);
  }

  @PostMapping("/step5")
  @ApiOperation("step5 작성 업데이트")
  public CommonResult selectStep5() {
    return responseService.getSingleResult(null);
  }

  @PostMapping("/step6")
  @ApiOperation("step6 작성 업데이트")
  public CommonResult selectStep6() {
    return responseService.getSingleResult(null);
  }

  @PostMapping("/step7")
  @ApiOperation("step7 작성 업데이트")
  public CommonResult selectStep7() {
    return responseService.getSingleResult(null);
  }

}
