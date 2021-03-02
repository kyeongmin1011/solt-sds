package com.safetyas.sds.common.entity.msds;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

  @Column(name = "step01_01")
  private String step01_01;

  @Column(name = "step01_02")
  private String step01_02;

  @Column(name = "step01_03")
  private String step01_03;

  @Column(name = "step01_04")
  private String step01_04;

  @Column(name = "step01_05")
  private String step01_05;


  @Column(name = "step02_01")
  private String step02_01;

  @Column(name = "step02_02")
  private String step02_02;

  @Column(name = "step02_03", columnDefinition = "LONGTEXT")
  private String step02_03;

  @Column(name = "step02_04", columnDefinition = "LONGTEXT")
  private String step02_04;

  @Column(name = "step02_05", columnDefinition = "LONGTEXT")
  private String step02_05;

  @Column(name = "step02_06", columnDefinition = "LONGTEXT")
  private String step02_06;

  @Column(name = "step02_07", columnDefinition = "LONGTEXT")
  private String step02_07;

  @Column(name = "step02_08")
  private String step02_08;


  @Column(name = "step04_0", columnDefinition = "LONGTEXT")
  private String step04_01;

  @Column(name = "step04_02", columnDefinition = "LONGTEXT")
  private String step04_02;

  @Column(name = "step04_03", columnDefinition = "LONGTEXT")
  private String step04_03;

  @Column(name = "step04_04", columnDefinition = "LONGTEXT")
  private String step04_04;

  @Column(name = "step04_05", columnDefinition = "LONGTEXT")
  private String step04_05;


  @Column(name = "step05_01", columnDefinition = "LONGTEXT")
  private String step05_01;

  @Column(name = "step05_02", columnDefinition = "LONGTEXT")
  private String step05_02;

  @Column(name = "step05_03", columnDefinition = "LONGTEXT")
  private String step05_03;


  @Column(name = "step06_01", columnDefinition = "LONGTEXT")
  private String step06_01;

  @Column(name = "step06_02", columnDefinition = "LONGTEXT")
  private String step06_02;

  @Column(name = "step06_03", columnDefinition = "LONGTEXT")
  private String step06_03;


  @Column(name = "step07_01", columnDefinition = "LONGTEXT")
  private String step07_01;

  @Column(name = "step07_02", columnDefinition = "LONGTEXT")
  private String step07_02;


  @Column(name = "step08_01", columnDefinition = "LONGTEXT")
  private String step08_01;

  @Column(name = "step08_02", columnDefinition = "LONGTEXT")
  private String step08_02;

  @Column(name = "step08_03")
  private String step08_03;

  @Column(name = "step08_04")
  private String step08_04;

  @Column(name = "step08_05")
  private String step08_05;


  @Column(name = "step10_01")
  private String step10_01;

  @Column(name = "step10_02")
  private String step10_02;

  @Column(name = "step10_03")
  private String step10_03;

  @Column(name = "step10_04")
  private String step10_04;


  @Column(name = "step11_01", columnDefinition = "LONGTEXT")
  private String step11_01;

  @Column(name = "step13_01")
  private String step13_01;

  @Column(name = "step13_02")
  private String step13_02;


  @Column(name = "step14_01")
  private String step14_01;

  @Column(name = "step14_02")
  private String step14_02;

  @Column(name = "step14_03")
  private String step14_03;

  @Column(name = "step14_04")
  private String step14_04;

  @Column(name = "step14_05")
  private String step14_05;

  @Column(name = "step14_06")
  private String step14_06;

  @Column(name = "step14_07")
  private String step14_07;

  @Column(name = "step15_01")
  private String step15_01;

  @Column(name = "step15_02")
  private String step15_02;

  private LocalDate step15_03;
  @Column(name = "step15_04")

  private String step15_04;
}
