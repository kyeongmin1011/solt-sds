package com.safetyas.sds.common.model;

import com.querydsl.core.annotations.QueryProjection;
import java.io.Serializable;
import java.time.LocalDateTime;
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
public class TranslationAgencyProgressDTO extends CommonDTO implements Serializable {

  private static final long serialVersionUID = -370168335705926088L;

  private Long translationAgencySeq;
  private String state;
  private String note;

  @QueryProjection
  public TranslationAgencyProgressDTO(LocalDateTime inDate, String state, String note) {
    super(inDate);
    this.state = state;
    this.note = note;
  }
}
