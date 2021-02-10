package com.safetyas.sds.common.dto;

import com.safetyas.sds.common.entity.File;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
@Builder
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
