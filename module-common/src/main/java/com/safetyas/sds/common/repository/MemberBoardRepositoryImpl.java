package com.safetyas.sds.common.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.entity.MemberBoard;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.MemberBoardDTO;
import com.safetyas.sds.common.model.QMemberBoardDTO;
import java.util.List;
import javax.persistence.EntityManager;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import static com.safetyas.sds.common.entity.QMember.member;
import static com.safetyas.sds.common.entity.QMemberBoard.memberBoard;

public class MemberBoardRepositoryImpl implements MemberBoardRepositoryCustom {

  private final JPAQueryFactory queryFactory;

  public MemberBoardRepositoryImpl(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  @Override
  public Page<MemberBoardDTO> selectMemberBoardList(Pageable pageable,
      BoardSearchCondition condition) {
    QueryResults<MemberBoardDTO> results = queryFactory
        .select(new QMemberBoardDTO(
            memberBoard.memberBoardSeq,
            memberBoard.category,
            memberBoard.title,
            memberBoard.content,
            memberBoard.writerName,
            memberBoard.writerEmail))
        .from(memberBoard)
        .leftJoin(memberBoard.member, member)
        .where(titleEq(condition),
            contentEq(condition),
            writerNameEq(condition),
            memberBoard.delDate.isNull())
        .offset(pageable.getOffset())
        .orderBy(memberBoard.memberBoardSeq.desc())
        .limit(pageable.getPageSize())
        .fetchResults();

    List<MemberBoardDTO> content = results.getResults();
    long total = results.getTotal();

    return new PageImpl<>(content, pageable, total);
  }

  @Override
  public MemberBoard selectMemberBoard(Long id) {
    return queryFactory
        .select(memberBoard)
        .from(memberBoard)
        .where(memberBoard.memberBoardSeq.eq(id), memberBoard.delDate.isNull())
        .fetchOne();
  }

  @Override
  public List<MemberBoardDTO> selectClientMainMemberBoardList(Long id) {
    return queryFactory
        .select(new QMemberBoardDTO(
            memberBoard.memberBoardSeq,
            memberBoard.category,
            memberBoard.title,
            memberBoard.content,
            memberBoard.writerName,
            memberBoard.writerEmail))
        .from(memberBoard)
        .where(memberBoard.member.memberSeq.eq(id))
        .limit(10)
        .orderBy(memberBoard.memberBoardSeq.desc())
        .fetch();
  }

  private BooleanExpression titleEq(BoardSearchCondition condition) {
    if (Strings.isBlank(condition.getCategory())) {
      return null;
    }
    return condition.getCategory().equals("title") && !Strings.isBlank(condition.getKeyword())
        ? memberBoard.title.like(condition.getKeyword()) : null;
  }

  private BooleanExpression contentEq(BoardSearchCondition condition) {
    if (Strings.isBlank(condition.getCategory())) {
      return null;
    }
    return condition.getCategory().equals("content") && !Strings.isBlank(condition.getKeyword())
        ? memberBoard.content.like(condition.getKeyword()) : null;
  }

  private BooleanExpression writerNameEq(BoardSearchCondition condition) {
    if (Strings.isBlank(condition.getCategory())) {
      return null;
    }
    return condition.getCategory().equals("writerName") && !Strings.isBlank(condition.getKeyword())
        ? memberBoard.writerName.like(condition.getKeyword()) : null;
  }
}
