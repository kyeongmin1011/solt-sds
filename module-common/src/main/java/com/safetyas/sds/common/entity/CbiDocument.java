package com.safetyas.sds.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "sds_cbi_document")
@Builder
public class CbiDocument {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cbi_document_seq")
  private Long cbiDocumentSeq;

  @Column(name = "non_knowledge")
  private String nonKnowledge;

  @Column(name = "confidentiality")
  private String confidentiality;

  @Column(name = "economic_usefulness")
  private String economicUsefulness;

  @OneToOne(mappedBy = "cbiDocument", fetch = FetchType.LAZY)
  private Product product;
}
