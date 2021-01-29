package com.safetyas.sds.client.config.security;

import com.safetyas.sds.client.api.service.ApiMemberService;
import com.safetyas.sds.common.entity.Member;
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

  private final ApiMemberService apiMemberService;

  @Override
  public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {

    return null;
  }
}
