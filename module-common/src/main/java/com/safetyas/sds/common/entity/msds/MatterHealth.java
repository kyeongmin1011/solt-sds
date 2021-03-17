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
@Table(name = "sds_matter_health")
public class MatterHealth implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "matter_health_seq", length = 20)
  private Long matterHealthSeq;

  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "matter_data_key", foreignKey = @ForeignKey(name = "matter_data_key_matter_health_fk"))
  private MatterData matterData;

  //----------------------------------------------------------------- B그룹 건강유해성 11 독성에 관한 정보
  @Column(name = "division_b01", columnDefinition = "varchar(100) comment '급성 경구독성-구분'")
  private String divisionB01;  // 구분값
  @Column(name = "ba01_species", columnDefinition = "varchar(100) comment '급성 경구독성-실험종'")
  private String ba01Species;
  @Column(name = "ba02_endpoint", columnDefinition = "varchar(100) comment '급성 경구독성-종말점'")
  private String ba02Endpoint;
  @Column(name = "ba03_value1", columnDefinition = "varchar(100) comment '급성 경구독성-유일값'")
  private String ba03Value1;
  @Column(name = "ba04_value2", columnDefinition = "varchar(100) comment '급성 경구독성-최소값1'")
  private String ba04Value2;
  @Column(name = "ba05_value3", columnDefinition = "varchar(100) comment '급성 경구독성-최소값2'")
  private String ba05Value3;
  @Column(name = "ba06_value4", columnDefinition = "varchar(100) comment '급성 경구독성-최대값1'")
  private String ba06Value4;
  @Column(name = "ba07_value5", columnDefinition = "varchar(100) comment '급성 경구독성-최대값2'")
  private String ba07Value5;
  @Column(name = "ba08_unit", columnDefinition = "varchar(100) comment '급성 경구독성-단위'")
  private String ba08Unit;
  @Column(name = "ba09_tg", columnDefinition = "varchar(100) comment '급성 경구독성-시험지침'")
  private String ba09Tg;
  @Column(name = "ba10_glp", columnDefinition = "varchar(100) comment '급성 경구독성-GLP'")
  private String ba10Glp;
  @Column(name = "ba11_ref", columnDefinition = "varchar(255) comment '급성 경구독성-출처'")
  private String ba11Ref;
  @Column(name = "ba12_other", columnDefinition = "varchar(100) comment '급성 경구독성-비고'")
  private String ba12Other;

  @Column(name = "division_b02", columnDefinition = "varchar(100) comment '급성 경피독성-구분'")
  private String divisionB02;  // 구분값
  @Column(name = "bb01_species", columnDefinition = "varchar(100) comment '급성 경피독성-실험종'")
  private String bb01Species;
  @Column(name = "bb02_endpoint", columnDefinition = "varchar(100) comment '급성 경피독성-종말점'")
  private String bb02Endpoint;
  @Column(name = "bb03_value1", columnDefinition = "varchar(100) comment '급성 경피독성-유일값'")
  private String bb03Value1;
  @Column(name = "bb04_value2", columnDefinition = "varchar(100) comment '급성 경피독성-최소값1'")
  private String bb04Value2;
  @Column(name = "bb05_value3", columnDefinition = "varchar(100) comment '급성 경피독성-최소값2'")
  private String bb05Value3;
  @Column(name = "bb06_value4", columnDefinition = "varchar(100) comment '급성 경피독성-최대값1'")
  private String bb06Value4;
  @Column(name = "bb07_value5", columnDefinition = "varchar(100) comment '급성 경피독성-최대값2'")
  private String bb07Value5;
  @Column(name = "bb08_unit", columnDefinition = "varchar(100) comment '급성 경피독성-단위'")
  private String bb08Unit;
  @Column(name = "bb09_tg", columnDefinition = "varchar(100) comment '급성 경피독성-시험지침'")
  private String bb09Tg;
  @Column(name = "bb10_glp", columnDefinition = "varchar(100) comment '급성 경피독성-GLP'")
  private String bb10Glp;
  @Column(name = "bb11_ref", columnDefinition = "varchar(255) comment '급성 경피독성-출처'")
  private String bb11Ref;
  @Column(name = "bb12_other", columnDefinition = "varchar(100) comment '급성 경피독성-비고'")
  private String bb12Other;

  @Column(name = "division_b03", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-가스구분'")
  private String divisionB03;  // 구분값
  @Column(name = "division_b04", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-증기구분'")
  private String divisionB04;  // 구분값
  @Column(name = "division_b05", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-분진미스트구분'")
  private String divisionB05;  // 구분값

  @Column(name = "bc01_species", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-실험종'")
  private String bc01Species;
  @Column(name = "bc02_endpoint", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-종말점'")
  private String bc02Endpoint;
  @Column(name = "bc03_value1", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-유일값'")
  private String bc03Value1;
  @Column(name = "bc04_value2", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-최소값1'")
  private String bc04Value2;
  @Column(name = "bc05_value3", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-최소값2'")
  private String bc05Value3;
  @Column(name = "bc06_value4", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-최대값1'")
  private String bc06Value4;
  @Column(name = "bc07_value5", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-최대값2'")
  private String bc07Value5;
  @Column(name = "bc08_unit", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-단위'")
  private String bc08Unit;
  @Column(name = "bc09_time", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-시간'")
  private String bc09Time;
  @Column(name = "bc10_property", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-성상'")
  private String bc10Property;
  @Column(name = "bc11_tg", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-시험지침'")
  private String bc11Tg;
  @Column(name = "bc12_glp", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-GLP'")
  private String bc12Glp;
  @Column(name = "bc13_ref", columnDefinition = "varchar(255) comment '급성 흡입독성 가스/증기/분진미스트-출처'")
  private String bc13Ref;
  @Column(name = "bc14_other", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-비고'")
  private String bc14Other;

  @Column(name = "division_b06", columnDefinition = "varchar(100) comment '피부 부식성/피부 자극성-구분'")
  private String divisionB06;  // 구분값
  @Column(name = "bd01_data", columnDefinition = "TEXT comment '피부 부식성/피부 자극성-값'")
  private String bd01Data;
  @Column(name = "bd02_tg", columnDefinition = "varchar(100) comment '피부 부식성/피부 자극성-시험지침'")
  private String bd02Tg;
  @Column(name = "bd03_glp", columnDefinition = "varchar(100) comment '피부 부식성/피부 자극성-GLP'")
  private String bd03Glp;
  @Column(name = "bd04_ref", columnDefinition = "varchar(255) comment '피부 부식성/피부 자극성-출처'")
  private String bd04Ref;
  @Column(name = "bd05_other", columnDefinition = "varchar(100) comment '피부 부식성/피부 자극성-비고'")
  private String bd05Other;

  @Column(name = "division_b07", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-구분'")
  private String divisionB07;  // 구분값
  @Column(name = "be01_data", columnDefinition = "TEXT comment '심한 눈 손상성/눈 자극성-값'")
  private String be01Data;
  @Column(name = "be02_tg", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-시험지침'")
  private String be02Tg;
  @Column(name = "be03_glp", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-GLP'")
  private String be03Glp;
  @Column(name = "be04_ref", columnDefinition = "varchar(255) comment '심한 눈 손상성/눈 자극성-출처'")
  private String be04Ref;
  @Column(name = "be05_data1", columnDefinition = "TEXT comment '심한 눈 손상성/눈 자극성-각막불투명도'")
  private String be05Data1;
  @Column(name = "be06_other1", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-비고1'")
  private String be06Other1;
  @Column(name = "be07_data2", columnDefinition = "TEXT comment '심한 눈 손상성/눈 자극성-홍채염'")
  private String be07Data2;
  @Column(name = "be08_other2", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-비고2'")
  private String be08Other2;
  @Column(name = "be09_data3", columnDefinition = "TEXT comment '심한 눈 손상성/눈 자극성-결막충혈상태'")
  private String be09Data3;
  @Column(name = "be10_Other3", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-비고3'")
  private String be10Other3;
  @Column(name = "be11_data4", columnDefinition = "TEXT comment '심한 눈 손상성/눈 자극성-결막부종상태'")
  private String be11Data4;
  @Column(name = "be12_other4", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-비고4'")
  private String be12Other4;
  @Column(name = "be13_other", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-비고'")
  private String be13Other; // 추가

  @Column(name = "division_b08", columnDefinition = "varchar(100) comment '호흡기과민성-구분'")
  private String divisionB08;  // 구분값
  @Column(name = "bf01_data", columnDefinition = "TEXT comment '호흡기과민성-값'")
  private String bf01Data;
  @Column(name = "bf02_tg", columnDefinition = "varchar(100) comment '호흡기과민성-시험지침'")
  private String bf02Tg;
  @Column(name = "bf03_glp", columnDefinition = "varchar(100) comment '호흡기과민성-GLP'")
  private String bf03Glp;
  @Column(name = "bf04_ref", columnDefinition = "varchar(255) comment '호흡기과민성-출처'")
  private String bf04Ref;
  @Column(name = "bf05_other", columnDefinition = "varchar(100) comment '호흡기과민성-비고'")
  private String bf05Other;

  @Column(name = "division_b09", columnDefinition = "varchar(100) comment '피부 과민성-구분'")
  private String divisionB09;  // 구분값
  @Column(name = "bg01_data", columnDefinition = "TEXT comment '피부 과민성-값'")
  private String bg01Data;
  @Column(name = "bg02_tg", columnDefinition = "varchar(100) comment '피부 과민성-시험지침'")
  private String bg02Tg;
  @Column(name = "bg03_glp", columnDefinition = "varchar(100) comment '피부 과민성-GLP'")
  private String bg03Glp;
  @Column(name = "bg04_ref", columnDefinition = "varchar(255) comment '피부 과민성-출처'")
  private String bg04Ref;
  @Column(name = "bg05_other", columnDefinition = "varchar(100) comment '피부 과민성-비고'")
  private String bg05Other;

  @Column(name = "division_b10", columnDefinition = "varchar(100) comment '생식세포 변이원성-구분'")
  private String divisionB10;  // 구분값
  @Column(name = "bh01_method1", columnDefinition = "varchar(100) comment '생식세포 변이원성-시험방법1'")
  private String bh01Method1;
  @Column(name = "bh02_data1", columnDefinition = "TEXT comment '생식세포 변이원성-값1'")
  private String bh02Data1;
  @Column(name = "bh03_tg1", columnDefinition = "varchar(100) comment '생식세포 변이원성-시험지침1'")
  private String bh03Tg1;
  @Column(name = "bh04_glp1", columnDefinition = "varchar(100) comment '생식세포 변이원성-GLP1'")
  private String bh04Glp1;
  @Column(name = "bh05_ref1", columnDefinition = "varchar(255) comment '생식세포 변이원성-출처1'")
  private String bh05Ref1;
  @Column(name = "bh06_other1", columnDefinition = "varchar(100) comment '생식세포 변이원성-비고1'")
  private String bh06Other1;
  @Column(name = "bh07_data2", columnDefinition = "TEXT comment '생식세포 변이원성-시험방법2'")
  private String bh07Data2;
  @Column(name = "bh08_method2", columnDefinition = "varchar(100) comment '생식세포 변이원성-값2'")
  private String bh08Method2;
  @Column(name = "bh09_tg2", columnDefinition = "varchar(100) comment '생식세포 변이원성-시험지침2'")
  private String bh09Tg2;
  @Column(name = "bh10_glp2", columnDefinition = "varchar(100) comment '생식세포 변이원성-GLP2'")
  private String bh10Glp2;
  @Column(name = "bh11_ref2", columnDefinition = "varchar(255) comment '생식세포 변이원성-출처2'")
  private String bh11Ref2;
  @Column(name = "bh12_other2", columnDefinition = "varchar(100) comment '생식세포 변이원성-비고2'")
  private String bh12Other2;
  @Column(name = "bh13_other", columnDefinition = "varchar(100) comment '생식세포 변이원성-비고'")
  private String bh13Other; //추가

  @Column(name = "division_b11", columnDefinition = "varchar(100) comment '발암성-구분'")
  private String divisionB11;  // 구분값
  @Column(name = "bi01_mol", columnDefinition = "varchar(100) comment '발암성-노동부'")
  private String bi01Mol;
  @Column(name = "bi02_iarc", columnDefinition = "varchar(100) comment '발암성-IARC'")
  private String bi02Iarc;
  @Column(name = "bi03_acgih", columnDefinition = "varchar(100) comment '발암성-ACGIH'")
  private String bi03Acgih;
  @Column(name = "bi04_ntp", columnDefinition = "varchar(100) comment '발암성-NTP'")
  private String bi04Ntp;
  @Column(name = "bi05_osha", columnDefinition = "varchar(100) comment '발암성-OSHA'")
  private String bi05Osha;
  @Column(name = "bi06_euclp", columnDefinition = "varchar(100) comment '발암성-EU CLP'")
  private String bi06Euclp;
  @Column(name = "bi07_other", columnDefinition = "varchar(100) comment '발암성-비고'")
  private String bi07other;

  @Column(name = "division_b12", columnDefinition = "varchar(100) comment '생식독성-구분1'")
  private String divisionB12;  // 구분값
  @Column(name = "bj01_data1", columnDefinition = "TEXT comment '생식독성-값1'")
  private String bj01Data1;
  @Column(name = "bj02_tg1", columnDefinition = "varchar(100) comment '생식독성-시험지침1'")
  private String bj02Tg1;
  @Column(name = "bj03_glp1", columnDefinition = "varchar(100) comment '생식독성-GLP1'")
  private String bj03Glp1;
  @Column(name = "bj04_ref1", columnDefinition = "varchar(255) comment '생식독성-출처1'")
  private String bj04Ref1;
  @Column(name = "bj05_other1", columnDefinition = "TEXT comment '생식독성-비고1'")
  private String bj05Other1;
  @Column(name = "division_b13", columnDefinition = "varchar(100) comment '생식독성-구분2'")
  private String divisionB13;  // 구분값
  @Column(name = "bj06_data2", columnDefinition = "TEXT comment '생식독성-값2'")
  private String bj06Data2;
  @Column(name = "bj07_tg2", columnDefinition = "varchar(100) comment '생식독성-시험지침2'")
  private String bj07Tg2;
  @Column(name = "bj08_glp2", columnDefinition = "varchar(100) comment '생식독성-GLP2'")
  private String bj08Glp2;
  @Column(name = "bj09_ref2", columnDefinition = "varchar(255) comment '생식독성-출처2'")
  private String bj09Ref2;
  @Column(name = "bj10_other2", columnDefinition = "varchar(100) comment '생식독성-비고2'")
  private String bj10Other2;

  @Column(name = "division_b14", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-구분1'")
  private String divisionB14;  // 구분값1
  @Column(name = "division_b15", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-구분2'")
  private String divisionB15;  // 구분값2
  @Column(name = "division_b16", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-구분3'")
  private String divisionB16;  // 구분값3
  @Column(name = "bk01_data1", columnDefinition = "TEXT comment '특정표적장기 독성 1회-값1'")
  private String bk01Data1;
  @Column(name = "bk02_tg1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-시험지침1'")
  private String bk02Tg1;
  @Column(name = "bk03_glp1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-GLP1'")
  private String bk03Glp1;
  @Column(name = "bk04_ref1", columnDefinition = "varchar(255) comment '특정표적장기 독성 1회-출처1'")
  private String bk04Ref1;
  @Column(name = "bk05_other1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-비고1'")
  private String bk05Other1;
  @Column(name = "bk06_data2", columnDefinition = "TEXT comment '특정표적장기 독성 1회-시험종값2'")
  private String bk06Data2;
  @Column(name = "bk07_noael2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-NOAEL2'")
  private String bk07Noael2;
  @Column(name = "bk08_unit2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-단위2'")
  private String bk08Unit2;
  @Column(name = "bk09_time2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-시간2'")
  private String bk09Time2;
  @Column(name = "bk10_tg2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-시험지침2'")
  private String bk10Tg2;
  @Column(name = "bk11_glp2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-GLP2'")
  private String bk11Glp2;
  @Column(name = "bk12_ref2", columnDefinition = "varchar(255) comment '특정표적장기 독성 1회-출처2'")
  private String bk12Ref2;
  @Column(name = "bk13_other2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-비고2'")
  private String bk13Other2;

  @Column(name = "division_b17", columnDefinition = "varchar(100) comment '특정표적장기 독성 반복-구분1'")
  private String divisionB17;  // 구분값1
  @Column(name = "bl01_data1", columnDefinition = "TEXT comment '특정표적장기 독성 1회-값1'")
  private String bl01Data1;
  @Column(name = "bl02_tg1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-시험지침1'")
  private String bl02Tg1;
  @Column(name = "bl03_glp1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-GLP1'")
  private String bl03Glp1;
  @Column(name = "bl04_ref1", columnDefinition = "varchar(255) comment '특정표적장기 독성 1회-출처1'")
  private String bl04Ref1;
  @Column(name = "bl05_other1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-비고1'")
  private String bl05Other1;
  @Column(name = "bl06_data2", columnDefinition = "TEXT comment '특정표적장기 독성 1회-시험종값2'")
  private String bl06Data2;
  @Column(name = "bl07_noael2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-NOAEL2'")
  private String bl07Noael2;
  @Column(name = "bl08_unit2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-단위2'")
  private String bl08Unit2;
  @Column(name = "bl09_time2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-시간2'")
  private String bl09Time2;
  @Column(name = "bl10_tg2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-시험지침2'")
  private String bl10Tg2;
  @Column(name = "bl11_glp2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-GLP2'")
  private String bl11Glp2;
  @Column(name = "bl12_ref2", columnDefinition = "varchar(255) comment '특정표적장기 독성 1회-출처2'")
  private String bl12Ref2;
  @Column(name = "bl13_other2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-비고2'")
  private String bl13Other2;

  @Column(name = "division_b18", columnDefinition = "varchar(100) comment '흡인유해성-구분'")
  private String divisionB18;  // 구분값
  @Column(name = "bm01_data", columnDefinition = "TEXT comment '흡인유해성-값'")
  private String bm01Data;
  @Column(name = "bm02_tg", columnDefinition = "varchar(100) comment '흡인유해성-시험지침'")
  private String bm02Tg;
  @Column(name = "bm03_glp", columnDefinition = "varchar(100) comment '흡인유해성-GLP'")
  private String bm03Glp;
  @Column(name = "bm04_ref", columnDefinition = "varchar(255) comment '흡인유해성-출처'")
  private String bm04Ref;
  @Column(name = "bm05_other", columnDefinition = "varchar(100) comment '흡인유해성-비고'")
  private String bm05Other;

}
