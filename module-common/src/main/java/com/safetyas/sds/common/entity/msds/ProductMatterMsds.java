package com.safetyas.sds.common.entity.msds;

import com.safetyas.sds.common.entity.info.InfoMatterUsage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "sds_product_matter_msds")   // 물질 msds 문서 정보
public class ProductMatterMsds {

  @Id
  @Column(name = "product_matter_msds_seq", length = 20)
  private Long productMatterMsdsSeq;

/*  @Column(name = "step01_01", columnDefinition = "varchar(255) comment '제품의 권고 용도'")
  private String step01_01;*/

  @ManyToMany
  @JoinTable(name = "sds_matter_usage",
      joinColumns = @JoinColumn(name = "product_matter_msds_seq"),
      inverseJoinColumns = @JoinColumn(name = "serial_number"))
  private List<InfoMatterUsage> infoMatterUsageList = new ArrayList<>();


  @Column(name = "step01_02", columnDefinition = "varchar(255) comment '제품의 사용상의 제한'")
  private String step01_02;

  @Column(name = "step01_03", columnDefinition = "varchar(255) comment '회사명'")
  private String step01_03;

  @Column(name = "step01_04", columnDefinition = "varchar(255) comment '주소'")
  private String step01_04;

  @Column(name = "step01_05", columnDefinition = "varchar(255) comment '긴급전화번호'")
  private String step01_05;


  @Column(name = "step02_01", columnDefinition = "varchar(255) comment '그림문자'")
  private String step02_01;

  @Column(name = "step02_02", columnDefinition = "varchar(255) comment '신호어'")
  private String step02_02;

  @Column(name = "step02_03", columnDefinition = "TEXT comment '유해,위험 문구'")
  private String step02_03;

  @Column(name = "step02_04", columnDefinition = "TEXT comment '예방'")
  private String step02_04;

  @Column(name = "step02_05", columnDefinition = "TEXT comment '대응'")
  private String step02_05;

  @Column(name = "step02_06", columnDefinition = "TEXT comment '저장'")
  private String step02_06;

  @Column(name = "step02_07", columnDefinition = "TEXT comment '폐기'")
  private String step02_07;

  @Column(name = "step02_08", columnDefinition = "TEXT comment '유해성,위험성 분류기준에 포함되지 않는 기타 유해성,위험성'")
  private String step02_08;


  @Column(name = "step04_0", columnDefinition = "TEXT comment '눈에 들어갔을 때'")
  private String step04_01;

  @Column(name = "step04_02", columnDefinition = "TEXT comment '피부에 접촉했을 때'")
  private String step04_02;

  @Column(name = "step04_03", columnDefinition = "TEXT comment '흡입했을 때'")
  private String step04_03;

  @Column(name = "step04_04", columnDefinition = "TEXT comment '먹었을 때'")
  private String step04_04;

  @Column(name = "step04_05", columnDefinition = "TEXT comment '기타 의사의 주의사항'")
  private String step04_05;


  @Column(name = "step05_01", columnDefinition = "TEXT comment '적절한 (및 부적절한) 소화제'")
  private String step05_01;

  @Column(name = "step05_02", columnDefinition = "TEXT comment '화학물질로부터 생기는 특정 유해성'")
  private String step05_02;

  @Column(name = "step05_03", columnDefinition = "TEXT comment '화재 진압 시 착용할 보호구 및 예방조치'")
  private String step05_03;


  @Column(name = "step06_01", columnDefinition = "TEXT comment '인체를 보호하기 위해 필요한 조치사항 및 보호구'")
  private String step06_01;

  @Column(name = "step06_02", columnDefinition = "TEXT comment '환경을 보호하기 위해 필요한 조치사항'")
  private String step06_02;

  @Column(name = "step06_03", columnDefinition = "TEXT comment '정화 또는 제거 방법'")
  private String step06_03;


  @Column(name = "step07_01", columnDefinition = "TEXT comment '안전취급요령'")
  private String step07_01;

  @Column(name = "step07_02", columnDefinition = "TEXT comment '안전한 저장 방법'")
  private String step07_02;


  @Column(name = "step08_01", columnDefinition = "TEXT comment '적절한 공학적 관리'")
  private String step08_01;

  @Column(name = "step08_02", columnDefinition = "TEXT comment '호흡기 보호'")
  private String step08_02;

  @Column(name = "step08_03", columnDefinition = "TEXT comment '눈 보호'")
  private String step08_03;

  @Column(name = "step08_04", columnDefinition = "TEXT comment '손 보호'")
  private String step08_04;

  @Column(name = "step08_05", columnDefinition = "TEXT comment '신체 보호'")
  private String step08_05;


  @Column(name = "step10_01", columnDefinition = "TEXT comment '화학적 안정성 및 유해 반응의 가능성'")
  private String step10_01;

  @Column(name = "step10_02", columnDefinition = "TEXT comment '피해야 할 조건'")
  private String step10_02;

  @Column(name = "step10_03", columnDefinition = "TEXT comment '피해야 할 물질'")
  private String step10_03;

  @Column(name = "step10_04", columnDefinition = "TEXT comment '분해 시 생성되는 유해물질'")
  private String step10_04;


  @Column(name = "step11_01", columnDefinition = "TEXT comment '가능성이 높은 노출 경로에 관한 정보'")
  private String step11_01;

  @Column(name = "step13_01", columnDefinition = "TEXT comment '폐기방법'")
  private String step13_01;

  @Column(name = "step13_02", columnDefinition = "TEXT comment '폐기 시 주의사항'")
  private String step13_02;


  @Column(name = "step14_01", columnDefinition = "varchar(100) comment '유엔 번호(UN No.)'")
  private String step14_01;

  @Column(name = "step14_02", columnDefinition = "varchar(100) comment '유엔 적정 선적명'")
  private String step14_02;

  @Column(name = "step14_03", columnDefinition = "varchar(100) comment '운송에서의 위험성 등급'")
  private String step14_03;

  @Column(name = "step14_04", columnDefinition = "varchar(100) comment '용기등급'")
  private String step14_04;

  @Column(name = "step14_05", columnDefinition = "varchar(100) comment '해양오염물질'")
  private String step14_05;

  @Column(name = "step14_06", columnDefinition = "varchar(100) comment '화재 시 비상조치'")
  private String step14_06;

  @Column(name = "step14_07", columnDefinition = "TEXT comment '유출 시 비상조치'")
  private String step14_07;

  @Column(name = "step15_01", columnDefinition = "date comment '최초 작성일자'")
  private LocalDate step15_01;

  @Column(name = "step15_02", columnDefinition = "int(11) comment '개정 회수'")
  private Integer step15_02;

  @Column(name = "step15_03", columnDefinition = "date comment '최초 개정일자'")
  private LocalDate step15_03;

  @Column(name = "step15_04", columnDefinition = "TEXT comment '기타'")
  private String step15_04;
}
