package com.safetyas.sds.admin.api.service;

import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.MemberBoardDto;
import com.safetyas.sds.common.service.admin.MemberBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminMemberBoardService {

  private final MemberBoardService memberBoardService;

  public Page<MemberBoardDto> selectMemberBoardList(BoardSearchCondition condition,
      Pageable pageable) {
    return memberBoardService.selectMemberBoardList(condition, pageable);
  }

  public MemberBoardDto selectMemberBoard(Long id) {
    return memberBoardService.selectMemberBoard(id);
  }

  public void insertMemberBoard(MemberBoardDto memberBoardDto) {
    memberBoardService.insertMemberBoard(memberBoardDto.toEntity());
  }

  public void updateMemberBoard(Long id, MemberBoardDto memberBoardDto) {
    memberBoardService.updateMemberBoard(id, memberBoardDto);
  }

  public void deleteMemberBoard(Long id) {
    memberBoardService.deleteMemberBoard(id);
  }
}
