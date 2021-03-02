package com.safetyas.sds.client.api.service;

import com.safetyas.sds.client.api.util.FileUtil;
import com.safetyas.sds.common.entity.Product;
import com.safetyas.sds.common.model.CbiAgencyProgressDTO;
import com.safetyas.sds.common.model.CbiAgencyRequestInfoDTO;
import com.safetyas.sds.common.model.OrAgencyDTO;
import com.safetyas.sds.common.model.ProductDTO;
import com.safetyas.sds.common.model.RenewAgencyDTO;
import com.safetyas.sds.common.model.RevisionAgencyProgressDTO;
import com.safetyas.sds.common.model.RevisionAgencyRequestInfoDTO;
import com.safetyas.sds.common.model.SubmissionAgencyDTO;
import com.safetyas.sds.common.model.TranslationAgencyProgressDTO;
import com.safetyas.sds.common.model.TranslationAgencyRequestInfoDTO;
import com.safetyas.sds.common.service.AgencyService;
import com.safetyas.sds.common.service.ProductService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
@RequiredArgsConstructor
public class ClientAgencyService {

  private final ProductService productService;
  private final ClientFileService clientFileService;
  private final AgencyService agencyService;

  private static final String TYPE_NAME = "attach";

  public CbiAgencyProgressDTO selectCbiProgress(Long productSeq) {
    return agencyService.selectCbiProgress(productSeq);
  }

  public CbiAgencyRequestInfoDTO selectCbiRequestInfo(Long productSeq) {
    return agencyService.selectCbiRequestInfo(productSeq);
  }

  public void insertCbiAgency(CbiAgencyRequestInfoDTO cbiAgencyRequestInfoDTO) {
    agencyService.insertCbiAgency(cbiAgencyRequestInfoDTO);
  }

  public List<SubmissionAgencyDTO> selectSubmission(Long productSeq) {
    return agencyService.selectSubmissionAgency(productSeq);
  }

  public List<OrAgencyDTO> selectOrAgency(Long productSeq) {
    return agencyService.selectOrAgency(productSeq);
  }

  public List<RenewAgencyDTO> selectRenewAgency(Long productSeq) {
    return agencyService.selectRenewAgency(productSeq);
  }

  public List<RevisionAgencyProgressDTO> selectRevisionProgress(Long productSeq) {
    return agencyService.selectRevisionProgress(productSeq);
  }

  public RevisionAgencyRequestInfoDTO selectRevisionRequestInfo(Long productSeq) {
    return agencyService.selectRevisionRequestInfo(productSeq);
  }

  public void insertRevisionRequestInfo(ProductDTO productDTO,
      MultipartHttpServletRequest multipartHttpServletRequest) {

    Product product = productService.selectProduct(productDTO.getProductSeq());
    product.updateRevisionLanguage(productDTO.getRevisionLanguage());
    long seq = productService.insertProduct(product);

    if (!FileUtil.isEmpty(multipartHttpServletRequest.getFiles(TYPE_NAME))) {
      Map<String, Object> infoMap = new HashMap<>();
      infoMap.put("path", "revision");
      infoMap.put("relateTable", "revisionAgency");
      infoMap.put("recordSeq", seq);
      infoMap.put("type", TYPE_NAME);
      infoMap.put("regUserSeq", seq);
      clientFileService.insertFile(multipartHttpServletRequest, infoMap);
    }
  }

  public TranslationAgencyProgressDTO selectTranslationProgress(Long productSeq) {
    return agencyService.selectTranslationProgress(productSeq);
  }

  public TranslationAgencyRequestInfoDTO selectTranslationRequestInfo(Long productSeq) {
    return agencyService.selectTranslationRequestInfo(productSeq);
  }

  public void insertTranslationRequestInfo(
      TranslationAgencyRequestInfoDTO translationAgencyRequestInfoDTO,
      MultipartHttpServletRequest multipartHttpServletRequest) {

    Product product = productService.selectProduct(translationAgencyRequestInfoDTO.getProductSeq());
    product.updateProductTranslation(translationAgencyRequestInfoDTO);
    productService.insertProduct(product);

    if (!FileUtil.isEmpty(multipartHttpServletRequest.getFiles(TYPE_NAME))) {
      Map<String, Object> infoMap = new HashMap<>();
      infoMap.put("path", "revision");
      infoMap.put("relateTable", "revisionAgency");
      infoMap.put("recordSeq", product.getProductSeq());
      infoMap.put("type", TYPE_NAME);
      infoMap.put("regUserSeq", product.getProductSeq());
      clientFileService.insertFile(multipartHttpServletRequest, infoMap);
    }
  }
}
