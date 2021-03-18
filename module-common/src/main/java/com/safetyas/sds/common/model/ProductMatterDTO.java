package com.safetyas.sds.common.model;

import com.querydsl.core.annotations.QueryProjection;
import com.safetyas.sds.common.entity.msds.ProductMatter;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductMatterDTO extends CommonDTO implements Serializable {

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

  private String productUid;

  @QueryProjection
  public ProductMatterDTO(LocalDateTime inDate, LocalDateTime modDate, String productUid,
      String cas, String chemName, String premiumDbYn) {
    super(inDate, modDate);
    this.productUid = productUid;
    this.cas = cas;
    this.chemName = chemName;
    this.premiumDbYn = premiumDbYn;
  }

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
