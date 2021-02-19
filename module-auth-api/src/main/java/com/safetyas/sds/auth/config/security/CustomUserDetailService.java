package com.safetyas.sds.auth.config.security;

import com.safetyas.sds.auth.api.entity.Member;
import com.safetyas.sds.auth.api.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Primary
@Service
public class CustomUserDetailService implements UserDetailsService {

  private final MemberRepository memberRepository;

  @Override
  public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
    Member member = memberRepository.findByMemberId(memberId).get();
    return new CustomUserDetails(member);
  }

}
