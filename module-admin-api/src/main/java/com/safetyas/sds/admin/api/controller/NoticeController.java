package com.safetyas.sds.admin.api.controller;

import com.safetyas.sds.admin.api.response.CommonResult;
import com.safetyas.sds.admin.api.response.ResponseService;
import com.safetyas.sds.common.model.NoticeDto;
import com.safetyas.sds.common.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api("공지 게시판")
@RestController
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {

  private final ResponseService responseService;
  private final NoticeService noticeService;

  @PostMapping("/insert")
  @ApiOperation("공지 게시판 작성")
  public CommonResult insertNotice(@RequestBody NoticeDto noticeDto) {
    noticeService.insertNotice(noticeDto);
    return responseService.getSuccessResult();
  }
}
