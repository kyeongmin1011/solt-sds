package com.safetyas.sds.common.service;

import com.safetyas.sds.common.entity.CbiAgency;
import com.safetyas.sds.common.entity.Product;
import com.safetyas.sds.common.entity.ProductMatter;
import com.safetyas.sds.common.model.CbiAgencyDTO;
import com.safetyas.sds.common.model.CbiAgencyProgressDTO;
import com.safetyas.sds.common.model.CbiAgencyRequestInfoDTO;
import com.safetyas.sds.common.model.FileDTO;
import com.safetyas.sds.common.model.OrAgencyDTO;
import com.safetyas.sds.common.model.ProductMatterDTO;
import com.safetyas.sds.common.model.RenewAgencyDTO;
import com.safetyas.sds.common.model.RevisionAgencyProgressDTO;
import com.safetyas.sds.common.model.RevisionAgencyRequestInfoDTO;
import com.safetyas.sds.common.model.SubmissionAgencyDTO;
import com.safetyas.sds.common.model.TranslationAgencyProgressDTO;
import com.safetyas.sds.common.model.TranslationAgencyRequestInfoDTO;
import com.safetyas.sds.common.repository.FileQueryRepository;
import com.safetyas.sds.common.repository.ProductMatterRepository;
import com.safetyas.sds.common.repository.ProductQueryRepository;
import com.safetyas.sds.common.repository.ProductRepository;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AgencyService {

  private final ProductQueryRepository productQueryRepository;
  private final ProductRepository productRepository;
  private final ProductMatterRepository productMatterRepository;
  private final FileQueryRepository fileQueryRepository;
  private final ModelMapper modelMapper;

  @Transactional
  public CbiAgencyProgressDTO selectCbiProgress(Long productSeq) {

    CbiAgencyProgressDTO cbiAgencyProgressDTO = new CbiAgencyProgressDTO();
    Product product = productQueryRepository.selectProductCbiAgencyById(productSeq);

    cbiAgencyProgressDTO.updateCbiAgencyInfo(product);
    for (CbiAgency cbiAgency : product.getCbiAgencyList()) {
      cbiAgencyProgressDTO.getCbiAgencyList().add(modelMapper.map(cbiAgency, CbiAgencyDTO.class));
    }
    return cbiAgencyProgressDTO;
  }

  @Transactional
  public CbiAgencyRequestInfoDTO selectCbiRequestInfo(Long productSeq) {

    CbiAgencyRequestInfoDTO cbiAgencyRequestInfoDTO = new CbiAgencyRequestInfoDTO();
    Product product = productQueryRepository.selectProductCbiAgencyById(productSeq);

    cbiAgencyRequestInfoDTO.updateCbiAgencyInfo(product);
    for (ProductMatter productMatter : product.getProductMatterList()) {
      cbiAgencyRequestInfoDTO.getProductMatterList()
          .add(modelMapper.map(productMatter, ProductMatterDTO.class));
    }
    return cbiAgencyRequestInfoDTO;
  }

  @Transactional
  public void insertCbiAgency(CbiAgencyRequestInfoDTO cbiAgencyRequestInfoDTO) {
    //TODO 포인트 차감

    Product product = productRepository.findById(cbiAgencyRequestInfoDTO.getProductSeq())
        .orElseThrow(NoSuchElementException::new);

    product
        .updateAgencyCbiDocYnAndSubstituteDataAgencyYn(cbiAgencyRequestInfoDTO.getAgencyCbiDocYn(),
            cbiAgencyRequestInfoDTO.getSubstituteDataAgencyYn());

    for (ProductMatterDTO productMatterDTO : cbiAgencyRequestInfoDTO.getProductMatterList()) {
      ProductMatter productMatter = productMatterRepository
          .findById(productMatterDTO.getProductMatterSeq())
          .orElseThrow(NoSuchElementException::new);

      productMatter.updateAlterContentYn(productMatterDTO.getAlterContentYn());
      productMatter.updateProduct(product);

      productMatterRepository.save(productMatter);
    }
  }

  @Transactional
  public List<SubmissionAgencyDTO> selectSubmissionAgency(Long productSeq) {
    return productQueryRepository.selectProductSubmissionAgency(productSeq);
  }

  @Transactional
  public List<OrAgencyDTO> selectOrAgency(Long productSeq) {
    return productQueryRepository.selectProductOrAgency(productSeq);
  }

  @Transactional
  public List<RenewAgencyDTO> selectRenewAgency(Long productSeq) {
    return productQueryRepository.selectProductRenewAgency(productSeq);
  }

  @Transactional
  public List<RevisionAgencyProgressDTO> selectRevisionProgress(Long productSeq) {
    return productQueryRepository.selectRevisionProgress(productSeq);
  }

  @Transactional
  public RevisionAgencyRequestInfoDTO selectRevisionRequestInfo(Long productSeq) {
    RevisionAgencyRequestInfoDTO revisionAgencyRequestInfoDTO = productQueryRepository
        .selectRevisionRequestInfo(productSeq);

    FileDTO file = FileDTO.builder()
        .recordSeq(productSeq)
        .relateTable("revisionAgency")
        .build();

    List<FileDTO> fileList = fileQueryRepository.selectFileListByFileDTO(file);

    if (!fileList.isEmpty()) {
      revisionAgencyRequestInfoDTO.setFileList(fileList);
    }
    return revisionAgencyRequestInfoDTO;
  }

  public TranslationAgencyProgressDTO selectTranslationProgress(Long productSeq) {
    return productQueryRepository.selectTranslationProgress(productSeq);
  }

  public TranslationAgencyRequestInfoDTO selectTranslationRequestInfo(Long productSeq) {
    TranslationAgencyRequestInfoDTO translationAgencyRequestInfoDTO = productQueryRepository
        .selectTranslationRequestInfo(productSeq);

    FileDTO file = FileDTO.builder()
        .recordSeq(productSeq)
        .relateTable("translationAgency")
        .build();

    List<FileDTO> fileList = fileQueryRepository.selectFileListByFileDTO(file);
    if (!fileList.isEmpty()) {
      translationAgencyRequestInfoDTO.setFileList(fileList);
    }

    return translationAgencyRequestInfoDTO;
  }
}
