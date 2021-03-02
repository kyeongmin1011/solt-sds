package com.safetyas.sds.common.service;

import com.safetyas.sds.common.entity.ProductMatter;
import com.safetyas.sds.common.model.ProductMatterDTO;
import com.safetyas.sds.common.repository.ProductMatterRepository;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductMatterService {

  private final ProductMatterRepository productMatterRepository;

  public void insertProductMatter(ProductMatter productMatter) {
    productMatterRepository.save(productMatter);
  }

  public void updateProductMatter(Long productMatterSeq, ProductMatterDTO productMatterDTO) {
    ProductMatter productMatter = productMatterRepository.findById(productMatterSeq)
        .orElseThrow(NoSuchElementException::new);
    productMatter.updateProductMatter(productMatterDTO);
    productMatterRepository.save(productMatter);
  }

  public void deleteProductMatter(Long productMatterSeq) {
    ProductMatter productMatter = productMatterRepository.findById(productMatterSeq)
        .orElseThrow(NoSuchElementException::new);
    productMatter.updateDelDate();
    productMatterRepository.save(productMatter);
  }
}
