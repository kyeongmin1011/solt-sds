package com.safetyas.sds.common.model;

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

  private Long HealthSeq;
  //----------------------------------------------------------------- B그룹 11 독성에 관한 정보

  private String divisionB01;  // 구분값

  private String ba01Species;

  private String ba02Endpoint;

  private String ba03Value1;

  private String ba04Value2;

  private String ba05Value3;

  private String ba06Value4;

  private String ba07Value5;

  private String ba08Unit;

  private String ba09Tg;

  private String ba10Glp;

  private String ba11Ref;

  private String ba12Other;


  private String divisionB02;  // 구분값

  private String bb01Species;

  private String bb02Endpoint;

  private String bb03Value1;

  private String bb04Value2;

  private String bb05Value3;

  private String bb06Value4;

  private String bb07Value5;

  private String bb08Unit;

  private String bb09Tg;

  private String bb10Glp;

  private String bb11Ref;

  private String bb12Other;


  private String divisionB03;  // 구분값


  private String bc01Species;

  private String bc02Endpoint;

  private String bc03Value1;

  private String bc04Value2;

  private String bc05Value3;

  private String bc06Value4;

  private String bc07Value5;

  private String bc08Unit;

  private String bc09Time;

  private String bc10Property;

  private String bc11Tg;

  private String bc12Glp;

  private String bc13Ref;

  private String bc14Other;


  private String divisionB04;  // 구분값

  private String bd01Data;

  private String bd02Tg;

  private String bd03Glp;

  private String bd04Ref;

  private String bd05Other;


  private String divisionB05;  // 구분값

  private String be01Data;

  private String be02Tg;

  private String be03Glp;

  private String be04Ref;

  private String be05Data1;

  private String be06Other1;

  private String be07Data2;

  private String be08Other2;

  private String be09Data3;

  private String be10Other3;

  private String be11Data4;

  private String be5Other4;


  private String divisionB06;  // 구분값

  private String bf01Data;

  private String bf02Tg;

  private String bf03Glp;

  private String bf04Ref;

  private String bf05Other;


  private String divisionB07;  // 구분값

  private String bg01Data;

  private String bg02Tg;

  private String bg03Glp;

  private String bg04Ref;

  private String bg05Other;


  private String divisionB08;  // 구분값

  private String bh01Method1;

  private String bh02Data1;

  private String bh03Tg1;

  private String bh04Glp1;

  private String bh05Ref1;

  private String bh06Other1;

  private String bh07Data2;

  private String bh08Method2;

  private String bh09Tg2;

  private String bh10Glp2;

  private String bh11Ref2;

  private String bh12Other2;


  private String divisionB09;  // 구분값

  private String bi01Mol;

  private String bi02Iarc;

  private String bi03Acgih;

  private String bi04Ntp;

  private String bi05Osha;

  private String bi06Euclp;

  private String bi07other;


  private String divisionB10;  // 구분값

  private String bj01Data1;

  private String bj02Tg1;

  private String bj03Glp1;

  private String bj04Ref1;

  private String bj05Other1;

  private String divisionB11;  // 구분값

  private String bj06Data2;

  private String bj07Tg2;

  private String bj08Glp2;

  private String bj09Ref2;

  private String bj10Other2;


  private String divisionB12;  // 구분값1

  private String divisionB13;  // 구분값2

  private String divisionB14;  // 구분값3

  private String bk01Data1;

  private String bk02Tg1;

  private String bk03Glp1;

  private String bk04Ref1;

  private String bk05Other1;

  private String bk06Data2;

  private String bk07Noael2;

  private String bk08Unit2;

  private String bk09Time2;

  private String bk10Tg2;

  private String bk11Glp2;

  private String bk12Ref2;

  private String bk13Other2;


  private String divisionB15;  // 구분값1

  private String bl01Data1;

  private String bl02Tg1;

  private String bl03Glp1;

  private String bl04Ref1;

  private String bl05Other1;

  private String bl06Data2;

  private String bl07Noael2;

  private String bl08Unit2;

  private String bl09Time2;

  private String bl10Tg2;

  private String bl11Glp2;

  private String bl12Ref2;

  private String bl13Other2;


  private String divisionB16;  // 구분값

  private String bm01Data;

  private String bm02Tg;

  private String bm03Glp;

  private String bm04Ref;

  private String bm05Other;

  public static MatterHealthDTO of(MatterHealth matterHealth) {
    return ModelMapperUtils.getModelMapper().map(matterHealth, MatterHealthDTO.class);
  }
  
}
