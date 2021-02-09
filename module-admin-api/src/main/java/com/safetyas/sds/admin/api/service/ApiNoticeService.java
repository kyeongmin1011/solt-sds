package com.safetyas.sds.admin.api.service;

import com.safetyas.sds.common.model.NoticeDto;
import com.safetyas.sds.common.service.admin.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiNoticeService {

  private final NoticeService noticeService;

  public NoticeDto selectNotice(Long id) {
    return noticeService.selectNotice(id);
  }

  public void insertNotice(NoticeDto noticeDto) {
    noticeService.insertNotice(noticeDto);
  }

  public void updateNotice(Long id, NoticeDto noticeDto) {
    noticeService.updateNotice(id, noticeDto);
  }

  public void deleteNotice(Long id) {
    noticeService.deleteNotice(id);
  }
}
