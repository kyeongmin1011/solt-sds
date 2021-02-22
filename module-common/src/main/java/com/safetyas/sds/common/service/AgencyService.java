package com.safetyas.sds.common.service;

import com.safetyas.sds.common.entity.CbiAgency;
import com.safetyas.sds.common.entity.Product;
import com.safetyas.sds.common.model.CbiAgencyDTO;
import com.safetyas.sds.common.model.CbiAgencyProgressDTO;
import com.safetyas.sds.common.repository.ProductQueryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgencyService {

  private final ProductQueryRepository productQueryRepository;
  private final ModelMapper modelMapper;

  public CbiAgencyProgressDTO selectCbiProgress(Long productSeq) {

    CbiAgencyProgressDTO cbiProgressDTO = new CbiAgencyProgressDTO();

    Product product = productQueryRepository.selectCbiProgress(productSeq);

    cbiProgressDTO.updateCbiAgencyInfo(product);
    for (CbiAgency cbiAgency : product.getCbiAgencyList()) {
      cbiProgressDTO.getCbiAgencyList().add(modelMapper.map(cbiAgency, CbiAgencyDTO.class));
    }
    return cbiProgressDTO;
  }
}
