package com.safetyas.sds.client.api.controller;

import com.safetyas.sds.client.api.response.CommonResult;
import com.safetyas.sds.client.api.response.ResponseService;
import com.safetyas.sds.client.api.response.SingleResult;
import com.safetyas.sds.client.api.service.ClientMemberBoardService;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.MemberBoardDTO;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Slf4j
@Api("고객 게시판")
@RestController
@RequiredArgsConstructor
@RequestMapping("/member-board")
public class MemberBoardController {

  private final ClientMemberBoardService clientMemberBoardService;
  private final ResponseService responseService;

  @GetMapping("")
  @ApiOperation("고객 게시판 목록 조회")
  public SingleResult<Page<MemberBoardDTO>> selectMemberBoardList(
      @PageableDefault Pageable pageable, BoardSearchCondition condition) {
    return responseService.getSingleResult(
        clientMemberBoardService.selectMemberBoardList(pageable, condition));
  }

  @GetMapping("/{id}")
  @ApiOperation("고객 게시판 조회")
  public SingleResult<MemberBoardDTO> selectMemberBoard(@PathVariable Long id) {
    return responseService.getSingleResult(clientMemberBoardService.selectMemberBoard(id));
  }

  @PostMapping("")
  @ApiOperation("고객 게시판 저장")
  public CommonResult insertMemberBoard(MemberBoardDTO memberBoardDto,
      MultipartHttpServletRequest multipartHttpServletRequest) {
    clientMemberBoardService.insertMemberBoard(memberBoardDto, multipartHttpServletRequest);
    return responseService.getSuccessResult();
  }

  @PutMapping("/{id}")
  @ApiOperation("고객 게시판 수정")
  public CommonResult updateMemberBoard(@PathVariable Long id,
      MemberBoardDTO memberBoardDto, MultipartHttpServletRequest multipartHttpServletRequest) {
    clientMemberBoardService.updateMemberBoard(id, memberBoardDto, multipartHttpServletRequest);
    return responseService.getSuccessResult();
  }

  @DeleteMapping("/{id}")
  @ApiOperation("고객 게시판 삭제")
  public CommonResult deleteMemberBoard(@PathVariable Long id) {
    clientMemberBoardService.deleteMemberBoard(id);
    return responseService.getSuccessResult();
  }
}

