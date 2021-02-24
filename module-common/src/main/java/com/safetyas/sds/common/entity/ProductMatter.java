package com.safetyas.sds.common.entity;

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
public class ProductMatter {

  @Builder
  public ProductMatter(Long productMatterSeq, String premiumDbYn, String alterContentYn) {
    this.productMatterSeq = productMatterSeq;
    this.premiumDbYn = premiumDbYn;
    this.alterContentYn = alterContentYn;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_matter_seq")
  private Long productMatterSeq;

  @Column(name = "cas")
  private String cas;

  @Column(name = "matter_name")
  private String matterName;

  @Column(name = "ke_number")
  private String keNumber;

  @Column(name = "content_rate")
  private Long contentRate;

  @Column(name = "alter_matter_name")
  private String alterMatterName;

  @Column(name = "alter_content_rate")
  private Long alterContentRate;

  @Column(name = "premium_db_yn")
  private String premiumDbYn;

  @Column(name = "alter_content_yn")
  private String alterContentYn;

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
}
