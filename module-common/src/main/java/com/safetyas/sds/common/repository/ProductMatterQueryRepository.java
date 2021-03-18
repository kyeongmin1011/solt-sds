package com.safetyas.sds.common.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.model.ProductMatterDTO;
import com.safetyas.sds.common.model.QProductMatterDTO;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import static com.safetyas.sds.common.entity.QMember.member;
import static com.safetyas.sds.common.entity.QMemberSupplier.memberSupplier;
import static com.safetyas.sds.common.entity.msds.QProduct.product;
import static com.safetyas.sds.common.entity.msds.QProductMatter.productMatter;

@Repository
public class ProductMatterQueryRepository {

  private final JPAQueryFactory queryFactory;

  public ProductMatterQueryRepository(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  public List<ProductMatterDTO> selectMatterLibrary(Long seq) {
    return queryFactory
        .select(new QProductMatterDTO(productMatter.inDate, productMatter.modDate,
         product.productUid,productMatter.cas, productMatter.chemName,
        productMatter.premiumDbYn))
        .from(productMatter)
        .leftJoin(productMatter.product, product)
        .leftJoin(productMatter.memberSupplier, memberSupplier)
        .leftJoin(memberSupplier.member, member)
        .where(member.memberSeq.eq(seq))
        .fetch();
  }
}
