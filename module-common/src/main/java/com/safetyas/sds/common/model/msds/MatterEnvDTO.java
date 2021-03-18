package com.safetyas.sds.common.model.msds;

import com.safetyas.sds.common.entity.msds.MatterData;
import com.safetyas.sds.common.entity.msds.MatterEnv;
import com.safetyas.sds.common.modelMapper.ModelMapperUtils;
import javax.persistence.OneToOne;
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
public class MatterEnvDTO {

  private Long envSeq;

  //------------------------------------------------------------- C그룹 12 환경유해성
  //(name = "division_C01", columnDefinition = "varchar(100) comment '급성-구분'")
  private String divisionC01;
  //(name = "division_C02", columnDefinition = "varchar(100) comment '만성-구분'")
  private String divisionC02;

  //(name = "ca01_time", columnDefinition = "varchar(100) comment '급성어류-시간'")
  private String ca01Time;
  //(name = "ca02_endpoint", columnDefinition = "varchar(100) comment '급성어류-종말점'")
  private String ca02Endpoint;
  //(name = "ca03_species", columnDefinition = "varchar(100) comment '급성어류-실험종'")
  private String ca03Species;
  //(name = "ca04_value1", columnDefinition = "varchar(100) comment '급성어류-유일값'")
  private String ca04Value1;
  //(name = "ca05_value2", columnDefinition = "varchar(100) comment '급성어류-최소값1'")
  private String ca05Value2;
  //(name = "ca06_value3", columnDefinition = "varchar(100) comment '급성어류-최소값2'")
  private String ca06Value3;
  //(name = "ca07_value4", columnDefinition = "varchar(100) comment '급성어류-최대값1'")
  private String ca07Value4;
  //(name = "ca08_value5", columnDefinition = "varchar(100) comment '급성어류-최대값2'")
  private String ca08Value5;
  //(name = "ca09_unit", columnDefinition = "varchar(100) comment '급성어류-단위'")
  private String ca09Unit;
  //(name = "ca10_tg", columnDefinition = "varchar(100) comment '급성어류-시험지침'")
  private String ca10Tg;
  //(name = "ca11_glp", columnDefinition = "varchar(100) comment '급성어류-GLP'")
  private String ca11Glp;
  //(name = "ca12_ref", columnDefinition = "varchar(255) comment '급성어류-출처'")
  private String ca12Ref;
  //(name = "ca13_other", columnDefinition = "varchar(100) comment '급성어류-비고'")
  private String ca13Other;

  //(name = "cb01_time", columnDefinition = "varchar(100) comment '급성갑각류-시간'")
  private String cb01Time;
  //(name = "cb02_endpoint", columnDefinition = "varchar(100) comment '급성갑각류-종말점'")
  private String cb02Endpoint;
  //(name = "cb03_species", columnDefinition = "varchar(100) comment '급성갑각류-실험종'")
  private String cb03Species;
  //(name = "cb04_value1", columnDefinition = "varchar(100) comment '급성갑각류-유일값'")
  private String cb04Value1;
  //(name = "cb05_value2", columnDefinition = "varchar(100) comment '급성갑각류-최소값1'")
  private String cb05Value2;
  //(name = "cb06_value3", columnDefinition = "varchar(100) comment '급성갑각류-최소값2'")
  private String cb06Value3;
  //(name = "cb07_value4", columnDefinition = "varchar(100) comment '급성갑각류-최대값1'")
  private String cb07Value4;
  //(name = "cb08_value5", columnDefinition = "varchar(100) comment '급성갑각류-최대값2'")
  private String cb08Value5;
  //(name = "cb09_unit", columnDefinition = "varchar(100) comment '급성갑각류-단위'")
  private String cb09Unit;
  //(name = "cb10_tg", columnDefinition = "varchar(100) comment '급성갑각류-시험지침'")
  private String cb10Tg;
  //(name = "cb11_glp", columnDefinition = "varchar(100) comment '급성갑각류-GLP'")
  private String cb11Glp;
  //(name = "cb12_ref", columnDefinition = "varchar(255) comment '급성갑각류-출처'")
  private String cb12Ref;
  //(name = "cb13_other", columnDefinition = "varchar(100) comment '급성갑각류-비고'")
  private String cb13Other;

  //(name = "cc01_time", columnDefinition = "varchar(100) comment '급성조류-시간'")
  private String cc01Time;
  //(name = "cc02_endpoint", columnDefinition = "varchar(100) comment '급성조류-종말점'")
  private String cc02Endpoint;
  //(name = "cc03_species", columnDefinition = "varchar(100) comment '급성조류-실험종'")
  private String cc03Species;
  //(name = "cc04_value1", columnDefinition = "varchar(100) comment '급성조류-유일값'")
  private String cc04Value1;
  //(name = "cc05_value2", columnDefinition = "varchar(100) comment '급성조류-최소값1'")
  private String cc05Value2;
  //(name = "cc06_value3", columnDefinition = "varchar(100) comment '급성조류-최소값2'")
  private String cc06Value3;
  //(name = "cc07_value4", columnDefinition = "varchar(100) comment '급성조류-최대값1'")
  private String cc07Value4;
  //(name = "cc08_value5", columnDefinition = "varchar(100) comment '급성조류-최대값2'")
  private String cc08Value5;
  //(name = "cc09_unit", columnDefinition = "varchar(100) comment '급성조류-단위'")
  private String cc09Unit;
  //(name = "cc10_tg", columnDefinition = "varchar(100) comment '급성조류-시험지침'")
  private String cc10Tg;
  //(name = "cc11_glp", columnDefinition = "varchar(100) comment '급성조류-GLP'")
  private String cc11Glp;
  //(name = "cc12_ref", columnDefinition = "varchar(255) comment '급성조류-출처'")
  private String cc12Ref;
  //(name = "cc13_other", columnDefinition = "varchar(100) comment '급성조류-비고'")
  private String cc13Other;

  //(name = "cd01_time", columnDefinition = "varchar(100) comment '급성기타-시간'")
  private String cd01Time;
  //(name = "cd02_endpoint", columnDefinition = "varchar(100) comment '급성기타-종말점'")
  private String cd02Endpoint;
  //(name = "cd03_species", columnDefinition = "varchar(100) comment '급성기타-실험종'")
  private String cd03Species;
  //(name = "cd04_value1", columnDefinition = "varchar(100) comment '급성기타-유일값'")
  private String cd04Value1;
  //(name = "cd05_value2", columnDefinition = "varchar(100) comment '급성기타-최소값1'")
  private String cd05Value2;
  //(name = "cd06_value3", columnDefinition = "varchar(100) comment '급성기타-최소값2'")
  private String cd06Value3;
  //(name = "cd07_value4", columnDefinition = "varchar(100) comment '급성기타-최대값1'")
  private String cd07Value4;
  //(name = "cd08_value5", columnDefinition = "varchar(100) comment '급성기타-최대값2'")
  private String cd08Value5;
  //(name = "cd09_unit", columnDefinition = "varchar(100) comment '급성기타-단위'")
  private String cd09Unit;
  //(name = "cd10_tg", columnDefinition = "varchar(100) comment '급성기타-시험지침'")
  private String cd10Tg;
  //(name = "cd11_glp", columnDefinition = "varchar(100) comment '급성기타-GLP'")
  private String cd11Glp;
  //(name = "cd12_ref", columnDefinition = "varchar(255) comment '급성기타-출처'")
  private String cd12Ref;
  //(name = "cd13_other", columnDefinition = "varchar(100) comment '급성기타-비고'")
  private String cd13Other;

  //(name = "ce01_time", columnDefinition = "varchar(100) comment '만성어류-시간'")
  private String ce01Time;
  //(name = "ce02_endpoint", columnDefinition = "varchar(100) comment '만성어류-종말점'")
  private String ce02Endpoint;
  //(name = "ce03_species", columnDefinition = "varchar(100) comment '만성어류-실험종'")
  private String ce03Species;
  //(name = "ce04_value1", columnDefinition = "varchar(100) comment '만성어류-유일값'")
  private String ce04Value1;
  //(name = "ce05_value2", columnDefinition = "varchar(100) comment '만성어류-최소값1'")
  private String ce05Value2;
  //(name = "ce06_value3", columnDefinition = "varchar(100) comment '만성어류-최소값2'")
  private String ce06Value3;
  //(name = "ce07_value4", columnDefinition = "varchar(100) comment '만성어류-최대값1'")
  private String ce07Value4;
  //(name = "ce08_value5", columnDefinition = "varchar(100) comment '만성어류-최대값2'")
  private String ce08Value5;
  //(name = "ce09_unit", columnDefinition = "varchar(100) comment '만성어류-단위'")
  private String ce09Unit;
  //(name = "ce10_tg", columnDefinition = "varchar(100) comment '만성어류-시험지침'")
  private String ce10Tg;
  //(name = "ce11_glp", columnDefinition = "varchar(100) comment '만성어류-GLP'")
  private String ce11Glp;
  //(name = "ce12_ref", columnDefinition = "varchar(255) comment '만성어류-출처'")
  private String ce12Ref;
  //(name = "ce13_other", columnDefinition = "varchar(100) comment '만성어류-비고'")
  private String ce13Other;

  // 만성 갑각류
  //(name = "cf01_time", columnDefinition = "varchar(100) comment '만성갑각류-시간'")
  private String cf01Time;
  //(name = "cf02_endpoint", columnDefinition = "varchar(100) comment '만성갑각류-종말점'")
  private String cf02Endpoint;
  //(name = "cf03_species", columnDefinition = "varchar(100) comment '만성갑각류-실험종'")
  private String cf03Species;
  //(name = "cf04_value1", columnDefinition = "varchar(100) comment '만성갑각류-유일값'")
  private String cf04Value1;
  //(name = "cf05_value2", columnDefinition = "varchar(100) comment '만성갑각류-최소값1'")
  private String cf05Value2;
  //(name = "cf06_value3", columnDefinition = "varchar(100) comment '만성갑각류-최소값2'")
  private String cf06Value3;
  //(name = "cf07_value4", columnDefinition = "varchar(100) comment '만성갑각류-최대값1'")
  private String cf07Value4;
  //(name = "cf08_value5", columnDefinition = "varchar(100) comment '만성갑각류-최대값2'")
  private String cf08Value5;
  //(name = "cf09_unit", columnDefinition = "varchar(100) comment '만성갑각류-단위'")
  private String cf09Unit;
  //(name = "cf10_tg", columnDefinition = "varchar(100) comment '만성갑각류-시험지침'")
  private String cf10Tg;
  //(name = "cf11_glp", columnDefinition = "varchar(100) comment '만성갑각류-GLP'")
  private String cf11Glp;
  //(name = "cf12_ref", columnDefinition = "varchar(255) comment '만성갑각류-출처'")
  private String cf12Ref;
  //(name = "cf13_other", columnDefinition = "varchar(100) comment '만성갑각류-비고'")
  private String cf13Other;



  //(name = "cg01_time", columnDefinition = "varchar(100) comment '만성조류-시간'")
  private String cg01Time;
  //(name = "cg02_endpoint", columnDefinition = "varchar(100) comment '만성조류-종말점'")
  private String cg02Endpoint;
  //(name = "cg03_species", columnDefinition = "varchar(100) comment '만성조류-실험종'")
  private String cg03Species;
  //(name = "cg04_value1", columnDefinition = "varchar(100) comment '만성조류-유일값'")
  private String cg04Value1;
  //(name = "cg05_value2", columnDefinition = "varchar(100) comment '만성조류-최소값1'")
  private String cg05Value2;
  //(name = "cg06_value3", columnDefinition = "varchar(100) comment '만성조류-최소값2'")
  private String cg06Value3;
  //(name = "cg07_value4", columnDefinition = "varchar(100) comment '만성조류-최대값1'")
  private String cg07Value4;
  //(name = "cg08_value5", columnDefinition = "varchar(100) comment '만성조류-최대값2'")
  private String cg08Value5;
  //(name = "cg09_unit", columnDefinition = "varchar(100) comment '만성조류-단위'")
  private String cg09Unit;
  //(name = "cg10_tg", columnDefinition = "varchar(100) comment '만성조류-시험지침'")
  private String cg10Tg;
  //(name = "cg11_glp", columnDefinition = "varchar(100) comment '만성조류-GLP'")
  private String cg11Glp;
  //(name = "cg12_ref", columnDefinition = "varchar(255) comment '만성조류-출처'")
  private String cg12Ref;
  //(name = "cg13_other", columnDefinition = "varchar(100) comment '만성조류-비고'")
  private String cg13Other;

  //(name = "ch01_time", columnDefinition = "varchar(100) comment '만성기타-시간'")
  private String ch01Time;
  //(name = "ch02_endpoint", columnDefinition = "varchar(100) comment '만성기타-종말점'")
  private String ch02Endpoint;
  //(name = "ch03_species", columnDefinition = "varchar(100) comment '만성기타-실험종'")
  private String ch03Species;
  //(name = "ch04_value1", columnDefinition = "varchar(100) comment '만성기타-유일값'")
  private String ch04Value1;
  //(name = "ch05_value2", columnDefinition = "varchar(100) comment '만성기타-최소값1'")
  private String ch05Value2;
  //(name = "ch06_value3", columnDefinition = "varchar(100) comment '만성기타-최소값2'")
  private String ch06Value3;
  //(name = "ch07_value4", columnDefinition = "varchar(100) comment '만성기타-최대값1'")
  private String ch07Value4;
  //(name = "ch08_value5", columnDefinition = "varchar(100) comment '만성기타-최대값2'")
  private String ch08Value5;
  //(name = "ch09_unit", columnDefinition = "varchar(100) comment '만성기타-단위'")
  private String ch09Unit;
  //(name = "ch10_tg", columnDefinition = "varchar(100) comment '만성기타-시험지침'")
  private String ch10Tg;
  //(name = "ch11_glp", columnDefinition = "varchar(100) comment '만성기타-GLP'")
  private String ch11Glp;
  //(name = "ch12_ref", columnDefinition = "varchar(255) comment '만성기타-출처'")
  private String ch12Ref;
  //(name = "ch13_other", columnDefinition = "varchar(100) comment '만성기타-비고'")
  private String ch13Other;

  //(name = "ch01_persistence", columnDefinition = "varchar(100) comment '잔류성'")
  private String ci01Persistence;

  //(name = "cj01_data", columnDefinition = "varchar(100) comment '생분해성-값'")
  private String cj01Data;
  //(name = "cj02_time", columnDefinition = "varchar(100) comment '생분해성-시간'")
  private String cj02Time;
  //(name = "cj03_degrade", columnDefinition = "varchar(100) comment '생분해성-분해도'")
  private String cj03Degrade;
  //(name = "cj04_ref", columnDefinition = "varchar(255) comment '생분해성-출처'")
  private String cj04Ref;
  //(name = "cj05_other", columnDefinition = "varchar(100) comment '생분해성-비고'")
  private String cj05Other;

  //(name = "ck01_value1", columnDefinition = "varchar(100) comment '농축성-유일값'")
  private String ck01Value1;
  //(name = "ck02_value2", columnDefinition = "varchar(100) comment '농축성-최소값1'")
  private String ck02Value2;
  //(name = "ck03_value3", columnDefinition = "varchar(100) comment '농축성-최소값2'")
  private String ck03Value3;
  //(name = "ck04_value4", columnDefinition = "varchar(100) comment '농축성-최대값1'")
  private String ck04Value4;
  //(name = "ck05_value5", columnDefinition = "varchar(100) comment '농축성-최대값2'")
  private String ck05Value5;
  //(name = "ck06_ref", columnDefinition = "varchar(255) comment '농축성-출처'")
  private String ck06Ref;
  //(name = "ck06_other", columnDefinition = "varchar(255) comment '농축성-비고'")
  private String ck06Other;

  //(name = "cl01_value1", columnDefinition = "varchar(100) comment '토양이동성-유일값'")
  private String cl01Value1;
  //(name = "cl02_value2", columnDefinition = "varchar(100) comment '토양이동성-최소값1'")
  private String cl02Value2;
  //(name = "cl03_value3", columnDefinition = "varchar(100) comment '토양이동성-최소값2'")
  private String cl03Value3;
  //(name = "cl04_value4", columnDefinition = "varchar(100) comment '토양이동성-최대값1'")
  private String cl04Value4;
  //(name = "cl05_value5", columnDefinition = "varchar(100) comment '토양이동성-최대값2'")
  private String cl05Value5;
  //(name = "cl06_ref", columnDefinition = "varchar(255) comment '토양이동성-출처'")
  private String cl06Ref;
  //(name = "cl06_other", columnDefinition = "varchar(100) comment '토양이동성-비고'")
  private String cl06Other;

  //(name = "division_C03", columnDefinition = "varchar(100) comment '기타유해영향-구분'")
  private String divisionC03;
  //(name = "cm01_data", columnDefinition = "varchar(100) comment '기타유해영향-오존층유해성값'")
  private String cm01Data;
  //(name = "cm02_ref", columnDefinition = "varchar(100) comment '기타유해영향-출처'")
  private String cm02Ref;
  //(name = "cm03_other", columnDefinition = "varchar(100) comment '기타유해영향-비고'")
  private String cm03Other;

  public static MatterEnvDTO of(MatterEnv matterEnv) {
    return ModelMapperUtils.getModelMapper().map(matterEnv, MatterEnvDTO.class);
  }

}
