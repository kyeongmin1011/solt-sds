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
@Table(name = "sds_user_matter")
public class UserMatter {

  @Id
  @Column(name = "user_matter_seq", length = 20)
  private Long userMatterSeq;

  @Column(name = "matter_database_seq", length = 20)
  private Long matterDatabaseSeq;  // 참조 물질디비시퀀스

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

  //------------------------------------------------------------- D그룹 14 un번호

  @Column(name = "da1_un", columnDefinition = "varchar(100) comment '번호'")
  private String da1Un;

  //------------------------------------------------------------- E그룹 8 노출기준

  @Column(name = "ea1_domestic", columnDefinition = "varchar(100) comment '노출기준-국내규정'")
  private String ea1Domestic;
  @Column(name = "ea2_biologic", columnDefinition = "varchar(100) comment '노출기준-생물학적'")
  private String ea2Biologic;
  @Column(name = "ea3_acgih", columnDefinition = "varchar(100) comment '노출기준-ACGIH'")
  private String ea3Acgih;
  @Column(name = "ea4_osha", columnDefinition = "varchar(100) comment '노출기준-OSHA'")
  private String ea4Osha;
  @Column(name = "ea5_niosh", columnDefinition = "varchar(100) comment '노출기준-NIOSH'")
  private String ea5Niosh;
  @Column(name = "ea6_eu", columnDefinition = "varchar(100) comment '노출기준-EU'")
  private String ea6EU;
  @Column(name = "ea7_other", columnDefinition = "varchar(100) comment '노출기준-비고'")
  private String ea7Other;

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
  //------------------------------------------------------------- 구분그룹 2 물리화학위험성 구분

  @Column(name = "division_a1", columnDefinition = "varchar(100) comment '폭발성물질 구분'")
  private String divisionA1;
  @Column(name = "division_a2", columnDefinition = "varchar(100) comment '인화성 가스 구분'")
  private String divisionA2;
  @Column(name = "division_a3", columnDefinition = "varchar(100) comment '인화성 가스 불안정 구분'")
  private String divisionA3;
  @Column(name = "division_a4", columnDefinition = "varchar(100) comment '인화성 가스 자연발화성 구분'")
  private String divisionA4;
  @Column(name = "division_a5", columnDefinition = "varchar(100) comment '인화성 에어로졸 구분'")
  private String divisionA5;
  @Column(name = "division_a6", columnDefinition = "varchar(100) comment '산화성 가스 구분'")
  private String divisionA6;
  @Column(name = "division_a7", columnDefinition = "varchar(100) comment '고압가스 구분'")
  private String divisionA7;
  @Column(name = "division_a8", columnDefinition = "varchar(100) comment '인화성 액체 구분'")
  private String divisionA8;
  @Column(name = "division_a9", columnDefinition = "varchar(100) comment '인화성 고체 구분'")
  private String divisionA9;
  @Column(name = "division_a10", columnDefinition = "varchar(100) comment '자기반응성 물질 및 혼합물 구분'")
  private String divisionA10;
  @Column(name = "division_a11", columnDefinition = "varchar(100) comment '자연발화성 액체 구분'")
  private String divisionA11;
  @Column(name = "division_a12", columnDefinition = "varchar(100) comment '자연발화성 고체 구분'")
  private String divisionA12;
  @Column(name = "division_a13", columnDefinition = "varchar(100) comment '자기발열성 물질 및 혼합물 구분'")
  private String divisionA13;
  @Column(name = "division_a14", columnDefinition = "varchar(100) comment '물반응성 물질 및 혼합물 구분'")
  private String divisionA14;
  @Column(name = "division_a15", columnDefinition = "varchar(100) comment '산화성 액체 구분'")
  private String divisionA15;
  @Column(name = "division_a16", columnDefinition = "varchar(100) comment '산화성 고체 구분'")
  private String divisionA16;
  @Column(name = "division_a17", columnDefinition = "varchar(100) comment '유기과산화물 구분'")
  private String divisionA17;
  @Column(name = "division_a18", columnDefinition = "varchar(100) comment '금속부식성 물질 구분'")
  private String divisionA18;
  @Column(name = "division_a19", columnDefinition = "varchar(100) comment '둔감폭발물 구분'")
  private String divisionA19;



}
