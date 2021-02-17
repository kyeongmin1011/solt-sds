package com.safetyas.sds.common.service.client;

import com.safetyas.sds.common.entity.Member;
import com.safetyas.sds.common.entity.MemberInfo;
import com.safetyas.sds.common.repository.MemberInfoRepository;
import com.safetyas.sds.common.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;
  private final MemberInfoRepository memberInfoRepository;

  @Transactional
  public Optional<Member> findByMemberId(String memberId) {
    return memberRepository.findByMemberId(memberId);
  }

  public long saveMember(Member member) {
    Member savedMember = memberRepository.save(member);
    return savedMember.getMemberSeq();
  }

  public MemberInfo saveMemberInfo(MemberInfo memberInfo) {
    return memberInfoRepository.save(memberInfo);
  }
}
