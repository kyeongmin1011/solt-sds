package com.safetyas.sds.admin.api.controller;

import com.safetyas.sds.admin.api.response.CommonResult;
import com.safetyas.sds.admin.api.response.ResponseService;
import com.safetyas.sds.admin.api.response.SingleResult;
import com.safetyas.sds.admin.api.service.ApiMemberBoardService;
import com.safetyas.sds.common.model.MemberBoardDto;
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
@Api("고객 게시판")
@RestController
@RequiredArgsConstructor
@RequestMapping("/member-board")
public class MemberBoardController {

  private final ApiMemberBoardService apiMemberBoardService;
  private final ResponseService responseService;

  @GetMapping("/")
  @ApiOperation("고객 게시판 목록 조회")
  public SingleResult<?> selectMemberBoardList() {
    return null;
  }

  @GetMapping("/{id}")
  @ApiOperation("고객 게시판 조회")
  public SingleResult<MemberBoardDto> selectMemberBoard(@PathVariable Long id) {
    return responseService.getSingleResult(apiMemberBoardService.selectMemberBoard(id));
  }

  @PostMapping("/")
  @ApiOperation("고객 게시판 저장")
  public CommonResult insertMemberBoard(@RequestBody MemberBoardDto memberBoardDto) {
    apiMemberBoardService.insertMemberBoard(memberBoardDto);
    return responseService.getSuccessResult();
  }

  @PutMapping("/{id}")
  @ApiOperation("고객 게시판 수정")
  public CommonResult updateMemberBoard(@PathVariable Long id,
      @RequestBody MemberBoardDto memberBoardDto) {
    apiMemberBoardService.updateMemberBoard(id, memberBoardDto);
    return responseService.getSuccessResult();
  }

  @DeleteMapping("/{id}")
  @ApiOperation("고객 게시판 삭제")
  public CommonResult deleteMemberBoard(@PathVariable Long id) {
    apiMemberBoardService.deleteMemberBoard(id);
    return responseService.getSuccessResult();
  }
}
