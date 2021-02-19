package com.safetyas.sds.common.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.model.HazardInfoDTO;
import com.safetyas.sds.common.model.QHazardInfoDTO;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import static com.safetyas.sds.common.entity.QHazardIdentification.hazardIdentification;

@Repository
public class HazardQueryRepository {

  private final JPAQueryFactory queryFactory;

  public HazardQueryRepository(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  public List<HazardInfoDTO> selectHazardInfo(String cas) {

    return queryFactory
        .select(new QHazardInfoDTO(hazardIdentification.cause, hazardIdentification.refer))
        .from(hazardIdentification)
        .where(hazardIdentification.cas.eq(cas))
        .fetch();
  }
}
