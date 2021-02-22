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
public class ClientMainMyPageDTO implements Serializable {

  private static final long serialVersionUID = -8493848676492726154L;

  private LocalDateTime memberValidStart;
  private LocalDateTime memberValidFinish;
  private Long productCount;
  private Long point;

  @QueryProjection
  public ClientMainMyPageDTO(LocalDateTime memberValidStart, LocalDateTime memberValidFinish, Long productCount) {
    this.memberValidStart = memberValidStart;
    this.memberValidFinish = memberValidFinish;
    this.productCount = productCount;
  }
}
