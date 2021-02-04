package com.safetyas.sds.common.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.entity.Member;
import com.safetyas.sds.common.entity.QMember;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MemberQueryRepository {
  private final JPAQueryFactory queryFactory;

  public List<Member> findByMemberId(String memberId) {
    return queryFactory.selectFrom(QMember.member)
        .where(QMember.member.memberId.eq(memberId))
        .fetch();
  }

}
