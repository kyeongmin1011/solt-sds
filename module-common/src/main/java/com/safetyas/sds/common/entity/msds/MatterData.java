package com.safetyas.sds.common.entity.msds;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "sds_matter_database")
public class MatterData {

  @Id
  @Column(name = "matter_data_seq", length = 20)
  private Long matterDataSeq;
  @Column(name = "cas_no", columnDefinition = "varchar(50) comment '카스번호'")
  private String casNo;
  @Column(name = "chem_name", columnDefinition = "varchar(500) comment '물질명'")
  private String chemName;
  @Column(name = "other_name", columnDefinition = "varchar(500) comment '이명'")
  private String otherName;

  //------------------------------------------------------------- A그룹 9 물리화학적 특성

  @Column(name = "aa1_appearance", columnDefinition = "varchar(100) comment '외관-성상'")
  private String aa1Appearance;
  @Column(name = "aa2_color", columnDefinition = "varchar(100) comment '외관-색상'")
  private String aa2Color;
  @Column(name = "aa3_ref", columnDefinition = "varchar(100) comment '외관-출처'")
  private String aa3Ref;
  @Column(name = "aa4_other", columnDefinition = "varchar(100) comment '외관-비고'")
  private String aa4Other;

  @Column(name = "ab1_data", columnDefinition = "varchar(100) comment '냄새-값'")
  private String ab1Data;
  @Column(name = "ab2_ref", columnDefinition = "varchar(100) comment '냄새-출처'")
  private String ab2Ref;

  @Column(name = "ac1_data", columnDefinition = "varchar(100) comment '냄새역치-값'")
  private String ac1Data;
  @Column(name = "ac2_unit", columnDefinition = "varchar(100) comment '냄새역치-단위'")
  private String ac2Unit;
  @Column(name = "ac3_ref", columnDefinition = "varchar(100) comment '냄새역치-출처'")
  private String ac3Ref;

  @Column(name = "ad1_value1", columnDefinition = "varchar(100) comment 'PH-유일값'")
  private String ad1Value1;
  @Column(name = "ad2_value2", columnDefinition = "varchar(100) comment 'PH-최소값1'")
  private String ad1Value2;
  @Column(name = "ad3_value3", columnDefinition = "varchar(100) comment 'PH-최소값2'")
  private String ad3Value3;
  @Column(name = "ad4_value4", columnDefinition = "varchar(100) comment 'PH-최대값1'")
  private String ad4Value4;
  @Column(name = "ad5_value5", columnDefinition = "varchar(100) comment 'PH-최대값2'")
  private String ad5Value5;
  @Column(name = "ad6_ref", columnDefinition = "varchar(100) comment 'PH-출처'")
  private String ad6Ref;
  @Column(name = "ad7_other", columnDefinition = "varchar(100) comment 'PH-비고'")
  private String ad7Other;

  @Column(name = "ae1_data", columnDefinition = "varchar(100) comment '녹는점/어는점-값'")
  private String ae1Data;
  @Column(name = "ae2_unit", columnDefinition = "varchar(100) comment '녹는점/어는점-단위'")
  private String ae2Unit;
  @Column(name = "ae3_tg", columnDefinition = "varchar(100) comment '녹는점/어는점-시험지침'")
  private String ae3Tg;
  @Column(name = "ae4_ref", columnDefinition = "varchar(100) comment '녹는점/어는점-출처'")
  private String ae1Ref;

  @Column(name = "af1_value1", columnDefinition = "varchar(100) comment '초기 끓는점과 끓는점 범위-유일값'")
  private String af1Value1;
  @Column(name = "af2_value2", columnDefinition = "varchar(100) comment '초기 끓는점과 끓는점 범위-최소값1'")
  private String af2Value2;
  @Column(name = "af3_value3", columnDefinition = "varchar(100) comment '초기 끓는점과 끓는점 범위-최소값2'")
  private String af3Value3;
  @Column(name = "af4_value4", columnDefinition = "varchar(100) comment '초기 끓는점과 끓는점 범위-최대값1'")
  private String af4Value4;
  @Column(name = "af5_value5", columnDefinition = "varchar(100) comment '초기 끓는점과 끓는점 범위-최대값2'")
  private String af5Value5;
  @Column(name = "af6_unit", columnDefinition = "varchar(100) comment '초기 끓는점과 끓는점 범위-단위'")
  private String af6Unit;
  @Column(name = "af7_tg", columnDefinition = "varchar(100) comment '초기 끓는점과 끓는점 범위-시험지침'")
  private String af7Tg;
  @Column(name = "af8_ref", columnDefinition = "varchar(100) comment '초기 끓는점과 끓는점 범위-출처'")
  private String af8Ref;

  @Column(name = "ag1_value1", columnDefinition = "varchar(100) comment '인화점-유일값'")
  private String ag1Value1;
  @Column(name = "ag2_value2", columnDefinition = "varchar(100) comment '인화점-최소값1'")
  private String ag2Value2;
  @Column(name = "ag3_value3", columnDefinition = "varchar(100) comment '인화점-최소값2'")
  private String ag3Value3;
  @Column(name = "ag4_value4", columnDefinition = "varchar(100) comment '인화점-최대값1'")
  private String ag4Value4;
  @Column(name = "ag5_value5", columnDefinition = "varchar(100) comment '인화점-최대값2'")
  private String ag5Value5;
  @Column(name = "ag6_unit", columnDefinition = "varchar(100) comment '인화점-단위'")
  private String ag6Unit;
  @Column(name = "ag7_tg", columnDefinition = "varchar(100) comment '인화점-시험지침'")
  private String ag7Tg;
  @Column(name = "ag8_ref", columnDefinition = "varchar(100) comment '인화점-출처'")
  private String ag8Ref;
  @Column(name = "ag9_other", columnDefinition = "varchar(100) comment '인화점-비고'")
  private String ag9Other;

  @Column(name = "ah1_data", columnDefinition = "varchar(100) comment '증발속도-값'")
  private String ah1Data;
  @Column(name = "ah2_method", columnDefinition = "varchar(100) comment '증발속도-시험조건'")
  private String ah2Method;
  @Column(name = "ah3_tg", columnDefinition = "varchar(100) comment '증발속도-시험지침'")
  private String ah3Tg;
  @Column(name = "ah4_ref", columnDefinition = "varchar(100) comment '증발속도-출처'")
  private String ah4Ref;

  @Column(name = "ai1_data", columnDefinition = "varchar(100) comment '인화성(고체,기체)-값'")
  private String ai1Data;
  @Column(name = "ai2_tg", columnDefinition = "varchar(100) comment '인화성(고체,기체)-시험지침'")
  private String ai2Tg;
  @Column(name = "ai3_ref", columnDefinition = "varchar(100) comment '인화성(고체,기체)-출처'")
  private String ai3Ref;
  @Column(name = "ai4_other", columnDefinition = "varchar(100) comment '인화성(고체,기체)-비고'")
  private String ai4Other;

  @Column(name = "aj1_value1", columnDefinition = "varchar(100) comment '인화 또는 폭발 범위의 상한/하한-유일값'")
  private String aj1Value1;
  @Column(name = "aj2_value2", columnDefinition = "varchar(100) comment '인화 또는 폭발 범위의 상한/하한-최소값1'")
  private String aj2Value2;
  @Column(name = "aj3_value3", columnDefinition = "varchar(100) comment '인화 또는 폭발 범위의 상한/하한-최소값2'")
  private String aj3Value3;
  @Column(name = "aj4_value4", columnDefinition = "varchar(100) comment '인화 또는 폭발 범위의 상한/하한-최대값1'")
  private String aj4Value4;
  @Column(name = "aj5_value5", columnDefinition = "varchar(100) comment '인화 또는 폭발 범위의 상한/하한-최대값2'")
  private String aj5Value5;
  @Column(name = "aj6_unit", columnDefinition = "varchar(100) comment '인화 또는 폭발 범위의 상한/하한-단위'")
  private String aj6Unit;
  @Column(name = "aj7_tg", columnDefinition = "varchar(100) comment '인화 또는 폭발 범위의 상한/하한-시험지침'")
  private String aj7Tg;
  @Column(name = "aj8_ref", columnDefinition = "varchar(100) comment '인화 또는 폭발 범위의 상한/하한-출처'")
  private String aj8Ref;
  @Column(name = "aj9_other", columnDefinition = "varchar(100) comment '인화 또는 폭발 범위의 상한/하한-비고'")
  private String aj9Other;

  @Column(name = "ak1_data", columnDefinition = "varchar(100) comment '증기압-값'")
  private String ak1Data;
  @Column(name = "ak2_unit", columnDefinition = "varchar(100) comment '증기압-단위'")
  private String ak2Unit;
  @Column(name = "ak3_method", columnDefinition = "varchar(100) comment '증기압-시험조건'")
  private String ak3Method;
  @Column(name = "ak4_tg", columnDefinition = "varchar(100) comment '증기압-시험지침'")
  private String ak4Tg;
  @Column(name = "ak5_ref", columnDefinition = "varchar(100) comment '증기압-출처'")
  private String ak5Ref;

  @Column(name = "al1_data", columnDefinition = "varchar(100) comment '용해도-값'")
  private String al1Data;
  @Column(name = "al2_unit", columnDefinition = "varchar(100) comment '용해도-단위'")
  private String al2Unit;
  @Column(name = "al3_method", columnDefinition = "varchar(100) comment '용해도-시험조건'")
  private String al3Method;
  @Column(name = "al4_tg", columnDefinition = "varchar(100) comment '용해도-시험지침'")
  private String al4Tg;
  @Column(name = "al5_ref", columnDefinition = "varchar(100) comment '용해도-출처'")
  private String al5Ref;
  @Column(name = "ak5_other", columnDefinition = "varchar(100) comment '용해도-비고'")
  private String al6Other;

  @Column(name = "am1_data", columnDefinition = "varchar(100) comment '증기밀도-값'")
  private String am1Data;
  @Column(name = "am2_unit", columnDefinition = "varchar(100) comment '증기밀도-단위'")
  private String am2Unit;
  @Column(name = "am3_method", columnDefinition = "varchar(100) comment '증기밀도-시험조건'")
  private String am3Method;
  @Column(name = "am4_tg", columnDefinition = "varchar(100) comment '증기밀도-시험지침'")
  private String am4Tg;
  @Column(name = "am5_ref", columnDefinition = "varchar(100) comment '증기밀도-출처'")
  private String am5Ref;

  @Column(name = "an1_data", columnDefinition = "varchar(100) comment '비중-값'")
  private String an1Data;
  @Column(name = "an2_unit", columnDefinition = "varchar(100) comment '비중-단위'")
  private String an2Unit;
  @Column(name = "an3_method", columnDefinition = "varchar(100) comment '비중-시험조건'")
  private String an3Method;
  @Column(name = "an4_tg", columnDefinition = "varchar(100) comment '비중-시험지침'")
  private String an4Tg;
  @Column(name = "an5_ref", columnDefinition = "varchar(100) comment '비중-출처'")
  private String an5Ref;

  @Column(name = "ao1_value1", columnDefinition = "varchar(100) comment 'n 옥탄올/물 분배계수-유일값'")
  private String ao1Value1;
  @Column(name = "ao2_value2", columnDefinition = "varchar(100) comment 'n 옥탄올/물 분배계수-최소값1'")
  private String ao2Value2;
  @Column(name = "ao3_value3", columnDefinition = "varchar(100) comment 'n 옥탄올/물 분배계수-최소값2'")
  private String ao3Value3;
  @Column(name = "ao4_value4", columnDefinition = "varchar(100) comment 'n 옥탄올/물 분배계수-최대값1'")
  private String ao4Value4;
  @Column(name = "ao5_value5", columnDefinition = "varchar(100) comment 'n 옥탄올/물 분배계수-최대값2'")
  private String ao5Value5;
  @Column(name = "ao6_unit", columnDefinition = "varchar(100) comment 'n 옥탄올/물 분배계수-단위'")
  private String ao6Unit;
  @Column(name = "ao7_tg", columnDefinition = "varchar(100) comment 'n 옥탄올/물 분배계수-시험지침'")
  private String ao7Tg;
  @Column(name = "ao8_ref", columnDefinition = "varchar(100) comment 'n 옥탄올/물 분배계수-출처'")
  private String ao8Ref;
  @Column(name = "ao9_other", columnDefinition = "varchar(100) comment 'n 옥탄올/물 분배계수-비고'")
  private String ao9Other;

  @Column(name = "ap1_data", columnDefinition = "varchar(100) comment '자연발화 온도-값'")
  private String ap1Data;
  @Column(name = "ap2_unit", columnDefinition = "varchar(100) comment '자연발화 온도-단위'")
  private String ap2Unit;
  @Column(name = "ap3_method", columnDefinition = "varchar(100) comment '자연발화 온도-시험조건'")
  private String ap3Method;
  @Column(name = "ap4_tg", columnDefinition = "varchar(100) comment '자연발화 온도-시험지침'")
  private String ap4Tg;
  @Column(name = "ap5_ref", columnDefinition = "varchar(100) comment '자연발화 온도-출처'")
  private String ap5Ref;

  @Column(name = "aq1_data", columnDefinition = "varchar(100) comment '분해온도-값'")
  private String aq1Data;
  @Column(name = "aq2_unit", columnDefinition = "varchar(100) comment '분해온도-단위'")
  private String aq2Unit;
  @Column(name = "aq3_method", columnDefinition = "varchar(100) comment '분해온도-시험조건'")
  private String aq3Method;
  @Column(name = "aq4_tg", columnDefinition = "varchar(100) comment '분해온도-시험지침'")
  private String aq4Tg;
  @Column(name = "aq5_ref", columnDefinition = "varchar(100) comment '분해온도-출처'")
  private String aq5Ref;

  @Column(name = "ar1_data1", columnDefinition = "varchar(100) comment '점도-값1'")
  private String ar1Data1;
  @Column(name = "ar2_unit1", columnDefinition = "varchar(100) comment '점도-단위1'")
  private String ar2Unit1;
  @Column(name = "ar3_ref1", columnDefinition = "varchar(100) comment '점도-출처1'")
  private String ar3Ref1;
  @Column(name = "ar4_data2", columnDefinition = "varchar(100) comment '점도-동점도값'")
  private String ar4Data2;
  @Column(name = "ar5_unit2", columnDefinition = "varchar(100) comment '점도-동점도 단위'")
  private String ar5Unit2;
  @Column(name = "ar6_temper", columnDefinition = "varchar(100) comment '점도-동점도 온도'")
  private String ar6Temper;
  @Column(name = "ar7_unit3", columnDefinition = "varchar(100) comment '점도-동점도 온도 단위3'")
  private String ar7Unit3;
  @Column(name = "ar8_ref2", columnDefinition = "varchar(100) comment '점도-동점도 출처2'")
  private String ar8Ref2;

  @Column(name = "as1_data", columnDefinition = "varchar(100) comment '분자량-값'")
  private String as1Data;
  @Column(name = "as2_ref", columnDefinition = "varchar(100) comment '분자량-출처'")
  private String as2Ref;

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

  @Column(name = "division_B3", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-구분'")
  private String divisionB3;  // 구분값
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

  @Column(name = "division_B4", columnDefinition = "varchar(100) comment '피부 부식성/피부 자극성-구분'")
  private String divisionB4;  // 구분값
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

  @Column(name = "division_B5", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-구분'")
  private String divisionB5;  // 구분값
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

  @Column(name = "division_B6", columnDefinition = "varchar(100) comment '호흡기과민성-구분'")
  private String divisionB6;  // 구분값
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

  @Column(name = "division_B7", columnDefinition = "varchar(100) comment '피부 과민성-구분'")
  private String divisionB7;  // 구분값
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

  @Column(name = "division_B8", columnDefinition = "varchar(100) comment '생식세포 변이원성-구분'")
  private String divisionB8;  // 구분값
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

  @Column(name = "division_B9", columnDefinition = "varchar(100) comment '발암성-구분'")
  private String divisionB9;  // 구분값
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

  @Column(name = "division_B10", columnDefinition = "varchar(100) comment '생식독성-구분1'")
  private String divisionB10;  // 구분값
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
  @Column(name = "division_B11", columnDefinition = "varchar(100) comment '생식독성-구분2'")
  private String divisionB11;  // 구분값
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

  @Column(name = "division_B12", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-구분1'")
  private String divisionB12;  // 구분값1
  @Column(name = "division_B13", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-구분2'")
  private String divisionB13;  // 구분값2
  @Column(name = "division_B14", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-구분3'")
  private String divisionB14;  // 구분값3
  @Column(name = "bk1_data1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-값1'")
  private String bk1Data1;
  @Column(name = "bk2_glp1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-GLP1'")
  private String bk2Glp1;
  @Column(name = "bk3_data2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-값2'")
  private String bk3Data2;
  @Column(name = "bk4_unit2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-단위2'")
  private String bk4Unit2;
  @Column(name = "bk5_tg2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-시험지침2'")
  private String bk5Tg2;
  @Column(name = "bk6_glp2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-GLP2'")
  private String bk6Glp2;
  @Column(name = "bk6_ref2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-출처2'")
  private String bk6Ref2;
  @Column(name = "bk6_other2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-비고2'")
  private String bk6Other2;

  @Column(name = "division_B15", columnDefinition = "varchar(100) comment '특정표적장기 독성 반복-구분1'")
  private String divisionB15;  // 구분값1
  @Column(name = "bl1_data1", columnDefinition = "varchar(100) comment '특정표적장기 독성 반복-값1'")
  private String bl1Data1;
  @Column(name = "bl1_tg1", columnDefinition = "varchar(100) comment '특정표적장기 독성 반복-시험지침1'")
  private String bl2Tg1;
  @Column(name = "bl3_glp1", columnDefinition = "varchar(100) comment '특정표적장기 독성 반복-GLP1'")
  private String bl3Glp1;
  @Column(name = "bl4_data2", columnDefinition = "varchar(100) comment '특정표적장기 독성 반복-시험종값2'")
  private String bl4Data2;
  @Column(name = "bl5_noael2", columnDefinition = "varchar(100) comment '특정표적장기 독성 반복-noael값2'")
  private String bl5Noael2;
  @Column(name = "bl6_unit2", columnDefinition = "varchar(100) comment '특정표적장기 독성 반복-단위2'")
  private String bl6Unit2;
  @Column(name = "bl7_tg2", columnDefinition = "varchar(100) comment '특정표적장기 독성 반복-시험지침2'")
  private String bl7Tg2;
  @Column(name = "bl8_glp2", columnDefinition = "varchar(100) comment '특정표적장기 독성 반복-GLP2'")
  private String bl8Glp2;
  @Column(name = "bl9_ref2", columnDefinition = "varchar(100) comment '특정표적장기 독성 반복-출처2'")
  private String bl9Ref2;
  @Column(name = "bl10_other2", columnDefinition = "varchar(100) comment '특정표적장기 독성 반복-비고2'")
  private String bl10Other2;

  @Column(name = "division_B16", columnDefinition = "varchar(100) comment '흡인유해성-구분'")
  private String divisionB16;  // 구분값
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

  //------------------------------------------------------------- C그룹 12 환경유해성

}
