package com.safetyas.sds.auth.api.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginRequest {

  private String id;
  private String password;
}
