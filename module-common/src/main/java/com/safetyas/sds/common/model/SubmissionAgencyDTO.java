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
public class SubmissionAgencyDTO extends CommonDTO implements Serializable {

  private static final long serialVersionUID = -1742054859720879557L;

  private Long submissionAgencySeq;
  private String state;
  private String note;

  @QueryProjection
  public SubmissionAgencyDTO(String state, String note) {
    this.state = state;
    this.note = note;
  }
}
