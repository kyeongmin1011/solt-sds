package com.safetyas.sds.common.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.safetyas.sds.common.entity.Member;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
class MemberRepositoryTest {

  @Autowired
  MemberRepository memberRepository;

  @Test
  void testMemberRepo(){
    //given
    String id = "test1";
    Member member = Member.builder()
        .memberId(id)
        .level(1)
        .role("USER")
        .build();
    memberRepository.save(member);

    //when
    List<Member> result = memberRepository.findAll();

    //then
    assertThat(result.size()).isEqualTo(1);
    assertThat(result.get(0).getMemberId()).isEqualTo(member.getMemberId());
  }


}