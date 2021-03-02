package com.safetyas.sds.client.api.service;

import com.safetyas.sds.client.api.request.CbiDocumentRequest;
import com.safetyas.sds.client.api.request.ProductRequest;
import com.safetyas.sds.client.api.util.FileUtil;
import com.safetyas.sds.common.entity.Product;
import com.safetyas.sds.common.model.CbiDocumentDTO;
import com.safetyas.sds.common.model.FileDTO;
import com.safetyas.sds.common.model.ProductDTO;
import com.safetyas.sds.common.model.ProductSearchCondition;
import com.safetyas.sds.common.repository.FileQueryRepository;
import com.safetyas.sds.common.service.ProductService;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
@RequiredArgsConstructor
public class ClientProductService {

  private final ProductService productService;
  private final FileQueryRepository fileQueryRepository;
  private final ClientFileService clientFileService;

  private static final String PATH_NAME = "cbiDocument";
  private static final String TYPE_NAME = "attach";
  private static final String RELATE_TABLE_NAME = "sds_cbi_document";

  public CbiDocumentDTO selectCbiDocument(Long productSeq) {
    CbiDocumentDTO cbiDocumentDTO = productService.selectCbiDocument(productSeq);
    FileDTO fileDTO = FileDTO.builder()
        .relateTable(RELATE_TABLE_NAME)
        .recordSeq(productSeq)
        .build();
    cbiDocumentDTO.setFileList(fileQueryRepository.selectFileListByFileDTO(fileDTO));
    return cbiDocumentDTO;
  }

  public void insertCbiDocument(CbiDocumentRequest cbiDocumentRequest,
      MultipartHttpServletRequest multipartHttpServletRequest) {

    Product product = productService.selectProduct(cbiDocumentRequest.getProductSeq());
    product.updateCbiDocument(cbiDocumentRequest.toEntity());
    long seq = productService.insertProductAndCbiDocument(product);
    ;

    if (!FileUtil.isEmpty(multipartHttpServletRequest.getFiles(TYPE_NAME))) {
      Map<String, Object> infoMap = new HashMap<>();
      infoMap.put("path", PATH_NAME);
      infoMap.put("relateTable", RELATE_TABLE_NAME);
      infoMap.put("recordSeq", seq);
      infoMap.put("type", TYPE_NAME);
      infoMap.put("regUserSeq", seq);
      clientFileService.insertFile(multipartHttpServletRequest, infoMap);
    }
  }

  public Page<ProductDTO> selectProductList(Pageable pageable,
      ProductSearchCondition productSearchCondition) {
    return productService.selectProductList(pageable, productSearchCondition);
  }

  public void insertProduct(ProductRequest productRequest) {
    productService.insertProductAndMemberSupplier(productRequest.toEntity(),
        productRequest.getMemberSupplierSeq());
  }

  public void updateProduct(Long productSeq, ProductDTO productDTO) {
    productService.updateProduct(productSeq, productDTO);
  }

  public void deleteProduct(Long productSeq) {
    productService.deleteProduct(productSeq);
  }

  public ProductDTO selectProduct(Long productSeq) {
    return productService.selectProductAndProductMatter(productSeq);
  }
}
