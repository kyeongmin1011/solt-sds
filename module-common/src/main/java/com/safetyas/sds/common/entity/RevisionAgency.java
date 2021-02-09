package com.safetyas.sds.common.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "sds_revision_agency")
public class RevisionAgency extends CommonEntity implements Serializable {

  @Builder
  public RevisionAgency(Product product, Long revisionAgencySeq, String state, String note,
      LocalDateTime inDate, LocalDateTime modDate, LocalDateTime delDate) {
    super(inDate, modDate, delDate);
    setProduct(product);
    this.revisionAgencySeq = revisionAgencySeq;
    this.state = state;
    this.note = note;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "revision_agency_seq")
  private Long revisionAgencySeq;

  @Column(name = "state")
  private String state;

  @Column(name = "note")
  private String note;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "product_seq", foreignKey = @ForeignKey(name = "product_seq_revision_agency_fk"))
  private Product product;

  public void setProduct(Product product) {
    if (this.product != null) {
      this.product.getRevisionAgencyList().remove(this);
    }
    this.product = product;
    product.getRevisionAgencyList().add(this);
  }

}
