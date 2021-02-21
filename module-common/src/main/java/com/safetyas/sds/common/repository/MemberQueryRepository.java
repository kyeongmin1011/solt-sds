package com.safetyas.sds.common.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.entity.Member;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import static com.safetyas.sds.common.entity.QMember.member;

@Repository
public class MemberQueryRepository {

  private final JPAQueryFactory queryFactory;

  public MemberQueryRepository(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  public List<Member> findByMemberId(String memberId) {
    return queryFactory.selectFrom(member)
        .where(member.memberId.eq(memberId))
        .fetch();
  }
}
