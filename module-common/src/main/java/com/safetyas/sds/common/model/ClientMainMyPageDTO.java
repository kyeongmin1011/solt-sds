package com.safetyas.sds.common.model;

import com.querydsl.core.annotations.QueryProjection;
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
public class ClientMainMyPageDTO {

  private LocalDateTime memberValidStart;
  private LocalDateTime memberValidFinish;
  private Long point;

  @QueryProjection
  public ClientMainMyPageDTO(LocalDateTime memberValidStart, LocalDateTime memberValidFinish) {
    this.memberValidStart = memberValidStart;
    this.memberValidFinish = memberValidFinish;
  }
}
