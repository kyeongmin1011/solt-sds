package com.safetyas.sds.client.config.security;

import com.safetyas.sds.client.api.service.ApiMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

  private final ApiMemberService apiMemberService;

  @Override
  public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
    Member member = apiMemberService.findByMemberId(memberId).get();
    return new CustomUserDetails(member);
  }
}
