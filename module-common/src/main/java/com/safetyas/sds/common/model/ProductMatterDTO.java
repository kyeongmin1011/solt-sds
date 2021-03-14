package com.safetyas.sds.common.model;

import com.safetyas.sds.common.entity.msds.ProductMatter;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
public class ProductMatterDTO implements Serializable {

  private static final long serialVersionUID = -2855176401095936738L;

  private Long productMatterSeq;
  private String cas;
  private String chemName;
  private String otherNumber;
  private Float contentRate;
  private String alterMatterName;
  private Float alterContentRate;
  private String alterNo;
  private LocalDate validStart;
  private LocalDate validFinish;
  private String premiumDbYn;
  private String alterContentYn;
  private MemberSupplierDTO memberSupplier;

  public static ProductMatter toEntity(ProductMatterDTO productMatterDTO) {
    return ProductMatter.builder()
          .cas(productMatterDTO.cas)
        .otherNumber(productMatterDTO.otherNumber)
        .chemName(productMatterDTO.chemName)
        .contentRate(productMatterDTO.contentRate)
        .alterContentYn(productMatterDTO.alterContentYn)
        .alterMatterName(productMatterDTO.alterMatterName)
        .alterContentRate(productMatterDTO.alterContentRate)
        .alterNo(productMatterDTO.alterNo)
        .validStart(productMatterDTO.validStart)
        .validFinish(productMatterDTO.validFinish)
        .build();
  }
}
