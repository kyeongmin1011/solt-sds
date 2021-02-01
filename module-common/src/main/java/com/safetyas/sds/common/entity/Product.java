package com.safetyas.sds.common.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "sds_product")
public class Product extends CommonEntity implements Serializable {

  @Builder
  public Product(Long productSeq, String productUid, String msds, String language, String writer,
      String writerEmail, String tonsYear, String submissionYn, String orYn, String agencySubmissionYn,
      String agencyTranslateYn, String agencyRevisionYn, String agencyOrYn, String agencyCbiYn,
      String agencyRenewYn, LocalDate validStart, LocalDate validFinish, String finalSaveYn,
      LocalDateTime inDate, LocalDateTime modDate, LocalDateTime delDate) {
    super(inDate, modDate, delDate);

  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_seq", nullable = false, length = 20)
  private Long productSeq;

  @Column(name = "product_uid", nullable = false, length = 100)
  private String productUid;

  @Column(name = "msds", length = 100)
  private String msds;

  @Column(name = "language", length = 100)
  private String language;

  @Column(name = "writer", length = 50)
  private String writer;

  @Column(name = "writer_email", length = 100)
  private String writerEmail;

  @Column(name = "tons_year", length = 100)
  private String tonsYear;

  @Column(name = "submission_yn", length = 1)
  private String submissionYn;

  @Column(name = "or_yn", length = 1)
  private String orYn;

  @Column(name = "agency_submission_yn", length = 1)
  private String agencySubmissionYn;

  @Column(name = "agency_translate_yn", length = 1)
  private String agencyTranslateYn;

  @Column(name = "agency_revision_yn", length = 1)
  private String agencyRevisionYn;

  @Column(name = "agency_or_yn", length = 1)
  private String agencyOrYn;

  @Column(name = "agency_cbi_yn", length = 1)
  private String agencyCbiYn;

  @Column(name = "agency_renew_yn", length = 1)
  private String agencyRenewYn;

  @Column(name = "valid_start")
  private LocalDate validStart;

  @Column(name = "valid_finish")
  private LocalDate validFinish;

  @Column(name = "final_save_yn", length = 1)
  private String finalSaveYn;
}
