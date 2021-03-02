package com.safetyas.sds.common.model;

import com.safetyas.sds.common.entity.ProductMatter;
import java.io.Serializable;
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

  private Long productMatterSeq;
  private String cas;
  private String matterName;
  private String keNumber;
  private Long contentRate;
  private String alterMatterName;
  private Long alterContentRate;
  private String premiumDbYn;
  private String alterContentYn;
  private MemberSupplierDTO memberSupplier;

  public ProductMatter toEntity() {
    return ProductMatter.builder()
        .cas(this.cas)
        .keNumber(this.keNumber)
        .matterName(this.matterName)
        .contentRate(this.contentRate)
        .alterContentYn(this.alterContentYn)
        .alterMatterName(this.alterMatterName)
        .alterContentRate(this.alterContentRate)
        .build();

  }
}
