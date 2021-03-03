package com.safetyas.sds.client.api.request;

import com.safetyas.sds.common.entity.msds.Product;
import java.io.Serializable;
import java.time.LocalDate;
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
public class ProductRequest implements Serializable {

  private static final long serialVersionUID = -2955772011267318801L;

  private String productUid;
  private String writer;
  private String writerEmail;
  private String tonsYear;
  private String language;
  private String remark;
  private String submissionYn;
  private String orYn;
  private String msds;
  private LocalDate validStart;
  private LocalDate validFinish;

  private Long memberSupplierSeq;

  public Product toEntity() {
    return Product.builder()
        .productUid(this.productUid)
        .writer(this.writer)
        .writerEmail(this.writerEmail)
        .tonsYear(this.tonsYear)
        .language(this.language)
        .remark(this.remark)
        .submissionYn(this.submissionYn)
        .orYn(this.orYn)
        .msds(this.msds)
        .validStart(this.validStart)
        .validFinish(this.validFinish)
        .build();

  }
}
