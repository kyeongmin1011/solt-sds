package com.safetyas.sds.common.service;

import com.safetyas.sds.common.entity.Notice;
import com.safetyas.sds.common.model.NoticeDto;
import com.safetyas.sds.common.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeService {

  private final NoticeRepository noticeRepository;

  public void insertNotice(NoticeDto noticeDto) {
    log.info(noticeDto.toString());
    Notice notice = noticeDto.toEntity(noticeDto);
    noticeRepository.save(notice);
  }
}
