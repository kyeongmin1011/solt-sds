package com.safetyas.sds.client.api.request;

import lombok.Data;

@Data
public class MemberInfoRequest {
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
}
