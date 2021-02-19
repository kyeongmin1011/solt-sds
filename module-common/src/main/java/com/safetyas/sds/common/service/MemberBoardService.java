package com.safetyas.sds.common.service;

import com.safetyas.sds.common.dto.FileDTO;
import com.safetyas.sds.common.entity.File;
import com.safetyas.sds.common.entity.Member;
import com.safetyas.sds.common.entity.MemberBoard;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.MemberBoardDto;
import com.safetyas.sds.common.repository.FileQueryRepository;
import com.safetyas.sds.common.repository.FileRepository;
import com.safetyas.sds.common.repository.MemberBoardRepository;
import com.safetyas.sds.common.repository.MemberRepository;
import com.safetyas.sds.common.service.client.FileService;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
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
  public Page<MemberBoardDto> selectMemberBoardList(BoardSearchCondition condition,
      Pageable pageable) {
    return memberBoardRepository.selectMemberBoardList(condition, pageable);
  }

  @Transactional
  public MemberBoardDto selectMemberBoard(Long id) {
    String relateTable = "sds_member_board";

    MemberBoardDto memberBoardDto = modelMapper
        .map(memberBoardRepository.selectMemberBoard(id), MemberBoardDto.class);

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
  public void updateMemberBoard(Long id, MemberBoardDto memberBoardDto) {
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
