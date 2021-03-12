package com.safetyas.sds.common.model;

import com.safetyas.sds.common.entity.msds.MatterPhyscDv;
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
public class MatterPhyscDvDTO {

  private Long PhyscDvSeq;

  //------------------------------------------------------------- 구분그룹 2 물리화학위험성 구분


  private String divisionA1;

  private String divisionA2;

  private String divisionA3;

  private String divisionA4;

  private String divisionA5;

  private String divisionA6;

  private String divisionA7;

  private String divisionA8;

  private String divisionA9;

  private String divisionA10;

  private String divisionA11;

  private String divisionA12;

  private String divisionA13;

  private String divisionA14;

  private String divisionA15;

  private String divisionA16;

  private String divisionA17;

  private String divisionA18;

  private String divisionA19;

  public static MatterPhyscDvDTO of(MatterPhyscDv matterPhyscDv) {
    return ModelMapperUtils.getModelMapper().map(matterPhyscDv, MatterPhyscDvDTO.class);
  }
}
