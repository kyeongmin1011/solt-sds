package com.safetyas.sds.common.service;

import com.safetyas.sds.common.entity.CbiDocument;
import com.safetyas.sds.common.entity.CbiSentence;
import com.safetyas.sds.common.entity.Product;
import com.safetyas.sds.common.model.CbiDocumentDTO;
import com.safetyas.sds.common.model.ProductDTO;
import com.safetyas.sds.common.model.ProductSearchCondition;
import com.safetyas.sds.common.repository.CbiDocumentRepository;
import com.safetyas.sds.common.repository.CbiSentenceRepository;
import com.safetyas.sds.common.repository.ProductQueryRepository;
import com.safetyas.sds.common.repository.ProductRepository;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;
  private final CbiSentenceRepository cbiSentenceRepository;
  private final ProductQueryRepository productQueryRepository;
  private final CbiDocumentRepository cbiDocumentRepository;

  public CbiDocumentDTO selectCbiDocument(Long productSeq) {
    CbiDocumentDTO cbiDocumentDTO = productQueryRepository.selectCbiDocument(productSeq);
    List<CbiSentence> cbiSentenceList = cbiSentenceRepository.findAll();
    cbiDocumentDTO.updateSentenceList(cbiSentenceList);
    return cbiDocumentDTO;
  }

  public long insertCbiDocument(CbiDocument cbiDocument) {
    return cbiDocumentRepository.save(cbiDocument).getCbiDocumentSeq();
  }

  public Product selectProduct(Long productSeq) {
    return productRepository.findById(productSeq).orElseThrow(NoSuchElementException::new);
  }

  public Long insertProductAndCbiDocument(Product product) {
    return productRepository.save(product).getCbiDocument().getCbiDocumentSeq();
  }

  public Page<ProductDTO> selectProductList(Pageable pageable, ProductSearchCondition productSearchCondition) {
    return productQueryRepository.selectProductList(pageable,productSearchCondition);
  }
}
