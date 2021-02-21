package com.safetyas.sds.client.api.service;

import com.safetyas.sds.common.service.client.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientMainService {

  private final MainService mainService;

  public void selectClientMain() {
    mainService.selectClientMain();
  }
}
