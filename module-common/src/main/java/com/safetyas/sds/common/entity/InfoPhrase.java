package com.safetyas.sds.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "sds_info_phrase") // 성상별문구
public class InfoPhrase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "info_phrase_seq", nullable = false, length = 11)
  private Integer infoPhraseSeq;

  @Column(name = "matter_type", columnDefinition = "varchar(50) comment '물질 성상'")
  private String matterType;

  @Column(name = "step_group", columnDefinition = "varchar(50) comment '구분'")
  private String stepGroup;

  @Column(name = "step_group_title", columnDefinition = "varchar(50) comment '구분명'")
  private String stepGroupTitle;

  @Column(name = "sub_group", columnDefinition = "varchar(50) comment 'msds 항목그룹'")
  private String subGroup;

  @Column(name = "sub_group_title", columnDefinition = "varchar(50) comment 'msds 항목명'")
  private String subGroupTitle;

  @Column(name = "phrase", columnDefinition = "varchar(500) comment '문구'")
  private String phrase;

  @Column(name = "source", columnDefinition = "varchar(100) comment '문구출처'")
  private String source;
}
