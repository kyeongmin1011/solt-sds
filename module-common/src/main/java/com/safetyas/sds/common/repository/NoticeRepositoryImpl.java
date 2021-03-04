package com.safetyas.sds.common.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.NoticeDTO;
import com.safetyas.sds.common.model.QNoticeDTO;
import java.util.List;
import javax.persistence.EntityManager;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import static com.safetyas.sds.common.entity.QNotice.notice;

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
        .where(titleEq(condition),
            contentEq(condition),
            writerNameEq(condition),
            notice.delDate.isNull())
        .offset(pageable.getOffset())
        .limit(pageable.getPageSize())
        .orderBy(notice.noticeSeq.desc())
        .fetchResults();

    List<NoticeDTO> content = results.getResults();
    long total = results.getTotal();

    return new PageImpl<>(content, pageable, total);
  }

  private BooleanExpression titleEq(BoardSearchCondition condition) {
    return Strings.isEmpty(condition.getCategory()) ? null
        : condition.getCategory().equals("title") ? notice.title.like(condition.getKeyword())
            : null;
  }

  private BooleanExpression contentEq(BoardSearchCondition condition) {
    return Strings.isEmpty(condition.getCategory()) ? null
        : condition.getCategory().equals("content") ? notice.title.like(condition.getKeyword())
            : null;
  }

  private BooleanExpression writerNameEq(BoardSearchCondition condition) {
    return Strings.isEmpty(condition.getCategory()) ? null
        : condition.getCategory().equals("writerName") ? notice.title.like(condition.getKeyword())
            : null;
  }
}
