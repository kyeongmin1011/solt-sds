package com.safetyas.sds.client.api.service;

import com.safetyas.sds.common.model.ProductMatterDTO;
import com.safetyas.sds.common.service.ProductMatterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientProductMatterService {

  private final ProductMatterService productMatterService;

  public void insertProductMatter(ProductMatterDTO productMatterDTO) {
    productMatterService.insertProductMatter(ProductMatterDTO.toEntity(productMatterDTO));
  }

  public void updateProductMatter(Long productMatterSeq, ProductMatterDTO productMatterDTO) {
    productMatterService.updateProductMatter(productMatterSeq, productMatterDTO);

  }

  public void deleteProductMatter(Long productMatterSeq) {
    productMatterService.deleteProductMatter(productMatterSeq);
  }

  /**
   * 오픈소스 물질 라이브러리에서 가져온 정보로 제품 물질 입력.
   */
  public void insertFromMatterData(String matterDataKey, Long productSeq) {
    System.out.println("params2: matterdatakey "+matterDataKey+", productseq "+productSeq);

    productMatterService.insertFromMatterData(matterDataKey, productSeq);
  }
}
