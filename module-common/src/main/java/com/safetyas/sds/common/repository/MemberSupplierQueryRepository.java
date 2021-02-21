package com.safetyas.sds.common.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.entity.MemberSupplier;
import com.safetyas.sds.common.entity.QMember;
import com.safetyas.sds.common.entity.QMemberSupplier;
import com.safetyas.sds.common.entity.QProduct;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

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
        .leftJoin(memberSupplier.member, QMember.member)
        .where(
            QMember.member.memberSeq.eq(memberSeq))
        .orderBy(memberSupplier.inDate.desc())
        .fetch();
  }

  public boolean existsByProduct(Long memberSupplierSeq) {
    QProduct product = new QProduct("product");
    return queryFactory.selectFrom(memberSupplier)
        .join(product.memberSupplier, memberSupplier).fetchJoin()
        .where(memberSupplier.memberSupplierSeq.eq(memberSupplierSeq))
        .fetchFirst() != null;
  }
}
