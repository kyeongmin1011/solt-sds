package com.safetyas.sds.admin.api.service;

import com.safetyas.sds.common.model.MemberBoardCommentDTO;
import com.safetyas.sds.common.service.MemberBoardCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminMemberBoardCommentService {

  private final MemberBoardCommentService commentService;

  public void insertMemberBoardComment(Long id, MemberBoardCommentDTO commentDto) {
    commentService.insertMemberBoardComment(id, commentDto.toEntity());
  }

  public void updateMemberBoardComment(Long id, MemberBoardCommentDTO commentDto) {
    commentService.updateMemberBoardComment(id, commentDto);
  }

  public void deleteMemberBoardComment(Long id) {
    commentService.deleteMemberBoardComment(id);
  }
}
