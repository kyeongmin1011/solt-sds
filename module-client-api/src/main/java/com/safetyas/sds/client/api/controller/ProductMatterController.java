package com.safetyas.sds.client.api.controller;

import com.safetyas.sds.client.api.response.CommonResult;
import com.safetyas.sds.client.api.response.ResponseService;
import com.safetyas.sds.client.api.response.SingleResult;
import com.safetyas.sds.client.api.service.ClientProductMatterService;
import com.safetyas.sds.common.model.ProductMatterDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"제품 물질 "})
@RestController
@RequestMapping(value = "/product-matter")
@RequiredArgsConstructor
public class ProductMatterController {

  private final ResponseService responseService;
  private final ClientProductMatterService clientProductMatterService;

  @GetMapping("/{productSeq}")
  @ApiOperation("한 제품의 물질리스트")
  public SingleResult<?> selectProductMatterList(@PathVariable Long productSeq) {

    return responseService.getSingleResult(null);
  }

  @PostMapping("/add")
  @ApiOperation("사용자 물질 입력")
  public CommonResult insertProductMatter(@RequestBody ProductMatterDTO productMatterDTO) {
    clientProductMatterService.insertProductMatter(productMatterDTO);
    return responseService.getSuccessResult();
  }

  @PutMapping("/{productMatterSeq}")
  @ApiOperation("한 제품의 물질 정보 업데이트")
  public CommonResult updateProductMatter(@PathVariable Long productMatterSeq,
      @RequestBody ProductMatterDTO productMatterDTO) {
    clientProductMatterService.updateProductMatter(productMatterSeq, productMatterDTO);
    return responseService.getSuccessResult();
  }

  @DeleteMapping("/{productMatterSeq}")
  @ApiOperation("제품 내 물질 삭제")
  public CommonResult deleteProductMatter(@PathVariable Long productMatterSeq) {
    clientProductMatterService.deleteProductMatter(productMatterSeq);
    return responseService.getSuccessResult();
  }

  @GetMapping("/matter-library")
  @ApiOperation("내 물질 라이브러리 검색")
  public SingleResult<List<ProductMatterDTO>> selectMatterLibrary() {
    return responseService.getSingleResult(clientProductMatterService.selectMatterLibrary());
  }

}
