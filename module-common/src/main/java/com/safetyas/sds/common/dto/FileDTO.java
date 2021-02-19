package com.safetyas.sds.common.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.safetyas.sds.common.entity.File;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileDTO {

  private Long fileSeq;
  private String relateTable;
  private Long recordSeq;
  private String type;
  private String path;
  private String name;
  private Integer size;
  private String ext;
  private String oriName;
  private Long regUserSeq;
  private Long modUserSeq;

  @QueryProjection
  public FileDTO(Long fileSeq, String relateTable, Long recordSeq) {
    this.fileSeq = fileSeq;
    this.relateTable = relateTable;
    this.recordSeq = recordSeq;
  }

  public File toEntity() {
    return File.builder()
        .relateTable(this.relateTable)
        .recordSeq(this.recordSeq)
        .type(this.type)
        .path(this.path)
        .name(this.name)
        .size(this.size)
        .ext(this.ext)
        .oriName(this.oriName)
        .regUserSeq(this.regUserSeq)
        .build();
  }
}
