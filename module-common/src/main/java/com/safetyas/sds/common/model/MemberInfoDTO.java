package com.safetyas.sds.common.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MemberInfoDTO implements Serializable {

  private static final long serialVersionUID = 2060749217879995896L;

  private Long memberSeq;
  private String memberId;
  private String pwd;
  private String companyName;
  private String companyNumber;
  private String addr1;
  private String addr2;
  private String managerDept;
  private String managerPosition;
  private String managerName;
  private String managerEmail;
  private String phone1;
  private String phone2;
  private String newsletterYn;
  private String joinRoute;
  private String consultingYn;
  private String msdsTermsYn;
  private String privateTermsYn;
  private String companyCertificate;
  private LocalDateTime memberValidStart;
  private LocalDateTime memberValidFinish;

  private FileDTO file;
}
