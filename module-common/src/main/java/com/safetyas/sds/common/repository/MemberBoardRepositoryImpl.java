package com.safetyas.sds.common.repository;

import static com.safetyas.sds.common.entity.QMember.member;
import static com.safetyas.sds.common.entity.QMemberBoard.memberBoard;
import static org.reflections.util.Utils.isEmpty;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.MemberBoardDto;
import com.safetyas.sds.common.model.QMemberBoardDto;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class MemberBoardRepositoryImpl implements MemberBoardRepositoryCustom {

  private final JPAQueryFactory queryFactory;

  public MemberBoardRepositoryImpl(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  @Override
  public Page<MemberBoardDto> selectMemberBoardList(BoardSearchCondition condition,
      Pageable pageable) {
    QueryResults<MemberBoardDto> results = queryFactory
        .select(new QMemberBoardDto(
            memberBoard.category,
            memberBoard.title,
            memberBoard.content,
            memberBoard.writerName,
            memberBoard.writerEmail))
        .from(memberBoard)
        .leftJoin(memberBoard.member, member)
        .where(categoryEq(condition.getCategory()),
            titleEq(condition.getTitle()),
            contentEq(condition.getContent()),
            writerNameEq(condition.getWriterName()),
            memberBoard.delDate.isNull())
        .offset(pageable.getOffset())
        .orderBy(memberBoard.memberBoardSeq.desc())
        .limit(pageable.getPageSize())
        .fetchResults();

    List<MemberBoardDto> content = results.getResults();
    long total = results.getTotal();

    return new PageImpl<>(content, pageable, total);
  }

  private BooleanExpression categoryEq(String category) {
    return isEmpty(category) ? null : memberBoard.category.eq(category);
  }

  private BooleanExpression titleEq(String title) {
    return isEmpty(title) ? null : memberBoard.title.eq(title);
  }

  private BooleanExpression contentEq(String content) {
    return content == null ? null : memberBoard.content.eq(content);
  }

  private BooleanExpression writerNameEq(String writerName) {
    return writerName == null ? null : memberBoard.writerName.eq(writerName);
  }
}
