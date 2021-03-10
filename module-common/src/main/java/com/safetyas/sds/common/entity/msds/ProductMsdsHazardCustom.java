package com.safetyas.sds.common.entity.msds;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "sds_product_msds_hazard_custom") // 가능성이 높은 노출 경로에 관한 커스텀 정보 테이블
public class ProductMsdsHazardCustom {

  @Id
  @Column(name = "product_hazard_custom_seq", length = 20)
  private Long productHazardCustomSeq;

  @Column(name = "hazard_code", columnDefinition = "varchar(50) comment '유해코드'")
  private String hazardCode;

  @Column(name = "custom_phrase", columnDefinition = "varchar(500) comment '커스텀 문구'")
  private String customPhrase;

  @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
  @JoinColumn(name = "product_msds_seq", foreignKey = @ForeignKey(name = "product_msds_seq_hazard_custom_fk"))
  private ProductMsds productMsds;
}
