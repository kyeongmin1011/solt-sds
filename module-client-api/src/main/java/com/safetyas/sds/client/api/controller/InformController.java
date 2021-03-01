package com.safetyas.sds.client.api.controller;

import com.safetyas.sds.client.api.response.ResponseService;
import com.safetyas.sds.client.api.response.SingleResult;
import com.safetyas.sds.client.api.service.ClientInformService;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.FaqDTO;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("inform")
@RestController
public class InformController {

  private final ResponseService responseService;
  private final ClientInformService clientInformService;


  @GetMapping("/faq")
  @ApiOperation("faq")
  public SingleResult<Page<FaqDTO>> selectFaqList(@PageableDefault Pageable pageable,
      BoardSearchCondition condition) {
    return null;
  }
}
