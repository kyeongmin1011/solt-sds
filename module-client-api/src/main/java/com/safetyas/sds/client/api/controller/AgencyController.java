package com.safetyas.sds.client.api.controller;

import com.safetyas.sds.client.api.response.CommonResult;
import com.safetyas.sds.client.api.response.ResponseService;
import com.safetyas.sds.client.api.response.SingleResult;
import com.safetyas.sds.client.api.service.ClientAgencyService;
import com.safetyas.sds.common.model.CbiAgencyProgressDTO;
import com.safetyas.sds.common.model.CbiAgencyRequestInfoDTO;
import com.safetyas.sds.common.model.OrAgencyDTO;
import com.safetyas.sds.common.model.ProductDTO;
import com.safetyas.sds.common.model.RenewAgencyDTO;
import com.safetyas.sds.common.model.RevisionAgencyProgressDTO;
import com.safetyas.sds.common.model.RevisionAgencyRequestInfoDTO;
import com.safetyas.sds.common.model.SubmissionAgencyDTO;
import com.safetyas.sds.common.model.TranslationAgencyProgressDTO;
import com.safetyas.sds.common.model.TranslationAgencyRequestInfoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Api(tags = {"대행 서비스"})
@Slf4j
@RestController
@RequestMapping(value = "/agency")
@RequiredArgsConstructor
public class AgencyController {

  private final ClientAgencyService clientAgencyService;
  private final ResponseService responseService;

  @ApiOperation(value = "제출대행")
  @GetMapping(value = "/submission/{productSeq}")
  public SingleResult<List<SubmissionAgencyDTO>> selectSubmission(
      @ApiParam(value = "제품 번호", required = true) @PathVariable Long productSeq) {
    return responseService.getSingleResult(clientAgencyService.selectSubmission(productSeq));
  }

  @ApiOperation(value = "OR대행")
  @GetMapping(value = "/or/{productSeq}")
  public SingleResult<List<OrAgencyDTO>> selectOr(
      @ApiParam(value = "제품 번호", required = true) @PathVariable Long productSeq) {
    return responseService.getSingleResult(clientAgencyService.selectOrAgency(productSeq));
  }

  @ApiOperation(value = "연장승인대행")
  @GetMapping(value = "/renew/{productSeq}")
  public SingleResult<List<RenewAgencyDTO>> selectRenew(
      @ApiParam(value = "제품 번호", required = true) @PathVariable Long productSeq) {
    return responseService.getSingleResult(clientAgencyService.selectRenewAgency(productSeq));
  }

  @ApiOperation(value = "개정대행 진행상태")
  @GetMapping(value = "/revision/progress/{productSeq}")
  public SingleResult<List<RevisionAgencyProgressDTO>> selectRevisionProgress(
      @ApiParam(value = "제품 번호", required = true) @PathVariable Long productSeq) {
    return responseService.getSingleResult(clientAgencyService.selectRevisionProgress(productSeq));
  }

  @ApiOperation(value = "개정대행 요청정보 조회")
  @GetMapping(value = "/revision/request-info/{productSeq}")
  public SingleResult<RevisionAgencyRequestInfoDTO> selectRevisionRequestInfo(
      @ApiParam(value = "제품 번호", required = true) @PathVariable Long productSeq) {
    return responseService
        .getSingleResult(clientAgencyService.selectRevisionRequestInfo(productSeq));
  }

  @ApiOperation(value = "개정대행 요청정보 등록")
  @PostMapping(value = "/revision/request-info")
  public CommonResult insertRevisionRequestInfo(
      @ApiParam(value = "제품 정보", required = true) ProductDTO productDTO,
      MultipartHttpServletRequest multipartHttpServletRequest) {
    clientAgencyService.insertRevisionRequestInfo(productDTO, multipartHttpServletRequest);
    return responseService.getSuccessResult();
  }

  @ApiOperation(value = "번역대행 요청정보 조회")
  @GetMapping(value = "/translate/request-info/{productSeq}")
  public SingleResult<TranslationAgencyRequestInfoDTO> selectTranslationRequestInfo(
      @ApiParam(value = "제품 정보", required = true) @PathVariable Long productSeq) {

    return responseService
        .getSingleResult(clientAgencyService.selectTranslationRequestInfo(productSeq));
  }

  @ApiOperation(value = "번역대행 요청정보 저장")
  @PostMapping(value = "/translate/request-info")
  public CommonResult insertTranslateAgencyRequestInfo(TranslationAgencyRequestInfoDTO translationAgencyRequestInfoDTO,
      MultipartHttpServletRequest multipartHttpServletRequest) {
    clientAgencyService.insertTranslationRequestInfo(translationAgencyRequestInfoDTO, multipartHttpServletRequest);
    return responseService.getSuccessResult();
  }

  @ApiOperation(value = "번역대행 진행상태 조회")
  @GetMapping(value = "/translate/progress/{productSeq}")
  public SingleResult<List<TranslationAgencyProgressDTO>> selectTranslateAgencyProgress(
      @ApiParam(value = "제품 번호", required = true) @PathVariable Long productSeq) {

    return responseService
        .getSingleResult(clientAgencyService.selectTranslationProgress(productSeq));
  }

  @ApiOperation(value = "영업비밀대행 요청정보")
  @GetMapping(value = "/cbi/request-info/{productSeq}")
  public SingleResult<CbiAgencyRequestInfoDTO> selectCbiAgencyRequestInfo(
      @ApiParam(value = "제품 번호", required = true) @PathVariable Long productSeq) {
    return responseService.getSingleResult(clientAgencyService.selectCbiRequestInfo(productSeq));
  }

  @ApiOperation(value = "영업비밀대행 요청정보 저장")
  @PostMapping(value = "/cbi/request-info")
  public CommonResult insertCbiAgency(
      @ApiParam(value = "제품 정보", required = true) CbiAgencyRequestInfoDTO cbiAgencyRequestInfoDTO) {
    clientAgencyService.insertCbiAgency(cbiAgencyRequestInfoDTO);
    return responseService.getSuccessResult();
  }

  @ApiOperation(value = "영업비밀대행 진행상태")
  @GetMapping(value = "/cbi/progress/{productSeq}")
  public SingleResult<CbiAgencyProgressDTO> selectCbiAgencyProgress(
      @ApiParam(value = "제품 번호", required = true) @PathVariable Long productSeq) {
    return responseService.getSingleResult(clientAgencyService.selectCbiProgress(productSeq));
  }
}