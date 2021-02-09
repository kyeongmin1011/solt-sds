package com.safetyas.sds.common.service.admin;

import com.safetyas.sds.common.entity.Member;
import com.safetyas.sds.common.entity.MemberBoard;
import com.safetyas.sds.common.model.MemberBoardDto;
import com.safetyas.sds.common.repository.MemberBoardRepository;
import com.safetyas.sds.common.repository.MemberRepository;
import java.util.NoSuchElementException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    memberBoardRepository.save(memberBoard);
  }

  @Transactional
  public void updateMemberBoard(Long id, MemberBoardDto memberBoardDto) {
    MemberBoard memberBoard = memberBoardRepository.findById(id)
        .orElseThrow(NoSuchElementException::new);
    memberBoard.updateMemberBoard(memberBoardDto);
    memberBoardRepository.save(memberBoard);
  }

  @Transactional
  public void deleteMemberBoard(Long id) {
    MemberBoard memberBoard = memberBoardRepository.findById(id)
        .orElseThrow(NoSuchElementException::new);
    memberBoard.updateDelDate();
    memberBoardRepository.save(memberBoard);
  }
}
