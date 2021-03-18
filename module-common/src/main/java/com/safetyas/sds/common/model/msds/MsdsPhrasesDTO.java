package com.safetyas.sds.common.model.msds;

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
public class MsdsPhrasesDTO {

  //(name = "step04_01", columnDefinition = "TEXT comment '눈에 들어갔을 때'")
  private String step04_01;

  //(name = "step04_02", columnDefinition = "TEXT comment '피부에 접촉했을 때'")
  private String step04_02;

  //(name = "step04_03", columnDefinition = "TEXT comment '흡입했을 때'")
  private String step04_03;

  //(name = "step04_04", columnDefinition = "TEXT comment '먹었을 때'")
  private String step04_04;

  //(name = "step04_05", columnDefinition = "TEXT comment '기타 의사의 주의사항'")
  private String step04_05;

  //(name = "step05_01", columnDefinition = "TEXT comment '적절한 (및 부적절한) 소화제'")
  private String step05_01;

  //(name = "step05_02", columnDefinition = "TEXT comment '화학물질로부터 생기는 특정 유해성'")
  private String step05_02;

  //(name = "step05_03", columnDefinition = "TEXT comment '화재 진압 시 착용할 보호구 및 예방조치'")
  private String step05_03;

  //(name = "step06_01", columnDefinition = "TEXT comment '인체를 보호하기 위해 필요한 조치사항 및 보호구'")
  private String step06_01;

  //(name = "step06_02", columnDefinition = "TEXT comment '환경을 보호하기 위해 필요한 조치사항'")
  private String step06_02;

  //(name = "step06_03", columnDefinition = "TEXT comment '정화 또는 제거 방법'")
  private String step06_03;

  //(name = "step07_01", columnDefinition = "TEXT comment '안전취급요령'")
  private String step07_01;

  //(name = "step07_02", columnDefinition = "TEXT comment '안전한 저장 방법'")
  private String step07_02;

  //(name = "step08_01", columnDefinition = "TEXT comment '적절한 공학적 관리'")
  private String step08_01;

  //(name = "step08_02", columnDefinition = "TEXT comment '호흡기 보호'")
  private String step08_02;

  //(name = "step08_03", columnDefinition = "TEXT comment '눈 보호'")
  private String step08_03;

  //(name = "step08_04", columnDefinition = "TEXT comment '손 보호'")
  private String step08_04;

  //(name = "step08_05", columnDefinition = "TEXT comment '신체 보호'")
  private String step08_05;

  //(name = "step10_01", columnDefinition = "TEXT comment '화학적 안정성 및 유해 반응의 가능성'")
  private String step10_01;

  //(name = "step10_02", columnDefinition = "TEXT comment '피해야 할 조건'")
  private String step10_02;

  //(name = "step10_03", columnDefinition = "TEXT comment '피해야 할 물질'")
  private String step10_03;

  //(name = "step10_04", columnDefinition = "TEXT comment '분해 시 생성되는 유해물질'")
  private String step10_04;


}
