package com.safetyas.sds.common.repository.admin;

import static com.safetyas.sds.common.entity.QFaq.faq;
import static org.reflections.util.Utils.isEmpty;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.FaqDto;
import com.safetyas.sds.common.model.QFaqDto;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class FaqRepositoryImpl implements FaqRepositoryCustom {

  private final JPAQueryFactory queryFactory;

  public FaqRepositoryImpl(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  @Override
  public Page<FaqDto> selectFaqList(BoardSearchCondition condition, Pageable pageable) {
    QueryResults<FaqDto> results = queryFactory
        .select(new QFaqDto(
            faq.category,
            faq.title,
            faq.content,
            faq.writerName
        ))
        .from(faq)
        .where(categoryEq(condition.getCategory()),
            titleEq(condition.getTitle()),
            contentEq(condition.getContent()),
            writerNameEq(condition.getWriterName()))
        .offset(pageable.getOffset())
        .orderBy(faq.faqSeq.desc())
        .limit(pageable.getPageSize())
        .fetchResults();

    List<FaqDto> content = results.getResults();
    long total = results.getTotal();

    return new PageImpl<>(content, pageable, total);
  }

  private BooleanExpression categoryEq(String category) {
    return isEmpty(category) ? null : faq.category.eq(category);
  }

  private BooleanExpression titleEq(String title) {
    return isEmpty(title) ? null : faq.title.eq(title);
  }

  private BooleanExpression contentEq(String content) {
    return content == null ? null : faq.content.eq(content);
  }

  private BooleanExpression writerNameEq(String writerName) {
    return writerName == null ? null : faq.writerName.eq(writerName);
  }
}
