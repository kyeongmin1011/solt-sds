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
@Table(name = "sds_matter_health")
public class MatterHealth {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "matter_health_seq", length = 20)
  private Long matterHealthSeq;

  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "matter_data_key", foreignKey = @ForeignKey(name = "matter_data_key_matter_health_fk"))
  private MatterData matterData;

  //----------------------------------------------------------------- B그룹 11 독성에 관한 정보
  @Column(name = "division_b1", columnDefinition = "varchar(100) comment '급성 경구독성-구분'")
  private String divisionB1;  // 구분값
  @Column(name = "ba1_species", columnDefinition = "varchar(100) comment '급성 경구독성-실험종'")
  private String ba1Species;
  @Column(name = "ba2_endpoint", columnDefinition = "varchar(100) comment '급성 경구독성-종말점'")
  private String ba2Endpoint;
  @Column(name = "ba3_value1", columnDefinition = "varchar(100) comment '급성 경구독성-유일값'")
  private String ba3Value1;
  @Column(name = "ba4_value2", columnDefinition = "varchar(100) comment '급성 경구독성-최소값1'")
  private String ba4Value2;
  @Column(name = "ba5_value3", columnDefinition = "varchar(100) comment '급성 경구독성-최소값2'")
  private String ba5Value3;
  @Column(name = "ba6_value4", columnDefinition = "varchar(100) comment '급성 경구독성-최대값1'")
  private String ba6Value4;
  @Column(name = "ba7_value5", columnDefinition = "varchar(100) comment '급성 경구독성-최대값2'")
  private String ba7Value5;
  @Column(name = "ba8_unit", columnDefinition = "varchar(100) comment '급성 경구독성-단위'")
  private String ba8Unit;
  @Column(name = "ba9_tg", columnDefinition = "varchar(100) comment '급성 경구독성-시험지침'")
  private String ba9Tg;
  @Column(name = "ba10_glp", columnDefinition = "varchar(100) comment '급성 경구독성-GLP'")
  private String ba10Glp;
  @Column(name = "ba11_ref", columnDefinition = "varchar(100) comment '급성 경구독성-출처'")
  private String ba11Ref;
  @Column(name = "ba12_other", columnDefinition = "varchar(100) comment '급성 경구독성-비고'")
  private String ba12Other;

  @Column(name = "division_b2", columnDefinition = "varchar(100) comment '급성 경피독성-구분'")
  private String divisionB2;  // 구분값
  @Column(name = "bb1_species", columnDefinition = "varchar(100) comment '급성 경피독성-실험종'")
  private String bb1Species;
  @Column(name = "bb2_endpoint", columnDefinition = "varchar(100) comment '급성 경피독성-종말점'")
  private String bb2Endpoint;
  @Column(name = "bb3_value1", columnDefinition = "varchar(100) comment '급성 경피독성-유일값'")
  private String bb3Value1;
  @Column(name = "bb4_value2", columnDefinition = "varchar(100) comment '급성 경피독성-최소값1'")
  private String bb4Value2;
  @Column(name = "bb5_value3", columnDefinition = "varchar(100) comment '급성 경피독성-최소값2'")
  private String bb5Value3;
  @Column(name = "bb6_value4", columnDefinition = "varchar(100) comment '급성 경피독성-최대값1'")
  private String bb6Value4;
  @Column(name = "bb7_value5", columnDefinition = "varchar(100) comment '급성 경피독성-최대값2'")
  private String bb7Value5;
  @Column(name = "bb8_unit", columnDefinition = "varchar(100) comment '급성 경피독성-단위'")
  private String bb8Unit;
  @Column(name = "bb9_tg", columnDefinition = "varchar(100) comment '급성 경피독성-시험지침'")
  private String bb9Tg;
  @Column(name = "bb10_glp", columnDefinition = "varchar(100) comment '급성 경피독성-GLP'")
  private String bb10Glp;
  @Column(name = "bb11_ref", columnDefinition = "varchar(100) comment '급성 경피독성-출처'")
  private String bb11Ref;
  @Column(name = "bb12_other", columnDefinition = "varchar(100) comment '급성 경피독성-비고'")
  private String bb12Other;

  @Column(name = "division_b3", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-가스구분'")
  private String divisionB3;  // 구분값
  @Column(name = "division_b4", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-증기구분'")
  private String divisionB4;  // 구분값
  @Column(name = "division_b5", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-분진미스트구분'")
  private String divisionB5;  // 구분값
  @Column(name = "bc1_species", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-실험종'")
  private String bc1Species;
  @Column(name = "bc2_endpoint", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-종말점'")
  private String bc2Endpoint;
  @Column(name = "bc3_value1", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-유일값'")
  private String bc3Value1;
  @Column(name = "bc4_value2", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-최소값1'")
  private String bc4Value2;
  @Column(name = "bc5_value3", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-최소값2'")
  private String bc5Value3;
  @Column(name = "bc6_value4", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-최대값1'")
  private String bc6Value4;
  @Column(name = "bc7_value5", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-최대값2'")
  private String bc7Value5;
  @Column(name = "bc8_unit", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-단위'")
  private String bc8Unit;
  @Column(name = "bc8_time", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-시간'")
  private String bc8Time;
  @Column(name = "bc8_property", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-성상'")
  private String bc8Property;
  @Column(name = "bc9_tg", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-시험지침'")
  private String bc9Tg;
  @Column(name = "bc10_glp", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-GLP'")
  private String bc10Glp;
  @Column(name = "bc11_ref", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-출처'")
  private String bc11Ref;
  @Column(name = "bc12_other", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-비고'")
  private String bc12Other;

  @Column(name = "division_b6", columnDefinition = "varchar(100) comment '피부 부식성/피부 자극성-구분'")
  private String divisionB6;  // 구분값
  @Column(name = "bd1_data", columnDefinition = "varchar(100) comment '피부 부식성/피부 자극성-값'")
  private String bd1Data;
  @Column(name = "bd2_tg", columnDefinition = "varchar(100) comment '피부 부식성/피부 자극성-시험지침'")
  private String bd2Tg;
  @Column(name = "bd3_glp", columnDefinition = "varchar(100) comment '피부 부식성/피부 자극성-GLP'")
  private String bd3Glp;
  @Column(name = "bd4_ref", columnDefinition = "varchar(100) comment '피부 부식성/피부 자극성-출처'")
  private String bd4Ref;
  @Column(name = "bd5_other", columnDefinition = "varchar(100) comment '피부 부식성/피부 자극성-비고'")
  private String bd5Other;

  @Column(name = "division_b7", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-구분'")
  private String divisionB7;  // 구분값
  @Column(name = "be1_data", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-값'")
  private String be1Data;
  @Column(name = "be2_tg", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-시험지침'")
  private String be2Tg;
  @Column(name = "be3_glp", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-GLP'")
  private String be3Glp;
  @Column(name = "be4_ref", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-출처'")
  private String be4Ref;
  @Column(name = "be5_data1", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-각막불투명도'")
  private String be5Data1;
  @Column(name = "be6_other1", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-비고'")
  private String be6Other1;
  @Column(name = "be7_data2", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-홍채염'")
  private String be7Data2;
  @Column(name = "be8_other2", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-비고'")
  private String be8Other2;
  @Column(name = "be9_data3", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-결막충혈상태'")
  private String be9Data3;
  @Column(name = "be10_Other3", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-비고'")
  private String be10Other3;
  @Column(name = "be11_data4", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-결막부종상태'")
  private String be11Data4;
  @Column(name = "be12_other4", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-비고'")
  private String be5Other4;

  @Column(name = "division_b8", columnDefinition = "varchar(100) comment '호흡기과민성-구분'")
  private String divisionB8;  // 구분값
  @Column(name = "bf1_data", columnDefinition = "varchar(100) comment '호흡기과민성-값'")
  private String bf1Data;
  @Column(name = "bf2_tg", columnDefinition = "varchar(100) comment '호흡기과민성-시험지침'")
  private String bf2Tg;
  @Column(name = "bf3_glp", columnDefinition = "varchar(100) comment '호흡기과민성-GLP'")
  private String bf3Glp;
  @Column(name = "bf4_ref", columnDefinition = "varchar(100) comment '호흡기과민성-출처'")
  private String bf4Ref;
  @Column(name = "bf5_other", columnDefinition = "varchar(100) comment '호흡기과민성-비고'")
  private String bf5Other;

  @Column(name = "division_b9", columnDefinition = "varchar(100) comment '피부 과민성-구분'")
  private String divisionB9;  // 구분값
  @Column(name = "bg1_data", columnDefinition = "varchar(100) comment '피부 과민성-값'")
  private String bg1Data;
  @Column(name = "bg2_tg", columnDefinition = "varchar(100) comment '피부 과민성-시험지침'")
  private String bg2Tg;
  @Column(name = "bg3_glp", columnDefinition = "varchar(100) comment '피부 과민성-GLP'")
  private String bg3Glp;
  @Column(name = "bg4_ref", columnDefinition = "varchar(100) comment '피부 과민성-출처'")
  private String bg4Ref;
  @Column(name = "bg5_other", columnDefinition = "varchar(100) comment '피부 과민성-비고'")
  private String bg5Other;

  @Column(name = "division_b10", columnDefinition = "varchar(100) comment '생식세포 변이원성-구분'")
  private String divisionB10;  // 구분값
  @Column(name = "bh1_method1", columnDefinition = "varchar(100) comment '생식세포 변이원성-시험방법1'")
  private String bh1Method1;
  @Column(name = "bh2_data1", columnDefinition = "varchar(100) comment '생식세포 변이원성-값1'")
  private String bh2Data1;
  @Column(name = "bh3_tg1", columnDefinition = "varchar(100) comment '생식세포 변이원성-시험지침1'")
  private String bh3Tg1;
  @Column(name = "bh4_glp1", columnDefinition = "varchar(100) comment '생식세포 변이원성-GLP1'")
  private String bh4Glp1;
  @Column(name = "bh5_ref1", columnDefinition = "varchar(100) comment '생식세포 변이원성-출처1'")
  private String bh5Ref1;
  @Column(name = "bh6_other1", columnDefinition = "varchar(100) comment '생식세포 변이원성-비고1'")
  private String bh6Other1;
  @Column(name = "bh7_method2", columnDefinition = "varchar(100) comment '생식세포 변이원성-값2'")
  private String bh7Method2;
  @Column(name = "bh8_data2", columnDefinition = "varchar(100) comment '생식세포 변이원성-시험방법2'")
  private String bh8Data2;
  @Column(name = "bh9_tg2", columnDefinition = "varchar(100) comment '생식세포 변이원성-시험지침2'")
  private String bh9Tg2;
  @Column(name = "bh10_glp2", columnDefinition = "varchar(100) comment '생식세포 변이원성-GLP2'")
  private String bh10Glp2;
  @Column(name = "bh11_ref2", columnDefinition = "varchar(100) comment '생식세포 변이원성-출처2'")
  private String bh11Ref2;
  @Column(name = "bh12_other2", columnDefinition = "varchar(100) comment '생식세포 변이원성-비고2'")
  private String bh12Other2;

  @Column(name = "division_b11", columnDefinition = "varchar(100) comment '발암성-구분'")
  private String divisionB11;  // 구분값
  @Column(name = "bi1_mol", columnDefinition = "varchar(100) comment '발암성-노동부'")
  private String bi1Mol;
  @Column(name = "bi2_iarc", columnDefinition = "varchar(100) comment '발암성-IARC'")
  private String bi2Iarc;
  @Column(name = "bi3_acgih", columnDefinition = "varchar(100) comment '발암성-ACGIH'")
  private String bi3Acgih;
  @Column(name = "bi4_ntp", columnDefinition = "varchar(100) comment '발암성-NTP'")
  private String bi4Ntp;
  @Column(name = "bi5_osha", columnDefinition = "varchar(100) comment '발암성-OSHA'")
  private String bi5Osha;
  @Column(name = "bi6_euclp", columnDefinition = "varchar(100) comment '발암성-EU CLP'")
  private String bi6Euclp;
  @Column(name = "bi7_other", columnDefinition = "varchar(100) comment '발암성-비고'")
  private String bi7other;

  @Column(name = "division_b12", columnDefinition = "varchar(100) comment '생식독성-구분1'")
  private String divisionB12;  // 구분값
  @Column(name = "bj1_data1", columnDefinition = "varchar(100) comment '생식독성-값1'")
  private String bj1Data1;
  @Column(name = "bj2_tg1", columnDefinition = "varchar(100) comment '생식독성-시험지침1'")
  private String bj2Tg1;
  @Column(name = "bj3_glp1", columnDefinition = "varchar(100) comment '생식독성-GLP1'")
  private String bj3Glp1;
  @Column(name = "bj4_ref1", columnDefinition = "varchar(100) comment '생식독성-출처1'")
  private String bj4Ref1;
  @Column(name = "bj5_other1", columnDefinition = "varchar(100) comment '생식독성-비고1'")
  private String bj5Other1;
  @Column(name = "division_b13", columnDefinition = "varchar(100) comment '생식독성-구분2'")
  private String divisionB13;  // 구분값
  @Column(name = "bj6_data2", columnDefinition = "varchar(100) comment '생식독성-값2'")
  private String bj6Data2;
  @Column(name = "bj7_tg2", columnDefinition = "varchar(100) comment '생식독성-시험지침2'")
  private String bj7Tg2;
  @Column(name = "bj8_glp2", columnDefinition = "varchar(100) comment '생식독성-GLP2'")
  private String bj8Glp2;
  @Column(name = "bj9_ref2", columnDefinition = "varchar(100) comment '생식독성-출처2'")
  private String bj9Ref2;
  @Column(name = "bj10_other2", columnDefinition = "varchar(100) comment '생식독성-비고2'")
  private String bj10Other2;

  @Column(name = "division_b14", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-구분1'")
  private String divisionB14;  // 구분값1
  @Column(name = "division_b15", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-구분2'")
  private String divisionB15;  // 구분값2
  @Column(name = "division_b16", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-구분3'")
  private String divisionB16;  // 구분값3
  @Column(name = "bk1_data1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-값1'")
  private String bk1Data1;
  @Column(name = "bk2_tg1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-시험지침1'")
  private String bk2Tg1;
  @Column(name = "bk3_glp1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-GLP1'")
  private String bk3Glp1;
  @Column(name = "bk4_ref1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-출처1'")
  private String bk4Ref1;
  @Column(name = "bk5_other1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-비고1'")
  private String bk5Other1;
  @Column(name = "bk6_data2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-시험종값2'")
  private String bk6Data2;
  @Column(name = "bk7_noael2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-NOAEL2'")
  private String bk7Noael2;
  @Column(name = "bk8_unit2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-단위2'")
  private String bk8Unit2;
  @Column(name = "bk9_time2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-시간2'")
  private String bk9Time2;
  @Column(name = "bk10_tg2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-시험지침2'")
  private String bk10Tg2;
  @Column(name = "bk11_glp2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-GLP2'")
  private String bk11Glp2;
  @Column(name = "bk12_ref2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-출처2'")
  private String bk12Ref2;
  @Column(name = "bk13_other2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-비고2'")
  private String bk13Other2;

  @Column(name = "division_b17", columnDefinition = "varchar(100) comment '특정표적장기 독성 반복-구분1'")
  private String divisionB17;  // 구분값1
  @Column(name = "bl1_data1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-값1'")
  private String bl1Data1;
  @Column(name = "bl2_tg1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-시험지침1'")
  private String bl2Tg1;
  @Column(name = "bl3_glp1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-GLP1'")
  private String bl3Glp1;
  @Column(name = "bl4_ref1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-출처1'")
  private String bl4Ref1;
  @Column(name = "bl5_other1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-비고1'")
  private String bl5Other1;
  @Column(name = "bl6_data2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-시험종값2'")
  private String bl6Data2;
  @Column(name = "bl7_noael2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-NOAEL2'")
  private String bl7Noael2;
  @Column(name = "bl8_unit2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-단위2'")
  private String bl8Unit2;
  @Column(name = "bl9_time2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-시간2'")
  private String bl9Time2;
  @Column(name = "bl10_tg2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-시험지침2'")
  private String bl10Tg2;
  @Column(name = "bl11_glp2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-GLP2'")
  private String bl11Glp2;
  @Column(name = "bl12_ref2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-출처2'")
  private String bl12Ref2;
  @Column(name = "bl13_other2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-비고2'")
  private String bl13Other2;

  @Column(name = "division_b18", columnDefinition = "varchar(100) comment '흡인유해성-구분'")
  private String divisionB18;  // 구분값
  @Column(name = "bm1_data", columnDefinition = "varchar(100) comment '흡인유해성-값'")
  private String bm1Data;
  @Column(name = "bm2_tg", columnDefinition = "varchar(100) comment '흡인유해성-시험지침'")
  private String bm2Tg;
  @Column(name = "bm3_glp", columnDefinition = "varchar(100) comment '흡인유해성-GLP'")
  private String bm3Glp;
  @Column(name = "bm4_ref", columnDefinition = "varchar(100) comment '흡인유해성-출처'")
  private String bm4Ref;
  @Column(name = "bm5_other", columnDefinition = "varchar(100) comment '흡인유해성-비고'")
  private String bm5Other;

}
