package com.safetyas.sds.client.api.service;

import com.safetyas.sds.common.model.ProductMatterDTO;
import com.safetyas.sds.common.service.ProductMatterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientProductMatterService {

  ProductMatterService productMatterService;

  public void insertProductMatter(ProductMatterDTO productMatterDTO) {
    productMatterService.insertProductMatter(productMatterDTO.toEntity());
  }

  public void updateProductMatter(Long productMatterSeq, ProductMatterDTO productMatterDTO) {
    productMatterService.updateProductMatter(productMatterSeq, productMatterDTO);

  }

  public void deleteProductMatter(Long productMatterSeq) {
    productMatterService.deleteProductMatter(productMatterSeq);
  }
}
