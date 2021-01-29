package com.safetyas.sds.client.api.service;

import com.safetyas.sds.common.entity.Member;
import com.safetyas.sds.common.service.MemberService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiMemberService {

  private final MemberService memberService;

  public Optional<Member> findByMemberId(String memberId) {
    return memberService.findByMemberId(memberId);
  }
}
