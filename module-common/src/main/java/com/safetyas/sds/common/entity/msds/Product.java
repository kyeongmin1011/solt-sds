package com.safetyas.sds.common.entity.msds;

import com.safetyas.sds.common.entity.CbiDocument;
import com.safetyas.sds.common.entity.CommonEntity;
import com.safetyas.sds.common.entity.MemberSupplier;
import com.safetyas.sds.common.entity.agency.CbiAgency;
import com.safetyas.sds.common.entity.agency.OrAgency;
import com.safetyas.sds.common.entity.agency.RenewAgency;
import com.safetyas.sds.common.entity.agency.RevisionAgency;
import com.safetyas.sds.common.entity.agency.SubmissionAgency;
import com.safetyas.sds.common.entity.agency.TranslationAgency;
import com.safetyas.sds.common.model.ProductDTO;
import com.safetyas.sds.common.model.TranslationAgencyRequestInfoDTO;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

  private static final long serialVersionUID = 7233544716870913503L;

  @Builder
  public Product(Long productSeq, String productUid, String msds, String language, String writer,
      String writerEmail, String tonsYear, String submissionYn, String orYn,
      String agencySubmissionYn,
      String agencyTranslateYn, String agencyRevisionYn, String agencyOrYn, String agencyCbiYn,
      String agencyRenewYn, LocalDate validStart, LocalDate validFinish, String finalSaveYn,
      String agencyCbiType, String agencyCbiDocYn, String remark,
      LocalDateTime inDate, LocalDateTime modDate,
      LocalDateTime delDate) {
    super(inDate, modDate, delDate);
    this.productSeq = productSeq;
    this.productUid = productUid;
    this.msds = msds;
    this.language = language;
    this.writer = writer;
    this.writerEmail = writerEmail;
    this.tonsYear = tonsYear;
    this.submissionYn = submissionYn;
    this.orYn = orYn;
    this.agencySubmissionYn = agencySubmissionYn;
    this.agencyTranslateYn = agencyTranslateYn;
    this.agencyRevisionYn = agencyRevisionYn;
    this.agencyOrYn = agencyOrYn;
    this.agencyCbiYn = agencyCbiYn;
    this.agencyRenewYn = agencyRenewYn;
    this.validStart = validStart;
    this.validFinish = validFinish;
    this.finalSaveYn = finalSaveYn;
    this.agencyCbiType = agencyCbiType;
    this.agencyCbiDocYn = agencyCbiDocYn;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_seq", nullable = false, length = 20)
  private Long productSeq;

  @Column(name = "product_uid", length = 100)
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

  @Column(name = "agency_cbi_type", length = 50)
  private String agencyCbiType;

  @Column(name = "agency_cbi_doc_yn", length = 1)
  private String agencyCbiDocYn;

  @Column(name = "revision_language", length = 50)
  private String revisionLanguage;

  @Column(name = "translation_language", length = 50)
  private String translationLanguage;

  @Column(name = "substitute_data_agency_yn")
  private String substituteDataAgencyYn;

  @Column(name = "remark")
  private String remark;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "member_supplier_seq", foreignKey = @ForeignKey(name = "member_supplier_seq_product_fk"))
  private MemberSupplier memberSupplier;

  @OneToMany(mappedBy = "product")
  private List<CbiAgency> cbiAgencyList = new ArrayList<>();

  @OneToMany(mappedBy = "product")
  private List<OrAgency> orAgencyList = new ArrayList<>();

  @OneToMany(mappedBy = "product")
  private List<TranslationAgency> translationAgencyList = new ArrayList<>();

  @OneToMany(mappedBy = "product")
  private List<RevisionAgency> revisionAgencyList = new ArrayList<>();

  @OneToMany(mappedBy = "product")
  private List<SubmissionAgency> submissionAgencyList = new ArrayList<>();

  @OneToMany(mappedBy = "product")
  private List<RenewAgency> renewAgencyList = new ArrayList<>();

  @OneToMany(mappedBy = "product")
  private List<ProductMatter> productMatterList = new ArrayList<>();

  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "cbi_document_seq")
  private CbiDocument cbiDocument;

  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "product_msds_seq", foreignKey = @ForeignKey(name = "product_msds_seq_product_fk"))
  private ProductMsds productMsds;

  public void updateMemberSupplier(MemberSupplier memberSupplier) {
    if (this.memberSupplier != null) {
      this.memberSupplier.getProductList().remove(this);
    }
    this.memberSupplier = memberSupplier;
    memberSupplier.getProductList().add(this);
  }


  public void updateProductInfo(ProductDTO productDTO) {
    this.productUid = productDTO.getProductUid();
    this.writer = productDTO.getWriter();
    this.writerEmail = productDTO.getWriterEmail();
    this.tonsYear = productDTO.getTonsYear();
    this.language = productDTO.getLanguage();
    this.remark = productDTO.getRemark();
    this.submissionYn = productDTO.getSubmissionYn();
    this.orYn = productDTO.getOrYn();
    this.msds = productDTO.getMsds();
    this.validStart = productDTO.getValidStart();
    this.validFinish = productDTO.getValidFinish();
  }

  public void updateProductCbiAgency(ProductDTO productDTO) {
    this.agencyCbiType = productDTO.getAgencyCbiType();
    this.agencyCbiDocYn = productDTO.getAgencyCbiDocYn();
  }

  public void updateCbiDocument(CbiDocument cbiDocument) {
    this.cbiDocument = cbiDocument;
  }

  public void updateProductTranslation(
      TranslationAgencyRequestInfoDTO translationAgencyRequestInfoDTO) {
    this.translationLanguage = translationAgencyRequestInfoDTO.getTranslationLanguage();
  }

  public void updateAgencyCbiDocYnAndSubstituteDataAgencyYn(String agencyCbiDocYn,
      String substituteDataAgencyYn) {
    this.agencyCbiDocYn = agencyCbiDocYn;
    this.substituteDataAgencyYn = substituteDataAgencyYn;
  }

  public void updateRevisionLanguage(String revisionLanguage) {
    this.revisionLanguage = revisionLanguage;
  }
}
