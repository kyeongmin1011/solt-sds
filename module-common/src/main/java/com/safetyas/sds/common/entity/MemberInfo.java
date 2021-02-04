package com.safetyas.sds.common.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "sds_member_info")
public class MemberInfo extends CommonEntity implements Serializable {

  @Builder
  public MemberInfo(Long memberInfoSeq, String companyName, String companyNumber, String companyAddr1,
      String companyAddr2, String managerDept, String managerPosition, String managerName, String managerEmail1,
      String managerEmail2, String phone1, String phone2, String newsletterYn, String joinRoute, String consultingYn,
      String msdsTermsYn, String privateTermsYn,
      LocalDateTime inDate, LocalDateTime modDate, LocalDateTime delDate) {
    super(inDate, modDate, delDate);
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_info_seq", nullable = false, length = 20)
  private Long memberInfoSeq;

  @Column(name = "company_name", length = 100)
  private String companyName; // 회사이름

  @Column(name = "company_number", length = 100)
  private String companyNumber; // 사업자번호

  @Column(name = "company_addr1", length = 500)
  private String companyAddr1;  // 회사주소1

  @Column(name = "company_addr2", length = 500)
  private String companyAddr2; // 회사주소2

  @Column(name = "manager_dept", length = 100)
  private String managerDept; // 담당자 부서

  @Column(name = "manager_position", length = 100)
  private String managerPosition; // 담당자 직급

  @Column(name = "manager_name", length = 100)
  private String managerName; // 담당자 이름

  @Column(name = "manager_email1", length = 100)
  private String managerEmail1; // 담당자 메일1

  @Column(name = "manager_email2", length = 100)
  private String managerEmail2; // 담당자 메일2

  @Column(name = "phone1", length = 100)
  private String phone1;  // 전화번호1

  @Column(name = "phone2", length = 100)
  private String phone2;  // 전화번호2

  @Column(name = "newsletter_yn", length = 1)
  private String newsletterYn;  // 뉴스레터 수신여부

  @Column(name = "join_route", length = 100)
  private String joinRoute;  // 가입경로

  @Column(name = "consulting_yn", length = 1)
  private String consultingYn;  // 컨설팅 여부

  @Column(name = "msds_terms_yn", length = 1)
  private String msdsTermsYn; // MSDS 이용약관 동의 여부

  @Column(name = "private_terms_yn", length = 1)
  private String privateTermsYn;  // 개인정보 취급방침

  @Column(name = "member_valid_start")
  private LocalDateTime memberValidStart; // 계약시작일

  @Column(name = "member_valid_finish")
  private LocalDateTime memberValidFinish; // 계약종료일

  @JsonManagedReference
  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "member_seq", foreignKey = @ForeignKey(name = "member_seq_member_info_fk"))
  private Member member;

}
