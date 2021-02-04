package com.safetyas.sds.client.config.security;

import com.safetyas.sds.common.entity.Member;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
public class CustomUserDetails implements UserDetails {

  private Long memberSeq;
  private String memberId;
  private Integer level;
  private String role;
  private String companyName;

  private Set<GrantedAuthority> authorities;

  public CustomUserDetails(Member member) {
    this.memberSeq = member.getMemberSeq();
    this.memberId = member.getMemberId();
    this.level = member.getLevel();
    this.role = member.getRole();
    setAuthorities(member.getRole());
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  public void setAuthorities(String role) {
    SimpleGrantedAuthority auth = new SimpleGrantedAuthority(role);
    Set<GrantedAuthority> authList = new HashSet<>();
    authList.add(auth);
    this.authorities = authList;
  }

  @Override
  public String getPassword() {
    return null;
  }

  @Override
  public String getUsername() {
    return null;
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return false;
  }

  public String getCompanyName() {
    return this.companyName;
  }
}
