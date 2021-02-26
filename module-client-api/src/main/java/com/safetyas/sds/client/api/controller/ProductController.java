package com.safetyas.sds.client.api.controller;

import com.safetyas.sds.client.api.request.CbiDocumentRequest;
import com.safetyas.sds.client.api.response.CommonResult;
import com.safetyas.sds.client.api.response.ResponseService;
import com.safetyas.sds.client.api.response.SingleResult;
import com.safetyas.sds.client.api.service.ClientProductService;
import com.safetyas.sds.common.model.CbiDocumentDTO;
import com.safetyas.sds.common.model.ProductDTO;
import com.safetyas.sds.common.model.ProductSearchCondition;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Api(tags = {"제품 리스트, 검색, 입력, 수정"})
@RestController
@RequestMapping(value = "/product")
@RequiredArgsConstructor
public class ProductController {

  private final ResponseService responseService;
  private final ClientProductService clientProductService;

  @GetMapping("")
  @ApiOperation("제품 리스트 조회")
  public SingleResult<Page<ProductDTO>> selectProductList(@PageableDefault Pageable pageable,
      ProductSearchCondition productSearchCondition) {
    return responseService
        .getSingleResult(clientProductService.selectProductList(pageable, productSearchCondition));
  }

  @PostMapping("")
  @ApiOperation("제품 등록")
  public CommonResult insertProduct(@RequestBody ProductDTO productDTO) {
    clientProductService.insertProduct(productDTO);
    return responseService.getSuccessResult();
  }

  @GetMapping("/cbi-document/{productSeq}")
  @ApiOperation("영업 비밀 입증 서류 조회")
  public SingleResult<CbiDocumentDTO> selectCbiDocument(@PathVariable Long productSeq) {
    return responseService.getSingleResult(clientProductService.selectCbiDocument(productSeq));
  }

  @PostMapping("/cbi-document")
  @ApiOperation("영업 비밀 입증 서류 저장")
  public CommonResult insertCbiDocument(CbiDocumentRequest cbiDocumentRequest,
      MultipartHttpServletRequest multipartHttpServletRequest) {
    clientProductService.insertCbiDocument(cbiDocumentRequest, multipartHttpServletRequest);
    return responseService.getSuccessResult();
  }
}