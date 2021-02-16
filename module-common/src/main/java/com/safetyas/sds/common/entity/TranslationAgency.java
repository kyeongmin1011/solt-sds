package com.safetyas.sds.common.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@Table(name = "sds_translation_agency")
public class TranslationAgency extends CommonEntity implements Serializable {

  @Builder
  public TranslationAgency(Product product, Long translationAgencySeq, String state, String note,
      LocalDateTime inDate, LocalDateTime modDate, LocalDateTime delDate) {
    super(inDate, modDate, delDate);
    this.translationAgencySeq = translationAgencySeq;
    this.state = state;
    this.note = note;
    setProduct(product);
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "translation_agency_seq")
  private Long translationAgencySeq;

  @Column(name = "state")
  private String state;

  @Column(name = "note")
  private String note;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "product_seq", foreignKey = @ForeignKey(name = "product_seq_translation_agency_fk"))
  private Product product;

  public void setProduct(Product product) {
    if (this.product != null) {
      this.product.getTranslationAgencyList().remove(this);
    }
    this.product = product;
    product.getTranslationAgencyList().add(this);
  }
}
