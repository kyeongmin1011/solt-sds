package com.safetyas.sds.common.service;

import com.safetyas.sds.common.entity.Member;
import com.safetyas.sds.common.entity.MemberBoard;
import com.safetyas.sds.common.entity.MemberBoardComment;
import com.safetyas.sds.common.model.MemberBoardCommentDto;
import com.safetyas.sds.common.repository.MemberBoardCommentRepository;
import com.safetyas.sds.common.repository.MemberBoardRepository;
import com.safetyas.sds.common.repository.MemberRepository;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberBoardCommentService {

  private final MemberBoardCommentRepository commentRepository;
  private final MemberBoardRepository memberBoardRepository;
  private final MemberRepository memberRepository;

  public void insertMemberBoardComment(Long id, MemberBoardComment memberBoardComment) {
    Member member = memberRepository.findById(1L).orElseThrow(NoSuchElementException::new);
    MemberBoard memberBoard = memberBoardRepository.findById(id)
        .orElseThrow(NoSuchElementException::new);
    memberBoardComment.updateMemberBoard(memberBoard);
    memberBoardComment.updateMember(member);
    commentRepository.save(memberBoardComment);
  }

  public void updateMemberBoardComment(Long id, MemberBoardCommentDto commentDto) {
    MemberBoardComment memberBoardComment = commentRepository.findById(id)
        .orElseThrow(NoSuchElementException::new);
    memberBoardComment.updateMemberBoardComment(commentDto);
    commentRepository.save(memberBoardComment);
  }

  public void deleteMemberBoardComment(Long id) {
    MemberBoardComment memberBoardComment = commentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    memberBoardComment.updateDelDate();
    commentRepository.save(memberBoardComment);
  }
}
