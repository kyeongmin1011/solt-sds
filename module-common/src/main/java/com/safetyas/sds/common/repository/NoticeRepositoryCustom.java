package com.safetyas.sds.common.repository;

import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.NoticeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoticeRepositoryCustom {
  Page<NoticeDTO> selectNoticeList(BoardSearchCondition condition, Pageable pageable);
}
