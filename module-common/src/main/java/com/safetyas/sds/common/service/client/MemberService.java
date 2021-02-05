package com.safetyas.sds.common.service.client;

import com.safetyas.sds.common.entity.Member;
import com.safetyas.sds.common.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  public Optional<Member> findByMemberId(String memberId) {
    return memberRepository.findByMemberId(memberId);
  }

}
