package com.safetyas.sds.common.repository;

import com.safetyas.sds.common.entity.MemberBoard;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.MemberBoardDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberBoardRepositoryCustom {

  Page<MemberBoardDTO> selectMemberBoardList(Pageable pageable, BoardSearchCondition condition);

  MemberBoard selectMemberBoard(Long id);

  List<MemberBoardDTO> selectClientMainMemberBoardList(Long id);
}
