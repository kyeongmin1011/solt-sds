package com.safetyas.sds.common.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.entity.File;
import com.safetyas.sds.common.model.FileDTO;
import com.safetyas.sds.common.model.QFileDTO;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import static com.safetyas.sds.common.entity.QFile.file;
import static org.springframework.util.StringUtils.isEmpty;

@Repository
public class FileQueryRepository {

  private final JPAQueryFactory queryFactory;

  public FileQueryRepository(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  public File selectFileByFileDTO(FileDTO fileDTO) {
    return queryFactory.selectFrom(file)
        .where(typeEq(fileDTO.getType()),
            relateTableEq(fileDTO.getRelateTable()),
            recordSeqEq(fileDTO.getRecordSeq()), file.delDate.isNull())
        .fetchOne();
  }

  public List<FileDTO> selectFileListByFileDTO(FileDTO fileDTO) {
    return queryFactory.select(
        new QFileDTO(file.fileSeq, file.relateTable, file.recordSeq,file.oriName))
        .from(file)
        .where(typeEq(fileDTO.getType()),
            relateTableEq(fileDTO.getRelateTable()),
            recordSeqEq(fileDTO.getRecordSeq()), file.delDate.isNull())
        .fetch();
  }

  private BooleanExpression typeEq(String type) {
    return isEmpty(type) ? null : file.type.eq(type);
  }

  private BooleanExpression relateTableEq(String relateTable) {
    return isEmpty(relateTable) ? null : file.relateTable.eq(relateTable);
  }

  private BooleanExpression recordSeqEq(Long recordSeq) {
    return isEmpty(recordSeq) ? null : file.recordSeq.eq(recordSeq);
  }

}
