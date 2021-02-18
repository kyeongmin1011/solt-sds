package com.safetyas.sds.admin.api.controller;

import com.safetyas.sds.admin.api.response.CommonResult;
import com.safetyas.sds.admin.api.response.ResponseService;
import com.safetyas.sds.admin.api.response.SingleResult;
import com.safetyas.sds.admin.api.service.AdminFaqService;
import com.safetyas.sds.admin.api.service.AdminNoticeService;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.FaqDto;
import com.safetyas.sds.common.model.NoticeDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Slf4j
@Api("공지 게시판 & Q&A")
@RestController
@RequiredArgsConstructor
@RequestMapping("/inform")
public class InformController {

  private final ResponseService responseService;
  private final AdminNoticeService noticeService;
  private final AdminFaqService faqService;

  @GetMapping("/notice")
  @ApiOperation("공지 게시판 목록 조회")
  public SingleResult<Page<NoticeDto>> selectNoticeList(BoardSearchCondition condition,
      @PageableDefault Pageable pageable) {
    return responseService.getSingleResult(noticeService.selectNoticeList(condition, pageable));
  }

  @GetMapping("/notice/{id}")
  @ApiOperation("공지 게시판 조회")
  public SingleResult<NoticeDto> selectNotice(@PathVariable Long id) {
    return responseService.getSingleResult(noticeService.selectNotice(id));

  }

  @PostMapping("/notice")
  @ApiOperation("공지 게시판 작성")
  public CommonResult insertNotice(NoticeDto noticeDto,
      MultipartHttpServletRequest multipartHttpServletRequest) {
    noticeService.insertNotice(noticeDto, multipartHttpServletRequest);
    return responseService.getSuccessResult();
  }

  @PutMapping("/notice/{id}")
  @ApiOperation("공지 게시판 수정")
  public CommonResult updateNotice(@PathVariable Long id, NoticeDto noticeDto,
      MultipartHttpServletRequest multipartHttpServletRequest) {
    noticeService.updateNotice(id, noticeDto, multipartHttpServletRequest);
    return responseService.getSuccessResult();
  }

  @DeleteMapping("/notice/{id}")
  @ApiOperation("공지 게시판 삭제")
  public CommonResult deleteNotice(@PathVariable Long id) {
    noticeService.deleteNotice(id);
    return responseService.getSuccessResult();
  }

  @GetMapping("/faq")
  @ApiOperation("자주 묻는 질문 목록 조회")
  public SingleResult<Page<FaqDto>> selectFaqList(BoardSearchCondition condition,
      @PageableDefault Pageable pageable) {
    return responseService.getSingleResult(faqService.selectFaqList(condition, pageable));
  }

  @GetMapping("/faq/{id}")
  @ApiOperation("자주 묻는 질문 조회")
  public SingleResult<FaqDto> selectFaq(@PathVariable Long id) {
    return responseService.getSingleResult(faqService.selectFaq(id));
  }

  @PostMapping("/faq")
  @ApiOperation("자주 묻는 질문 작성")
  public CommonResult insertFaq(FaqDto faqDto,
      MultipartHttpServletRequest multipartHttpServletRequestL) {
    faqService.insertFaq(faqDto, multipartHttpServletRequestL);
    return responseService.getSuccessResult();
  }

  @PutMapping("/faq/{id}")
  @ApiOperation("자주 묻는 게시판 수정")
  public CommonResult updateFaq(@PathVariable Long id, FaqDto faqDto,
      MultipartHttpServletRequest multipartHttpServletRequest) {
    faqService.updateFaq(id, faqDto, multipartHttpServletRequest);
    return responseService.getSuccessResult();
  }

  @DeleteMapping("/faq/{id}")
  @ApiOperation("자주 묻는 게시판 삭제")
  public CommonResult deleteFaq(@PathVariable Long id) {
    faqService.deleteFaq(id);
    return responseService.getSuccessResult();
  }
}
