package com.safetyas.sds.common.repository.admin;

import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.NoticeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoticeRepositoryCustom {
  Page<NoticeDto> selectNoticeList(BoardSearchCondition condition, Pageable pageable);
}
