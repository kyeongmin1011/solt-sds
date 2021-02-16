package com.safetyas.sds.client.config.security;

import com.safetyas.sds.client.api.service.ClientMemberService;
import com.safetyas.sds.common.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

  private final ClientMemberService clientMemberService;

  @Override
  public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
    Member member = clientMemberService.findByMemberId(memberId).get();
    return new CustomUserDetails(member);
  }
}
