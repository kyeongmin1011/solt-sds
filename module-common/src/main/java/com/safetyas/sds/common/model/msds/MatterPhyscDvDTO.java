package com.safetyas.sds.common.model.msds;

import com.safetyas.sds.common.entity.msds.MatterPhyscDv;
import com.safetyas.sds.common.modelMapper.ModelMapperUtils;
import javax.persistence.Column;
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
public class MatterPhyscDvDTO {

  private Long physcDvSeq;

  //------------------------------------------------------------- 구분그룹 2 물리화학위험성 구분


  //(name = "division_a1", columnDefinition = "varchar(100) comment '폭발성물질 구분'")
  private String divisionA01;
  //(name = "division_a2", columnDefinition = "varchar(100) comment '인화성 가스 구분'")
  private String divisionA02;
  //(name = "division_a3", columnDefinition = "varchar(100) comment '인화성 가스 불안정 구분'")
  private String divisionA03;
  //(name = "division_a4", columnDefinition = "varchar(100) comment '인화성 가스 자연발화성 구분'")
  private String divisionA04;
  //(name = "division_a5", columnDefinition = "varchar(100) comment '인화성 에어로졸 구분'")
  private String divisionA05;
  //(name = "division_a6", columnDefinition = "varchar(100) comment '산화성 가스 구분'")
  private String divisionA06;
  //(name = "division_a7", columnDefinition = "varchar(100) comment '고압가스 구분'")
  private String divisionA07;
  //(name = "division_a8", columnDefinition = "varchar(100) comment '인화성 액체 구분'")
  private String divisionA08;
  //(name = "division_a9", columnDefinition = "varchar(100) comment '인화성 고체 구분'")
  private String divisionA09;
  //(name = "division_a10", columnDefinition = "varchar(100) comment '자기반응성 물질 및 혼합물 구분'")
  private String divisionA10;
  //(name = "division_a11", columnDefinition = "varchar(100) comment '자연발화성 액체 구분'")
  private String divisionA11;
  //(name = "division_a12", columnDefinition = "varchar(100) comment '자연발화성 고체 구분'")
  private String divisionA12;
  //(name = "division_a13", columnDefinition = "varchar(100) comment '자기발열성 물질 및 혼합물 구분'")
  private String divisionA13;
  //(name = "division_a14", columnDefinition = "varchar(100) comment '물반응성 물질 및 혼합물 구분'")
  private String divisionA14;
  //(name = "division_a15", columnDefinition = "varchar(100) comment '산화성 액체 구분'")
  private String divisionA15;
  //(name = "division_a16", columnDefinition = "varchar(100) comment '산화성 고체 구분'")
  private String divisionA16;
  //(name = "division_a17", columnDefinition = "varchar(100) comment '유기과산화물 구분'")
  private String divisionA17;
  //(name = "division_a18", columnDefinition = "varchar(100) comment '금속부식성 물질 구분'")
  private String divisionA18;
  //(name = "division_a19", columnDefinition = "varchar(100) comment '둔감폭발물 구분'")
  private String divisionA19;

  public static MatterPhyscDvDTO of(MatterPhyscDv matterPhyscDv) {
    return ModelMapperUtils.getModelMapper().map(matterPhyscDv, MatterPhyscDvDTO.class);
  }
}
