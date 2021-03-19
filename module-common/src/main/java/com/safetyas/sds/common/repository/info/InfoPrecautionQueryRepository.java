package com.safetyas.sds.common.repository.info;

import static com.safetyas.sds.common.entity.info.QInfoPrecaution.infoPrecaution;
import static org.springframework.util.StringUtils.isEmpty;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.model.info.InfoGradeDetailDTO;
import com.safetyas.sds.common.model.info.InfoPrecautionDTO;
import com.safetyas.sds.common.model.info.QInfoPrecautionDTO;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class InfoPrecautionQueryRepository{
  private final JPAQueryFactory queryFactory;

  public InfoPrecautionQueryRepository(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  public InfoGradeDetailDTO getPrecautionsBy(Map<String, Object> param) {
    List<InfoPrecautionDTO> hazardCodeList = queryFactory
        .select(new QInfoPrecautionDTO(infoPrecaution.hpCode,
            infoPrecaution.codeType, infoPrecaution.phrase))
        .from(infoPrecaution)
        .where(hpCodeEq((HashSet) param.get("hazardCodeList")))
        .fetch();
    String hazardCode = hazardCodeList.stream()
        .map(v->v.getHpCode() + " " +v.getPhrase())
        .collect(Collectors.joining(";"));

    List<InfoPrecautionDTO> precautionCodeList = queryFactory
        .select(new QInfoPrecautionDTO(infoPrecaution.hpCode,
            infoPrecaution.codeType, infoPrecaution.phrase))
        .from(infoPrecaution)
        .where(hpCodeEq((HashSet) param.get("precautionCodeList")))
        .fetch();
    String precautionCode = precautionCodeList.stream()
        .map(v->v.getHpCode() + " " +v.getPhrase())
        .collect(Collectors.joining(";"));

    List<InfoPrecautionDTO> actionCodeList = queryFactory
        .select(new QInfoPrecautionDTO(infoPrecaution.hpCode,
            infoPrecaution.codeType, infoPrecaution.phrase))
        .from(infoPrecaution)
        .where(hpCodeEq((HashSet) param.get("actionCodeList")))
        .fetch();
    String actionCode = actionCodeList.stream()
        .map(v->v.getHpCode() + " " +v.getPhrase())
        .collect(Collectors.joining(";"));

    List<InfoPrecautionDTO> storeCodeList = queryFactory
        .select(new QInfoPrecautionDTO(infoPrecaution.hpCode,
            infoPrecaution.codeType, infoPrecaution.phrase))
        .from(infoPrecaution)
        .where(hpCodeEq((HashSet) param.get("storeCodeList")))
        .fetch();
    String storeCode = storeCodeList.stream()
        .map(v->v.getHpCode() + " " +v.getPhrase())
        .collect(Collectors.joining(";"));

    List<InfoPrecautionDTO> discardCodeList = queryFactory
        .select(new QInfoPrecautionDTO(infoPrecaution.hpCode,
            infoPrecaution.codeType, infoPrecaution.phrase))
        .from(infoPrecaution)
        .where(hpCodeEq((HashSet) param.get("discardCodeList")))
        .fetch();
    String discardCode = discardCodeList.stream()
        .map(v->v.getHpCode() + " " +v.getPhrase())
        .collect(Collectors.joining(";"));

    return InfoGradeDetailDTO.builder()
        .ghsImage(String.join(";",(HashSet)param.get("ghsImageList")))
        .hazardSignal(String.join(";", (HashSet)param.get("hazardSignalList")))
        .hazardCode(hazardCode)
        .precautionCode(precautionCode)
        .actionCode(actionCode)
        .storeCode(storeCode)
        .discardCode(discardCode)
        .build();
  }

  private BooleanBuilder hpCodeEq(HashSet<String> hpCodeList) {
    BooleanBuilder builder = new BooleanBuilder();
    for(String code: hpCodeList) {
      if(code != null && !isEmpty(code)) {
        builder.or(infoPrecaution.hpCode.eq(code));
      }
    }
    return builder;
  }
}
