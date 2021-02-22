package com.safetyas.sds.common.entity;

import com.safetyas.sds.common.dto.MemberInfoDTO;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@Table(name = "sds_member_info")
public class MemberInfo extends CommonEntity implements Serializable {

  @Builder
  public MemberInfo(Long memberInfoSeq, String companyName, String companyNumber, String companyAddr1,
      String companyAddr2, String managerDept, String managerPosition, String managerName, String managerEmail1,
      String managerEmail2, String phone1, String phone2, String newsletterYn, String joinRoute, String consultingYn,
      Member member, String msdsTermsYn, String privateTermsYn,
      LocalDateTime inDate, LocalDateTime modDate, LocalDateTime delDate) {
    super(inDate, modDate, delDate);
    this.memberInfoSeq  = memberInfoSeq;
    this.companyName = companyName;
    this.companyNumber = companyNumber;
    this.companyAddr1 = companyAddr1;
    this.companyAddr2 = companyAddr2;
    this.managerDept = managerDept;
    this.managerPosition = managerPosition;
    this.managerName = managerName;
    this.managerEmail1 = managerEmail1;
    this.managerEmail2 = managerEmail2;
    this.phone1 = phone1;
    this.phone2 = phone2;
    this.newsletterYn = newsletterYn;
    this.joinRoute = joinRoute;
    this.consultingYn = consultingYn;
    this.msdsTermsYn = msdsTermsYn;
    this.privateTermsYn = privateTermsYn;
    setMember(member);
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_info_seq", nullable = false, length = 20)
  private Long memberInfoSeq;

  @Column(name = "company_name", columnDefinition = "varchar(100) comment '회사이름'")
  private String companyName; // 회사이름

  @Column(name = "company_number", columnDefinition = "varchar(100) comment '사업자번호'")
  private String companyNumber; // 사업자번호

  @Column(name = "company_addr1", columnDefinition = "varchar(500) comment '회사주소'")
  private String companyAddr1;  // 회사주소1

  @Column(name = "company_addr2", columnDefinition = "varchar(500) comment '회사주소2'")
  private String companyAddr2; // 회사주소2

  @Column(name = "manager_dept", columnDefinition = "varchar(100) comment '담당자 부서'")
  private String managerDept; // 담당자 부서

  @Column(name = "manager_position", columnDefinition = "varchar(100) comment '담당자 직급'")
  private String managerPosition; // 담당자 직급

  @Column(name = "manager_name", columnDefinition = "varchar(100) comment '담당자 이름'")
  private String managerName; // 담당자 이름

  @Column(name = "manager_email1", columnDefinition = "varchar(100) comment '담당자 메일1'")
  private String managerEmail1; // 담당자 메일1

  @Column(name = "manager_email2", columnDefinition = "varchar(100) comment '담당자 메일2'")
  private String managerEmail2; // 담당자 메일2

  @Column(name = "phone1", columnDefinition = "varchar(100) comment '전화번호'")
  private String phone1;  // 전화번호1

  @Column(name = "phone2", columnDefinition = "varchar(100) comment '전화번호2'")
  private String phone2;  // 전화번호2

  @Column(name = "newsletter_yn", columnDefinition = "varchar(1) comment '뉴스레터 수신여부'")
  private String newsletterYn;  // 뉴스레터 수신여부

  @Column(name = "join_route", columnDefinition = "varchar(50) comment '가입경로'")
  private String joinRoute;  // 가입경로

  @Column(name = "consulting_yn", columnDefinition = "varchar(1) comment '컨설팅 여부'")
  private String consultingYn;  // 컨설팅 여부

  @Column(name = "msds_terms_yn", columnDefinition = "varchar(1) comment 'MSDS 이용약관 동의 여부'")
  private String msdsTermsYn; // MSDS 이용약관 동의 여부

  @Column(name = "private_terms_yn", columnDefinition = "varchar(1) comment '개인정보 취급방침'")
  private String privateTermsYn;  // 개인정보 취급방침

  @Column(name = "member_valid_start", columnDefinition = "datetime comment '계약시작일'")
  private LocalDateTime memberValidStart; // 계약시작일

  @Column(name = "member_valid_finish", columnDefinition = "datetime comment '계약종료일'")
  private LocalDateTime memberValidFinish; // 계약종료일

  @OneToOne(mappedBy = "memberInfo", fetch = FetchType.LAZY)
  private Member member;

  public void setMember(Member member) {
    this.member = member;
    member.setMemberInfo(this);
  }

  public void updateMemberInfo(MemberInfoDTO memberInfoDTO) {
    this.companyName = memberInfoDTO.getCompanyName();
    this.companyNumber = memberInfoDTO.getCompanyNumber();
    this.companyAddr1 = memberInfoDTO.getAddr1();
    this.companyAddr2 = memberInfoDTO.getAddr2();
    this.managerDept = memberInfoDTO.getManagerDept();
    this.managerPosition = memberInfoDTO.getManagerPosition();
    this.managerName = memberInfoDTO.getManagerName();
    this.managerEmail1 = memberInfoDTO.getManagerEmail();
    this.phone1 = memberInfoDTO.getPhone1();
    this.phone2 = memberInfoDTO.getPhone2();
    this.newsletterYn = memberInfoDTO.getNewsletterYn();
    this.joinRoute = memberInfoDTO.getJoinRoute();
    this.consultingYn = memberInfoDTO.getConsultingYn();
    this.msdsTermsYn = memberInfoDTO.getMsdsTermsYn();
    this.privateTermsYn = memberInfoDTO.getPrivateTermsYn();
  }
}
