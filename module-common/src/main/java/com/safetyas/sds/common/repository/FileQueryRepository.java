package com.safetyas.sds.common.repository;

import static org.springframework.util.StringUtils.isEmpty;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.dto.FileDTO;
import com.safetyas.sds.common.entity.File;
import com.safetyas.sds.common.entity.QFile;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class FileQueryRepository {

  private final JPAQueryFactory queryFactory;

  public FileQueryRepository(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  public File selectCompanyCertificate (FileDTO fileDTO) {
    return queryFactory.selectFrom(QFile.file)
        .where(typeEq(fileDTO.getType()),
            relateTableEq(fileDTO.getRelateTable()),
            recordSeqEq(fileDTO.getRecordSeq()))
        .fetchFirst();
  }

  private BooleanExpression typeEq(String type) {
    return isEmpty(type) ? null : QFile.file.type.eq(type);
  }

  private BooleanExpression relateTableEq(String relateTable) {
    return isEmpty(relateTable) ? null : QFile.file.relateTable.eq(relateTable);
  }

  private BooleanExpression recordSeqEq(Long recordSeq) {
    return isEmpty(recordSeq) ? null : QFile.file.recordSeq.eq(recordSeq);
  }

}
