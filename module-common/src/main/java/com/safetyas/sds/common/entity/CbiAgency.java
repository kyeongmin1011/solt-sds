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
@Table(name = "sds_cbi_agency")
public class CbiAgency extends CommonEntity implements Serializable {

  @Builder
  public CbiAgency(Product product, Long cbiAgencySeq, String state, String note,
      LocalDateTime inDate, LocalDateTime modDate, LocalDateTime delDate) {
    super(inDate, modDate, delDate);
    setProduct(product);
    this.cbiAgencySeq = cbiAgencySeq;
    this.state = state;
    this.note = note;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cbi_agency_seq")
  private Long cbiAgencySeq;

  @Column(name = "state", columnDefinition = "varchar(100) comment '상태'")
  private String state;

  @Column(name = "note", columnDefinition = "varchar(255) comment '설명메모'")
  private String note;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "product_seq", foreignKey = @ForeignKey(name = "product_seq_cbi_agency_fk"))
  private Product product;

  public void setProduct(Product product) {
    if (this.product != null) {
      this.product.getCbiAgencyList().remove(this);
    }
    this.product = product;
    product.getCbiAgencyList().add(this);
  }
}
