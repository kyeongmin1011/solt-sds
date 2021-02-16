package com.safetyas.sds.common.service.admin;

import com.safetyas.sds.common.entity.Member;
import com.safetyas.sds.common.entity.MemberBoard;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.MemberBoardDto;
import com.safetyas.sds.common.repository.MemberBoardRepository;
import com.safetyas.sds.common.repository.MemberRepository;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberBoardService {

  private final MemberBoardRepository memberBoardRepository;
  private final MemberRepository memberRepository;
  private final ModelMapper modelMapper;


  @Transactional
  public MemberBoardDto selectMemberBoard(Long id) {
    return modelMapper.map(memberBoardRepository.findById(id), MemberBoardDto.class);
  }

  @Transactional
  public void insertMemberBoard(MemberBoard memberBoard) {
    Member member = memberRepository.findById(1L).orElseThrow(NoSuchElementException::new);
    memberBoard.updateMember(member);
    memberBoardRepository.save(memberBoard);
  }

  @Transactional
  public void updateMemberBoard(Long id, MemberBoardDto memberBoardDto) {

    Member member = memberRepository.findById(1L).orElseThrow(NoSuchElementException::new);
    MemberBoard memberBoard = memberBoardRepository.findById(id)
        .orElseThrow(NoSuchElementException::new);
    memberBoard.updateMemberBoard(memberBoardDto, member);
    memberBoardRepository.save(memberBoard);
  }

  @Transactional
  public void deleteMemberBoard(Long id) {
    MemberBoard memberBoard = memberBoardRepository.findById(id)
        .orElseThrow(NoSuchElementException::new);
    memberBoard.updateDelDate();
    memberBoardRepository.save(memberBoard);
  }

  public Page<MemberBoardDto> selectMemberBoardList(BoardSearchCondition condition,
      Pageable pageable) {
    return memberBoardRepository.searchMemberBoard(condition, pageable);
  }
}
