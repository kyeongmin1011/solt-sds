package com.safetyas.sds.client.api.service;

import com.safetyas.sds.common.service.MemberBoardService;
import com.safetyas.sds.common.service.admin.FaqService;
import com.safetyas.sds.common.service.admin.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientMainService {

  private final NoticeService noticeService;
  private final FaqService faqService;
  private final MemberBoardService memberBoardService;

  public void selectClientMain() {

    noticeService.findTop5ByOrderByNoticeSeqDesc();
  }
}
