package com.safetyas.sds.common.entity;

import java.io.Serializable;
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
@Table(name = "sds_member")
public class Member extends CommonEntity implements Serializable {

  @Builder
  public Member(Long memberSeq, Integer level, String role, String memberId, String pwd, String companyName, String companyAddr1,
      String companyAddr2, String managerDept, String managerPosition, String managerName, String managerEmail1,
      String managerEmail2, String phone1, String phone2, String newsletterYn, String joinRoute, String consultingYn,
      String msdsTermsYn, String privateTermsYn, LocalDateTime loginLast, Integer loginCount, LocalDateTime inDate,
      LocalDateTime modDate, LocalDateTime delDate) {
    super();
    this.memberSeq = memberSeq;
    this.level = level;
    this.role = role;
    this.memberId = memberId;
    this.pwd = pwd;
    this.companyName = companyName;
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
    this.loginLast = loginLast;
    this.loginCount = loginCount;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_seq", nullable = false, length = 20)
  private Long memberSeq;  // 멤버 시퀀스

  @Column(name = "level", length = 10)
  private Integer level;  // 멤버 레벨

  @Column(name = "role", length = 100)
  private String role;  // 멤버 롤

  @Column(name = "member_id", length = 50)
  private String memberId;  // 아이디

  @Column(name = "pwd", length = 100)
  private String pwd; // 패스워드

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

  @Column(name = "login_last")
  private LocalDateTime loginLast;  // 마지막 로그인

  @Column(name = "login_count", length = 10)
  private Integer loginCount;  // 로그인 횟수

}
