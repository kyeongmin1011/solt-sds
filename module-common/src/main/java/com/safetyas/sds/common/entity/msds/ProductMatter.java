package com.safetyas.sds.common.entity.msds;

import com.safetyas.sds.common.entity.CommonEntity;
import com.safetyas.sds.common.entity.MemberSupplier;
import com.safetyas.sds.common.model.ProductMatterDTO;
import java.time.LocalDate;
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
import javax.persistence.OneToOne;
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
  public ProductMatter(Product product, String cas, String otherNumber, String chemName,
      Float contentRate, String alterNo, LocalDate validStart, LocalDate validFinish,
      String alterContentYn, String alterMatterName, Float alterContentRate,
      String premiumDbYn, String matterDatabaseKey) {
    updateProduct(product);
    this.cas = cas;
    this.otherNumber = otherNumber;
    this.chemName = chemName;
    this.contentRate = contentRate;
    this.alterContentYn = alterContentYn;
    this.alterMatterName = alterMatterName;
    this.alterContentRate = alterContentRate;
    this.alterNo = alterNo;
    this.validStart = validStart;
    this.validFinish = validFinish;
    this.premiumDbYn = premiumDbYn;
    this.matterDatabaseKey = matterDatabaseKey;
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

  @Column(name = "alter_no", columnDefinition = "varchar(50) comment '대체자료 승인번호'")
  private String alterNo;

  @Column(name = "valid_start", columnDefinition = "varchar(50) comment '대체자료 유효기간 시작'")
  private LocalDate validStart;

  @Column(name = "valid_finish", columnDefinition = "varchar(50) comment '대체자료 유효기간 끝'")
  private LocalDate validFinish;

  @Column(name = "alter_content_yn", columnDefinition = "varchar(1) comment '대체명칭 신청여부'")
  private String alterContentYn;

  @Column(name = "premium_db_yn", columnDefinition = "varchar(1) comment '프리미엄디비여부'")
  private String premiumDbYn;

  @Column(name = "matter_database_key", length = 20)
  private String matterDatabaseKey;  // 참조 물질디비시퀀스

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "member_supplier_seq", foreignKey = @ForeignKey(name = "member_supplier_seq_product_matter_fk"))
  private MemberSupplier memberSupplier;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "product_seq", foreignKey = @ForeignKey(name = "product_seq_product_matter_fk"))
  private Product product;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "matter_data_key", foreignKey = @ForeignKey(name = "matter_data_key_product_matter_fk"))
  private MatterData matterData;

  @OneToOne(mappedBy = "productMatter", fetch = FetchType.LAZY)
  private ProductMatterPhyscChem productMatterPhyscChem;

  @OneToOne(mappedBy = "productMatter", fetch = FetchType.LAZY)
  private ProductMatterHealth productMatterHealth;

  @OneToOne(mappedBy = "productMatter", fetch = FetchType.LAZY)
  private ProductMatterEnv productMatterEnv;

  @OneToOne(mappedBy = "productMatter", fetch = FetchType.LAZY)
  private ProductMatterLaw productMatterLaw;

  @OneToOne(mappedBy = "productMatter", fetch = FetchType.LAZY)
  private ProductMatterPhyscDv productMatterPhyscDv;

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
    this.alterNo = productMatterDTO.getAlterNo();
    this.validStart = productMatterDTO.getValidStart();
    this.validFinish = productMatterDTO.getValidFinish();
  }


}
