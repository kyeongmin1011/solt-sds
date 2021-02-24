package com.safetyas.sds.common.model;

import com.querydsl.core.annotations.QueryProjection;
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
public class RenewAgencyDTO {

  private Long renewAgencySeq;
  private String state;
  private String note;

  @QueryProjection
  public RenewAgencyDTO(String state, String note) {
    this.state = state;
    this.note = note;
  }
}
