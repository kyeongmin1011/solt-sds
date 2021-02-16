package com.safetyas.sds.common.repository.admin;

import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.MemberBoardDto;
import com.safetyas.sds.common.repository.MemberBoardRepository;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootTest

class MemberBoardRepositoryImplTest {

  @Autowired
  MemberBoardRepository memberBoardRepository;

  @Autowired
  EntityManager em;

  @Test
  public void pageTest() {

    BoardSearchCondition condition = new BoardSearchCondition();
    PageRequest pageRequest = PageRequest.of(1, 3);

    Page<MemberBoardDto> result = memberBoardRepository
        .selectMemberBoardList(condition, pageRequest);

  }
}