package com.safetyas.sds.common.model;

import com.querydsl.core.annotations.QueryProjection;
import java.io.Serializable;
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
public class OrAgencyDTO extends CommonDTO implements Serializable {

  private static final long serialVersionUID = 7391252276350918800L;

  private Long orAgencySeq;
  private String state;
  private String note;

  @QueryProjection
  public OrAgencyDTO(String state, String note) {
    this.state = state;
    this.note = note;
  }
}
