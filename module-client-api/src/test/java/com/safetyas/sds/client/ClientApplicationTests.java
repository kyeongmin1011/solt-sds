package com.safetyas.sds.client;

import static org.assertj.core.api.Assertions.assertThat;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.entity.Member;
import com.safetyas.sds.common.entity.QMember;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ClientApplicationTests {
  @Autowired
  EntityManager em;

  @BeforeEach
  public void before() {
    Member member = Member.builder().memberId("test11").build();
    em.persist(member);

    JPAQueryFactory query = new JPAQueryFactory(em);
    QMember qMember = QMember.member;

    Member result = query
        .selectFrom(qMember)
        .fetchOne();

    assertThat(result).isEqualTo(member);
    assertThat(result.getMemberId()).isEqualTo(member.getMemberId());
  }

}
