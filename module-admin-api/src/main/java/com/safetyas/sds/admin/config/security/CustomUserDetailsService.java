package com.safetyas.sds.admin.config.security;

import com.safetyas.sds.admin.api.service.AdminMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

  private final AdminMemberService adminMemberService;

  @Override
  public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
    return null;
  }
}
