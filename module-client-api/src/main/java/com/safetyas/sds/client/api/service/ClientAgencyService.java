package com.safetyas.sds.client.api.service;

import com.safetyas.sds.client.api.response.CommonResult;
import com.safetyas.sds.common.service.AgencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientAgencyService {

  private final AgencyService agencyService;

  public CommonResult selectCbiProgress(Integer productSeq) {
    agencyService.selectCbiProgress(productSeq);
    return null;
  }
}
