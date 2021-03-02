package com.safetyas.sds.client.api.service;

import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.FaqDTO;
import com.safetyas.sds.common.model.NoticeDTO;
import com.safetyas.sds.common.service.admin.FaqService;
import com.safetyas.sds.common.service.admin.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientInformService {

  private final FaqService faqService;
  private final NoticeService noticeService;

  public Page<FaqDTO> selectFaqList(Pageable pageable, BoardSearchCondition condition) {
    return faqService.selectFaqList(pageable, condition);
  }

  public FaqDTO selectFaq(Long id) {
    return faqService.selectFaq(id);
  }

  public Page<NoticeDTO> selectNoticeList(Pageable pageable, BoardSearchCondition condition) {
    return noticeService.selectNoticeList(pageable, condition);
  }

  public NoticeDTO selectNotice(Long id) {
    return noticeService.selectNotice(id);
  }
}
