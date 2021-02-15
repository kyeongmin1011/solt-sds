package com.safetyas.sds.common.repository;

import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.MemberBoardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberBoardRepositoryCustom {
  Page<MemberBoardDto> searchMemberBoard(BoardSearchCondition boardSearchCondition, Pageable pageable);
}
