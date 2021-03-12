package com.safetyas.sds.common.model;

import com.safetyas.sds.common.entity.msds.MatterEnv;
import com.safetyas.sds.common.modelMapper.ModelMapperUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatterEnvDTO {

  private Long EnvSeq;
  //------------------------------------------------------------- C그룹 12 환경유해성

  private String divisionC01;
  private String divisionC02;

  private String ca01Time;
  private String ca02Endpoint;
  private String ca03Species;
  private String ca04Value1;
  private String ca05Value2;
  private String ca06Value3;
  private String ca07Value4;
  private String ca08Value5;
  private String ca09Unit;
  private String ca10Tg;
  private String ca11Glp;
  private String ca12Ref;
  private String ca13Other;

  private String cb01Time;
  private String cb02Endpoint;
  private String cb03Species;
  private String cb04Value1;
  private String cb05Value2;
  private String cb06Value3;
  private String cb07Value4;
  private String cb08Value5;
  private String cb09Unit;
  private String cb10Tg;
  private String cb11Glp;
  private String cb12Ref;
  private String cb13Other;

  private String cc01Time;
  private String cc02Endpoint;
  private String cc03Species;
  private String cc04Value1;
  private String cc05Value2;
  private String cc06Value3;
  private String cc07Value4;
  private String cc08Value5;
  private String cc09Unit;
  private String cc10Tg;
  private String cc11Glp;
  private String cc12Ref;
  private String cc13Other;

  private String cd01Time;
  private String cd02Endpoint;
  private String cd03Species;
  private String cd04Value1;
  private String cd05Value2;
  private String cd06Value3;
  private String cd07Value4;
  private String cd08Value5;
  private String cd09Unit;
  private String cd10Tg;
  private String cd11Glp;
  private String cd12Ref;
  private String cd13Other;

  private String ce01Time;
  private String ce02Endpoint;
  private String ce03Species;
  private String ce04Value1;
  private String ce05Value2;
  private String ce06Value3;
  private String ce07Value4;
  private String ce08Value5;
  private String ce09Unit;
  private String ce10Tg;
  private String ce11Glp;
  private String ce12Ref;
  private String ce13Other;

  // 만성 갑각류
  private String cf01Time;
  private String cf02Endpoint;
  private String cf03Species;
  private String cf04Value1;
  private String cf05Value2;
  private String cf06Value3;
  private String cf07Value4;
  private String cf08Value5;
  private String cf09Unit;
  private String cf10Tg;
  private String cf11Glp;
  private String cf12Ref;
  private String cf13Other;


  private String cg01Time;
  private String cg02Endpoint;
  private String cg03Species;
  private String cg04Value1;
  private String cg05Value2;
  private String cg06Value3;
  private String cg07Value4;
  private String cg08Value5;
  private String cg09Unit;
  private String cg10Tg;
  private String cg11Glp;
  private String cg12Ref;
  private String cg13Other;

  private String ch01Time;
  private String ch02Endpoint;
  private String ch03Species;
  private String ch04Value1;
  private String ch05Value2;
  private String ch06Value3;
  private String ch07Value4;
  private String ch08Value5;
  private String ch09Unit;
  private String ch10Tg;
  private String ch11Glp;
  private String ch12Ref;
  private String ch13Other;

  private String ci01Persistence;

  private String cj01Data;
  private String cj02Time;
  private String cj03Degrade;
  private String cj04Ref;
  private String cj05Other;

  private String ck01Value1;
  private String ck02Value2;
  private String ck03Value3;
  private String ck04Value4;
  private String ck05Value5;
  private String ck06Ref;
  private String ck06Other;

  private String cl01Value1;
  private String cl02Value2;
  private String cl03Value3;
  private String cl04Value4;
  private String cl05Value5;
  private String cl06Ref;
  private String cl06Other;

  private String divisionC03;
  private String cm01Data;
  private String cm02Ref;
  private String cm03Other;

  public static MatterEnvDTO of(MatterEnv matterEnv) {
    return ModelMapperUtils.getModelMapper().map(matterEnv, MatterEnvDTO.class);
  }

}
