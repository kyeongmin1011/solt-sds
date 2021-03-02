package com.safetyas.sds.common.entity.agency;

import com.safetyas.sds.common.entity.CommonEntity;
import com.safetyas.sds.common.entity.msds.Product;
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
@Table(name = "sds_renew_agency")
public class RenewAgency extends CommonEntity implements Serializable {

  @Builder
  public RenewAgency(Product product, Long renewAgencySeq, String state, String note,
      LocalDateTime inDate, LocalDateTime modDate, LocalDateTime delDate) {
    super(inDate, modDate, delDate);
    setProduct(product);
    this.renewAgencySeq = renewAgencySeq;
    this.state = state;
    this.note = note;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "renew_agency_seq")
  private Long renewAgencySeq;

  @Column(name = "state")
  private String state;

  @Column(name = "note")
  private String note;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "product_seq", foreignKey = @ForeignKey(name = "product_seq_renew_agency_fk"))
  private Product product;

  public void setProduct(Product product) {
    if (this.product != null) {
      this.product.getRenewAgencyList().remove(this);
    }
    this.product = product;
    product.getRenewAgencyList().add(this);
  }
}
