package com.safetyas.sds.common.model.info;

import javax.persistence.Column;
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
public class InfoPhraseDTO {

  private Integer infoPhraseSeq;

  //(name = "matter_type", columnDefinition = "varchar(50) comment '물질 성상'")
  private String matterType;

  //(name = "step_group", columnDefinition = "varchar(50) comment '구분'")
  private String stepGroup;

  //(name = "step_group_title", columnDefinition = "varchar(50) comment '구분명'")
  private String stepGroupTitle;

  //(name = "sub_group", columnDefinition = "varchar(50) comment 'msds 항목그룹'")
  private String subGroup;

  //(name = "sub_group_title", columnDefinition = "varchar(50) comment 'msds 항목명'")
  private String subGroupTitle;

  //(name = "phrase", columnDefinition = "varchar(500) comment '문구'")
  private String phrase;
}
