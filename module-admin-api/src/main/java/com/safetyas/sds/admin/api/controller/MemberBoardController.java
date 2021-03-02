package com.safetyas.sds.admin.api.controller;

import com.safetyas.sds.admin.api.response.CommonResult;
import com.safetyas.sds.admin.api.response.ResponseService;
import com.safetyas.sds.admin.api.response.SingleResult;
import com.safetyas.sds.admin.api.service.AdminMemberBoardService;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.MemberBoardCommentDTO;
import com.safetyas.sds.common.model.MemberBoardDTO;
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
@RestController
@RequestMapping("/member-board-comment")
@RequiredArgsConstructor
public class MemberBoardController {

  private final ResponseService responseService;
  private final AdminMemberBoardService adminMemberBoardService;

  @GetMapping("")
  @ApiOperation("고객 게시판 목록 조회")
  public SingleResult<Page<MemberBoardDTO>> selectMemberBoardList(
      @PageableDefault Pageable pageable, BoardSearchCondition condition) {
    return responseService.getSingleResult(
        adminMemberBoardService.selectMemberBoardList(pageable, condition));
  }

  @GetMapping("/{id}")
  @ApiOperation("고객 게시판 조회")
  public SingleResult<MemberBoardDTO> selectMemberBoard(@PathVariable Long id) {
    return responseService.getSingleResult(adminMemberBoardService.selectMemberBoard(id));
  }

  @PostMapping("/{id}")
  @ApiOperation("1:1 게시판 댓글 저장")
  public CommonResult insertMemberBoardComment(@PathVariable Long id,
      MemberBoardCommentDTO commentDto, MultipartHttpServletRequest multipartHttpServletRequest) {
    adminMemberBoardService.insertMemberBoardComment(id, commentDto, multipartHttpServletRequest);
    return responseService.getSuccessResult();
  }

  @PutMapping("/{id}")
  @ApiOperation("1:1 게시판 댓글 수정")
  public CommonResult updateMemberBoardComment(@PathVariable Long id,
      MemberBoardCommentDTO commentDto, MultipartHttpServletRequest multipartHttpServletRequest) {
    adminMemberBoardService.updateMemberBoardComment(id, commentDto, multipartHttpServletRequest);
    return responseService.getSuccessResult();
  }

  @DeleteMapping("/{id}")
  @ApiOperation("1:1 게시판 댓글 삭제")
  public CommonResult deleteMemberBoardComment(@PathVariable Long id) {
    adminMemberBoardService.deleteMemberBoardComment(id);
    return responseService.getSuccessResult();
  }
}
