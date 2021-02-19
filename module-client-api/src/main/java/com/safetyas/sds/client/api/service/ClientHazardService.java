package com.safetyas.sds.client.api.service;

import com.safetyas.sds.common.model.HazardIdentificationDTO;
import com.safetyas.sds.common.service.client.HazardService;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientHazardService {

  private final HazardService hazardService;

  public List<HazardIdentificationDTO> selectHazardInfo(String cas) {

    List<String> casList = Arrays.asList(cas.trim().split(","));

    return hazardService.selectHazardInfo(casList);
  }
}
