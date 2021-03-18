package com.safetyas.sds.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class CommonDTO implements Serializable {

  private static final long serialVersionUID = 7600430260286755324L;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
  private LocalDateTime inDate;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
  private LocalDateTime modDate;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
  private LocalDateTime delDate;

  public CommonDTO(LocalDateTime inDate) {
    this.inDate = inDate;
  }

  public CommonDTO(LocalDateTime inDate, LocalDateTime modDate) {
    this.inDate = inDate;
    this.modDate = modDate;
  }
}
