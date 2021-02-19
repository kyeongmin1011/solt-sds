package com.safetyas.sds.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberInfoDTO {

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



}
