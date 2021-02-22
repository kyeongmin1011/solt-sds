package com.safetyas.sds.common.model;

import com.querydsl.core.annotations.QueryProjection;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class HazardInfoDTO implements Serializable {

  private static final long serialVersionUID = 7355865616220889339L;
  private String cause;
  private String refer;

  @QueryProjection
  public HazardInfoDTO(String cause, String refer) {
    this.cause = cause;
    this.refer = refer;
  }
}
