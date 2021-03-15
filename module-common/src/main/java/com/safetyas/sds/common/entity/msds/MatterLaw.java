package com.safetyas.sds.common.entity.msds;

import java.io.Serializable;
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
@Table(name = "sds_matter_law")
public class MatterLaw implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "matter_law_seq", length = 20)
  private Long matterLawSeq;

  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "matter_data_key", foreignKey = @ForeignKey(name = "matter_data_key_matter_law_fk"))
  private MatterData matterData;

  //------------------------------------------------------------- D그룹 14 un번호

  @Column(name = "da1_un", columnDefinition = "varchar(100) comment '번호'")
  private String da1Un;

  //------------------------------------------------------------- E그룹 8 노출기준

  @Column(name = "ea1_domestic", columnDefinition = "varchar(100) comment '노출기준-국내규정'")
  private String ea1Domestic;
  @Column(name = "ea2_acgih", columnDefinition = "varchar(100) comment '노출기준-ACGIH'")
  private String ea2Acgih;
  @Column(name = "ea3_osha", columnDefinition = "varchar(100) comment '노출기준-OSHA'")
  private String ea3Osha;
  @Column(name = "ea4_niosh", columnDefinition = "varchar(100) comment '노출기준-NIOSH'")
  private String ea4Niosh;
  @Column(name = "ea5_eu", columnDefinition = "varchar(100) comment '노출기준-EU'")
  private String ea5EU;
  @Column(name = "ea6_other", columnDefinition = "varchar(100) comment '노출기준-비고'")
  private String ea6Other;

  //------------------------------------------------------------- F그룹 15 법적규제현황

  @Column(name = "fa1_data1", columnDefinition = "varchar(100) comment '산안법-노출기준설정물질'")
  private String fa1Data1;
  @Column(name = "fa2_data2", columnDefinition = "varchar(100) comment '산안법-작업환경측정대상'")
  private String fa2Data2;
  @Column(name = "fa3_data3", columnDefinition = "varchar(100) comment '산안법-특수건강진단대상'")
  private String fa3Data3;
  @Column(name = "fa4_data4", columnDefinition = "varchar(100) comment '산안법-관리대상유해물질'")
  private String fa4Data4;
  @Column(name = "fa5_data5", columnDefinition = "varchar(100) comment '산안법-특별관리물질'")
  private String fa5Data5;
  @Column(name = "fa6_data6", columnDefinition = "varchar(100) comment '산안법-허용기준이하유지'")
  private String fa6Data6;
  @Column(name = "fa7_data7", columnDefinition = "varchar(100) comment '산안법-공정안전보고서'")
  private String fa7Data7;
  @Column(name = "fa8_data8", columnDefinition = "varchar(100) comment '산안법-법117조'")
  private String fa8Data8;
  @Column(name = "fa9_data9", columnDefinition = "varchar(100) comment '산안법-법118'")
  private String fa9Data9;

  @Column(name = "fb1_data1", columnDefinition = "varchar(100) comment '화관법-유독물질'")
  private String fb1Data1;
  @Column(name = "fb2_data2", columnDefinition = "varchar(100) comment '화관법-허가물질'")
  private String fb2_data2;
  @Column(name = "fb3_data3", columnDefinition = "varchar(100) comment '화관법-제한물질'")
  private String fb3Date3;
  @Column(name = "fb4_data4", columnDefinition = "varchar(100) comment '화관법-금지물질'")
  private String fb4Data4;
  @Column(name = "fb5_data5", columnDefinition = "varchar(100) comment '화관법-사고대비물'")
  private String fb5Data5;

  @Column(name = "fc1_data1", columnDefinition = "varchar(100) comment '위안법-값'")
  private String fc1Data1;

  @Column(name = "fd1_data1", columnDefinition = "varchar(100) comment '폐기물관리법-값'")
  private String fd1Data1;

  @Column(name = "fe1_data1", columnDefinition = "varchar(100) comment '기타규제-잔류성유기오염물질관리법'")
  private String fe1Data1;
  @Column(name = "fe2_data2", columnDefinition = "varchar(100) comment '기타규제-화평법'")
  private String fe2Data2;
  @Column(name = "fe3Data3", columnDefinition = "varchar(100) comment '기타규제-EU분류정보'")
  private String fe3Data3;
  @Column(name = "fe4_data4", columnDefinition = "varchar(100) comment '기타규제-로테르담협약물질'")
  private String fe4Data4;
  @Column(name = "fe5_data5", columnDefinition = "varchar(100) comment '기타규제-스톡홀름협약물질'")
  private String fe5Data5;
  @Column(name = "fe6_data6", columnDefinition = "varchar(100) comment '기타규제-몬트리올의정서'")
  private String fe6Data6;

}
