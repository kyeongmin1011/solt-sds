package com.safetyas.sds.common.service;

import com.safetyas.sds.common.dto.FileDTO;
import com.safetyas.sds.common.entity.Member;
import com.safetyas.sds.common.entity.MemberBoard;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.MemberBoardDTO;
import com.safetyas.sds.common.repository.MemberBoardRepository;
import com.safetyas.sds.common.repository.MemberRepository;
import com.safetyas.sds.common.service.client.FileService;
import java.util.List;
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
  private final FileService fileService;
  private final ModelMapper modelMapper;

  @Transactional
  public Page<MemberBoardDTO> selectMemberBoardList(BoardSearchCondition condition,
      Pageable pageable) {
    return memberBoardRepository.selectMemberBoardList(condition, pageable);
  }

  @Transactional
  public MemberBoardDTO selectMemberBoard(Long id) {
    String relateTable = "sds_member_board";

    MemberBoardDTO memberBoardDto = modelMapper
        .map(memberBoardRepository.selectMemberBoard(id), MemberBoardDTO.class);

    List<FileDTO> fileDTOList = fileService.selectFileList(id, relateTable);

    if (!fileDTOList.isEmpty()) {
      fileDTOList.stream().forEach(file -> memberBoardDto.getFileDTOList().add(file));
    }
    return memberBoardDto;
  }

  @Transactional
  public long insertMemberBoard(MemberBoard memberBoard) {
    Member member = memberRepository.findById(1L).orElseThrow(NoSuchElementException::new);
    memberBoard.updateMember(member);
    return memberBoardRepository.save(memberBoard).getMemberBoardSeq();
  }

  @Transactional
  public void updateMemberBoard(Long id, MemberBoardDTO memberBoardDto) {
    MemberBoard memberBoard = memberBoardRepository.findById(id).orElseThrow(NoSuchElementException::new);
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
