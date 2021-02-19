package com.safetyas.sds.common.service.client;

import com.safetyas.sds.common.model.HazardIdentificationDTO;
import com.safetyas.sds.common.repository.HazardQueryRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HazardService {

  private final HazardQueryRepository hazardQueryRepository;

  public List<HazardIdentificationDTO> selectHazardInfo(List<String> casList) {
    List<HazardIdentificationDTO> hazardIdentificationList = new ArrayList<>();
    for (String cas : casList) {
      HazardIdentificationDTO hazardIdentificationDTO = new HazardIdentificationDTO();
      hazardIdentificationDTO.updateHazardInfoDTO(cas, hazardQueryRepository.selectHazardInfo(cas));
      hazardIdentificationList.add(hazardIdentificationDTO);
    }
    return hazardIdentificationList;
  }
}
