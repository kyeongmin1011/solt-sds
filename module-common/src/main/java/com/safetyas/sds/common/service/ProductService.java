package com.safetyas.sds.common.service;

import com.safetyas.sds.common.entity.CbiSentence;
import com.safetyas.sds.common.model.CbiSentenceDTO;
import com.safetyas.sds.common.repository.CbiSentenceRepository;
import com.safetyas.sds.common.repository.ProductRepository;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final CbiSentenceRepository cbiSentenceRepository;
  private final ProductRepository productRepository;

  public CbiSentenceDTO selectCbiSentence(Long productSeq) {

    List<CbiSentence> cbiSentenceList = cbiSentenceRepository.findAll();
    String productUid = productRepository.findById(productSeq).orElseThrow(NoSuchElementException::new).getProductUid();

    CbiSentenceDTO cbiSentenceDTO = new CbiSentenceDTO();

    cbiSentenceDTO.setProductUid(productUid);

    cbiSentenceDTO.setNonKnowledgeList(
        cbiSentenceList
            .stream()
            .filter(test -> test.getType().equals("비공지성"))
            .map(CbiSentence::getSentence)
            .collect(Collectors.toList()));

    cbiSentenceDTO.setEconomicUsefulnessList(
        cbiSentenceList
            .stream()
            .filter(test -> test.getType().equals("경제적유용성"))
            .map(CbiSentence::getSentence)
            .collect(Collectors.toList()));

    cbiSentenceDTO.setConfidentialityList(
        cbiSentenceList
            .stream()
            .filter(test -> test.getType().equals("비밀관리성"))
            .map(CbiSentence::getSentence)
            .collect(Collectors.toList()));

    return cbiSentenceDTO;
  }
}
