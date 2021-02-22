package com.safetyas.sds.common.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.entity.Product;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import static com.safetyas.sds.common.entity.QProduct.product;

@Repository
public class ProductQueryRepository {

  private final JPAQueryFactory queryFactory;

  public ProductQueryRepository(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  public Product selectCbiProgress(Long id){
    return queryFactory.selectFrom(product)
        .where(product.productSeq.eq(id))
        .where(product.agencyCbiYn.eq("Y"))
        .fetchOne();
  }
}
