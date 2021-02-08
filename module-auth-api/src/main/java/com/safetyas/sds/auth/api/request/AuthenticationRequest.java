package com.safetyas.sds.auth.api.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthenticationRequest {

  private String username;
  private String password;
}
