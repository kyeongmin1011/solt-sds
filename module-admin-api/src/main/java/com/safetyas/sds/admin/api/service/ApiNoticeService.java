package com.safetyas.sds.admin.api.service;

import com.safetyas.sds.common.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiNoticeService {

  private final NoticeService noticeService;

}
