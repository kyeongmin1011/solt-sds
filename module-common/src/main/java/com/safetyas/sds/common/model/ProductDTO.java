package com.safetyas.sds.common.model;

import com.querydsl.core.annotations.QueryProjection;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
public class ProductDTO extends CommonDTO implements Serializable {

  private static final long serialVersionUID = 2684568000494080226L;

  private Long productSeq;
  private String productUid;
  private String msds;
  private String language;
  private String writer;
  private String writerEmail;
  private String tonsYear;
  private String submissionYn;
  private String orYn;
  private String agencySubmissionYn;
  private String agencyTranslateYn;
  private String agencyRevisionYn;
  private String agencyOrYn;
  private String agencyCbiYn;
  private String agencyRenewYn;
  private LocalDate validStart;
  private LocalDate validFinish;
  private String finalSaveYn;
  private String agencyCbiType;
  private String agencyCbiDocYn;
  private String revisionLanguage;
  private String translationLanguage;
  private String remark;

  private Long memberSupplierSeq;

  private String casList;

  private List<CbiAgencyDTO> cbiAgencyList = new ArrayList<>();
  private List<ProductMatterDTO> productMatterList = new ArrayList<>();
  private List<FileDTO> fileList = new ArrayList<>();

  @QueryProjection
  public ProductDTO(LocalDateTime inDate, Long productSeq, String productUid, String finalSaveYn,
      String language,
      String agencyTranslateYn, String agencyRevisionYn, String tonsYear, String agencySubmissionYn,
      String agencyCbiDocYn, String orYn,String casList) {
    super(inDate);
    this.productSeq = productSeq;
    this.productUid = productUid;
    this.finalSaveYn = finalSaveYn;
    this.language = language;
    this.agencyTranslateYn = agencyTranslateYn;
    this.agencyRevisionYn = agencyRevisionYn;
    this.tonsYear = tonsYear;
    this.agencySubmissionYn = agencySubmissionYn;
    this.agencyCbiDocYn = agencyCbiDocYn;
    this.orYn = orYn;
    this.casList = casList;
  }
}