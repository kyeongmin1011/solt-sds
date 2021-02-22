package com.safetyas.sds.common.model;

import com.querydsl.core.annotations.QueryProjection;
import com.safetyas.sds.common.entity.File;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileDTO implements Serializable {

  private static final long serialVersionUID = 1299881201921700000L;

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
