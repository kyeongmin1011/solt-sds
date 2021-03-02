package com.safetyas.sds.admin.api.service;

import com.safetyas.sds.admin.api.util.FileUtil;
import com.safetyas.sds.common.entity.File;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.FaqDTO;
import com.safetyas.sds.common.model.FileDTO;
import com.safetyas.sds.common.service.admin.FaqService;
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
public class AdminFaqService {

  private final FaqService faqService;
  private final FileService fileService;
  private final FileUtil fileUtil;

  private static final String PATH_NAME = "faq";
  private static final String RELATE_TABLE_NAME = "sds_faq";
  private static final String TYPE_NAME = "attach";

  public FaqDTO selectFaq(Long id) {
    return faqService.selectFaq(id);
  }

  public void insertFaq(FaqDTO faqDto, MultipartHttpServletRequest multipartHttpServletRequest) {
    long faqSeq = faqService.insertFaq(faqDto.toEntity());
    if (multipartHttpServletRequest.getFile(TYPE_NAME) != null) {
      insertFile(faqSeq, multipartHttpServletRequest);
    }
  }

  public void updateFaq(Long faqSeq, FaqDTO faqDto,
      MultipartHttpServletRequest multipartHttpServletRequest) {
    faqService.updateFaq(faqSeq, faqDto);

    if (multipartHttpServletRequest.getFile(PATH_NAME) != null) {
      updateFile(faqSeq, multipartHttpServletRequest);
    }
  }

  public void deleteFaq(Long id) {
    faqService.deleteFaq(id);
  }

  public Page<FaqDTO> selectFaqList(Pageable pageable, BoardSearchCondition condition) {
    return faqService.selectFaqList(pageable,condition);
  }

  private void insertFile(long faqSeq, MultipartHttpServletRequest multipartHttpServletRequest) {
    Map<String, Object> info = new HashMap<>();
    info.put("path", PATH_NAME);
    info.put("relateTable", RELATE_TABLE_NAME);
    info.put("recordSeq", faqSeq);
    info.put("type", TYPE_NAME);
    info.put("regUserSeq", faqSeq);

    FileDTO companyFile = fileUtil.parseFile(multipartHttpServletRequest.getFile(TYPE_NAME), info);
    fileService.saveFile(companyFile);
  }

  private void updateFile(long faqSeq, MultipartHttpServletRequest multipartHttpServletRequest) {
    FileDTO fileDTO = FileDTO.builder()
        .relateTable(RELATE_TABLE_NAME)
        .recordSeq(faqSeq)
        .type(TYPE_NAME)
        .build();

    File preFile = fileService.selectFileByFileDTO(fileDTO);
    fileUtil.deleteFile(preFile.getPath(), preFile.getName());

    insertFile(faqSeq, multipartHttpServletRequest);
  }
}
