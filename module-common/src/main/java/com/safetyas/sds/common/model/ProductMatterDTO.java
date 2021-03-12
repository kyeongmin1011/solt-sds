package com.safetyas.sds.common.model;

import com.safetyas.sds.common.entity.msds.ProductMatter;
import com.safetyas.sds.common.modelMapper.CustomModelMapper;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class ProductMatterDTO implements Serializable {

  private static final long serialVersionUID = -2855176401095936738L;
  private static ModelMapper modelMapper;

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
/*    return ProductMatter.builder()
        .cas(this.cas)
        .otherNumber(this.otherNumber)
        .chemName(this.chemName)
        .contentRate(this.contentRate)
        .alterContentYn(this.alterContentYn)
        .alterMatterName(this.alterMatterName)
        .alterContentRate(this.alterContentRate)
        .alterNo(this.alterNo)
        .validStart(this.validStart)
        .validFinish(this.validFinish)
        .build();*/
    return modelMapper.map(productMatterDTO, ProductMatter.class);
  }
}
