package com.safetyas.sds.common.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.FaqDTO;
import com.safetyas.sds.common.model.QFaqDTO;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import static com.safetyas.sds.common.entity.QFaq.faq;

public class FaqRepositoryImpl implements FaqRepositoryCustom {

  private final JPAQueryFactory queryFactory;

  public FaqRepositoryImpl(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  @Override
  public Page<FaqDTO> selectFaqList(Pageable pageable, BoardSearchCondition condition) {
    QueryResults<FaqDTO> results = queryFactory
        .select(new QFaqDTO(
            faq.category,
            faq.title,
            faq.content,
            faq.writerName
        ))
        .from(faq)
        .where(titleEq(condition),
            contentEq(condition),
            writerNameEq(condition),
            faq.delDate.isNull())
        .offset(pageable.getOffset())
        .orderBy(faq.faqSeq.desc())
        .limit(pageable.getPageSize())
        .fetchResults();

    List<FaqDTO> content = results.getResults();
    long total = results.getTotal();

    return new PageImpl<>(content, pageable, total);
  }

  private BooleanExpression titleEq(BoardSearchCondition condition) {
    return condition.getCategory().equals("title") ? faq.title.like(condition.getKeyword()) : null;
  }

  private BooleanExpression contentEq(BoardSearchCondition condition) {
    return condition.getCategory().equals("content") ? faq.title.like(condition.getKeyword()) : null;
  }

  private BooleanExpression writerNameEq(BoardSearchCondition condition) {
    return condition.getCategory().equals("writerName") ? faq.title.like(condition.getKeyword()) : null;
  }
}
