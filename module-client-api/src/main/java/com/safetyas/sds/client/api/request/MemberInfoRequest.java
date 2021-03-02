package com.safetyas.sds.client.api.request;

import com.safetyas.sds.common.model.MemberInfoDTO;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MemberInfoRequest implements Serializable {

  private static final long serialVersionUID = -7248261417811317900L;

  @ApiModelProperty(value = "멤버 시퀀스")
  private Long memberSeq;

  @NotEmpty
  @Size(min = 2, max = 20)
  @ApiModelProperty(value = "멤버 아이디")
  private String memberId;

  @NotEmpty
  @Size(min = 2, max = 50)
  @ApiModelProperty(value = "비밀번호")
  private String pwd;

  @NotEmpty
  @Size(min = 2, max = 50)
  @ApiModelProperty(value = "회사이름")
  private String companyName;

  @NotEmpty
  @Size(min = 2, max = 20)
  @ApiModelProperty(value = "사업자번호")
  private String companyNumber;

  @NotEmpty
  @Size(min = 2, max = 100)
  @ApiModelProperty(value = "주소1")
  private String addr1;

  @NotEmpty
  @Size(min = 2, max = 100)
  @ApiModelProperty(value = "주소2")
  private String addr2;

  @NotEmpty
  @Size(min = 2, max = 20)
  @ApiModelProperty(value = "담당자 부서")
  private String managerDept;

  @NotEmpty
  @Size(min = 2, max = 20)
  @ApiModelProperty(value = "담당자 직책")
  private String managerPosition;

  @NotEmpty
  @Size(min = 2, max = 20)
  @ApiModelProperty(value = "담당자 이름")
  private String managerName;

  @NotEmpty
  @Size(min = 2, max = 50)
  @ApiModelProperty(value = "담당자 이메일")
  private String managerEmail;

  @NotEmpty
  @Size(min = 2, max = 20)
  @ApiModelProperty(value = "전화번호1")
  private String phone1;

  @Size(max = 20)
  @ApiModelProperty(value = "전화번호2")
  private String phone2;

  @Size(max = 20)
  @ApiModelProperty(value = "뉴스레터 여부")
  private String newsletterYn;

  @Size(max = 50)
  @ApiModelProperty(value = "가입경로")
  private String joinRoute;

  @Size(max = 20)
  @ApiModelProperty(value = "컨설팅 여부")
  private String consultingYn;

  @Size(max = 20)
  @ApiModelProperty(value = "MSDS 이용약관 동의")
  private String msdsTermsYn;

  @Size(max = 20)
  @ApiModelProperty(value = "개인정보 취급방침 동의")
  private String privateTermsYn;

  private MultipartFile companyCertificate;

  public MemberInfoDTO toMemberInfoDTO() {
    return MemberInfoDTO.builder()
        .memberSeq(this.memberSeq)
        .memberId(this.memberId)
        .pwd(this.pwd)
        .companyName(this.companyName)
        .companyNumber(this.companyNumber)
        .addr1(this.addr1)
        .addr2(this.addr2)
        .managerDept(this.managerDept)
        .managerPosition(this.managerPosition)
        .managerName(this.managerName)
        .managerEmail(this.managerEmail)
        .phone1(this.phone1)
        .phone2(this.phone2)
        .newsletterYn(this.newsletterYn)
        .joinRoute(this.joinRoute)
        .consultingYn(this.getConsultingYn())
        .msdsTermsYn(this.msdsTermsYn)
        .privateTermsYn(this.privateTermsYn)
        .build();
  }
}
