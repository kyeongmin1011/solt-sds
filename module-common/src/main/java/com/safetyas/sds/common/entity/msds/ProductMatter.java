package com.safetyas.sds.common.entity.msds;

import com.safetyas.sds.common.entity.CommonEntity;
import com.safetyas.sds.common.entity.MemberSupplier;
import com.safetyas.sds.common.model.ProductMatterDTO;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "sds_product_matter")
public class ProductMatter extends CommonEntity {

  @Builder
  public ProductMatter(String cas, String otherNumber, String chemName, Float contentRate,
      String alterContentYn, String alterMatterName, Float alterContentRate) {
    this.cas = cas;
    this.otherNumber = otherNumber;
    this.chemName = chemName;
    this.contentRate = contentRate;
    this.alterContentYn = alterContentYn;
    this.alterMatterName = alterMatterName;
    this.alterContentRate = alterContentRate;
  }

/*  @Builder
  public ProductMatter(Long productMatterSeq, String premiumDbYn, String alterContentYn) {
    this.productMatterSeq = productMatterSeq;
    this.premiumDbYn = premiumDbYn;
    this.alterContentYn = alterContentYn;
  }*/

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_matter_seq")
  private Long productMatterSeq;

  @Column(name = "cas", columnDefinition = "varchar(50) comment '카스번호'")
  private String cas;

  @Column(name = "chem_name", columnDefinition = "varchar(500) comment '물질명'")
  private String chemName;

  @Column(name = "other_number", columnDefinition = "varchar(50) comment '다른고유번호'")
  private String otherNumber;

  @Column(name = "content_rate", columnDefinition = "float(12) comment '함유율'")
  private Float contentRate;

  @Column(name = "alter_matter_name", columnDefinition = "varchar(500) comment '대체물질명'")
  private String alterMatterName;

  @Column(name = "alter_content_rate", columnDefinition = "float(12) comment '대체함유율'")
  private Float alterContentRate;

  @Column(name = "alter_content_yn", columnDefinition = "varchar(1) comment '대체명칭 신청여부'")
  private String alterContentYn;

  @Column(name = "premium_db_yn", columnDefinition = "varchar(1) comment '프리미엄디비여부'")
  private String premiumDbYn;

  @Column(name = "matter_database_seq", length = 20)
  private Long matterDatabaseSeq;  // 참조 물질디비시퀀스

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "member_supplier_seq", foreignKey = @ForeignKey(name = "member_supplier_seq_product_matter_fk"))
  private MemberSupplier memberSupplier;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "product_seq", foreignKey = @ForeignKey(name = "product_seq_product_matter_fk"))
  private Product product;

  public void updateProduct(Product product) {
    if (this.product != null) {
      this.product.getProductMatterList().remove(this);
    }
    this.product = product;
    product.getProductMatterList().add(this);
  }

  public void updateAlterContentYn(String alterContentYn) {
    this.alterContentYn = alterContentYn;
  }

  public void updateProductMatter(ProductMatterDTO productMatterDTO) {
    this.cas = productMatterDTO.getCas();
    this.otherNumber = productMatterDTO.getOtherNumber();
    this.chemName = productMatterDTO.getChemName();
    this.contentRate = productMatterDTO.getContentRate();
    this.alterContentYn = productMatterDTO.getAlterContentYn();
    this.alterMatterName = productMatterDTO.getAlterMatterName();
    this.alterContentRate = productMatterDTO.getAlterContentRate();
  }
}
