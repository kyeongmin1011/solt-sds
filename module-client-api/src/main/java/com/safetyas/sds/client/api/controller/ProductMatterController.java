package com.safetyas.sds.client.api.controller;

import com.safetyas.sds.client.api.response.CommonResult;
import com.safetyas.sds.client.api.response.ResponseService;
import com.safetyas.sds.client.api.response.SingleResult;
import com.safetyas.sds.client.api.service.ClientProductMatterService;
import com.safetyas.sds.common.model.ProductMatterDTO;
import io.swagger.annotations.Api;
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

  @GetMapping
  public SingleResult<?> selectProductMatterList() {

    return responseService.getSingleResult(null);
  }

  @PostMapping
  public CommonResult insertProductMatter(@RequestBody ProductMatterDTO productMatterDTO) {
    clientProductMatterService.insertProductMatter(productMatterDTO);
    return responseService.getSuccessResult();
  }

  @PutMapping("/{productMatterSeq}")
  public CommonResult updateProductMatter(@PathVariable Long productMatterSeq, @RequestBody ProductMatterDTO productMatterDTO) {
    clientProductMatterService.updateProductMatter(productMatterSeq,productMatterDTO);
    return responseService.getSuccessResult();
  }

  @DeleteMapping("/{productMatterSeq}")
  public CommonResult deleteProductMatter(@PathVariable Long productMatterSeq) {
    clientProductMatterService.deleteProductMatter(productMatterSeq);
    return responseService.getSuccessResult();
  }
}
