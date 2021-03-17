package com.safetyas.sds.common.repository.info;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.entity.info.InfoPhrase;
import com.safetyas.sds.common.entity.info.QInfoHazardGrade;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import static com.safetyas.sds.common.entity.info.QInfoHazardGrade.infoHazardGrade;
import static com.safetyas.sds.common.entity.info.QInfoPhrase.*;
import static org.springframework.util.StringUtils.isEmpty;

@Repository
public class InfoPhraseQueryRepository {

  private final JPAQueryFactory queryFactory;

  public InfoPhraseQueryRepository(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  public List<InfoPhrase> selectMsdsPhrase(Map<String, Object> param) {
    return queryFactory.selectFrom(infoPhrase)
        .leftJoin(infoPhrase.infoHazardGrade, infoHazardGrade)
        .where(infoPhrase.matterType.eq("common").or(matterTypeEq((String)param.get("matterType"))),
            hazardGradeKeyEq((List)param.get("keyList")))
        .orderBy(infoPhrase.stepGroup.asc(), infoPhrase.subGroup.asc())
        .fetch();
  }

  private BooleanExpression matterTypeEq(String matterType) {
    return isEmpty(matterType)? null : infoPhrase.matterType.eq(matterType);
  }

  private BooleanBuilder hazardGradeKeyEq(List<String> keyList) {
    BooleanBuilder builder = new BooleanBuilder();
    for (String key: keyList) {
      if(key != null && isEmpty(key)) {
        builder.or(infoHazardGrade.hazardGradeKey.eq(key));
      }
    }
    return builder;
  }
}
