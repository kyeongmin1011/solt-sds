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
public class RevisionAgencyProgressDTO extends CommonDTO implements Serializable {

  private static final long serialVersionUID = 5153844118969634990L;

  private Long revisionAgencySeq;
  private String state;
  private String note;

  @QueryProjection
  public RevisionAgencyProgressDTO(String state, String note) {
    this.state = state;
    this.note = note;
  }
}
