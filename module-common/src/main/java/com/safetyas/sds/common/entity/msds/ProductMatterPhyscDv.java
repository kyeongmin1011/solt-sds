package com.safetyas.sds.common.entity.msds;

import com.safetyas.sds.common.model.msds.MatterPhyscDvDTO;
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
@Table(name = "sds_product_matter_physc_dv")
public class ProductMatterPhyscDv implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_matter_physc_dv_seq", length = 20)
  private Long productMatterPhyscDvSeq;

  @OneToOne(mappedBy = "productMatterPhyscDv", fetch = FetchType.LAZY)
  private ProductMatter productMatter;

  //------------------------------------------------------------- 구분그룹 2 물리화학위험성 구분

  @Column(name = "division_a01", columnDefinition = "varchar(100) comment '폭발성물질 구분'")
  private String divisionA01;
  @Column(name = "division_a02", columnDefinition = "varchar(100) comment '인화성 가스 구분'")
  private String divisionA02;
  @Column(name = "division_a03", columnDefinition = "varchar(100) comment '인화성 가스 불안정 구분'")
  private String divisionA03;
  @Column(name = "division_a04", columnDefinition = "varchar(100) comment '인화성 가스 자연발화성 구분'")
  private String divisionA04;
  @Column(name = "division_a05", columnDefinition = "varchar(100) comment '인화성 에어로졸 구분'")
  private String divisionA05;
  @Column(name = "division_a06", columnDefinition = "varchar(100) comment '산화성 가스 구분'")
  private String divisionA06;
  @Column(name = "division_a07", columnDefinition = "varchar(100) comment '고압가스 구분'")
  private String divisionA07;
  @Column(name = "division_a08", columnDefinition = "varchar(100) comment '인화성 액체 구분'")
  private String divisionA08;
  @Column(name = "division_a09", columnDefinition = "varchar(100) comment '인화성 고체 구분'")
  private String divisionA9;
  @Column(name = "division_a10", columnDefinition = "varchar(100) comment '자기반응성 물질 및 혼합물 구분'")
  private String divisionA10;
  @Column(name = "division_a11", columnDefinition = "varchar(100) comment '자연발화성 액체 구분'")
  private String divisionA11;
  @Column(name = "division_a12", columnDefinition = "varchar(100) comment '자연발화성 고체 구분'")
  private String divisionA12;
  @Column(name = "division_a13", columnDefinition = "varchar(100) comment '자기발열성 물질 및 혼합물 구분'")
  private String divisionA13;
  @Column(name = "division_a14", columnDefinition = "varchar(100) comment '물반응성 물질 및 혼합물 구분'")
  private String divisionA14;
  @Column(name = "division_a15", columnDefinition = "varchar(100) comment '산화성 액체 구분'")
  private String divisionA15;
  @Column(name = "division_a16", columnDefinition = "varchar(100) comment '산화성 고체 구분'")
  private String divisionA16;
  @Column(name = "division_a17", columnDefinition = "varchar(100) comment '유기과산화물 구분'")
  private String divisionA17;
  @Column(name = "division_a18", columnDefinition = "varchar(100) comment '금속부식성 물질 구분'")
  private String divisionA18;
  @Column(name = "division_a19", columnDefinition = "varchar(100) comment '둔감폭발물 구분'")
  private String divisionA19;

  public void setProductMatter(ProductMatter productMatter) {
    this.productMatter = productMatter;
  }

  public static ProductMatterPhyscDv toEntity(MatterPhyscDvDTO matterPhyscDvDTO) {
    return ModelMapperUtils.getModelMapper().map(matterPhyscDvDTO, ProductMatterPhyscDv.class);
  }
}
