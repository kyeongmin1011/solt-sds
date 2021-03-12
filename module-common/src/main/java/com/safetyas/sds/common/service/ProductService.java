package com.safetyas.sds.common.service;

import com.safetyas.sds.common.entity.CbiDocument;
import com.safetyas.sds.common.entity.CbiSentence;
import com.safetyas.sds.common.entity.MemberSupplier;
import com.safetyas.sds.common.entity.msds.Product;
import com.safetyas.sds.common.model.CbiDocumentDTO;
import com.safetyas.sds.common.model.MemberSupplierDTO;
import com.safetyas.sds.common.model.ProductDTO;
import com.safetyas.sds.common.model.ProductSearchCondition;
import com.safetyas.sds.common.repository.CbiDocumentRepository;
import com.safetyas.sds.common.repository.CbiSentenceRepository;
import com.safetyas.sds.common.repository.MemberSupplierQueryRepository;
import com.safetyas.sds.common.repository.MemberSupplierRepository;
import com.safetyas.sds.common.repository.ProductQueryRepository;
import com.safetyas.sds.common.repository.ProductRepository;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;
  private final ProductQueryRepository productQueryRepository;
  private final MemberSupplierRepository memberSupplierRepository;
  private final MemberSupplierQueryRepository memberSupplierQueryRepository;
  private final CbiSentenceRepository cbiSentenceRepository;
  private final CbiDocumentRepository cbiDocumentRepository;

  private final ModelMapper modelMapper;

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

  public Page<ProductDTO> selectProductList(Pageable pageable,
      ProductSearchCondition productSearchCondition) {
    return productQueryRepository.selectProductList(pageable, productSearchCondition);
  }

  public long insertProductAndMemberSupplier(Product product, Long memberSupplierSeq) {
    MemberSupplier memberSupplier = memberSupplierRepository.findById(memberSupplierSeq)
        .orElseThrow(NoSuchElementException::new);
    product.updateMemberSupplier(memberSupplier);
    return productRepository.save(product).getProductSeq();
  }

  public long insertProduct(Product product) {
    return productRepository.save(product).getProductSeq();
  }

  public void updateProduct(Long productSeq, ProductDTO productDTO) {
    MemberSupplier memberSupplier = memberSupplierRepository
        .findById(productDTO.getMemberSupplierSeq())
        .orElseThrow(NoSuchElementException::new);

    Product product = productRepository.findById(productSeq)
        .orElseThrow(NoSuchElementException::new);
    product.updateProductInfo(productDTO);
    product.updateMemberSupplier(memberSupplier);
    productRepository.save(product);
  }

  public void deleteProduct(Long productSeq) {
    Product product = productRepository.findById(productSeq)
        .orElseThrow(NoSuchElementException::new);
    product.updateDelDate();
    productRepository.save(product);
  }

  public ProductDTO selectProductAndProductMatter(Long productSeq) {
    Product product = productRepository.findById(productSeq)
        .orElseThrow(NoSuchElementException::new);

    ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);

    productDTO.setMemberSupplierSeq(product.getMemberSupplier().getMemberSupplierSeq());

    //TODO:: 멤버 시퀀스 넣어줘야 함
    productDTO.setMemberSupplierList(
        modelMapper.map(memberSupplierQueryRepository.selectMemberSuppliers(1L),
            new TypeToken<List<MemberSupplierDTO>>() {
            }.getType()));

    return productDTO;
  }
}
