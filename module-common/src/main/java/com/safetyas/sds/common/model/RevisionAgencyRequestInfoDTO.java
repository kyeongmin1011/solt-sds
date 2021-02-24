package com.safetyas.sds.common.model;

import com.querydsl.core.annotations.QueryProjection;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RevisionAgencyRequestInfoDTO {
  private String revisionLanguage;
  private List<FileDTO> fileList = new ArrayList<>();

  @QueryProjection
  public RevisionAgencyRequestInfoDTO(String revisionLanguage){
    this.revisionLanguage = revisionLanguage;
  }
}
