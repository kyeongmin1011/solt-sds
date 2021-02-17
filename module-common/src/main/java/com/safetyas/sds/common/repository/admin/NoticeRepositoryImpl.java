package com.safetyas.sds.common.repository.admin;

import static com.safetyas.sds.common.entity.QNotice.notice;
import static org.reflections.util.Utils.isEmpty;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.NoticeDto;
import com.safetyas.sds.common.model.QNoticeDto;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class NoticeRepositoryImpl implements NoticeRepositoryCustom {

  private final JPAQueryFactory queryFactory;

  public NoticeRepositoryImpl(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  @Override
  public Page<NoticeDto> selectNoticeList(BoardSearchCondition condition, Pageable pageable) {
    QueryResults<NoticeDto> results = queryFactory
        .select(new QNoticeDto(
            notice.category,
            notice.title,
            notice.content,
            notice.writerName))
        .from(notice)
        .where(categoryEq(condition.getCategory()),
            titleEq(condition.getTitle()),
            contentEq(condition.getContent()),
            writerNameEq(condition.getWriterName()),
            notice.delDate.isNull())
        .offset(pageable.getOffset())
        .orderBy(notice.noticeSeq.desc())
        .limit(pageable.getPageSize())
        .fetchResults();

    List<NoticeDto> content = results.getResults();
    long total = results.getTotal();

    return new PageImpl<>(content, pageable, total);
  }

  private BooleanExpression categoryEq(String category) {
    return isEmpty(category) ? null : notice.category.eq(category);
  }

  private BooleanExpression titleEq(String title) {
    return isEmpty(title) ? null : notice.title.eq(title);
  }

  private BooleanExpression contentEq(String content) {
    return content == null ? null : notice.content.eq(content);
  }

  private BooleanExpression writerNameEq(String writerName) {
    return writerName == null ? null : notice.writerName.eq(writerName);
  }
}
