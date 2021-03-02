package com.safetyas.sds.common.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.NoticeDTO;
import com.safetyas.sds.common.model.QNoticeDTO;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import static com.safetyas.sds.common.entity.QNotice.notice;
import static org.reflections.util.Utils.isEmpty;

public class NoticeRepositoryImpl implements NoticeRepositoryCustom {

  private final JPAQueryFactory queryFactory;

  public NoticeRepositoryImpl(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  @Override
  public Page<NoticeDTO> selectNoticeList(Pageable pageable, BoardSearchCondition condition) {
    QueryResults<NoticeDTO> results = queryFactory
        .select(new QNoticeDTO(
            notice.inDate,
            notice.noticeSeq,
            notice.category,
            notice.title,
            notice.writerName,
            notice.viewCount))
        .from(notice)
        .where(categoryEq(condition.getCategory()),
            titleEq(condition.getTitle()),
            contentEq(condition.getContent()),
            writerNameEq(condition.getWriterName()),
            notice.delDate.isNull())
        .offset(pageable.getOffset())
        .limit(pageable.getPageSize())
        .orderBy(notice.noticeSeq.desc())
        .fetchResults();

    List<NoticeDTO> content = results.getResults();
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
