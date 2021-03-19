package com.safetyas.sds.common.model.info;

import javax.persistence.Column;
import javax.persistence.Id;
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
public class InfoHazardGradeDTO {

  //(name = "hazard_grade_key", length = 50)
  private String hazardGradeKey;

  //(name = "group_title", columnDefinition = "varchar(50) comment '그룹명'")
  private String groupTitle;

  //(name = "group_type", columnDefinition = "varchar(50) comment '그룹'")
  private String groupType;

  //(name = "element_idx", columnDefinition = "varchar(50) comment '항목인덱스'")
  private String elementIdx;

  //(name = "element_num", columnDefinition = "varchar(50) comment '항목번호'")
  private Integer elementNum;

  //(name = "element_title", columnDefinition = "varchar(255) comment '항목명'")
  private String elementTitle;

  //(name = "hazard_value", columnDefinition = "int(11) comment '구분숫자값'")
  private Integer hazardValue;

  //(name = "kor", columnDefinition = "varchar(255) comment '국내'")
  private String kor;

  //(name = "unGhs", columnDefinition = "varchar(255) comment 'UN'")
  private String unGhs;

  //(name = "usa", columnDefinition = "varchar(255) comment '미국'")
  private String usa;

  //(name = "eu_clp", columnDefinition = "varchar(255) comment '유럽'")
  private String euClp;
}
