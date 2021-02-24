package com.safetyas.sds.client.api.controller;

import com.safetyas.sds.client.api.response.ResponseService;
import com.safetyas.sds.client.api.response.SingleResult;
import com.safetyas.sds.client.api.service.ClientProductService;
import com.safetyas.sds.common.model.CbiSentenceDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"제품 리스트, 검색, 입력, 수정"})
@RestController
@RequestMapping(value = "/product")
@RequiredArgsConstructor
public class ProductController {

  private final ResponseService responseService;
  private final ClientProductService clientProductService;

  @GetMapping("/sentence/{productSeq}")
  @ApiOperation("영업비밀 입증 서류 예시 문장 라이브러리 조회")
  public SingleResult<CbiSentenceDTO> selectCbiSentence(@PathVariable Long productSeq) {

    return responseService.getSingleResult(clientProductService.selectCbiSentence(productSeq));
  }
}
