package com.safetyas.sds.common.entity.msds;

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
@Table(name = "sds_matter_env")
public class MatterEnv {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "matter_env_seq", length = 20)
  private Long matterEnvSeq;

  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "matter_data_key", foreignKey = @ForeignKey(name = "matter_data_key_matter_env_fk"))
  private MatterData matterData;

  //------------------------------------------------------------- C그룹 12 환경유해성
  @Column(name = "division_C1", columnDefinition = "varchar(100) comment '급성-구분'")
  private String divisionC1;
  @Column(name = "division_C2", columnDefinition = "varchar(100) comment '만성-구분'")
  private String divisionC2;

  @Column(name = "ca1_time", columnDefinition = "varchar(100) comment '급성어류-시간'")
  private String ca1Time;
  @Column(name = "ca2_endpoint", columnDefinition = "varchar(100) comment '급성어류-종말점'")
  private String ca2Endpoint;
  @Column(name = "ca3_species", columnDefinition = "varchar(100) comment '급성어류-실험종'")
  private String ca3Species;
  @Column(name = "ca4_value1", columnDefinition = "varchar(100) comment '급성어류-유일값'")
  private String ca4Value1;
  @Column(name = "ca5_value2", columnDefinition = "varchar(100) comment '급성어류-최소값1'")
  private String ca5Value2;
  @Column(name = "ca6_value3", columnDefinition = "varchar(100) comment '급성어류-최소값2'")
  private String ca6Value3;
  @Column(name = "ca7_value4", columnDefinition = "varchar(100) comment '급성어류-최대값1'")
  private String ca7Value4;
  @Column(name = "ca8_value5", columnDefinition = "varchar(100) comment '급성어류-최대값2'")
  private String ca8Value5;
  @Column(name = "ca9_tg", columnDefinition = "varchar(100) comment '급성어류-시험지침'")
  private String ca9Tg;
  @Column(name = "ca10_glp", columnDefinition = "varchar(100) comment '급성어류-GLP'")
  private String ca10Glp;
  @Column(name = "ca11_ref", columnDefinition = "varchar(100) comment '급성어류-출처'")
  private String ca11Ref;
  @Column(name = "ca12_other", columnDefinition = "varchar(100) comment '급성어류-비고'")
  private String ca12Other;

  @Column(name = "cb1_time", columnDefinition = "varchar(100) comment '급성갑각류-시간'")
  private String cb1Time;
  @Column(name = "cb2_endpoint", columnDefinition = "varchar(100) comment '급성갑각류-종말점'")
  private String cb2Endpoint;
  @Column(name = "cb3_species", columnDefinition = "varchar(100) comment '급성갑각류-실험종'")
  private String cb3Species;
  @Column(name = "cb4_value1", columnDefinition = "varchar(100) comment '급성갑각류-유일값'")
  private String cb4Value1;
  @Column(name = "cb5_value2", columnDefinition = "varchar(100) comment '급성갑각류-최소값1'")
  private String cb5Value2;
  @Column(name = "cb6_value3", columnDefinition = "varchar(100) comment '급성갑각류-최소값2'")
  private String cb6Value3;
  @Column(name = "cb7_value4", columnDefinition = "varchar(100) comment '급성갑각류-최대값1'")
  private String cb7Value4;
  @Column(name = "cb8_value5", columnDefinition = "varchar(100) comment '급성갑각류-최대값2'")
  private String cb8Value5;
  @Column(name = "cb9_tg", columnDefinition = "varchar(100) comment '급성갑각류-시험지침'")
  private String cb9Tg;
  @Column(name = "cb10_glp", columnDefinition = "varchar(100) comment '급성갑각류-GLP'")
  private String cb10Glp;
  @Column(name = "cb11_ref", columnDefinition = "varchar(100) comment '급성갑각류-출처'")
  private String cb11Ref;
  @Column(name = "cb12_other", columnDefinition = "varchar(100) comment '급성갑각류-비고'")
  private String cb12Other;

  @Column(name = "cc1_time", columnDefinition = "varchar(100) comment '급성조류-시간'")
  private String cc1Time;
  @Column(name = "cc2_endpoint", columnDefinition = "varchar(100) comment '급성조류-종말점'")
  private String cc2Endpoint;
  @Column(name = "cc3_species", columnDefinition = "varchar(100) comment '급성조류-실험종'")
  private String cc3Species;
  @Column(name = "cc4_value1", columnDefinition = "varchar(100) comment '급성조류-유일값'")
  private String cc4Value1;
  @Column(name = "cc5_value2", columnDefinition = "varchar(100) comment '급성조류-최소값1'")
  private String cc5Value2;
  @Column(name = "cc6_value3", columnDefinition = "varchar(100) comment '급성조류-최소값2'")
  private String cc6Value3;
  @Column(name = "cc7_value4", columnDefinition = "varchar(100) comment '급성조류-최대값1'")
  private String cc7Value4;
  @Column(name = "cc8_value5", columnDefinition = "varchar(100) comment '급성조류-최대값2'")
  private String cc8Value5;
  @Column(name = "cc9_tg", columnDefinition = "varchar(100) comment '급성조류-시험지침'")
  private String cc9Tg;
  @Column(name = "cc10_glp", columnDefinition = "varchar(100) comment '급성조류-GLP'")
  private String cc10Glp;
  @Column(name = "cc11_ref", columnDefinition = "varchar(100) comment '급성조류-출처'")
  private String cc11Ref;
  @Column(name = "cc12_other", columnDefinition = "varchar(100) comment '급성조류-비고'")
  private String cc12Other;

  @Column(name = "cd1_time", columnDefinition = "varchar(100) comment '급성기타-시간'")
  private String cd1Time;
  @Column(name = "cd2_endpoint", columnDefinition = "varchar(100) comment '급성기타-종말점'")
  private String cd2Endpoint;
  @Column(name = "cd3_species", columnDefinition = "varchar(100) comment '급성기타-실험종'")
  private String cd3Species;
  @Column(name = "cd4_value1", columnDefinition = "varchar(100) comment '급성기타-유일값'")
  private String cd4Value1;
  @Column(name = "cd5_value2", columnDefinition = "varchar(100) comment '급성기타-최소값1'")
  private String cd5Value2;
  @Column(name = "cd6_value3", columnDefinition = "varchar(100) comment '급성기타-최소값2'")
  private String cd6Value3;
  @Column(name = "cd7_value4", columnDefinition = "varchar(100) comment '급성기타-최대값1'")
  private String cd7Value4;
  @Column(name = "cd8_value5", columnDefinition = "varchar(100) comment '급성기타-최대값2'")
  private String cd8Value5;
  @Column(name = "cd9_tg", columnDefinition = "varchar(100) comment '급성기타-시험지침'")
  private String cd9Tg;
  @Column(name = "cd10_glp", columnDefinition = "varchar(100) comment '급성기타-GLP'")
  private String cd10Glp;
  @Column(name = "cd11_ref", columnDefinition = "varchar(100) comment '급성기타-출처'")
  private String cd11Ref;
  @Column(name = "cd12_other", columnDefinition = "varchar(100) comment '급성기타-비고'")
  private String cd12Other;

  @Column(name = "ce1_time", columnDefinition = "varchar(100) comment '만성어류-시간'")
  private String ce1Time;
  @Column(name = "ce2_endpoint", columnDefinition = "varchar(100) comment '만성어류-종말점'")
  private String ce2Endpoint;
  @Column(name = "ce3_species", columnDefinition = "varchar(100) comment '만성어류-실험종'")
  private String ce3Species;
  @Column(name = "ce4_value1", columnDefinition = "varchar(100) comment '만성어류-유일값'")
  private String ce4Value1;
  @Column(name = "ce5_value2", columnDefinition = "varchar(100) comment '만성어류-최소값1'")
  private String ce5Value2;
  @Column(name = "ce6_value3", columnDefinition = "varchar(100) comment '만성어류-최소값2'")
  private String ce6Value3;
  @Column(name = "ce7_value4", columnDefinition = "varchar(100) comment '만성어류-최대값1'")
  private String ce7Value4;
  @Column(name = "ce8_value5", columnDefinition = "varchar(100) comment '만성어류-최대값2'")
  private String ce8Value5;
  @Column(name = "ce9_tg", columnDefinition = "varchar(100) comment '만성어류-시험지침'")
  private String ce9Tg;
  @Column(name = "ce10_glp", columnDefinition = "varchar(100) comment '만성어류-GLP'")
  private String ce10Glp;
  @Column(name = "ce11_ref", columnDefinition = "varchar(100) comment '만성어류-출처'")
  private String ce11Ref;
  @Column(name = "ce12_other", columnDefinition = "varchar(100) comment '만성어류-비고'")
  private String ce12Other;

  @Column(name = "cf1_time", columnDefinition = "varchar(100) comment '만성조류-시간'")
  private String cf1Time;
  @Column(name = "cf2_endpoint", columnDefinition = "varchar(100) comment '만성조류-종말점'")
  private String cf2Endpoint;
  @Column(name = "cf3_species", columnDefinition = "varchar(100) comment '만성조류-실험종'")
  private String cf3Species;
  @Column(name = "cf4_value1", columnDefinition = "varchar(100) comment '만성조류-유일값'")
  private String cf4Value1;
  @Column(name = "cf5_value2", columnDefinition = "varchar(100) comment '만성조류-최소값1'")
  private String cf5Value2;
  @Column(name = "cf6_value3", columnDefinition = "varchar(100) comment '만성조류-최소값2'")
  private String cf6Value3;
  @Column(name = "cf7_value4", columnDefinition = "varchar(100) comment '만성조류-최대값1'")
  private String cf7Value4;
  @Column(name = "cf8_value5", columnDefinition = "varchar(100) comment '만성조류-최대값2'")
  private String cf8Value5;
  @Column(name = "cf9_tg", columnDefinition = "varchar(100) comment '만성조류-시험지침'")
  private String cf9Tg;
  @Column(name = "cf10_glp", columnDefinition = "varchar(100) comment '만성조류-GLP'")
  private String cf10Glp;
  @Column(name = "cf11_ref", columnDefinition = "varchar(100) comment '만성조류-출처'")
  private String cf11Ref;
  @Column(name = "cf12_other", columnDefinition = "varchar(100) comment '만성조류-비고'")
  private String cf12Other;

  @Column(name = "cg1_time", columnDefinition = "varchar(100) comment '만성기타-시간'")
  private String cg1Time;
  @Column(name = "cg2_endpoint", columnDefinition = "varchar(100) comment '만성기타-종말점'")
  private String cg2Endpoint;
  @Column(name = "cg3_species", columnDefinition = "varchar(100) comment '만성기타-실험종'")
  private String cg3Species;
  @Column(name = "cg4_value1", columnDefinition = "varchar(100) comment '만성기타-유일값'")
  private String cg4Value1;
  @Column(name = "cg5_value2", columnDefinition = "varchar(100) comment '만성기타-최소값1'")
  private String cg5Value2;
  @Column(name = "cg6_value3", columnDefinition = "varchar(100) comment '만성기타-최소값2'")
  private String cg6Value3;
  @Column(name = "cg7_value4", columnDefinition = "varchar(100) comment '만성기타-최대값1'")
  private String cg7Value4;
  @Column(name = "cg8_value5", columnDefinition = "varchar(100) comment '만성기타-최대값2'")
  private String cg8Value5;
  @Column(name = "cg9_tg", columnDefinition = "varchar(100) comment '만성기타-시험지침'")
  private String cg9Tg;
  @Column(name = "cg10_glp", columnDefinition = "varchar(100) comment '만성기타-GLP'")
  private String cg10Glp;
  @Column(name = "cg11_ref", columnDefinition = "varchar(100) comment '만성기타-출처'")
  private String cg11Ref;
  @Column(name = "cg12_other", columnDefinition = "varchar(100) comment '만성기타-비고'")
  private String cg12Other;

  @Column(name = "ch1_persistence", columnDefinition = "varchar(100) comment '잔류성'")
  private String ch1Persistence;

  @Column(name = "ci1_data", columnDefinition = "varchar(100) comment '생분해성-값'")
  private String ci1Data;
  @Column(name = "ci2_time", columnDefinition = "varchar(100) comment '생분해성-시간'")
  private String ci2Time;
  @Column(name = "ci3_degrade", columnDefinition = "varchar(100) comment '생분해성-분해도'")
  private String ci3Degrade;
  @Column(name = "ci4_ref", columnDefinition = "varchar(100) comment '생분해성-출처'")
  private String ci4Ref;
  @Column(name = "ci5_other", columnDefinition = "varchar(100) comment '생분해성-비고'")
  private String ci5Other;

  @Column(name = "cj1_value1", columnDefinition = "varchar(100) comment '농축성-유일값'")
  private String cj1Value1;
  @Column(name = "cj2_value2", columnDefinition = "varchar(100) comment '농축성-최소값1'")
  private String cj2Value2;
  @Column(name = "cj3_value3", columnDefinition = "varchar(100) comment '농축성-최소값2'")
  private String cj3Value3;
  @Column(name = "cj4_value4", columnDefinition = "varchar(100) comment '농축성-최대값1'")
  private String cj4Value4;
  @Column(name = "cj5_value5", columnDefinition = "varchar(100) comment '농축성-최대값2'")
  private String cj5Value5;
  @Column(name = "cj6_ref", columnDefinition = "varchar(100) comment '농축성-출처'")
  private String cj6Ref;
  @Column(name = "cj6_other", columnDefinition = "varchar(100) comment '농축성-비고'")
  private String cj6Other;

  @Column(name = "ck1_value1", columnDefinition = "varchar(100) comment '토양이동성-유일값'")
  private String ck1Value1;
  @Column(name = "ck2_value2", columnDefinition = "varchar(100) comment '토양이동성-최소값1'")
  private String ck2Value2;
  @Column(name = "ck3_value3", columnDefinition = "varchar(100) comment '토양이동성-최소값2'")
  private String ck3Value3;
  @Column(name = "ck4_value4", columnDefinition = "varchar(100) comment '토양이동성-최대값1'")
  private String ck4Value4;
  @Column(name = "ck5_value5", columnDefinition = "varchar(100) comment '토양이동성-최대값2'")
  private String ck5Value5;
  @Column(name = "ck6_ref", columnDefinition = "varchar(100) comment '토양이동성-출처'")
  private String ck6Ref;
  @Column(name = "ck6_other", columnDefinition = "varchar(100) comment '토양이동성-비고'")
  private String ck6Other;

  @Column(name = "division_C3", columnDefinition = "varchar(100) comment '기타유해영향-구분'")
  private String divisionC3;
  @Column(name = "cl1_data", columnDefinition = "varchar(100) comment '기타유해영향-오존층유해성값'")
  private String cl1Data;
  @Column(name = "cl2_ref", columnDefinition = "varchar(100) comment '기타유해영향-출처'")
  private String cl2Ref;
  @Column(name = "cl3_other", columnDefinition = "varchar(100) comment '기타유해영향-비고'")
  private String cl3Other;


}
