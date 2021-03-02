package com.safetyas.sds.common.model;

import com.safetyas.sds.common.entity.msds.Product;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CbiAgencyProgressDTO extends CommonDTO implements Serializable {

  private static final long serialVersionUID = 7557719571080591937L;

  private Long productSeq;
  private LocalDate validStart;
  private LocalDate validFinish;
  private String msds;
  private List<CbiAgencyDTO> cbiAgencyList = new ArrayList<>();

  public void updateCbiAgencyInfo(Product product) {
    this.productSeq = product.getProductSeq();
    this.validStart = product.getValidStart();
    this.validFinish = product.getValidFinish();
    this.msds = product.getMsds();
  }
}