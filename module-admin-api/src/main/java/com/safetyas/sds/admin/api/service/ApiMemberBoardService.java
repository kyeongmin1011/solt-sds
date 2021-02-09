package com.safetyas.sds.admin.api.service;

import com.safetyas.sds.common.model.MemberBoardDto;
import com.safetyas.sds.common.service.admin.MemberBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiMemberBoardService {

  private final MemberBoardService memberBoardService;

  public MemberBoardDto selectMemberBoard(Long id) {
    return memberBoardService.selectMemberBoard(id);
  }

  public void insertMemberBoard(MemberBoardDto memberBoardDto) {
    memberBoardService.insertMemberBoard(memberBoardDto.toEntity());
  }

  public void updateMemberBoard(Long id, MemberBoardDto memberBoardDto) {
    memberBoardService.updateMemberBoard(id,memberBoardDto);
  }

  public void deleteMemberBoard(Long id) {
    memberBoardService.deleteMemberBoard(id);
  }
}
