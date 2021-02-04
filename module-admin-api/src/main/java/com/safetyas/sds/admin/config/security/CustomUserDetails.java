package com.safetyas.sds.admin.config.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

  private Long memberSeq;
  private String memberId;
  private Integer level;
  private String role;
  private Set<GrantedAuthority> authorities;

  public CustomUserDetails(Long memberSeq, String memberId, Integer level, String role,
      Set<GrantedAuthority> authorities) {
    this.memberSeq = memberSeq;
    this.memberId = memberId;
    this.level = level;
    this.role = role;
    this.authorities = authorities;
  }

  /* 계정이 갖고 있는 권한 목록을 리턴한다 */
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    ArrayList<GrantedAuthority> authorityArrayList = new ArrayList<>();
    authorityArrayList.add(new SimpleGrantedAuthority(role));
    return authorityArrayList;
  }

  /* 계정의 패스워드를 리턴한다 */
  @Override
  public String getPassword() {
    return null;
  }

  /* 계정의 이름을 리턴한다 */
  @Override
  public String getUsername() {
    return null;
  }

  /* 계정이 만료되지 않았는지를 리턴한다 (true를 리턴하면 만료되지 않음을 의미) */
  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  /* 계정이 잠겨있지 않은지를 리턴한다 (true를 리턴하면 계정이 잠겨있지 않음을 의미) */
  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  /* 계정의 패스워드가 만료되지 않았는지를 리턴한다 (true를 리턴하면 패스워드가 만료되지 않음을 의미) */
  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  /* 계정이 사용가능한 계정인지를 리턴한다 (true를 리턴하면 사용가능한 계정인지를 의미) */
  @Override
  public boolean isEnabled() {
    return false;
  }
}
