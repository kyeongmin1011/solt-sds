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
@Table(name = "sds_matter_env")
public class MatterEnv implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "matter_env_seq", length = 20)
  private Long matterEnvSeq;

  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "matter_data_key", foreignKey = @ForeignKey(name = "matter_data_key_matter_env_fk"))
  private MatterData matterData;

  //------------------------------------------------------------- C그룹 12 환경유해성
  @Column(name = "division_C01", columnDefinition = "varchar(100) comment '급성-구분'")
  private String divisionC01;
  @Column(name = "division_C02", columnDefinition = "varchar(100) comment '만성-구분'")
  private String divisionC02;

  @Column(name = "ca01_time", columnDefinition = "varchar(100) comment '급성어류-시간'")
  private String ca01Time;
  @Column(name = "ca02_endpoint", columnDefinition = "varchar(100) comment '급성어류-종말점'")
  private String ca02Endpoint;
  @Column(name = "ca03_species", columnDefinition = "varchar(100) comment '급성어류-실험종'")
  private String ca03Species;
  @Column(name = "ca04_value1", columnDefinition = "varchar(100) comment '급성어류-유일값'")
  private String ca04Value1;
  @Column(name = "ca05_value2", columnDefinition = "varchar(100) comment '급성어류-최소값1'")
  private String ca05Value2;
  @Column(name = "ca06_value3", columnDefinition = "varchar(100) comment '급성어류-최소값2'")
  private String ca06Value3;
  @Column(name = "ca07_value4", columnDefinition = "varchar(100) comment '급성어류-최대값1'")
  private String ca07Value4;
  @Column(name = "ca08_value5", columnDefinition = "varchar(100) comment '급성어류-최대값2'")
  private String ca08Value5;
  @Column(name = "ca09_unit", columnDefinition = "varchar(100) comment '급성어류-단위'")
  private String ca09Unit;
  @Column(name = "ca10_tg", columnDefinition = "varchar(100) comment '급성어류-시험지침'")
  private String ca10Tg;
  @Column(name = "ca11_glp", columnDefinition = "varchar(100) comment '급성어류-GLP'")
  private String ca11Glp;
  @Column(name = "ca12_ref", columnDefinition = "varchar(255) comment '급성어류-출처'")
  private String ca12Ref;
  @Column(name = "ca13_other", columnDefinition = "varchar(100) comment '급성어류-비고'")
  private String ca13Other;

  @Column(name = "cb01_time", columnDefinition = "varchar(100) comment '급성갑각류-시간'")
  private String cb01Time;
  @Column(name = "cb02_endpoint", columnDefinition = "varchar(100) comment '급성갑각류-종말점'")
  private String cb02Endpoint;
  @Column(name = "cb03_species", columnDefinition = "varchar(100) comment '급성갑각류-실험종'")
  private String cb03Species;
  @Column(name = "cb04_value1", columnDefinition = "varchar(100) comment '급성갑각류-유일값'")
  private String cb04Value1;
  @Column(name = "cb05_value2", columnDefinition = "varchar(100) comment '급성갑각류-최소값1'")
  private String cb05Value2;
  @Column(name = "cb06_value3", columnDefinition = "varchar(100) comment '급성갑각류-최소값2'")
  private String cb06Value3;
  @Column(name = "cb07_value4", columnDefinition = "varchar(100) comment '급성갑각류-최대값1'")
  private String cb07Value4;
  @Column(name = "cb08_value5", columnDefinition = "varchar(100) comment '급성갑각류-최대값2'")
  private String cb08Value5;
  @Column(name = "cb09_unit", columnDefinition = "varchar(100) comment '급성갑각류-단위'")
  private String cb09Unit;
  @Column(name = "cb10_tg", columnDefinition = "varchar(100) comment '급성갑각류-시험지침'")
  private String cb10Tg;
  @Column(name = "cb11_glp", columnDefinition = "varchar(100) comment '급성갑각류-GLP'")
  private String cb11Glp;
  @Column(name = "cb12_ref", columnDefinition = "varchar(255) comment '급성갑각류-출처'")
  private String cb12Ref;
  @Column(name = "cb13_other", columnDefinition = "varchar(100) comment '급성갑각류-비고'")
  private String cb13Other;

  @Column(name = "cc01_time", columnDefinition = "varchar(100) comment '급성조류-시간'")
  private String cc01Time;
  @Column(name = "cc02_endpoint", columnDefinition = "varchar(100) comment '급성조류-종말점'")
  private String cc02Endpoint;
  @Column(name = "cc03_species", columnDefinition = "varchar(100) comment '급성조류-실험종'")
  private String cc03Species;
  @Column(name = "cc04_value1", columnDefinition = "varchar(100) comment '급성조류-유일값'")
  private String cc04Value1;
  @Column(name = "cc05_value2", columnDefinition = "varchar(100) comment '급성조류-최소값1'")
  private String cc05Value2;
  @Column(name = "cc06_value3", columnDefinition = "varchar(100) comment '급성조류-최소값2'")
  private String cc06Value3;
  @Column(name = "cc07_value4", columnDefinition = "varchar(100) comment '급성조류-최대값1'")
  private String cc07Value4;
  @Column(name = "cc08_value5", columnDefinition = "varchar(100) comment '급성조류-최대값2'")
  private String cc08Value5;
  @Column(name = "cc09_unit", columnDefinition = "varchar(100) comment '급성조류-단위'")
  private String cc09Unit;
  @Column(name = "cc10_tg", columnDefinition = "varchar(100) comment '급성조류-시험지침'")
  private String cc10Tg;
  @Column(name = "cc11_glp", columnDefinition = "varchar(100) comment '급성조류-GLP'")
  private String cc11Glp;
  @Column(name = "cc12_ref", columnDefinition = "varchar(255) comment '급성조류-출처'")
  private String cc12Ref;
  @Column(name = "cc13_other", columnDefinition = "varchar(100) comment '급성조류-비고'")
  private String cc13Other;

  @Column(name = "cd01_time", columnDefinition = "varchar(100) comment '급성기타-시간'")
  private String cd01Time;
  @Column(name = "cd02_endpoint", columnDefinition = "varchar(100) comment '급성기타-종말점'")
  private String cd02Endpoint;
  @Column(name = "cd03_species", columnDefinition = "varchar(100) comment '급성기타-실험종'")
  private String cd03Species;
  @Column(name = "cd04_value1", columnDefinition = "varchar(100) comment '급성기타-유일값'")
  private String cd04Value1;
  @Column(name = "cd05_value2", columnDefinition = "varchar(100) comment '급성기타-최소값1'")
  private String cd05Value2;
  @Column(name = "cd06_value3", columnDefinition = "varchar(100) comment '급성기타-최소값2'")
  private String cd06Value3;
  @Column(name = "cd07_value4", columnDefinition = "varchar(100) comment '급성기타-최대값1'")
  private String cd07Value4;
  @Column(name = "cd08_value5", columnDefinition = "varchar(100) comment '급성기타-최대값2'")
  private String cd08Value5;
  @Column(name = "cd09_unit", columnDefinition = "varchar(100) comment '급성기타-단위'")
  private String cd09Unit;
  @Column(name = "cd10_tg", columnDefinition = "varchar(100) comment '급성기타-시험지침'")
  private String cd10Tg;
  @Column(name = "cd11_glp", columnDefinition = "varchar(100) comment '급성기타-GLP'")
  private String cd11Glp;
  @Column(name = "cd12_ref", columnDefinition = "varchar(255) comment '급성기타-출처'")
  private String cd12Ref;
  @Column(name = "cd13_other", columnDefinition = "varchar(100) comment '급성기타-비고'")
  private String cd13Other;

  @Column(name = "ce01_time", columnDefinition = "varchar(100) comment '만성어류-시간'")
  private String ce01Time;
  @Column(name = "ce02_endpoint", columnDefinition = "varchar(100) comment '만성어류-종말점'")
  private String ce02Endpoint;
  @Column(name = "ce03_species", columnDefinition = "varchar(100) comment '만성어류-실험종'")
  private String ce03Species;
  @Column(name = "ce04_value1", columnDefinition = "varchar(100) comment '만성어류-유일값'")
  private String ce04Value1;
  @Column(name = "ce05_value2", columnDefinition = "varchar(100) comment '만성어류-최소값1'")
  private String ce05Value2;
  @Column(name = "ce06_value3", columnDefinition = "varchar(100) comment '만성어류-최소값2'")
  private String ce06Value3;
  @Column(name = "ce07_value4", columnDefinition = "varchar(100) comment '만성어류-최대값1'")
  private String ce07Value4;
  @Column(name = "ce08_value5", columnDefinition = "varchar(100) comment '만성어류-최대값2'")
  private String ce08Value5;
  @Column(name = "ce09_unit", columnDefinition = "varchar(100) comment '만성어류-단위'")
  private String ce09Unit;
  @Column(name = "ce10_tg", columnDefinition = "varchar(100) comment '만성어류-시험지침'")
  private String ce10Tg;
  @Column(name = "ce11_glp", columnDefinition = "varchar(100) comment '만성어류-GLP'")
  private String ce11Glp;
  @Column(name = "ce12_ref", columnDefinition = "varchar(255) comment '만성어류-출처'")
  private String ce12Ref;
  @Column(name = "ce13_other", columnDefinition = "varchar(100) comment '만성어류-비고'")
  private String ce13Other;

  // 만성 갑각류
  @Column(name = "cf01_time", columnDefinition = "varchar(100) comment '만성갑각류-시간'")
  private String cf01Time;
  @Column(name = "cf02_endpoint", columnDefinition = "varchar(100) comment '만성갑각류-종말점'")
  private String cf02Endpoint;
  @Column(name = "cf03_species", columnDefinition = "varchar(100) comment '만성갑각류-실험종'")
  private String cf03Species;
  @Column(name = "cf04_value1", columnDefinition = "varchar(100) comment '만성갑각류-유일값'")
  private String cf04Value1;
  @Column(name = "cf05_value2", columnDefinition = "varchar(100) comment '만성갑각류-최소값1'")
  private String cf05Value2;
  @Column(name = "cf06_value3", columnDefinition = "varchar(100) comment '만성갑각류-최소값2'")
  private String cf06Value3;
  @Column(name = "cf07_value4", columnDefinition = "varchar(100) comment '만성갑각류-최대값1'")
  private String cf07Value4;
  @Column(name = "cf08_value5", columnDefinition = "varchar(100) comment '만성갑각류-최대값2'")
  private String cf08Value5;
  @Column(name = "cf09_unit", columnDefinition = "varchar(100) comment '만성갑각류-단위'")
  private String cf09Unit;
  @Column(name = "cf10_tg", columnDefinition = "varchar(100) comment '만성갑각류-시험지침'")
  private String cf10Tg;
  @Column(name = "cf11_glp", columnDefinition = "varchar(100) comment '만성갑각류-GLP'")
  private String cf11Glp;
  @Column(name = "cf12_ref", columnDefinition = "varchar(255) comment '만성갑각류-출처'")
  private String cf12Ref;
  @Column(name = "cf13_other", columnDefinition = "varchar(100) comment '만성갑각류-비고'")
  private String cf13Other;


  @Column(name = "cg01_time", columnDefinition = "varchar(100) comment '만성조류-시간'")
  private String cg01Time;
  @Column(name = "cg02_endpoint", columnDefinition = "varchar(100) comment '만성조류-종말점'")
  private String cg02Endpoint;
  @Column(name = "cg03_species", columnDefinition = "varchar(100) comment '만성조류-실험종'")
  private String cg03Species;
  @Column(name = "cg04_value1", columnDefinition = "varchar(100) comment '만성조류-유일값'")
  private String cg04Value1;
  @Column(name = "cg05_value2", columnDefinition = "varchar(100) comment '만성조류-최소값1'")
  private String cg05Value2;
  @Column(name = "cg06_value3", columnDefinition = "varchar(100) comment '만성조류-최소값2'")
  private String cg06Value3;
  @Column(name = "cg07_value4", columnDefinition = "varchar(100) comment '만성조류-최대값1'")
  private String cg07Value4;
  @Column(name = "cg08_value5", columnDefinition = "varchar(100) comment '만성조류-최대값2'")
  private String cg08Value5;
  @Column(name = "cg09_unit", columnDefinition = "varchar(100) comment '만성조류-단위'")
  private String cg09Unit;
  @Column(name = "cg10_tg", columnDefinition = "varchar(100) comment '만성조류-시험지침'")
  private String cg10Tg;
  @Column(name = "cg11_glp", columnDefinition = "varchar(100) comment '만성조류-GLP'")
  private String cg11Glp;
  @Column(name = "cg12_ref", columnDefinition = "varchar(255) comment '만성조류-출처'")
  private String cg12Ref;
  @Column(name = "cg13_other", columnDefinition = "varchar(100) comment '만성조류-비고'")
  private String cg13Other;

  @Column(name = "ch01_time", columnDefinition = "varchar(100) comment '만성기타-시간'")
  private String ch01Time;
  @Column(name = "ch02_endpoint", columnDefinition = "varchar(100) comment '만성기타-종말점'")
  private String ch02Endpoint;
  @Column(name = "ch03_species", columnDefinition = "varchar(100) comment '만성기타-실험종'")
  private String ch03Species;
  @Column(name = "ch04_value1", columnDefinition = "varchar(100) comment '만성기타-유일값'")
  private String ch04Value1;
  @Column(name = "ch05_value2", columnDefinition = "varchar(100) comment '만성기타-최소값1'")
  private String ch05Value2;
  @Column(name = "ch06_value3", columnDefinition = "varchar(100) comment '만성기타-최소값2'")
  private String ch06Value3;
  @Column(name = "ch07_value4", columnDefinition = "varchar(100) comment '만성기타-최대값1'")
  private String ch07Value4;
  @Column(name = "ch08_value5", columnDefinition = "varchar(100) comment '만성기타-최대값2'")
  private String ch08Value5;
  @Column(name = "ch09_unit", columnDefinition = "varchar(100) comment '만성기타-단위'")
  private String ch09Unit;
  @Column(name = "ch10_tg", columnDefinition = "varchar(100) comment '만성기타-시험지침'")
  private String ch10Tg;
  @Column(name = "ch11_glp", columnDefinition = "varchar(100) comment '만성기타-GLP'")
  private String ch11Glp;
  @Column(name = "ch12_ref", columnDefinition = "varchar(255) comment '만성기타-출처'")
  private String ch12Ref;
  @Column(name = "ch13_other", columnDefinition = "varchar(100) comment '만성기타-비고'")
  private String ch13Other;

  @Column(name = "ch01_persistence", columnDefinition = "varchar(100) comment '잔류성'")
  private String ci01Persistence;

  @Column(name = "cj01_data", columnDefinition = "varchar(100) comment '생분해성-값'")
  private String cj01Data;
  @Column(name = "cj02_time", columnDefinition = "varchar(100) comment '생분해성-시간'")
  private String cj02Time;
  @Column(name = "cj03_degrade", columnDefinition = "varchar(100) comment '생분해성-분해도'")
  private String cj03Degrade;
  @Column(name = "cj04_ref", columnDefinition = "varchar(255) comment '생분해성-출처'")
  private String cj04Ref;
  @Column(name = "cj05_other", columnDefinition = "varchar(100) comment '생분해성-비고'")
  private String cj05Other;

  @Column(name = "ck01_value1", columnDefinition = "varchar(100) comment '농축성-유일값'")
  private String ck01Value1;
  @Column(name = "ck02_value2", columnDefinition = "varchar(100) comment '농축성-최소값1'")
  private String ck02Value2;
  @Column(name = "ck03_value3", columnDefinition = "varchar(100) comment '농축성-최소값2'")
  private String ck03Value3;
  @Column(name = "ck04_value4", columnDefinition = "varchar(100) comment '농축성-최대값1'")
  private String ck04Value4;
  @Column(name = "ck05_value5", columnDefinition = "varchar(100) comment '농축성-최대값2'")
  private String ck05Value5;
  @Column(name = "ck06_ref", columnDefinition = "varchar(255) comment '농축성-출처'")
  private String ck06Ref;
  @Column(name = "ck06_other", columnDefinition = "varchar(255) comment '농축성-비고'")
  private String ck06Other;

  @Column(name = "cl01_value1", columnDefinition = "varchar(100) comment '토양이동성-유일값'")
  private String cl01Value1;
  @Column(name = "cl02_value2", columnDefinition = "varchar(100) comment '토양이동성-최소값1'")
  private String cl02Value2;
  @Column(name = "cl03_value3", columnDefinition = "varchar(100) comment '토양이동성-최소값2'")
  private String cl03Value3;
  @Column(name = "cl04_value4", columnDefinition = "varchar(100) comment '토양이동성-최대값1'")
  private String cl04Value4;
  @Column(name = "cl05_value5", columnDefinition = "varchar(100) comment '토양이동성-최대값2'")
  private String cl05Value5;
  @Column(name = "cl06_ref", columnDefinition = "varchar(255) comment '토양이동성-출처'")
  private String cl06Ref;
  @Column(name = "cl06_other", columnDefinition = "varchar(100) comment '토양이동성-비고'")
  private String cl06Other;

  @Column(name = "division_C03", columnDefinition = "varchar(100) comment '기타유해영향-구분'")
  private String divisionC03;
  @Column(name = "cm01_data", columnDefinition = "varchar(100) comment '기타유해영향-오존층유해성값'")
  private String cm01Data;
  @Column(name = "cm02_ref", columnDefinition = "varchar(100) comment '기타유해영향-출처'")
  private String cm02Ref;
  @Column(name = "cm03_other", columnDefinition = "varchar(100) comment '기타유해영향-비고'")
  private String cm03Other;
}
