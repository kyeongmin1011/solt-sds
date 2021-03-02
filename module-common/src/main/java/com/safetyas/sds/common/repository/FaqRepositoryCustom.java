package com.safetyas.sds.common.repository;

import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.FaqDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FaqRepositoryCustom {

  Page<FaqDTO> selectFaqList(Pageable pageable, BoardSearchCondition condition);
}
