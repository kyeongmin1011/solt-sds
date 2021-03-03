package com.safetyas.sds.common.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.entity.MemberSupplier;
import com.safetyas.sds.common.entity.QMemberSupplier;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import static com.safetyas.sds.common.entity.QMember.member;
import static com.safetyas.sds.common.entity.msds.QProduct.product;

@Repository
public class MemberSupplierQueryRepository {

  private final JPAQueryFactory queryFactory;
  private final QMemberSupplier memberSupplier;

  public MemberSupplierQueryRepository (EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
    memberSupplier = new QMemberSupplier("memberSupplier");
  }

  public List<MemberSupplier> selectMemberSuppliers (Long memberSeq) {
    return queryFactory.selectFrom(memberSupplier)
        .leftJoin(memberSupplier.member, member)
        .where(member.memberSeq.eq(memberSeq))
        .orderBy(memberSupplier.inDate.desc())
        .fetch();
  }

     public boolean existsByProduct(Long memberSupplierSeq) {
    return queryFactory.selectFrom(memberSupplier)
        .leftJoin(memberSupplier.productList, product)
        .where(memberSupplier.memberSupplierSeq.eq(memberSupplierSeq))
        .fetchFirst() != null;
  }
}
