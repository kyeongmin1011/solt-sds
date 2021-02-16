package com.safetyas.sds.auth.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberClientDTO {
  private String memberId;
  private String pwd;
  private String role;
  private Integer level;
  private String token;

}
