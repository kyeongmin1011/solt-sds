package com.safetyas.sds.common.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.repository.MemberQueryRepository;
import com.safetyas.sds.common.repository.MemberRepository;
import javax.persistence.EntityManager;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class MemberTest {

  @Autowired
  private MemberRepository memberRepository;

  @Autowired
  private MemberQueryRepository memberQueryRepository;

  @BeforeEach
  public void before() {
    Member member = Member.builder().memberId("test11").build();

  }

  @Test
  public void memberQueryTest() {
    //givin
  }

}