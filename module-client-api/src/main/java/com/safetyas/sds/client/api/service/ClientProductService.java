package com.safetyas.sds.client.api.service;

import com.safetyas.sds.common.model.CbiSentenceDTO;
import com.safetyas.sds.common.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientProductService {

  private final ProductService productService;

  public CbiSentenceDTO selectCbiSentence(Long productSeq) {
    return productService.selectCbiSentence(productSeq);
  }
}
