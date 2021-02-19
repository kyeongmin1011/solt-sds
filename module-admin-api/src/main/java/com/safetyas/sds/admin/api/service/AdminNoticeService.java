package com.safetyas.sds.admin.api.service;

import com.safetyas.sds.admin.api.util.FileUtil;
import com.safetyas.sds.common.dto.FileDTO;
import com.safetyas.sds.common.entity.File;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.NoticeDTO;
import com.safetyas.sds.common.service.admin.NoticeService;
import com.safetyas.sds.common.service.client.FileService;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
@RequiredArgsConstructor
public class AdminNoticeService {

  private final NoticeService noticeService;
  private final FileService fileService;
  private final FileUtil fileUtil;

  private static final String PATH = "notice";
  private static final String RELATE_TABLE = "sds_notice";
  private static final String TYPE = "attach";

  public NoticeDTO selectNotice(Long id) {
    return noticeService.selectNotice(id);
  }

  public void insertNotice(NoticeDTO noticeDto,
      MultipartHttpServletRequest multipartHttpServletRequest) {
    long noticeSeq = noticeService.insertNotice(noticeDto.toEntity());

    if (multipartHttpServletRequest.getFile(TYPE) != null) {
      insertFile(noticeSeq, multipartHttpServletRequest);
    }
  }

  public void updateNotice(Long noticeSeq, NoticeDTO noticeDto,
      MultipartHttpServletRequest multipartHttpServletRequest) {
    noticeService.updateNotice(noticeSeq, noticeDto);

    if (multipartHttpServletRequest.getFile(TYPE) != null) {
      updateFile(noticeSeq, multipartHttpServletRequest);
    }
  }

  public void deleteNotice(Long id) {
    noticeService.deleteNotice(id);
  }

  public Page<NoticeDTO> selectNoticeList(BoardSearchCondition condition, Pageable pageable) {
    return noticeService.selectNoticeList(condition, pageable);
  }

  private void insertFile(long noticeSeq, MultipartHttpServletRequest multipartHttpServletRequest) {
    Map<String, Object> info = new HashMap<>();
    info.put("path", PATH);
    info.put("relateTable", RELATE_TABLE);
    info.put("recordSeq", noticeSeq);
    info.put("type", TYPE);
    info.put("regUserSeq", noticeSeq);

    FileDTO companyFile = fileUtil.parseFile(multipartHttpServletRequest.getFile(TYPE), info);
    fileService.saveFile(companyFile);
  }

  private void updateFile(long noticeSeq, MultipartHttpServletRequest multipartHttpServletRequest) {
    FileDTO fileDTO = FileDTO.builder()
        .relateTable(RELATE_TABLE)
        .recordSeq(noticeSeq)
        .type(TYPE)
        .build();

    File preFile = fileService.selectFileByFileDTO(fileDTO);
    fileUtil.deleteFile(preFile.getPath(), preFile.getName());
    preFile.updateDelDate();
    fileService.saveFile(preFile);


    insertFile(noticeSeq, multipartHttpServletRequest);
  }
}
