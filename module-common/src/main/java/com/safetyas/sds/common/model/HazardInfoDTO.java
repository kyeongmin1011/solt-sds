package com.safetyas.sds.common.model;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class HazardInfoDTO {

  private String cause;
  private String refer;

  @QueryProjection
  public HazardInfoDTO(String cause, String refer) {
    this.cause = cause;
    this.refer = refer;
  }
}
