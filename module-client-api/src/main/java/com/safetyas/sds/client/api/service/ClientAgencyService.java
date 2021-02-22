package com.safetyas.sds.client.api.service;

import com.safetyas.sds.common.model.CbiAgencyProgressDTO;
import com.safetyas.sds.common.service.AgencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientAgencyService {

  private final AgencyService agencyService;

  public CbiAgencyProgressDTO selectCbiProgress(Long productSeq) {
    return agencyService.selectCbiProgress(productSeq);
  }

  public Object selectCbiRequestInfo(Long productSeq) {
    return null;
  }
}
