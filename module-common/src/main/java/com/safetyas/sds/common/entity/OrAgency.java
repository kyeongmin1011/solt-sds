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
@Table(name = "sds_or_agency")
public class OrAgency extends CommonEntity implements Serializable {

  @Builder
  public OrAgency(Product product, Long orAgencySeq, String state, String note,
      LocalDateTime inDate, LocalDateTime modDate, LocalDateTime delDate) {
    super(inDate, modDate, delDate);
    setProduct(product);
    this.orAgencySeq = orAgencySeq;
    this.state = state;
    this.note = note;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "or_agency_seq")
  private Long orAgencySeq;

  @Column(name = "state")
  private String state;

  @Column(name = "note")
  private String note;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "product_seq", foreignKey = @ForeignKey(name = "product_seq_or_agency_fk"))
  private Product product;

  public void setProduct(Product product) {
    if (this.product != null) {
      this.product.getOrAgencyList().remove(this);
    }
    this.product = product;
    product.getOrAgencyList().add(this);
  }
}
