package com.safetyas.sds.admin.api.controller;

import com.safetyas.sds.admin.api.response.CommonResult;
import com.safetyas.sds.admin.api.response.ResponseService;
import com.safetyas.sds.admin.api.response.SingleResult;
import com.safetyas.sds.admin.api.service.AdminMemberBoardService;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.MemberBoardDto;
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

@Slf4j
@Api("고객 게시판")
@RestController
@RequiredArgsConstructor
@RequestMapping("/member-board")
public class MemberBoardController {

  private final AdminMemberBoardService memberBoardService;
  private final ResponseService responseService;

  @GetMapping("")
  @ApiOperation("고객 게시판 목록 조회")
  public SingleResult<Page<MemberBoardDto>> selectMemberBoardList(
      BoardSearchCondition condition,
      @PageableDefault Pageable pageable) {

    return responseService.getSingleResult(
        memberBoardService.selectMemberBoardList(condition, pageable));
  }

  @GetMapping("/{id}")
  @ApiOperation("고객 게시판 조회")
  public SingleResult<MemberBoardDto> selectMemberBoard(@PathVariable Long id) {
    return responseService.getSingleResult(memberBoardService.selectMemberBoard(id));
  }

  @PostMapping("")
  @ApiOperation("고객 게시판 저장")
  public CommonResult insertMemberBoard(@RequestBody MemberBoardDto memberBoardDto) {
    memberBoardService.insertMemberBoard(memberBoardDto);
    return responseService.getSuccessResult();
  }

  @PutMapping("/{id}")
  @ApiOperation("고객 게시판 수정")
  public CommonResult updateMemberBoard(@PathVariable Long id,
      @RequestBody MemberBoardDto memberBoardDto) {
    memberBoardService.updateMemberBoard(id, memberBoardDto);
    return responseService.getSuccessResult();
  }

  @DeleteMapping("/{id}")
  @ApiOperation("고객 게시판 삭제")
  public CommonResult deleteMemberBoard(@PathVariable Long id) {
    memberBoardService.deleteMemberBoard(id);
    return responseService.getSuccessResult();
  }
}
