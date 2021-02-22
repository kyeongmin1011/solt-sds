package com.safetyas.sds.common.model;

import com.safetyas.sds.common.entity.MemberSupplier;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductMatterDTO implements Serializable {

  private static final long serialVersionUID = -2855176401095936738L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_matter_seq", nullable = false)
  private Long productMatterSeq;

  @Column(name = "cas", nullable = false)
  private String cas;

  @Column(name = "matter_name", nullable = false)
  private String matterName;

  @Column(name = "ke_number", nullable = false)
  private String keNumber;

  @Column(name = "content_rate", nullable = false)
  private Long contentRate;

  @Column(name = "alter_matter_name", nullable = false)
  private String alterMatterName;

  @Column(name = "alter_content_rate", nullable = false)
  private Long alterContentRate;

  @Column(name = "premium_db_yn", nullable = false)
  private String premiumDbYn;

  @Column(name = "alter_content_yn", nullable = false)
  private String alterContentYn;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "member_supplier_seq", foreignKey = @ForeignKey(name = "member_supplier_seq_product__matter_fk"))
  private MemberSupplier memberSupplier;

}
