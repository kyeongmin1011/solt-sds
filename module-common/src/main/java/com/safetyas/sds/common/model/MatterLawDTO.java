package com.safetyas.sds.common.model;

import com.safetyas.sds.common.entity.msds.MatterLaw;
import com.safetyas.sds.common.modelMapper.ModelMapperUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatterLawDTO {

  private static ModelMapper modelMapper;

  private Long LawSeq;
  
  //------------------------------------------------------------- D그룹 14 un번호


  private String da1Un;

  //------------------------------------------------------------- E그룹 8 노출기준


  private String ea1Domestic;

  private String ea2Acgih;

  private String ea3Osha;

  private String ea4Niosh;

  private String ea5EU;

  private String ea6Other;

  //------------------------------------------------------------- F그룹 15 법적규제현황


  private String fa1Data1;

  private String fa2Data2;

  private String fa3Data3;

  private String fa4Data4;

  private String fa5Data5;

  private String fa6Data6;

  private String fa7Data7;

  private String fa8Data8;

  private String fa9Data9;


  private String fb1Data1;

  private String fb2Data2;

  private String fb3Date3;

  private String fb4Data4;

  private String fb5Data5;


  private String fc1Data1;


  private String fd1Data1;


  private String fe1Data1;

  private String fe2Data2;

  private String fe3Data3;

  private String fe4Data4;

  private String fe5Data5;

  private String fe6Data6;

  public static  MatterLawDTO of(MatterLaw matterLaw) {
    return ModelMapperUtils.getModelMapper().map(matterLaw, MatterLawDTO.class);
  }

}
