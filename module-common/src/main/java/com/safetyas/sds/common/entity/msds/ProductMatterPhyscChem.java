package com.safetyas.sds.common.entity.msds;

import com.safetyas.sds.common.model.msds.MatterPhyscChemDTO;
import com.safetyas.sds.common.modelMapper.ModelMapperUtils;
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
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "sds_product_matter_physc_chem")
public class ProductMatterPhyscChem implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_matter_physc_chem_seq", length = 20)
  private Long productMatterPhyscChemSeq;

  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "product_matter_seq", foreignKey = @ForeignKey(name = "product_matter_seq_product_matter_physc_chem_fk"))
  private ProductMatter productMatter;

  //------------------------------------------------------------- A그룹 9 물리화학적 특성

  @Column(name = "aa1_apr", columnDefinition = "varchar(100) comment '외관-성상'")
  private String aa1Apr;
  @Column(name = "aa2_color", columnDefinition = "varchar(100) comment '외관-색상'")
  private String aa2Color;
  @Column(name = "aa3_ref", columnDefinition = "varchar(100) comment '외관-출처'")
  private String aa3Ref;
  @Column(name = "aa4_other", columnDefinition = "varchar(100) comment '외관-비고'")
  private String aa4Other;

  @Column(name = "ab1_data", columnDefinition = "varchar(100) comment '냄새-값'")
  private String ab1Data;
  @Column(name = "ab2_ref", columnDefinition = "varchar(100) comment '냄새-출처'")
  private String ab2Ref;
  @Column(name = "ab3_other", columnDefinition = "varchar(500) comment '냄새-비고'")
  private String ab3Other;  //추가

  @Column(name = "ac1_data", columnDefinition = "varchar(100) comment '냄새역치-값'")
  private String ac1Data;
  @Column(name = "ac2_unit", columnDefinition = "varchar(100) comment '냄새역치-단위'")
  private String ac2Unit;
  @Column(name = "ac3_ref", columnDefinition = "varchar(100) comment '냄새역치-출처'")
  private String ac3Ref;
  @Column(name = "ab4_other", columnDefinition = "varchar(500) comment '냄새역치-비고'")
  private String ac4Other;  //추가

  @Column(name = "ad1_value1", columnDefinition = "varchar(100) comment 'PH-유일값'")
  private String ad1Value1;
  @Column(name = "ad2_value2", columnDefinition = "varchar(100) comment 'PH-최소값1'")
  private String ad1Value2;
  @Column(name = "ad3_value3", columnDefinition = "varchar(100) comment 'PH-최소값2'")
  private String ad3Value3;
  @Column(name = "ad4_value4", columnDefinition = "varchar(100) comment 'PH-최대값1'")
  private String ad4Value4;
  @Column(name = "ad5_value5", columnDefinition = "varchar(100) comment 'PH-최대값2'")
  private String ad5Value5;
  @Column(name = "ad6_ref", columnDefinition = "varchar(100) comment 'PH-출처'")
  private String ad6Ref;
  @Column(name = "ad7_other", columnDefinition = "varchar(100) comment 'PH-비고'")
  private String ad7Other;

  @Column(name = "ae1_data", columnDefinition = "varchar(100) comment '녹는점/어는점-값'")
  private String ae1Data;
  @Column(name = "ae2_unit", columnDefinition = "varchar(100) comment '녹는점/어는점-단위'")
  private String ae2Unit;
  @Column(name = "ae3_tg", columnDefinition = "varchar(100) comment '녹는점/어는점-시험지침'")
  private String ae3Tg;
  @Column(name = "ae4_ref", columnDefinition = "varchar(100) comment '녹는점/어는점-출처'")
  private String ae1Ref;
  @Column(name = "ae5_other", columnDefinition = "varchar(500) comment '녹는점/어는점-비고'")
  private String ae5Other;  //추가

  @Column(name = "af1_value1", columnDefinition = "varchar(100) comment '초기 끓는점과 끓는점 범위-유일값'")
  private String af1Value1;
  @Column(name = "af2_value2", columnDefinition = "varchar(100) comment '초기 끓는점과 끓는점 범위-최소값1'")
  private String af2Value2;
  @Column(name = "af3_value3", columnDefinition = "varchar(100) comment '초기 끓는점과 끓는점 범위-최소값2'")
  private String af3Value3;
  @Column(name = "af4_value4", columnDefinition = "varchar(100) comment '초기 끓는점과 끓는점 범위-최대값1'")
  private String af4Value4;
  @Column(name = "af5_value5", columnDefinition = "varchar(100) comment '초기 끓는점과 끓는점 범위-최대값2'")
  private String af5Value5;
  @Column(name = "af6_unit", columnDefinition = "varchar(100) comment '초기 끓는점과 끓는점 범위-단위'")
  private String af6Unit;
  @Column(name = "af7_tg", columnDefinition = "varchar(100) comment '초기 끓는점과 끓는점 범위-시험지침'")
  private String af7Tg;
  @Column(name = "af8_ref", columnDefinition = "varchar(100) comment '초기 끓는점과 끓는점 범위-출처'")
  private String af8Ref;
  @Column(name = "af9_other", columnDefinition = "varchar(500) comment '초기 끓는점과 끓는점 범위-비고'")
  private String af9Other;  //추가

  @Column(name = "ag1_value1", columnDefinition = "varchar(100) comment '인화점-유일값'")
  private String ag1Value1;
  @Column(name = "ag2_value2", columnDefinition = "varchar(100) comment '인화점-최소값1'")
  private String ag2Value2;
  @Column(name = "ag3_value3", columnDefinition = "varchar(100) comment '인화점-최소값2'")
  private String ag3Value3;
  @Column(name = "ag4_value4", columnDefinition = "varchar(100) comment '인화점-최대값1'")
  private String ag4Value4;
  @Column(name = "ag5_value5", columnDefinition = "varchar(100) comment '인화점-최대값2'")
  private String ag5Value5;
  @Column(name = "ag6_unit", columnDefinition = "varchar(100) comment '인화점-단위'")
  private String ag6Unit;
  @Column(name = "ag7_tg", columnDefinition = "varchar(100) comment '인화점-시험지침'")
  private String ag7Tg;
  @Column(name = "ag8_ref", columnDefinition = "varchar(100) comment '인화점-출처'")
  private String ag8Ref;
  @Column(name = "ag9_other", columnDefinition = "varchar(100) comment '인화점-비고'")
  private String ag9Other;

  @Column(name = "ah1_data", columnDefinition = "varchar(100) comment '증발속도-값'")
  private String ah1Data;
  @Column(name = "ah2_method", columnDefinition = "varchar(100) comment '증발속도-시험조건'")
  private String ah2Method;
  @Column(name = "ah3_tg", columnDefinition = "varchar(100) comment '증발속도-시험지침'")
  private String ah3Tg;
  @Column(name = "ah4_ref", columnDefinition = "varchar(100) comment '증발속도-출처'")
  private String ah4Ref;
  @Column(name = "ah5_other", columnDefinition = "varchar(500) comment '증발속도-비고'")
  private String ah5Other;  //추가

  @Column(name = "ai1_data", columnDefinition = "varchar(100) comment '인화성(고체,기체)-값'")
  private String ai1Data;
  @Column(name = "ai2_tg", columnDefinition = "varchar(100) comment '인화성(고체,기체)-시험지침'")
  private String ai2Tg;
  @Column(name = "ai3_ref", columnDefinition = "varchar(100) comment '인화성(고체,기체)-출처'")
  private String ai3Ref;
  @Column(name = "ai4_other", columnDefinition = "varchar(100) comment '인화성(고체,기체)-비고'")
  private String ai4Other;

  @Column(name = "aj1_data1", columnDefinition = "varchar(100) comment '인화 또는 폭발 범위의 상한/하한-상한'")
  private String aj1Data1;
  @Column(name = "aj2_data2", columnDefinition = "varchar(100) comment '인화 또는 폭발 범위의 상한/하한-하한'")
  private String aj2Data2;
  @Column(name = "aj3_unit", columnDefinition = "varchar(100) comment '인화 또는 폭발 범위의 상한/하한-단위'")
  private String aj3Unit;
  @Column(name = "aj4_tg", columnDefinition = "varchar(100) comment '인화 또는 폭발 범위의 상한/하한-시험지침'")
  private String aj4Tg;
  @Column(name = "aj5_ref", columnDefinition = "varchar(100) comment '인화 또는 폭발 범위의 상한/하한-출처'")
  private String aj5Ref;
  @Column(name = "aj6_other", columnDefinition = "varchar(100) comment '인화 또는 폭발 범위의 상한/하한-비고'")
  private String aj6Other;

  @Column(name = "ak1_data", columnDefinition = "varchar(100) comment '증기압-값'")
  private String ak1Data;
  @Column(name = "ak2_unit", columnDefinition = "varchar(100) comment '증기압-단위'")
  private String ak2Unit;
  @Column(name = "ak3_method", columnDefinition = "varchar(100) comment '증기압-시험조건'")
  private String ak3Method;
  @Column(name = "ak4_tg", columnDefinition = "varchar(100) comment '증기압-시험지침'")
  private String ak4Tg;
  @Column(name = "ak5_ref", columnDefinition = "varchar(100) comment '증기압-출처'")
  private String ak5Ref;
  @Column(name = "ak6_other", columnDefinition = "varchar(500) comment '증기압-비고'")
  private String ak6Other;  //추가

  @Column(name = "al1_data", columnDefinition = "varchar(100) comment '용해도-값'")
  private String al1Data;
  @Column(name = "al2_unit", columnDefinition = "varchar(100) comment '용해도-단위'")
  private String al2Unit;
  @Column(name = "al3_method", columnDefinition = "varchar(100) comment '용해도-시험조건'")
  private String al3Method;
  @Column(name = "al4_tg", columnDefinition = "varchar(100) comment '용해도-시험지침'")
  private String al4Tg;
  @Column(name = "al5_ref", columnDefinition = "varchar(100) comment '용해도-출처'")
  private String al5Ref;
  @Column(name = "ak5_other", columnDefinition = "varchar(100) comment '용해도-비고'")
  private String al6Other;

  @Column(name = "am1_data", columnDefinition = "varchar(100) comment '증기밀도-값'")
  private String am1Data;
  @Column(name = "am2_unit", columnDefinition = "varchar(100) comment '증기밀도-단위'")
  private String am2Unit;
  @Column(name = "am3_method", columnDefinition = "varchar(100) comment '증기밀도-시험조건'")
  private String am3Method;
  @Column(name = "am4_tg", columnDefinition = "varchar(100) comment '증기밀도-시험지침'")
  private String am4Tg;
  @Column(name = "am5_ref", columnDefinition = "varchar(100) comment '증기밀도-출처'")
  private String am5Ref;
  @Column(name = "am6_other", columnDefinition = "varchar(500) comment '증기밀도-비고'")
  private String am6Other;  //추가

  @Column(name = "an1_data", columnDefinition = "varchar(100) comment '비중-값'")
  private String an1Data;
  @Column(name = "an2_unit", columnDefinition = "varchar(100) comment '비중-단위'")
  private String an2Unit;
  @Column(name = "an3_method", columnDefinition = "varchar(100) comment '비중-시험조건'")
  private String an3Method;
  @Column(name = "an4_tg", columnDefinition = "varchar(100) comment '비중-시험지침'")
  private String an4Tg;
  @Column(name = "an5_ref", columnDefinition = "varchar(100) comment '비중-출처'")
  private String an5Ref;
  @Column(name = "an6_other", columnDefinition = "varchar(500) comment '비중-비고'")
  private String an6Other;  //추가

  @Column(name = "ao1_value1", columnDefinition = "varchar(100) comment 'n 옥탄올/물 분배계수-유일값'")
  private String ao1Value1;
  @Column(name = "ao2_value2", columnDefinition = "varchar(100) comment 'n 옥탄올/물 분배계수-최소값1'")
  private String ao2Value2;
  @Column(name = "ao3_value3", columnDefinition = "varchar(100) comment 'n 옥탄올/물 분배계수-최소값2'")
  private String ao3Value3;
  @Column(name = "ao4_value4", columnDefinition = "varchar(100) comment 'n 옥탄올/물 분배계수-최대값1'")
  private String ao4Value4;
  @Column(name = "ao5_value5", columnDefinition = "varchar(100) comment 'n 옥탄올/물 분배계수-최대값2'")
  private String ao5Value5;
  @Column(name = "ao6_tg", columnDefinition = "varchar(100) comment 'n 옥탄올/물 분배계수-시험지침'")
  private String ao6Tg;
  @Column(name = "ao7_ref", columnDefinition = "varchar(100) comment 'n 옥탄올/물 분배계수-출처'")
  private String ao7Ref;
  @Column(name = "ao8_other", columnDefinition = "varchar(100) comment 'n 옥탄올/물 분배계수-비고'")
  private String ao8Other;

  @Column(name = "ap1_data", columnDefinition = "varchar(100) comment '자연발화 온도-값'")
  private String ap1Data;
  @Column(name = "ap2_unit", columnDefinition = "varchar(100) comment '자연발화 온도-단위'")
  private String ap2Unit;
  @Column(name = "ap3_method", columnDefinition = "varchar(100) comment '자연발화 온도-시험조건'")
  private String ap3Method;
  @Column(name = "ap4_tg", columnDefinition = "varchar(100) comment '자연발화 온도-시험지침'")
  private String ap4Tg;
  @Column(name = "ap5_ref", columnDefinition = "varchar(100) comment '자연발화 온도-출처'")
  private String ap5Ref;
  @Column(name = "ap6_other", columnDefinition = "varchar(500) comment '자연발화 온도-비고'")
  private String ap6Other;  //추가

  @Column(name = "aq1_data", columnDefinition = "varchar(100) comment '분해온도-값'")
  private String aq1Data;
  @Column(name = "aq2_unit", columnDefinition = "varchar(100) comment '분해온도-단위'")
  private String aq2Unit;
  @Column(name = "aq3_method", columnDefinition = "varchar(100) comment '분해온도-시험조건'")
  private String aq3Method;
  @Column(name = "aq4_tg", columnDefinition = "varchar(100) comment '분해온도-시험지침'")
  private String aq4Tg;
  @Column(name = "aq5_ref", columnDefinition = "varchar(100) comment '분해온도-출처'")
  private String aq5Ref;
  @Column(name = "aq6_other", columnDefinition = "varchar(500) comment '분해온도-비고'")
  private String aq6Other;  //추가

  @Column(name = "ar1_data1", columnDefinition = "varchar(100) comment '점도-값1'")
  private String ar1Data1;
  @Column(name = "ar2_unit1", columnDefinition = "varchar(100) comment '점도-단위1'")
  private String ar2Unit1;
  @Column(name = "ar3_ref1", columnDefinition = "varchar(100) comment '점도-출처1'")
  private String ar3Ref1;
  @Column(name = "ar4_data2", columnDefinition = "varchar(100) comment '점도-동점도값'")
  private String ar4Data2;
  @Column(name = "ar5_unit2", columnDefinition = "varchar(100) comment '점도-동점도 단위'")
  private String ar5Unit2;
  @Column(name = "ar6_temper", columnDefinition = "varchar(100) comment '점도-동점도 온도'")
  private String ar6Temper;
  @Column(name = "ar7_ref2", columnDefinition = "varchar(100) comment '점도-동점도 출처2'")
  private String ar7Ref2;
  @Column(name = "ar8_other", columnDefinition = "varchar(500) comment '점도-비고'")
  private String ar8Other;  //추가

  @Column(name = "as1_data", columnDefinition = "varchar(100) comment '분자량-값'")
  private String as1Data;
  @Column(name = "as2_ref", columnDefinition = "varchar(100) comment '분자량-출처'")
  private String as2Ref;
  @Column(name = "as3_other", columnDefinition = "varchar(500) comment '분자량-비고'")
  private String as3Other;  //추가

  public void setProductMatter(ProductMatter productMatter) {
    this.productMatter = productMatter;
  }

  public static ProductMatterPhyscChem toEntity(MatterPhyscChemDTO matterPhyscChemDTO) {
    return ModelMapperUtils.getModelMapper().map(matterPhyscChemDTO, ProductMatterPhyscChem.class);
  }

}
