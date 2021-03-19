package com.safetyas.sds.common.model.msds;

import com.safetyas.sds.common.entity.msds.MatterHealth;
import com.safetyas.sds.common.modelMapper.ModelMapperUtils;
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
public class MatterHealthDTO {

  private Long healthSeq;

  //----------------------------------------------------------------- B그룹 건강유해성 11 독성에 관한 정보
  //(name = "division_b01", columnDefinition = "varchar(100) comment '급성 경구독성-구분'")
  private String divisionB01;  // 구분값
  //(name = "ba01_species", columnDefinition = "varchar(100) comment '급성 경구독성-실험종'")
  private String ba01Species;
  //(name = "ba02_endpoint", columnDefinition = "varchar(100) comment '급성 경구독성-종말점'")
  private String ba02Endpoint;
  //(name = "ba03_value1", columnDefinition = "varchar(100) comment '급성 경구독성-유일값'")
  private String ba03Value1;
  //(name = "ba04_value2", columnDefinition = "varchar(100) comment '급성 경구독성-최소값1'")
  private String ba04Value2;
  //(name = "ba05_value3", columnDefinition = "varchar(100) comment '급성 경구독성-최소값2'")
  private String ba05Value3;
  //(name = "ba06_value4", columnDefinition = "varchar(100) comment '급성 경구독성-최대값1'")
  private String ba06Value4;
  //(name = "ba07_value5", columnDefinition = "varchar(100) comment '급성 경구독성-최대값2'")
  private String ba07Value5;
  //(name = "ba08_unit", columnDefinition = "varchar(100) comment '급성 경구독성-단위'")
  private String ba08Unit;
  //(name = "ba09_tg", columnDefinition = "varchar(100) comment '급성 경구독성-시험지침'")
  private String ba09Tg;
  //(name = "ba10_glp", columnDefinition = "varchar(100) comment '급성 경구독성-GLP'")
  private String ba10Glp;
  //(name = "ba11_ref", columnDefinition = "varchar(255) comment '급성 경구독성-출처'")
  private String ba11Ref;
  //(name = "ba12_other", columnDefinition = "varchar(100) comment '급성 경구독성-비고'")
  private String ba12Other;

  //(name = "division_b02", columnDefinition = "varchar(100) comment '급성 경피독성-구분'")
  private String divisionB02;  // 구분값
  //(name = "bb01_species", columnDefinition = "varchar(100) comment '급성 경피독성-실험종'")
  private String bb01Species;
  //(name = "bb02_endpoint", columnDefinition = "varchar(100) comment '급성 경피독성-종말점'")
  private String bb02Endpoint;
  //(name = "bb03_value1", columnDefinition = "varchar(100) comment '급성 경피독성-유일값'")
  private String bb03Value1;
  //(name = "bb04_value2", columnDefinition = "varchar(100) comment '급성 경피독성-최소값1'")
  private String bb04Value2;
  //(name = "bb05_value3", columnDefinition = "varchar(100) comment '급성 경피독성-최소값2'")
  private String bb05Value3;
  //(name = "bb06_value4", columnDefinition = "varchar(100) comment '급성 경피독성-최대값1'")
  private String bb06Value4;
  //(name = "bb07_value5", columnDefinition = "varchar(100) comment '급성 경피독성-최대값2'")
  private String bb07Value5;
  //(name = "bb08_unit", columnDefinition = "varchar(100) comment '급성 경피독성-단위'")
  private String bb08Unit;
  //(name = "bb09_tg", columnDefinition = "varchar(100) comment '급성 경피독성-시험지침'")
  private String bb09Tg;
  //(name = "bb10_glp", columnDefinition = "varchar(100) comment '급성 경피독성-GLP'")
  private String bb10Glp;
  //(name = "bb11_ref", columnDefinition = "varchar(255) comment '급성 경피독성-출처'")
  private String bb11Ref;
  //(name = "bb12_other", columnDefinition = "varchar(100) comment '급성 경피독성-비고'")
  private String bb12Other;

  //(name = "division_b03", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-가스구분'")
  private String divisionB03;  // 구분값

  //(name = "division_b04", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-증기구분'")
  private String divisionB04;  // 구분값
  //(name = "division_b05", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-분진미스트구분'")
  private String divisionB05;  // 구분값

  //(name = "bc01_species", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-실험종'")
  private String bc01Species;
  //(name = "bc02_endpoint", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-종말점'")
  private String bc02Endpoint;
  //(name = "bc03_value1", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-유일값'")
  private String bc03Value1;
  //(name = "bc04_value2", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-최소값1'")
  private String bc04Value2;
  //(name = "bc05_value3", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-최소값2'")
  private String bc05Value3;
  //(name = "bc06_value4", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-최대값1'")
  private String bc06Value4;
  //(name = "bc07_value5", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-최대값2'")
  private String bc07Value5;
  //(name = "bc08_unit", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-단위'")
  private String bc08Unit;
  //(name = "bc09_time", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-시간'")
  private String bc09Time;
  //(name = "bc10_property", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-성상'")
  private String bc10Property;
  //(name = "bc11_tg", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-시험지침'")
  private String bc11Tg;
  //(name = "bc12_glp", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-GLP'")
  private String bc12Glp;
  //(name = "bc13_ref", columnDefinition = "varchar(255) comment '급성 흡입독성 가스/증기/분진미스트-출처'")
  private String bc13Ref;
  //(name = "bc14_other", columnDefinition = "varchar(100) comment '급성 흡입독성 가스/증기/분진미스트-비고'")
  private String bc14Other;

  //(name = "division_b06", columnDefinition = "varchar(100) comment '피부 부식성/피부 자극성-구분'")
  private String divisionB06;  // 구분값
  //(name = "bd01_data", columnDefinition = "LONGTEXT comment '피부 부식성/피부 자극성-값'")
  private String bd01Data;
  //(name = "bd02_tg", columnDefinition = "varchar(100) comment '피부 부식성/피부 자극성-시험지침'")
  private String bd02Tg;
  //(name = "bd03_glp", columnDefinition = "varchar(100) comment '피부 부식성/피부 자극성-GLP'")
  private String bd03Glp;
  //(name = "bd04_ref", columnDefinition = "varchar(255) comment '피부 부식성/피부 자극성-출처'")
  private String bd04Ref;
  //(name = "bd05_other", columnDefinition = "varchar(100) comment '피부 부식성/피부 자극성-비고'")
  private String bd05Other;

  //(name = "division_b07", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-구분'")
  private String divisionB07;  // 구분값
  //(name = "be01_data", columnDefinition = "LONGTEXT comment '심한 눈 손상성/눈 자극성-값'")
  private String be01Data;
  //(name = "be02_tg", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-시험지침'")
  private String be02Tg;
  //(name = "be03_glp", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-GLP'")
  private String be03Glp;
  //(name = "be04_ref", columnDefinition = "varchar(255) comment '심한 눈 손상성/눈 자극성-출처'")
  private String be04Ref;
  //(name = "be05_data1", columnDefinition = "LONGTEXT comment '심한 눈 손상성/눈 자극성-각막불투명도'")
  private String be05Data1;
  //(name = "be06_other1", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-비고1'")
  private String be06Other1;
  //(name = "be07_data2", columnDefinition = "LONGTEXT comment '심한 눈 손상성/눈 자극성-홍채염'")
  private String be07Data2;
  //(name = "be08_other2", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-비고2'")
  private String be08Other2;
  //(name = "be09_data3", columnDefinition = "LONGTEXT comment '심한 눈 손상성/눈 자극성-결막충혈상태'")
  private String be09Data3;
  //(name = "be10_Other3", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-비고3'")
  private String be10Other3;
  //(name = "be11_data4", columnDefinition = "LONGTEXT comment '심한 눈 손상성/눈 자극성-결막부종상태'")
  private String be11Data4;
  //(name = "be12_other4", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-비고4'")
  private String be5Other4;
  //(name = "be13_other", columnDefinition = "varchar(100) comment '심한 눈 손상성/눈 자극성-비고'")
  private String be13Other; // 추가

  //(name = "division_b08", columnDefinition = "varchar(100) comment '호흡기과민성-구분'")
  private String divisionB08;  // 구분값
  //(name = "bf01_data", columnDefinition = "LONGTEXT comment '호흡기과민성-값'")
  private String bf01Data;
  //(name = "bf02_tg", columnDefinition = "varchar(100) comment '호흡기과민성-시험지침'")
  private String bf02Tg;
  //(name = "bf03_glp", columnDefinition = "varchar(100) comment '호흡기과민성-GLP'")
  private String bf03Glp;
  //(name = "bf04_ref", columnDefinition = "varchar(255) comment '호흡기과민성-출처'")
  private String bf04Ref;
  //(name = "bf05_other", columnDefinition = "varchar(100) comment '호흡기과민성-비고'")
  private String bf05Other;

  //(name = "division_b09", columnDefinition = "varchar(100) comment '피부 과민성-구분'")
  private String divisionB09;  // 구분값
  //(name = "bg01_data", columnDefinition = "LONGTEXT comment '피부 과민성-값'")
  private String bg01Data;
  //(name = "bg02_tg", columnDefinition = "varchar(100) comment '피부 과민성-시험지침'")
  private String bg02Tg;
  //(name = "bg03_glp", columnDefinition = "varchar(100) comment '피부 과민성-GLP'")
  private String bg03Glp;
  //(name = "bg04_ref", columnDefinition = "varchar(255) comment '피부 과민성-출처'")
  private String bg04Ref;
  //(name = "bg05_other", columnDefinition = "varchar(100) comment '피부 과민성-비고'")
  private String bg05Other;

  //(name = "division_b10", columnDefinition = "varchar(100) comment '생식세포 변이원성-구분'")
  private String divisionB10;  // 구분값
  //(name = "bh01_method1", columnDefinition = "varchar(100) comment '생식세포 변이원성-시험방법1'")
  private String bh01Method1;
  //(name = "bh02_data1", columnDefinition = "LONGTEXT comment '생식세포 변이원성-값1'")
  private String bh02Data1;
  //(name = "bh03_tg1", columnDefinition = "varchar(100) comment '생식세포 변이원성-시험지침1'")
  private String bh03Tg1;
  //(name = "bh04_glp1", columnDefinition = "varchar(100) comment '생식세포 변이원성-GLP1'")
  private String bh04Glp1;
  //(name = "bh05_ref1", columnDefinition = "varchar(255) comment '생식세포 변이원성-출처1'")
  private String bh05Ref1;
  //(name = "bh06_other1", columnDefinition = "varchar(100) comment '생식세포 변이원성-비고1'")
  private String bh06Other1;
  //(name = "bh07_data2", columnDefinition = "LONGTEXT comment '생식세포 변이원성-시험방법2'")
  private String bh07Data2;
  //(name = "bh08_method2", columnDefinition = "varchar(100) comment '생식세포 변이원성-값2'")
  private String bh08Method2;
  //(name = "bh09_tg2", columnDefinition = "varchar(100) comment '생식세포 변이원성-시험지침2'")
  private String bh09Tg2;
  //(name = "bh10_glp2", columnDefinition = "varchar(100) comment '생식세포 변이원성-GLP2'")
  private String bh10Glp2;
  //(name = "bh11_ref2", columnDefinition = "varchar(255) comment '생식세포 변이원성-출처2'")
  private String bh11Ref2;
  //(name = "bh12_other2", columnDefinition = "varchar(100) comment '생식세포 변이원성-비고2'")
  private String bh12Other2;
  //(name = "bh13_other", columnDefinition = "varchar(100) comment '생식세포 변이원성-비고'")
  private String bh13Other; //추가

  //(name = "division_b11", columnDefinition = "varchar(100) comment '발암성-구분'")
  private String divisionB11;  // 구분값
  //(name = "bi01_mol", columnDefinition = "varchar(100) comment '발암성-노동부'")
  private String bi01Mol;
  //(name = "bi02_iarc", columnDefinition = "varchar(100) comment '발암성-IARC'")
  private String bi02Iarc;
  //(name = "bi03_acgih", columnDefinition = "varchar(100) comment '발암성-ACGIH'")
  private String bi03Acgih;
  //(name = "bi04_ntp", columnDefinition = "varchar(100) comment '발암성-NTP'")
  private String bi04Ntp;
  //(name = "bi05_osha", columnDefinition = "varchar(100) comment '발암성-OSHA'")
  private String bi05Osha;
  //(name = "bi06_euclp", columnDefinition = "varchar(100) comment '발암성-EU CLP'")
  private String bi06Euclp;
  //(name = "bi07_other", columnDefinition = "varchar(100) comment '발암성-비고'")
  private String bi07other;

  //(name = "division_b12", columnDefinition = "varchar(100) comment '생식독성-구분1'")
  private String divisionB12;  // 구분값
  //(name = "bj01_data1", columnDefinition = "LONGTEXT comment '생식독성-값1'")
  private String bj01Data1;
  //(name = "bj02_tg1", columnDefinition = "varchar(100) comment '생식독성-시험지침1'")
  private String bj02Tg1;
  //(name = "bj03_glp1", columnDefinition = "varchar(100) comment '생식독성-GLP1'")
  private String bj03Glp1;
  //(name = "bj04_ref1", columnDefinition = "varchar(255) comment '생식독성-출처1'")
  private String bj04Ref1;
  //(name = "bj05_other1", columnDefinition = "LONGTEXT comment '생식독성-비고1'")
  private String bj05Other1;
  //(name = "division_b13", columnDefinition = "varchar(100) comment '생식독성-구분2'")
  private String divisionB13;  // 구분값
  //(name = "bj06_data2", columnDefinition = "LONGTEXT comment '생식독성-값2'")
  private String bj06Data2;
  //(name = "bj07_tg2", columnDefinition = "varchar(100) comment '생식독성-시험지침2'")
  private String bj07Tg2;
  //(name = "bj08_glp2", columnDefinition = "varchar(100) comment '생식독성-GLP2'")
  private String bj08Glp2;
  //(name = "bj09_ref2", columnDefinition = "varchar(255) comment '생식독성-출처2'")
  private String bj09Ref2;
  //(name = "bj10_other2", columnDefinition = "varchar(100) comment '생식독성-비고2'")
  private String bj10Other2;

  //(name = "division_b14", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-구분1'")
  private String divisionB14;  // 구분값1
  //(name = "division_b15", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-구분2'")
  private String divisionB15;  // 구분값2
  //(name = "division_b16", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-구분3'")
  private String divisionB16;  // 구분값3
  //(name = "bk01_data1", columnDefinition = "LONGTEXT comment '특정표적장기 독성 1회-값1'")
  private String bk01Data1;
  //(name = "bk02_tg1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-시험지침1'")
  private String bk02Tg1;
  //(name = "bk03_glp1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-GLP1'")
  private String bk03Glp1;
  //(name = "bk04_ref1", columnDefinition = "varchar(255) comment '특정표적장기 독성 1회-출처1'")
  private String bk04Ref1;
  //(name = "bk05_other1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-비고1'")
  private String bk05Other1;
  //(name = "bk06_data2", columnDefinition = "LONGTEXT comment '특정표적장기 독성 1회-시험종값2'")
  private String bk06Data2;
  //(name = "bk07_noael2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-NOAEL2'")
  private String bk07Noael2;
  //(name = "bk08_unit2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-단위2'")
  private String bk08Unit2;
  //(name = "bk09_time2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-시간2'")
  private String bk09Time2;
  //(name = "bk10_tg2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-시험지침2'")
  private String bk10Tg2;
  //(name = "bk11_glp2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-GLP2'")
  private String bk11Glp2;
  //(name = "bk12_ref2", columnDefinition = "varchar(255) comment '특정표적장기 독성 1회-출처2'")
  private String bk12Ref2;
  //(name = "bk13_other2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-비고2'")
  private String bk13Other2;

  //(name = "division_b17", columnDefinition = "varchar(100) comment '특정표적장기 독성 반복-구분1'")
  private String divisionB17;  // 구분값1
  //(name = "bl01_data1", columnDefinition = "LONGTEXT comment '특정표적장기 독성 1회-값1'")
  private String bl01Data1;
  //(name = "bl02_tg1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-시험지침1'")
  private String bl02Tg1;
  //(name = "bl03_glp1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-GLP1'")
  private String bl03Glp1;
  //(name = "bl04_ref1", columnDefinition = "varchar(255) comment '특정표적장기 독성 1회-출처1'")
  private String bl04Ref1;
  //(name = "bl05_other1", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-비고1'")
  private String bl05Other1;
  //(name = "bl06_data2", columnDefinition = "LONGTEXT comment '특정표적장기 독성 1회-시험종값2'")
  private String bl06Data2;
  //(name = "bl07_noael2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-NOAEL2'")
  private String bl07Noael2;
  //(name = "bl08_unit2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-단위2'")
  private String bl08Unit2;
  //(name = "bl09_time2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-시간2'")
  private String bl09Time2;
  //(name = "bl10_tg2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-시험지침2'")
  private String bl10Tg2;
  //(name = "bl11_glp2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-GLP2'")
  private String bl11Glp2;
  //(name = "bl12_ref2", columnDefinition = "varchar(255) comment '특정표적장기 독성 1회-출처2'")
  private String bl12Ref2;
  //(name = "bl13_other2", columnDefinition = "varchar(100) comment '특정표적장기 독성 1회-비고2'")
  private String bl13Other2;

  //(name = "division_b18", columnDefinition = "varchar(100) comment '흡인유해성-구분'")
  private String divisionB18;  // 구분값
  //(name = "bm01_data", columnDefinition = "LONGTEXT comment '흡인유해성-값'")
  private String bm01Data;
  //(name = "bm02_tg", columnDefinition = "varchar(100) comment '흡인유해성-시험지침'")
  private String bm02Tg;
  //(name = "bm03_glp", columnDefinition = "varchar(100) comment '흡인유해성-GLP'")
  private String bm03Glp;
  //(name = "bm04_ref", columnDefinition = "varchar(255) comment '흡인유해성-출처'")
  private String bm04Ref;
  //(name = "bm05_other", columnDefinition = "varchar(100) comment '흡인유해성-비고'")
  private String bm05Other;

  public static MatterHealthDTO of(MatterHealth matterHealth) {
    return ModelMapperUtils.getModelMapper().map(matterHealth, MatterHealthDTO.class);
  }
  
}
