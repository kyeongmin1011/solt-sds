package com.safetyas.sds.admin.api.service;

import com.safetyas.sds.admin.api.util.FileUtil;
import com.safetyas.sds.common.entity.File;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.FileDTO;
import com.safetyas.sds.common.model.MemberBoardCommentDTO;
import com.safetyas.sds.common.model.MemberBoardDTO;
import com.safetyas.sds.common.service.MemberBoardCommentService;
import com.safetyas.sds.common.service.MemberBoardService;
import com.safetyas.sds.common.service.client.FileService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
@RequiredArgsConstructor
public class AdminMemberBoardService {

  private final MemberBoardCommentService commentService;
  private final MemberBoardService memberBoardService;
  private final FileUtil fileUtil;
  private final FileService fileService;

  private static final String PATH_NAME = "memberBoardComment";
  private static final String TABLE_NAME = "sds_member_board_comment";
  private static final String TYPE_NAME = "attach";

  public Page<MemberBoardDTO> selectMemberBoardList(Pageable pageable,
      BoardSearchCondition condition) {
    return memberBoardService.selectMemberBoardList(pageable, condition);
  }

  public MemberBoardDTO selectMemberBoard(Long id) {
    return memberBoardService.selectMemberBoard(id);
  }

  public void insertMemberBoardComment(Long id, MemberBoardCommentDTO commentDto,
      MultipartHttpServletRequest multipartHttpServletRequest) {
    long seq = commentService.insertMemberBoardComment(id, commentDto.toEntity());
    insertFile(seq, multipartHttpServletRequest);
  }

  public void updateMemberBoardComment(Long id, MemberBoardCommentDTO commentDTO,
      MultipartHttpServletRequest multipartHttpServletRequest) {
    long seq = commentService.updateMemberBoardComment(id, commentDTO);
  }

  public void deleteMemberBoardComment(Long id) {
    commentService.deleteMemberBoardComment(id);
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

  private void updateFile(long commentSeq, MemberBoardCommentDTO commentDTO,
      MultipartHttpServletRequest multipartHttpServletRequest) {
    List<Long> originFileList = fileService.selectFileList(commentSeq, TABLE_NAME)
        .stream()
        .map(FileDTO::getFileSeq)
        .collect(Collectors.toList());

    List<Long> responseFileList = commentDTO.getFileList()
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
    insertFile(commentSeq, multipartHttpServletRequest);
  }
}
