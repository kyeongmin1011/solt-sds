package com.safetyas.sds.admin.api.service;

import com.safetyas.sds.admin.api.util.FileUtil;
import com.safetyas.sds.common.entity.File;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.FileDTO;
import com.safetyas.sds.common.model.MemberBoardDTO;
import com.safetyas.sds.common.service.MemberBoardService;
import com.safetyas.sds.common.service.client.FileService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminMemberBoardService {

  private final MemberBoardService memberBoardService;
  private final FileService fileService;
  private final FileUtil fileUtil;

  private static final String TYPE_NAME = "attach";
  private static final String TABLE_NAME = "sds_member_board";
  private static final String PATH_NAME = "memberBoard";

  public Page<MemberBoardDTO> selectMemberBoardList(Pageable pageable,
      BoardSearchCondition condition) {
    return memberBoardService.selectMemberBoardList(pageable, condition);
  }

  public MemberBoardDTO selectMemberBoard(Long id) {
    return memberBoardService.selectMemberBoard(id);
  }

  public void insertMemberBoard(MemberBoardDTO memberBoardDto,
      MultipartHttpServletRequest multipartHttpServletRequest) {
    long seq = memberBoardService.insertMemberBoard(memberBoardDto.toEntity());
    insertFile(seq, multipartHttpServletRequest);
  }

  public void updateMemberBoard(Long id, MemberBoardDTO memberBoardDto,
      MultipartHttpServletRequest multipartHttpServletRequest) {
    memberBoardService.updateMemberBoard(id, memberBoardDto);

    if (!multipartHttpServletRequest.getFiles(TYPE_NAME).isEmpty()) {
      updateFile(id, memberBoardDto, multipartHttpServletRequest);
    }
  }

  public void deleteMemberBoard(Long id) {
    memberBoardService.deleteMemberBoard(id);
  }

  private void insertFile(long seq, MultipartHttpServletRequest multipartHttpServletRequest) {
    List<MultipartFile> attachList = multipartHttpServletRequest.getFiles(TYPE_NAME);
    Map<String, MultipartFile> fileMap = new HashMap<>();

    int i = 1;
    for (MultipartFile multipartFile : attachList) {
      fileMap.put(TYPE_NAME + i, multipartFile);
      i++;
    }

    Map<String, Object> info = new HashMap<>();

    info.put("path", PATH_NAME);
    info.put("relateTable", TABLE_NAME);
    info.put("recordSeq", seq);
    info.put("type", TYPE_NAME);
    info.put("regUserSeq", seq);

    List<File> fileList = fileUtil.parseFiles(fileMap, info)
        .stream()
        .map(FileDTO::toEntity)
        .collect(Collectors.toList());
    fileService.saveFiles(fileList);
  }

  private void updateFile(long memberBoardSeq, MemberBoardDTO memberBoardDto,
      MultipartHttpServletRequest multipartHttpServletRequest) {

    List<Long> originFileList = fileService.selectFileList(memberBoardSeq, TABLE_NAME)
        .stream()
        .map(FileDTO::getFileSeq)
        .collect(Collectors.toList());

    List<Long> responseFileList = memberBoardDto.getFileList()
        .stream()
        .map(FileDTO::getFileSeq)
        .collect(Collectors.toList());

    if (!originFileList.isEmpty()) {
      originFileList.removeAll(responseFileList);

      for (Long fileSeq : originFileList) {
        File file = fileService.selectFile(fileSeq);
        file.updateDelDate();
        fileService.saveFile(file);
        fileUtil.deleteFile(file.getPath(), file.getName());
      }
    }
    insertFile(memberBoardSeq, multipartHttpServletRequest);
  }
}
