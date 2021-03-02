package com.safetyas.sds.common.model;

import com.querydsl.core.annotations.QueryProjection;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TranslationAgencyRequestInfoDTO {

  private Long productSeq;
  private String translationLanguage;
  private List<FileDTO> fileList = new ArrayList<>();

  @QueryProjection
  public TranslationAgencyRequestInfoDTO(String translationLanguage) {
    this.translationLanguage = translationLanguage;
  }
}
