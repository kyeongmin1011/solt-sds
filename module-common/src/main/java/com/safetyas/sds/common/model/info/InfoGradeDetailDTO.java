package com.safetyas.sds.common.model.info;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InfoGradeDetailDTO {

  private Integer infoGradeDetailSeq;

  //(name = "ghs_image", columnDefinition = "varchar(255) comment 'ghs 그림문자'")
  private String ghsImage;

  //(name = "hazard_signal", columnDefinition = "varchar(255) comment '신호어'")
  private String hazardSignal;

  //(name = "hazard_code", columnDefinition = "varchar(255) comment '유해위험문구 코드'")
  private String hazardCode;

  //(name = "precaution_code", columnDefinition = "varchar(255) comment '예방문구 코드'")
  private String precautionCode;

  //(name = "action_code", columnDefinition = "varchar(255) comment '대응문구 코드'")
  private String actionCode;

  //(name = "store_code", columnDefinition = "varchar(255) comment '저장문구 코드'")
  private String storeCode;

  //(name = "discard_code", columnDefinition = "varchar(255) comment '폐기문구 코드'")
  private String discardCode;

  @QueryProjection
  public InfoGradeDetailDTO(String ghsImage, String hazardSignal, String hazardCode, String precautionCode,
  String actionCode, String storeCode, String discardCode) {
    this.ghsImage = ghsImage;
    this.hazardSignal = hazardSignal;
    this.hazardCode = hazardCode;
    this.precautionCode = precautionCode;
    this.actionCode = actionCode;
    this.storeCode = storeCode;
    this.discardCode = discardCode;
  }
}
