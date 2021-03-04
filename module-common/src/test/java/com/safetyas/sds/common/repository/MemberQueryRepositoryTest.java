package com.safetyas.sds.common.repository;

import com.safetyas.sds.common.entity.Member;
import com.safetyas.sds.common.model.BoardSearchCondition;
import java.util.List;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class MemberQueryRepositoryTest {

  @Autowired
  MemberRepository memberRepository;
  @Autowired
  MemberQueryRepository memberQueryRepository;

  @Test
  void testMemberQuery() {
    //given
    String id = "test1";
    Member member = Member.builder()
        .memberId(id)
        .level(1)
        .role("USER")
        .build();
    memberRepository.save(member);

    //when
    List<Member> result = memberQueryRepository.findByMemberId("test1");

    System.out.println(result.get(0).getMemberId());
    //then
    assertThat(result.get(0).getMemberId()).isEqualTo(member.getMemberId());
  }

  @Test
  public void isEmptyTest(){
    BoardSearchCondition boardSearchCondition = new BoardSearchCondition();

    boardSearchCondition.setCategory("123123");

    boolean empty = Strings.isEmpty(boardSearchCondition.getCategory());

    System.out.println(empty);
  }

}