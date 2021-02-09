package com.safetyas.sds.admin.api.controller;

import com.safetyas.sds.admin.api.response.CommonResult;
import com.safetyas.sds.admin.api.response.ResponseService;
import com.safetyas.sds.admin.api.response.SingleResult;
import com.safetyas.sds.admin.api.service.ApiFaqService;
import com.safetyas.sds.admin.api.service.ApiNoticeService;
import com.safetyas.sds.common.model.FaqDto;
import com.safetyas.sds.common.model.NoticeDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api("공지 게시판 & Q&A")
@RestController
@RequiredArgsConstructor
@RequestMapping("/inform")
public class InformController {

  private final ResponseService responseService;
  private final ApiNoticeService noticeService;
  private final ApiFaqService faqService;

  @GetMapping("/notice")
  @ApiOperation("공지 게시판 목록 조회")
  public SingleResult<?> selectNoticeList() {
    return null;
  }

  @GetMapping("/notice/{id}")
  @ApiOperation("공지 게시판 조회")
  public SingleResult<NoticeDto> selectNotice(@PathVariable Long id) {
    return responseService.getSingleResult(noticeService.selectNotice(id));

  }

  @PostMapping("/notice")
  @ApiOperation("공지 게시판 작성")
  public CommonResult insertNotice(@RequestBody NoticeDto noticeDto) {
    noticeService.insertNotice(noticeDto);
    return responseService.getSuccessResult();
  }

  @PutMapping("/notice/{id}")
  @ApiOperation("공지 게시판 수정")
  public CommonResult updateNotice(@PathVariable Long id, @RequestBody NoticeDto noticeDto) {
    noticeService.updateNotice(id, noticeDto);
    return responseService.getSuccessResult();
  }

  @DeleteMapping("/notice/{id}")
  @ApiOperation("공지 게시판 삭제")
  public CommonResult deleteNotice(@PathVariable Long id) {
    noticeService.deleteNotice(id);
    return responseService.getSuccessResult();
  }

  @GetMapping("/faq")
  @ApiOperation("자주 묻는 조회 목록")
  public SingleResult<?> selectFaqList() {
    return null;
  }

  @GetMapping("/faq/{id}")
  @ApiOperation("자주 묻는 질문 조회")
  public SingleResult<FaqDto> selectFaq(@PathVariable Long id) {
    return responseService.getSingleResult(faqService.selectFaq(id));
  }

  @PostMapping("/faq/{id}")
  @ApiOperation("자주 묻는 질문 작성")
  public CommonResult insertFaq(@RequestBody FaqDto faqDto) {
    faqService.insertFaq(faqDto);
    return responseService.getSuccessResult();
  }

  @PutMapping("/faq/{id}")
  @ApiOperation("자주 묻는 게시판 수정")
  public CommonResult updateFaq(@PathVariable Long id, @RequestBody FaqDto faqDto) {
    faqService.updateFaq(id, faqDto);
    return responseService.getSuccessResult();
  }

  @DeleteMapping("/faq/{id}")
  @ApiOperation("자주 묻는 게시판 삭제")
  public CommonResult deleteFaq(@PathVariable Long id) {
    faqService.deleteFaq(id);
    return responseService.getSuccessResult();
  }
}
