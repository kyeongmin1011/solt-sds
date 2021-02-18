package com.safetyas.sds.common.repository;

import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.FaqDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FaqRepositoryCustom {

  Page<FaqDto> selectFaqList(BoardSearchCondition condition, Pageable pageable);
}
