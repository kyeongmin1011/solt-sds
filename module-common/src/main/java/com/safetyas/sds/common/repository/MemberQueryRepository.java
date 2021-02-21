package com.safetyas.sds.common.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.entity.Member;
import com.safetyas.sds.common.model.ClientMainMyPageDTO;
import com.safetyas.sds.common.model.QClientMainMyPageDTO;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import static com.safetyas.sds.common.entity.QMember.member;
import static com.safetyas.sds.common.entity.QMemberInfo.memberInfo;

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

  public ClientMainMyPageDTO selectClientMainMemberInfo(long id) {
    return queryFactory.select(new QClientMainMyPageDTO(member.memberInfo.memberValidStart,member.memberInfo.memberValidFinish))
        .from(member)
        .leftJoin(member.memberInfo, memberInfo)
        .where(member.memberSeq.eq(id))
        .fetchOne();
  }
}
