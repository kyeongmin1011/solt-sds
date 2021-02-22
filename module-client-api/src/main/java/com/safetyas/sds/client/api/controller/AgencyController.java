package com.safetyas.sds.client.api.controller;

import com.safetyas.sds.client.api.response.CommonResult;
import com.safetyas.sds.client.api.response.ResponseService;
import com.safetyas.sds.client.api.response.SingleResult;
import com.safetyas.sds.client.api.service.ClientAgencyService;
import com.safetyas.sds.common.model.CbiAgencyProgressDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"대행 서비스"})
@Slf4j
@RestController
@RequestMapping(value = "/agency")
@RequiredArgsConstructor
public class AgencyController {

  private final ClientAgencyService clientAgencyService;
  private final ResponseService responseService;

  @ApiOperation(value = "제출대행")
  @GetMapping(value = "/submission/{submissionAgencySeq}")
  public CommonResult selectSubmission(
      @ApiParam(value = "제출대행 번호", required = true) @PathVariable Integer submissionAgencySeq) {
    return null;
  }

  @ApiOperation(value = "OR대행")
  @GetMapping(value = "/or/{orAgencySeq}")
  public CommonResult selectOr(
      @ApiParam(value = "OR대행 번호", required = true) @PathVariable Integer orAgencySeq) {
    return null;
  }

  @ApiOperation(value = "연장승인대행")
  @GetMapping(value = "/renew/{renewAgencySeq}")
  public CommonResult selectRenew(
      @ApiParam(value = "연장승인대행 번호", required = true) @PathVariable Integer renewAgencySeq) {
    return null;
  }

  @ApiOperation(value = "개정대행")
  @GetMapping(value = "/revision/{revisionAgencySeq}")
  public CommonResult selectRevision(
      @ApiParam(value = "개정대행 번호", required = true) @PathVariable Integer revisionAgencySeq) {
    return null;
  }

  @ApiOperation(value = "번역대행")
  @GetMapping(value = "/translate/{revisionAgencySeq}")
  public CommonResult selectTranslate(
      @ApiParam(value = "번역대행 번호", required = true) @PathVariable Integer translateAgencySeq) {
    return null;
  }

  @ApiOperation(value = "영업비밀대행 요청정보")
  @GetMapping(value = "/cbi/request-info/{productSeq}")
  public SingleResult<?> selectCbiAgencyRequestInfo(@PathVariable Long productSeq) {
    return responseService.getSingleResult(clientAgencyService.selectCbiRequestInfo(productSeq));
  }

  @ApiOperation(value = "영업비밀대행 진행상태")
  @GetMapping(value = "/cbi/progress/{productSeq}")
  public SingleResult<CbiAgencyProgressDTO> selectCbiAgencyProgress(
      @ApiParam(value = "영업비밀대행 번호", required = true) @PathVariable Long productSeq) {
    return responseService.getSingleResult(clientAgencyService.selectCbiProgress(productSeq));
  }
}
