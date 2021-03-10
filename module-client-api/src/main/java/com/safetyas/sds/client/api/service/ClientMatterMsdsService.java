package com.safetyas.sds.client.api.service;

import com.safetyas.sds.common.service.MatterMsdsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientMatterMsdsService {

  private final MatterMsdsService matterMsdsService;
  private final ModelMapper modelMapper;

  /**
   * step01 업데이트
   */
  public void updateStep1() {

  }

}
