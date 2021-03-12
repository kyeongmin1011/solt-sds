package com.safetyas.sds.common.model;

import com.safetyas.sds.common.entity.msds.MatterPhyscChem;
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
public class MatterPhyscChemDTO {

  private Long PhyscChemSeq;

  //------------------------------------------------------------- A그룹 9 물리화학적 특성

  private String aa1Apr;

  private String aa2Color;

  private String aa3Ref;

  private String aa4Other;


  private String ab1Data;

  private String ab2Ref;


  private String ac1Data;

  private String ac2Unit;

  private String ac3Ref;


  private String ad1Value1;

  private String ad1Value2;

  private String ad3Value3;

  private String ad4Value4;

  private String ad5Value5;

  private String ad6Ref;

  private String ad7Other;


  private String ae1Data;

  private String ae2Unit;

  private String ae3Tg;

  private String ae1Ref;


  private String af1Value1;

  private String af2Value2;

  private String af3Value3;

  private String af4Value4;

  private String af5Value5;

  private String af6Unit;

  private String af7Tg;

  private String af8Ref;


  private String ag1Value1;

  private String ag2Value2;

  private String ag3Value3;

  private String ag4Value4;

  private String ag5Value5;

  private String ag6Unit;

  private String ag7Tg;

  private String ag8Ref;

  private String ag9Other;


  private String ah1Data;

  private String ah2Method;

  private String ah3Tg;

  private String ah4Ref;


  private String ai1Data;

  private String ai2Tg;

  private String ai3Ref;

  private String ai4Other;


  private String aj1Data1;

  private String aj2Data2;

  private String aj3Unit;

  private String aj4Tg;

  private String aj5Ref;

  private String aj6Other;


  private String ak1Data;

  private String ak2Unit;

  private String ak3Method;

  private String ak4Tg;

  private String ak5Ref;


  private String al1Data;

  private String al2Unit;

  private String al3Method;

  private String al4Tg;

  private String al5Ref;

  private String al6Other;


  private String am1Data;

  private String am2Unit;

  private String am3Method;

  private String am4Tg;

  private String am5Ref;


  private String an1Data;

  private String an2Unit;

  private String an3Method;

  private String an4Tg;

  private String an5Ref;


  private String ao1Value1;

  private String ao2Value2;

  private String ao3Value3;

  private String ao4Value4;

  private String ao5Value5;

  private String ao6Tg;

  private String ao7Ref;

  private String ao8Other;


  private String ap1Data;

  private String ap2Unit;

  private String ap3Method;

  private String ap4Tg;

  private String ap5Ref;


  private String aq1Data;

  private String aq2Unit;

  private String aq3Method;

  private String aq4Tg;

  private String aq5Ref;


  private String ar1Data1;

  private String ar2Unit1;

  private String ar3Ref1;

  private String ar4Data2;

  private String ar5Unit2;

  private String ar6Temper;

  private String ar7Ref2;


  private String as1Data;

  private String as2Ref;

  public static MatterPhyscChemDTO of(MatterPhyscChem matterPhyscChem) {
    return ModelMapperUtils.getModelMapper().map(matterPhyscChem, MatterPhyscChemDTO.class);
  }

}
