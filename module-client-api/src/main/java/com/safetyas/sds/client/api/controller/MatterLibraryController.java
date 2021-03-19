package com.safetyas.sds.client.api.controller;

import com.safetyas.sds.client.api.response.CommonResult;
import com.safetyas.sds.client.api.response.ResponseService;
import com.safetyas.sds.client.api.service.ClientProductMatterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"물질 오픈소스 데이터 검색 리스팅"})
@RestController
@RequestMapping(value = "/matter-sas-library")
@RequiredArgsConstructor
public class MatterLibraryController {

  private final ResponseService responseService;
  private final ClientProductMatterService clientProductMatterService;

  @PostMapping("/select-into")
  @ApiOperation("선택 크롤링 물질 데이터로 제품 물질로 추가")
  public CommonResult insertFromLibMatter(String matterDataKey, Long productSeq) {
    clientProductMatterService.insertFromMatterData(matterDataKey, productSeq);
    // TODO:추가되어 업데이트한 ProductMatter 리스트 반환

    return responseService.getSuccessResult();
  }
}
