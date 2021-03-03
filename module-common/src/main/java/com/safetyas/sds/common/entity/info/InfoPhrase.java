package com.safetyas.sds.common.entity.info;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "sds_info_phrase") // 유해구분별 문구
public class InfoPhrase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "info_phrase_seq", nullable = false, length = 11)
  private Integer infoPhraseSeq;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "hazard_grade_key", foreignKey = @ForeignKey(name = "hazard_grade_key_info_phrase_fk"))
  private InfoHazardGrade infoHazardGrade;

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

}
