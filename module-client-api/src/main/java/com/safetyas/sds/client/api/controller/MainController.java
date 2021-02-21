package com.safetyas.sds.client.api.controller;

import com.safetyas.sds.client.api.response.ResponseService;
import com.safetyas.sds.client.api.response.SingleResult;
import com.safetyas.sds.client.api.service.ClientMainService;
import com.safetyas.sds.common.model.ClientMainMyPageDTO;
import com.safetyas.sds.common.model.FaqDTO;
import com.safetyas.sds.common.model.MemberBoardDTO;
import com.safetyas.sds.common.model.NoticeDTO;
import io.swagger.annotations.Api;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"SDS Main  메인"})
@RestController
@RequestMapping(value = "/sds-api")
@RequiredArgsConstructor
public class MainController {

  private final ResponseService responseService;
  private final ClientMainService clientMainService;

  @GetMapping("/notices")
  public SingleResult<List<NoticeDTO>> selectClientMainNoticeList() {
    return responseService.getSingleResult(clientMainService.selectClientMainNoticeList());
  }

  @GetMapping("/faqs")
  public SingleResult<List<FaqDTO>> selectClientMainFaqList() {
    return responseService.getSingleResult(clientMainService.selectClientMainFaqList());
  }

  @GetMapping("/member-boards")
  public SingleResult<List<MemberBoardDTO>> selectClientMemberBoardList() {
    return responseService.getSingleResult(clientMainService.selectClientMainMemberBoardList());
  }

  @GetMapping("/member-info")
  public SingleResult<ClientMainMyPageDTO> selectClientMemberInfo() {
    return responseService.getSingleResult(clientMainService.selectClientMainMemberInfo());
  }
}
