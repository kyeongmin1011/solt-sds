package com.safetyas.sds.common.model;

import java.io.Serializable;
import java.time.LocalDate;
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
public class ProductDTO implements Serializable {

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

  private List<CbiAgencyDTO> cbiAgencyList = new ArrayList<>();
}
