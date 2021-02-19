package com.safetyas.sds.admin.api.controller;

import com.safetyas.sds.admin.api.response.CommonResult;
import com.safetyas.sds.admin.api.response.ResponseService;
import com.safetyas.sds.admin.api.service.AdminMemberBoardCommentService;
import com.safetyas.sds.common.model.MemberBoardCommentDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class MemberBoardCommentController {

  private final ResponseService responseService;
  private final AdminMemberBoardCommentService commentService;

  @PostMapping("/{id}")
  @ApiOperation("1:1 게시판 댓글 저장")
  public CommonResult insertMemberBoardComment(@PathVariable Long id,
      @RequestBody MemberBoardCommentDto commentDto) {
    commentService.insertMemberBoardComment(id, commentDto);
    return responseService.getSuccessResult();
  }

  @PutMapping("/{id}")
  @ApiOperation("1:1 게시판 댓글 수정")
  public CommonResult updateMemberBoardComment(@PathVariable Long id,
      @RequestBody MemberBoardCommentDto commentDto) {
    commentService.updateMemberBoardComment(id, commentDto);
    return responseService.getSuccessResult();
  }

  @DeleteMapping("/{id}")
  @ApiOperation("1:1 게시판 댓글 삭제")
  public CommonResult deleteMemberBoardComment(@PathVariable Long id) {
    commentService.deleteMemberBoardComment(id);
    return responseService.getSuccessResult();
  }
}
