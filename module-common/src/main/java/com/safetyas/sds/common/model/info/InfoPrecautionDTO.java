package com.safetyas.sds.common.model.info;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class InfoPrecautionDTO {

  private String hpCode;
  private String codeType;
  private String phrase;

  @QueryProjection
  public InfoPrecautionDTO(String hpCode, String codeType, String phrase) {
    this.hpCode = hpCode;
    this.codeType = codeType;
    this.phrase = phrase;
  }
}
