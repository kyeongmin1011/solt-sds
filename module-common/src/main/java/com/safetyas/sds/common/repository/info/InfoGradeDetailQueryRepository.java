package com.safetyas.sds.common.repository.info;

import static com.safetyas.sds.common.entity.info.QInfoHazardGrade.infoHazardGrade;
import static com.safetyas.sds.common.entity.info.QInfoHazardGradeDetail.infoHazardGradeDetail;
import static org.springframework.util.StringUtils.isEmpty;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.entity.info.QInfoHazardGrade;
import com.safetyas.sds.common.entity.info.QInfoHazardGradeDetail;
import com.safetyas.sds.common.model.info.InfoGradeDetailDTO;
import com.safetyas.sds.common.model.info.QInfoGradeDetailDTO;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class InfoGradeDetailQueryRepository {

  private final JPAQueryFactory queryFactory;

  public InfoGradeDetailQueryRepository(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  public List<InfoGradeDetailDTO> selectGradeCode(List<String> keyList) {
    return queryFactory.select(
        new QInfoGradeDetailDTO(infoHazardGradeDetail.ghsImage,
            infoHazardGradeDetail.hazardSignal,
            infoHazardGradeDetail.hazardCode,
            infoHazardGradeDetail.precautionCode,
            infoHazardGradeDetail.actionCode,
            infoHazardGradeDetail.storeCode,
            infoHazardGradeDetail.discardCode))
        .from(infoHazardGradeDetail)
        .leftJoin(infoHazardGradeDetail.infoHazardGrade, infoHazardGrade)
        .where(hazardGradeKeyEq(keyList))
        .fetch();
  }

  private BooleanBuilder hazardGradeKeyEq(List<String> keyList) {
    BooleanBuilder builder = new BooleanBuilder();
    for (String key: keyList) {
      if(key != null && !isEmpty(key)) {
        builder.or(infoHazardGrade.hazardGradeKey.eq(key));
      }
    }
    return builder;
  }

}
