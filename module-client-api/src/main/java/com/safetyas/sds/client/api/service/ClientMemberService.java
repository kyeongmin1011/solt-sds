package com.safetyas.sds.client.api.service;

import com.safetyas.sds.client.api.exception.CustomUserNotFoundException;
import com.safetyas.sds.client.api.request.MemberInfoRequest;
import com.safetyas.sds.client.api.util.FileUtil;
import com.safetyas.sds.common.dto.FileDTO;
import com.safetyas.sds.common.dto.MemberInfoDTO;
import com.safetyas.sds.common.dto.MemberSupplierDTO;
import com.safetyas.sds.common.entity.File;
import com.safetyas.sds.common.entity.Member;
import com.safetyas.sds.common.entity.MemberInfo;
import com.safetyas.sds.common.entity.MemberSupplier;
import com.safetyas.sds.common.service.client.FileService;
import com.safetyas.sds.common.service.client.MemberService;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
  private final ModelMapper modelMapper;

  public Optional<Member> findByMemberId(String memberId) {
    return memberService.findMemberByMemberId(memberId);
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
      info.put("relateTable", "sds_member");
      info.put("recordSeq", memberSeq);
      info.put("type", "companyCertificate");
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
    Member member = Member.builder()
        .memberId(memberInfoRequest.getMemberId())
        .pwd(passwordEncoder.encode(memberInfoRequest.getPwd()))
        .role("USER")
        .level(1)
        .loginCount(1)
        .build();
    memberService.saveMember(member);

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
        .member(member)
        .build();
    MemberInfo memberInfoResult = memberService.saveMemberInfo(memberInfo);
    return memberInfoResult.getMember().getMemberSeq();
  }

  public void updateMemberInfo(MemberInfoRequest memberInfoRequest) {
    Member member = memberService.findMemberByMemberId(memberInfoRequest.getMemberId()).orElseThrow(
        NoSuchElementException::new);
    if(memberInfoRequest.getPwd() != null) { //패스워드 재설정
      memberInfoRequest.setPwd(passwordEncoder.encode(memberInfoRequest.getPwd()));
    }
    member.updateMemberInfo(memberInfoRequest.toMemberInfoDTO());
    memberService.saveMember(member);

    MultipartFile file = memberInfoRequest.getCompanyCertificate();
    if (file != null) {
      FileDTO fileDTO = FileDTO.builder()
          .relateTable("sds_member")
          .recordSeq(member.getMemberSeq())
          .type("companyCertificate")
          .build();
      File preFile = fileService.selectFileByFileDTO(fileDTO);
      fileUtil.deleteFile(preFile.getPath(), preFile.getName());
      fileService.deleteFileData(preFile);

      Map<String, Object> info = new HashMap<>();
      info.put("path", "companyCertificate");
      info.put("relateTable", "sds_member");
      info.put("recordSeq", member.getMemberSeq());
      info.put("type", "companyCertificate");
      info.put("regUserSeq", memberInfoRequest.getMemberSeq());
      // 첨부파일 등록
      FileDTO companyFile = fileUtil.parseFile(file, info);

      if (null != companyFile) {
        fileService.saveFile(companyFile);
      }
    }
  }

  /**
   * 멤버 수정할 정보 가져오기
   * @param id Bass64 아이디
   */
  public MemberInfoDTO selectMemberInfo(String id) {
    String decodedId = new String(Base64.getDecoder().decode(id), StandardCharsets.UTF_8);
    Member member = memberService.selectMemberInfo(decodedId)
        .orElseThrow(CustomUserNotFoundException::new);

    FileDTO fileDTO = FileDTO.builder()
        .relateTable("sds_member")
        .recordSeq(member.getMemberSeq())
        .type("companyCertificate")
        .build();
    File companyFile = fileService.selectFileByFileDTO(fileDTO);

    return MemberInfoDTO.builder()
        .memberSeq(member.getMemberSeq())
        .memberId(member.getMemberId())
        .companyName(member.getMemberInfo().getCompanyName())
        .companyNumber(member.getMemberInfo().getCompanyNumber())
        .addr1(member.getMemberInfo().getCompanyAddr1())
        .addr2(member.getMemberInfo().getCompanyAddr2())
        .managerDept(member.getMemberInfo().getManagerDept())
        .managerPosition(member.getMemberInfo().getManagerPosition())
        .managerName(member.getMemberInfo().getManagerName())
        .managerEmail(member.getMemberInfo().getManagerEmail1())
        .phone1(member.getMemberInfo().getPhone1())
        .phone2(member.getMemberInfo().getPhone2())
        .newsletterYn(member.getMemberInfo().getNewsletterYn())
        .joinRoute(member.getMemberInfo().getJoinRoute())
        .consultingYn(member.getMemberInfo().getConsultingYn())
        .msdsTermsYn(member.getMemberInfo().getMsdsTermsYn())
        .privateTermsYn(member.getMemberInfo().getPrivateTermsYn())
        .companyCertificate(companyFile.getOriName())
        .build();
  }

  /**
   *
   * @return list
   */
  public List<MemberSupplierDTO> selectMemberSuppliers(Long memberSeq) {
    List<MemberSupplier> memberSuppliers = memberService.selectMemberSuppliers(memberSeq);
    return modelMapper.map(memberSuppliers, new TypeToken<List<MemberSupplier>>() {}.getType());

  }

  /**
   *
   * @param memberSupplierDTO 공급자 정보
   * @return dto
   */
  public void saveMemberSupplier(MemberSupplierDTO memberSupplierDTO, Long memberSeq) {
    System.out.println("멤버시퀀스"+ memberSeq);
    Member member = memberService.findMemberById(memberSeq)
        .orElseThrow(CustomUserNotFoundException::new);
    memberService.saveMemberSupplier(memberSupplierDTO.toEntity(member));
  }

  /**
   * 공급자 수정
   * @param memberSupplierDTO
   */
  public void updateMemberSupplier(MemberSupplierDTO memberSupplierDTO) {
    MemberSupplier memberSupplier = memberService
        .selectMemberSupplier(memberSupplierDTO.getMemberSupplierSeq())
        .orElseThrow(CustomUserNotFoundException::new);
    memberSupplier.update(memberSupplierDTO);

    memberService.saveMemberSupplier(memberSupplier);
  }

  /**
   * 공급자 삭제
   * @param memberSupplierSeq
   */
  public boolean deleteMemberSupplier(Long memberSupplierSeq) {
    // 공급자가 제품을 가지고 있는지 확인
    if(!memberService.checkMemberSupplierProduct(memberSupplierSeq)) {
      return false;
    } else {
      memberService.deleteMemberSupplier(memberSupplierSeq);
    }
    return true;
  }
}
