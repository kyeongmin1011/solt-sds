package com.safetyas.sds.common.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "sds_info_grade_detail")
public class InfoHazardGradeDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "grade_detail_seq", nullable = false, length = 11)
  private Integer infoGradeDetailSeq;

/*  @Column(name = "hazard_grade_key", columnDefinition = "varchar(255) comment '유해등급고유값'")
  private String hazardGradeKey;*/

  @Column(name = "ghs_image", columnDefinition = "varchar(255) comment 'ghs 그림문자'")
  private String ghsImage;

  @Column(name = "hazard_signal", columnDefinition = "varchar(255) comment '신호어'")
  private String hazardSignal;

  @Column(name = "hazard_code", columnDefinition = "varchar(255) comment '유해위험문구 코드'")
  private String hazardCode;

  @Column(name = "precaution_code", columnDefinition = "varchar(255) comment '예방문구 코드'")
  private String precautionCode;

  @Column(name = "action_code", columnDefinition = "varchar(255) comment '대응문구 코드'")
  private String actionCode;

  @Column(name = "store_code", columnDefinition = "varchar(255) comment '저장문구 코드'")
  private String storeCode;

  @Column(name = "discard_code", columnDefinition = "varchar(255) comment '폐기문구 코드'")
  private String discardCode;

  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "hazard_grade_key", foreignKey = @ForeignKey(name = "hazard_grade_key_info_hazard_grade_detail_fk"))
  private InfoHazardGrade infoHazardGrade;
}
