package com.safetyas.sds.client.api.controller;

import com.safetyas.sds.client.api.response.ResponseService;
import com.safetyas.sds.client.api.response.SingleResult;
import com.safetyas.sds.client.api.service.ClientInformService;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.FaqDTO;
import com.safetyas.sds.common.model.NoticeDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api("공지 게시판 & Q&A")
@RestController
@RequiredArgsConstructor
@RequestMapping("/inform")
public class InformController {

  private final ResponseService responseService;
  private final ClientInformService clientInformService;

  @GetMapping("/faq")
  @ApiOperation("자주 묻는 질문 목록 조회")
  public SingleResult<Page<FaqDTO>> selectFaqList(@PageableDefault Pageable pageable,
      BoardSearchCondition condition) {
    return responseService.getSingleResult(clientInformService.selectFaqList(pageable, condition));
  }

  @GetMapping("/faq/{id}")
  @ApiOperation("주주 묻는 질문 조회")
  public SingleResult<FaqDTO> selectFaq(@PathVariable Long id) {
    return responseService.getSingleResult(clientInformService.selectFaq(id));
  }

  @GetMapping("/notice")
  @ApiOperation("공지사항 목록 조회")
  public SingleResult<Page<NoticeDTO>> selectNoticeList(@PageableDefault Pageable pageable,
      BoardSearchCondition condition) {
    return responseService
        .getSingleResult(clientInformService.selectNoticeList(pageable, condition));
  }

  @GetMapping("/notice/{id}")
  @ApiOperation("공지사항 조회")
  public SingleResult<NoticeDTO> selectNotice(@PathVariable Long id) {
    return responseService.getSingleResult(clientInformService.selectNotice(id));
  }
}
