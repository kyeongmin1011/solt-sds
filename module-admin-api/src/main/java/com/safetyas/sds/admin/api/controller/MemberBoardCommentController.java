package com.safetyas.sds.admin.api.controller;

import com.safetyas.sds.admin.api.response.CommonResult;
import com.safetyas.sds.admin.api.response.ResponseService;
import com.safetyas.sds.admin.api.service.AdminMemberBoardCommentService;
import com.safetyas.sds.common.model.MemberBoardCommentDto;
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
  public CommonResult insertMemberBoardComment(@PathVariable Long id,
      @RequestBody MemberBoardCommentDto commentDto) {
    commentService.insertMemberBoardComment(id, commentDto);
    return responseService.getSuccessResult();
  }

  @PutMapping("/{id}")
  public CommonResult updateMemberBoardComment(@PathVariable Long id,
      @RequestBody MemberBoardCommentDto commentDto) {
    commentService.updateMemberBoardComment(id, commentDto);
    return responseService.getSuccessResult();
  }

  @DeleteMapping("/{id}")
  public CommonResult deleteMemberBoardComment(@PathVariable Long id) {
    commentService.deleteMemberBoardComment(id);
    return responseService.getSuccessResult();
  }
}
