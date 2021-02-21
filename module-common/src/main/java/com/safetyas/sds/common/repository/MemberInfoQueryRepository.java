package com.safetyas.sds.common.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class MemberInfoQueryRepository {

  private final JPAQueryFactory queryFactory;

  public MemberInfoQueryRepository(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }
}
