package com.safetyas.sds.client.api.service;

import com.safetyas.sds.client.api.request.MemberInfoRequest;
import com.safetyas.sds.client.api.util.FileUtil;
import com.safetyas.sds.common.dto.FileDTO;
import com.safetyas.sds.common.entity.File;
import com.safetyas.sds.common.entity.Member;
import com.safetyas.sds.common.entity.MemberInfo;
import com.safetyas.sds.common.service.client.FileService;
import com.safetyas.sds.common.service.client.MemberService;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ClientMemberService {

  private final PasswordEncoder passwordEncoder;
  private final MemberService memberService;
  private final FileService fileService;
  private final FileUtil fileUtil;

  public Optional<Member> findByMemberId(String memberId) {
    return memberService.findByMemberId(memberId);
  }

  /**
   * 회원가입 멤버
   * @param memberInfoRequest MemberInfoRequest
   * @param file MultipartFile
   */
  public void saveJoinMember(MemberInfoRequest memberInfoRequest, MultipartFile file) {
    long memberSeq = saveMember(memberInfoRequest);
    if (file != null) {
      Map<String, Object> info = new HashMap<>();
      info.put("path", "companyCertificate");
      info.put("table", "sds_member");
      info.put("recordSeq", memberSeq);
      info.put("type", "companyCertificate"); //파일(문서 등) : ATTACH , 이미지 : IMAGE
      info.put("regUserSeq", memberSeq);
      // 첨부파일 등록
      FileDTO companyFile = fileUtil.parseFile(file, info);

      if (null != companyFile) {
        fileService.saveFile(companyFile);
      }
    }
  }

  /**
   * 멤버 저장
   * @param memberInfoRequest MemberInfoRequest
   */
  public long saveMember(MemberInfoRequest memberInfoRequest) {
    MemberInfo memberInfo = MemberInfo.builder()
        .companyName(memberInfoRequest.getCompanyName())
        .companyNumber(memberInfoRequest.getCompanyNumber())
        .companyAddr1(memberInfoRequest.getAddr1())
        .companyAddr2(memberInfoRequest.getAddr2())
        .managerDept(memberInfoRequest.getManagerDept())
        .managerPosition(memberInfoRequest.getManagerPosition())
        .managerName(memberInfoRequest.getManagerName())
        .managerEmail1(memberInfoRequest.getManagerEmail())
        .phone1(memberInfoRequest.getPhone1())
        .phone2(memberInfoRequest.getPhone2())
        .newsletterYn(memberInfoRequest.getNewsletterYn())
        .joinRoute(memberInfoRequest.getJoinRoute())
        .consultingYn(memberInfoRequest.getConsultingYn())
        .msdsTermsYn(memberInfoRequest.getMsdsTermsYn())
        .privateTermsYn(memberInfoRequest.getPrivateTermsYn())
        .build();

    Member member = Member.builder()
        .memberId(memberInfoRequest.getMemberId())
        .pwd(passwordEncoder.encode(memberInfoRequest.getPwd()))
        .role("USER")
        .level(1)
        .loginCount(1)
        .memberInfo(memberInfo)
        .build();
    return memberService.saveMember(member);
  }

  public void updateMemberInfo(MemberInfoRequest memberInfoRequest, MultipartFile file) {
    Member member = memberService.findByMemberId(memberInfoRequest.getMemberId()).orElseThrow(
        NoSuchElementException::new);
    member.updateMemberInfo(memberInfoRequest.toMemberInfoDTO());
    memberService.saveMember(member);

    if (file != null) {
      FileDTO fileDTO = FileDTO.builder()
          .relateTable("sds_member")
          .recordSeq(member.getMemberSeq())
          .type("companyCertificate")
          .build();
      File preFile = fileService.selectCompanyCertificate(fileDTO);
      fileUtil.deleteFile(preFile.getPath(), preFile.getName());

      Map<String, Object> info = new HashMap<>();
      info.put("path", "companyCertificate");
      info.put("table", "sds_member");
      info.put("recordSeq", member.getMemberSeq());
      info.put("type", "companyCertificate"); //파일(문서 등) : ATTACH , 이미지 : IMAGE
      info.put("regUserSeq", memberInfoRequest.getMemberSeq());
      // 첨부파일 등록
      FileDTO companyFile = fileUtil.parseFile(file, info);

      if (null != companyFile) {
        fileService.saveFile(companyFile);
      }
    }
  }
}
